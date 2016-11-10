package frontEnd;

import antlr.BasicParser;
import antlr.BasicParserBaseVisitor;
import ast.*;
import ast.assignRight.*;
import ast.expression.*;
import ast.parameter.*;
import ast.statement.*;
import ast.assignLeft.*;
import org.antlr.v4.runtime.misc.NotNull;
import type.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SemanticCheckVisitor extends BasicParserBaseVisitor<ASTNode> {

    private SymbolTable symbolTable = null;

    @Override
    public ASTNode visitAssignr_arrayliter(@NotNull BasicParser.Assignr_arrayliterContext ctx) {
        List<BasicParser.ExprContext> ectxs = ctx.arrayLiter().expr();
        List<ExpressionNode> elements = new ArrayList<>();
        for (BasicParser.ExprContext ectx : ectxs) {
            ASTNode node = visit(ectx);
            if (node instanceof ExpressionNode) {
                elements.add((ExpressionNode) node);
            } else {
                System.err.println("element not instance of expression node");
                return null;
            }
        }
        return new ArrayLiterAsRNode(elements); //TODO: [DL] need to check if WACC allows [int[], bool[], char[]]
    }
    @Override
    public ASTNode visitArgList(@NotNull BasicParser.ArgListContext ctx) {
        List<BasicParser.ExprContext> ectx = ctx.expr();
        List<ExpressionNode> exprs = new ArrayList<>();
        for (BasicParser.ExprContext context : ectx) {
            ASTNode node = visit(context);
            if (node instanceof ExpressionNode) {
                exprs.add((ExpressionNode) node);
            } else {
                System.err.println("non expression node in arg list");
                return null;
            }
        }
        return new ArgListNode(exprs);
    }

    //Maybe not used
    @Override
    public ASTNode visitArrayLiter(@NotNull BasicParser.ArrayLiterContext ctx) {
        return super.visitArrayLiter(ctx);
    }

    @Override
    public ASTNode visitString_liter(@NotNull BasicParser.String_literContext ctx) {
        //Nothing to add, juts a new StringLiterNode needed.
        return new StringLiterNode(ctx.getText());
    }

    @Override
    public ASTNode visitPrintln_stat(@NotNull BasicParser.Println_statContext ctx) {
        ASTNode expr = visit(ctx.expr());

        if(!(expr instanceof ExpressionNode)){
            System.out.println("Incompatible expression type in println.");
        }

        try{
            expr.getNodeType(symbolTable);
        } catch (SemanticException e){
            System.out.println("Cannot get expression's type in println statement");
        }
        return new PrintlnStatNode((ExpressionNode) expr);

    }

    @Override
    public ASTNode visitScope_stat(@NotNull BasicParser.Scope_statContext ctx) {
        newSymbolTable();

        ASTNode stat = visit(ctx.stat());

        if( !(stat.equals(new StatementType()))){
            System.err.println("Incompatible type in scope statement.");
        }

        try{
            stat.getNodeType(symbolTable);
        } catch (SemanticException s){
            System.err.println("Cannot get statement's type in scope statement.");
        }

        if (symbolTable.getParent() != null) {
            symbolTable = symbolTable.getParent();
        } else {
            System.err.println("error in finding symbol table parent");
        }

        popSymbolTable();
        return new ScopingStatNode((StatementNode) stat);
    }

    @Override
    public ASTNode visitAssignr_expr(@NotNull BasicParser.Assignr_exprContext ctx) {
        ASTNode exprNode = visit(ctx.expr());
        if (exprNode instanceof ExpressionNode) {
            return new ExprAsRNode((ExpressionNode) exprNode);
        } else {
            System.err.println("non expression node found");
            return null;
        }
    }

    @Override
    public ASTNode visitUnaryOper(@NotNull BasicParser.UnaryOperContext ctx) {
        //We probably do not need this since we won't use this visit function.
        return super.visitUnaryOper(ctx);
    }

    @Override
    public ASTNode visitIdent(@NotNull BasicParser.IdentContext ctx) {
        return new IdentNode(ctx.getText()); //TODO: [DL] is it ctx.getText() or ctx.IDENT().getText()?
    }

    @Override
    public ASTNode visitAssignl_arrayelem(@NotNull BasicParser.Assignl_arrayelemContext ctx) {
        ASTNode arrayElem = visit(ctx.arrayElem());

        if (arrayElem instanceof ArrayElemNode) {
            return new ArrayElemAsLNode((ArrayElemNode) arrayElem);
        } else {
            System.err.println("required arrayElemNode not found");
            return null;
        }
    }

    @Override
    public ASTNode visitProgram(@NotNull BasicParser.ProgramContext ctx) {

        // initiate and getting initial variable
        symbolTable = new SymbolTable();
        ProgramNode programNode = new ProgramNode();
        List<BasicParser.FuncContext> functions = ctx.func();
        BasicParser.StatContext statement = ctx.stat();

        // populate the list of function nodes in program node
        try {
            for (BasicParser.FuncContext f : functions) {
                FunctionNode fn = (FunctionNode) visitFunc(f);
                symbolTable.addFunction(fn.getFunctionName(), fn.getNodeType(symbolTable));
                programNode.addFunction(fn);
            }
        } catch (SemanticException e) {
            System.err.println(e);
        }

        // set program node's statement node
        ASTNode statementNode = visit(statement);
        try {
            if (statementNode.getNodeType(symbolTable).equals(new StatementType())) {
                if (statementNode instanceof ReturnStatNode) {
                    System.err.println("return statement not allowed in global scope");
                }
                programNode.setStatementNode((StatementNode)statementNode);
                return programNode;
            }
        } catch (SemanticException e) {
            e.printStackTrace();
            System.err.println(e);
        }

        // reaching here means the statement node cannot be correctly constructed
        System.err.println("Error in processing statementNode");
        return null;

    }


    @Override
    public ASTNode visitExit_stat(@NotNull BasicParser.Exit_statContext ctx) {

        ASTNode exitCode = visit(ctx.expr());
        Type exitCodeType = null;

        if(!(exitCode instanceof ExpressionNode)){
            System.err.println("Incompatible type in exitCode.");
        }

        try{
            exitCodeType = exitCode.getNodeType(symbolTable);
        } catch (SemanticException e){
            System.err.println("Cannot get exitCode's type in exit stat.");
        }

        if(!(exitCodeType instanceof IntType)){
            System.err.println("The exit code must be an int");
        }

        return new ExitStatNode((ExpressionNode) exitCode);
    }

    @Override
    public ASTNode visitType(@NotNull BasicParser.TypeContext ctx) {
        //We just need to visit the children type.
        return visitChildren(ctx);
    }

    @Override
    public ASTNode visitSkip_stat(@NotNull BasicParser.Skip_statContext ctx) {
        return new SkipStatNode();
    }

    @Override
    public ASTNode visitDeclare_stat(@NotNull BasicParser.Declare_statContext ctx) {
        Type typeOfIdent = identifyType(ctx.type());
        String ident = ctx.IDENT().getText();
        ASTNode assignRhs = visit(ctx.assignRHS());

        if (assignRhs instanceof AssignRightNode && operandsTypeCheck(typeOfIdent, (AssignRightNode) assignRhs)) {
            return new DeclareStatNode(typeOfIdent, new IdentNode(ident), (AssignRightNode) assignRhs);
        } else {
            System.err.println("type mismatch");
            return null;
        }


    }

    @Override
    public ASTNode visitBaseType(@NotNull BasicParser.BaseTypeContext ctx) {
        //[DL] We probably do not need this as we won't use this visit function.
        return super.visitBaseType(ctx);
    }

    @Override
    public ASTNode visitInt_liter(@NotNull BasicParser.Int_literContext ctx) {

        IntLiterNode i = null;

        try {
            i = new IntLiterNode(Integer.parseInt(ctx.getText()));
        } catch (Exception e) {
            System.err.println("Syntax error.");
        }

        return i;

    }

    @Override
    public ASTNode visitParen_expr(@NotNull BasicParser.Paren_exprContext ctx) {
        //just visit the expr part but ignoring others.
        return visit(ctx.getChild(1));
    }

    @Override
    public ASTNode visitParam(@NotNull BasicParser.ParamContext ctx) {
        Type typeOfIdent = identifyType(ctx.type());
        String ident = ctx.IDENT().getText();

        try{
            symbolTable.addVariable(ident, typeOfIdent);
        } catch (SemanticException e){
            System.err.println("Variable with same identifier is already declared in current scope");
        }
        return new ParamNode(typeOfIdent, new IdentNode(ident));

    }

    @Override
    public ASTNode visitWhile_stat(@NotNull BasicParser.While_statContext ctx) {
        newSymbolTable();

        ASTNode cond = visit(ctx.expr());
        Type condType;
        ASTNode stat = visit(ctx.stat());

        if(!(cond instanceof ExpressionNode)){
            System.err.println("Incompatible type in While.");
        }

        if(!(stat instanceof StatementNode)){
            System.err.println("Incompatible type in While.");
        }

        //Checking if the condition returns a boolean
        try{
            //TODO : Check symbol table
            condType = cond.getNodeType(symbolTable);
            if(!condType.equals(new BoolType())){
                System.err.println("Incompatible type in condition.");
            }
        } catch (SemanticException e){
            System.err.println("Cannot get condition's type.");
        }

        try{
            //TODO : Check symbol table
            stat.getNodeType(symbolTable);
        } catch (SemanticException e){
            System.err.println("Cannot get statement's type.");
        }

        popSymbolTable();
        return new WhileStatNode((ExpressionNode) cond, (StatementNode) stat);
    }

    @Override
    public ASTNode visitAssignl_id(@NotNull BasicParser.Assignl_idContext ctx) {
        return new IdentAsLNode(new IdentNode(ctx.IDENT().getText())); //TODO: [DL] is it ctx.getText() or ctx.IDENT().getText()?
    }

    @Override
    public ASTNode visitChar_liter(@NotNull BasicParser.Char_literContext ctx) {

        return new CharLiterNode(ctx.getText());
    }

    @Override
    public ASTNode visitIf_stat(@NotNull BasicParser.If_statContext ctx) {
        ASTNode cond = visit(ctx.expr());
        ASTNode statIF = visit(ctx.stat(0));
        ASTNode statELSE = visit(ctx.stat(1));

        Type condType;

        if(!(cond instanceof ExpressionNode)){
            System.err.println("Incompatible type in condition expr in If statement");
        }

        if(!(statIF instanceof StatementNode)){
            System.err.println("Incompatible type in IF stat body in if statement");
        }

        if(!(statELSE instanceof StatementNode)){
            System.err.println("Incompatible type in Else stat body in if statement");
        }

        try{
            condType = cond.getNodeType(symbolTable);
            if(!condType.equals(new BoolType())){
                System.err.println("The condition should result in a boolean type.");
            }
        } catch (SemanticException e){
            System.err.println("Cannot get condition's type in if statement");
        }
        //TODO: check symbolTable
        //TODO: create new symTable for the if and else scope
        try{
            statIF.getNodeType(symbolTable);
        } catch (SemanticException e){
            System.err.println("Cannot get statIf's type in if statement");
        }
        try{
            statELSE.getNodeType(symbolTable);
        } catch (SemanticException e){
            System.err.println("Cannot get statELSE's type in if statement");
        }


        return new IfStatNode((ExpressionNode) cond, (StatementNode) statIF, (StatementNode) statELSE);
    }

    @Override
    public ASTNode visitPairElem(@NotNull BasicParser.PairElemContext ctx) {

        String fstOrSnd = ctx.getChild(0).getText();
        ASTNode valueNode = visit(ctx.expr());
        Type type = null;

        if (valueNode instanceof IdentNode) {
            try {
                type = valueNode.getNodeType(symbolTable);
            } catch (SemanticException e) {
                System.err.println("Semantic error: Cannot find pair elem type.");
                return null;
            }
        }

        if (!(type instanceof  PairType)) {
            System.err.println("Semantic error: It can only be pairtype.");
        }

        final String fst = "fst";
        boolean isFirst;

        if (fstOrSnd.equals(fst)) {
            isFirst = true;
            return new PairElemNode((ExpressionNode) valueNode, isFirst);
        } else {
            isFirst = false;
            return new PairElemNode((ExpressionNode) valueNode, isFirst);
        }

    }

    @Override
    public ASTNode visitPrint_stat(@NotNull BasicParser.Print_statContext ctx) {
        ASTNode expr = visit(ctx.expr());

        if(!(expr instanceof ExpressionNode)){
            System.out.println("Error: need an expr for println");
        }

        try{
            expr.getNodeType(symbolTable);
        } catch (SemanticException e){
            System.out.println("Error: cannot get nodeType of the expression in println statement");
        }
        return new PrintlnStatNode((ExpressionNode) expr);
    }

    @Override
    public ASTNode visitArrayType(@NotNull BasicParser.ArrayTypeContext ctx) {
        //[DL] We probably do not need this visit function.
        return super.visitArrayType(ctx);
    }

    @Override
    public ASTNode visitAssign_stat(@NotNull BasicParser.Assign_statContext ctx) {
        ASTNode assignLHS = visit(ctx.assignLHS());
        ASTNode assignRHS = visit(ctx.assignRHS());
        Type lhsType = null, rhsType = null;

        if(!(assignLHS instanceof AssignLeftNode)){
            System.err.println("Incompatible type in target statement in Assign stat.");
        }
        if(!(assignRHS instanceof AssignRightNode)){
            System.err.println("Incompatible type in the assign statement in Assign stat.");
        }

        try{
            lhsType = assignLHS.getNodeType(symbolTable);
        } catch (SemanticException e){
            System.err.println("Cannot get target type in assign statement.");
        }

        if (operandsTypeCheck(lhsType, (AssignRightNode) assignRHS)) {
            return new AssignStatNode((AssignRightNode) assignRHS, (AssignLeftNode) assignLHS);
        } else {
            System.err.println("Type mismatch");
            return null;
        }

    }

    private boolean operandsTypeCheck(Type targetType, AssignRightNode node) {
        Type rhsType;
        try{
            rhsType = node.getNodeType(symbolTable);
        } catch (SemanticException e){
            System.err.println("Cannot get assignment type in assign statement.");
            return false;
        }

        if(targetType != null && rhsType != null){
            if(node instanceof ExpressionNode
                    || node instanceof ArrayLiterAsRNode
                    || node instanceof CallAsRNode
                    || node instanceof PairElemAsRNode){
                if (!targetType.equals(rhsType)) {
                    System.err.println("Different types in target and assign value");
                    return false;
                }
            }

            if (node instanceof NewPairAsRNode) {
                try {
                    if (!(targetType.equals(new PairType()))) {
                        System.err.println("target type is not pair type");
                        return false;
                    }
                    PairType pType = (PairType) targetType;
                    if (pType.getFstExprType() != ((NewPairAsRNode) node).getFstType(symbolTable)
                            ||pType.getSndExprType() != ((NewPairAsRNode) node).getSndType(symbolTable)) {
                        System.err.println("target pair elements mismatched with assignments");
                        return false;
                    }

                } catch (SemanticException e) {
                    e.printStackTrace();
                    System.err.println(e);
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }


    @Override
    public ASTNode visitBool_liter(@NotNull BasicParser.Bool_literContext ctx) {
        //Only return a BoolLiterNode with the value.
        return new BoolLiterNode(Boolean.valueOf(ctx.getText()));

    }

    @Override
    public ASTNode visitReturn_stat(@NotNull BasicParser.Return_statContext ctx) {
        ASTNode expr = visit(ctx.expr());
        if(!(expr instanceof ExpressionNode)){
            System.out.println("Error: need an expr for println");
        }

        try{
            expr.getNodeType(symbolTable);
        } catch (SemanticException e){
            System.err.println("Cannot get exprType in return statement.");
        }

        return new ReadStatNode((ExpressionNode) expr);
    }

    @Override
    public ASTNode visitAssignr_pairelem(@NotNull BasicParser.Assignr_pairelemContext ctx) {
        ASTNode pairElem = visit(ctx.pairElem());
        if (pairElem instanceof PairElemNode) {
            return new PairElemAsRNode((PairElemNode) pairElem);
        }
        System.err.println("required pairElemNode not found");
        return null;
    }

    @Override
    public ASTNode visitBinary_op(@NotNull BasicParser.Binary_opContext ctx) {

        ASTNode exprL = visit(ctx.exprL);
        ASTNode exprR = visit(ctx.exprR);

        if (exprL instanceof ExpressionNode && exprR instanceof ExpressionNode) {

            String binaryOp = ctx.binaryOper().getText();
            BinaryOpr binaryOpr = BinaryOpr.MULT;


            try {
                Type exprLType = exprL.getNodeType(symbolTable);
                Type exprRType = exprR.getNodeType(symbolTable);
            } catch (SemanticException e) {
                System.err.println("Error type");
            }


            switch (binaryOp) {
                case "+":
                    binaryOpr = BinaryOpr.PLUS;
                    break;
                case "-":
                    binaryOpr = BinaryOpr.MINUS;
                    break;
                case "*":
                    binaryOpr = BinaryOpr.MULT;
                    break;
                case "/":
                    binaryOpr = BinaryOpr.DIV;
                    break;
                case "%":
                    binaryOpr = BinaryOpr.MOD;
                    break;
                case "<":
                    binaryOpr = BinaryOpr.LT;
                    break;
                case "<=":
                    binaryOpr = BinaryOpr.LTE;
                    break;
                case ">":
                    binaryOpr = BinaryOpr.GT;
                    break;
                case ">=":
                    binaryOpr = BinaryOpr.GTE;
                    break;
                case "==":
                    binaryOpr = BinaryOpr.EQ;
                    break;
                case "!=":
                    binaryOpr = BinaryOpr.NEQ;
                    break;
                case "&&":
                    binaryOpr = BinaryOpr.AND;
                    break;
                case "||":
                    binaryOpr = BinaryOpr.OR;
                    break;
                default:
                    System.err.println("Binary Operator not found.");
            }

            return new BinaryOprNode(binaryOpr, (ExpressionNode) exprL, (ExpressionNode) exprR);

        } else {
            System.err.println("not instance of expressionNode");
            return null;
        }

    }

    @Override
    public ASTNode visitUnary_op(@NotNull BasicParser.Unary_opContext ctx) {
        ASTNode expr = (ExpressionNode) visit(ctx.expr());

        if (expr instanceof ExpressionNode) {

            String unaryOp = ctx.unaryOper().getText();
            UnaryOpr unaryOpr = UnaryOpr.NEG;

            switch (unaryOp) {
                case "!":
                    unaryOpr = UnaryOpr.NOT;
                    break;
                case "-":
                    unaryOpr = UnaryOpr.NEG;
                    break;
                case "len":
                    unaryOpr = UnaryOpr.LEN;
                    break;
                case "ord":
                    unaryOpr = UnaryOpr.ORD;
                    break;
                case "chr":
                    unaryOpr = UnaryOpr.CHR;
                    break;
                default:
                    System.err.println("Unary Operator not found.");
            }

            return new UnaryOprNode(unaryOpr, (ExpressionNode) expr);
        } else {
            System.err.println("not instance of expressionNode");
            return null;
        }
    }

    @Override
    public ASTNode visitBinaryOper(@NotNull BasicParser.BinaryOperContext ctx) {
        //[DL] We probably do not need this visit function.
        return super.visitBinaryOper(ctx);
    }

    @Override
    public ASTNode visitFree_stat(@NotNull BasicParser.Free_statContext ctx) {
        ASTNode expr = visit(ctx.expr());
        Type exprType = null;

        if(!(expr instanceof ExpressionNode)){
            System.err.println("Please put an expression(pair) to free.");
        }

        try{
            exprType = expr.getNodeType(symbolTable);
        } catch (SemanticException e){
            System.err.println("Cannot get the expressionType in free statement.");
        }

        if(!(exprType instanceof PairType)){
            System.err.println("Free is used to free the heap memory for pairType");
        }

        return new FreeStatNode((ExpressionNode) expr);
    }

    @Override
    public ASTNode visitPair_liter(@NotNull BasicParser.Pair_literContext ctx) {
        //Only return a new PairLiterNode.
        return new PairLiterNode();
    }

    @Override
    public ASTNode visitPairType(@NotNull BasicParser.PairTypeContext ctx) {
        //[DL] We probably do not need this visit function.
        return super.visitPairType(ctx);
    }

    @Override
    public ASTNode visitPairElemType(@NotNull BasicParser.PairElemTypeContext ctx) {
        //[DL] We probably do not need this visit function.
      return super.visitPairElemType(ctx);
    }

    @Override
    public ASTNode visitArrayElem(@NotNull BasicParser.ArrayElemContext ctx) {
        String id = ctx.name.getText();
        IdentNode identNode = new IdentNode(id);
        List<ExpressionNode> indexes = new LinkedList<>();
        Type arrayType = null;
        Type indexType;


        for (int i = 0; i < ctx.expr().size(); i++) {
            BasicParser.ExprContext index = ctx.expr(i);
            try {
                ASTNode a = visit(index);
                indexType = a.getNodeType(symbolTable);
                if (!(indexType.equals(new IntType()) && a instanceof ExpressionNode)) {
                    System.err.println("Semantic error");
                    return null;
                }
                indexes.add((ExpressionNode) a);
            } catch (SemanticException e) {
                System.err.println("Semantic error");
            }
        }

        try {
            symbolTable.lookUpVariable(id);
        } catch (SemanticException e) {
            System.err.println("Semantic error: Identifier not found.");
        }

        return new ArrayElemNode(identNode, indexes);
    }

    @Override
    public ASTNode visitFunc(@NotNull BasicParser.FuncContext ctx) {
        newSymbolTable();

        Type retType = identifyType(ctx.type());
        if (retType == null) {
            System.err.println("cannot recognize return type");
            return null;
        }
        IdentNode functionId = new IdentNode(ctx.IDENT().getText());
        ParamListNode params = null;
        if (ctx.paramList() != null) {
            ASTNode node = visit(ctx.paramList());
            if (node instanceof ParamListNode) {
                params = (ParamListNode) node;
            }
        }
        StatementNode stat = null;
        ASTNode s = visit(ctx.stat());
        if (s instanceof StatementNode) {
            if (s instanceof SequentialStatNode
                    && (((SequentialStatNode)s).getSndStat() instanceof ExitStatNode
                        || ((SequentialStatNode)s).getSndStat() instanceof ReturnStatNode)) {
                stat = (StatementNode) s;
            } else {
                if (s instanceof ExitStatNode || s instanceof ReturnStatNode) {
                    stat = (StatementNode) s;
                }
            }
        }

        if (stat == null) {
            System.err.println("function not end with return or exit statement");
            return null;
        }

        popSymbolTable();
        return new FunctionNode(retType, functionId, params, stat);
    }

    @Override
    public ASTNode visitParamList(@NotNull BasicParser.ParamListContext ctx) {
        List<ParamNode> params = new ArrayList<>();
        List<BasicParser.ParamContext> pctx = ctx.param();
        for (BasicParser.ParamContext context : pctx) {
            ASTNode node = visit(context);
            if (node instanceof ParamNode) {
                params.add((ParamNode) node);
            } else {
                System.err.println("non paramNode returned from param context");
                return null;
            }
        }
        return new ParamListNode(params);
    }

    @Override
    public ASTNode visitSequential_stat(@NotNull BasicParser.Sequential_statContext ctx) {
        ASTNode statFst = visit(ctx.stat(0));
        ASTNode statSnd = visit(ctx.stat(1));

        if(!(statFst.equals(new StatementType()))){
            System.err.println("Incompatible type in sequential statement.");
        }

        if(statFst instanceof ReturnStatNode){
            System.err.println("Cannot have return node type in the first statement");
        }

        try{
            statFst.getNodeType(symbolTable);
        } catch (SemanticException e){
            System.err.println("Cannot get first statement's type in sequential stat.");
        }

        try{
            statSnd.getNodeType(symbolTable);
        } catch (SemanticException e){
            System.err.println("Cannot get second statement's type in sequential stat.");
        }
        return new SequentialStatNode((StatementNode) statFst, (StatementNode) statSnd);
    }

    // todo: [DL] changed pairelem so need review here
    @Override
    public ASTNode visitRead_stat(@NotNull BasicParser.Read_statContext ctx) {
        ASTNode assignLHS = visit(ctx.assignLHS());
        Type assignLHSType;

        if(!(assignLHS instanceof AssignLeftNode)){
            System.out.println("Error: need type assignLHS for read");
        }
        try{
            assignLHSType = assignLHS.getNodeType(symbolTable);

            if(assignLHSType.equals(new PairType())){
                PairType pairType = (PairType) assignLHSType;
                PairElemAsLNode assignLPair = (PairElemAsLNode) assignLHS;

                Type elemType;
                elemType = assignLPair.getPairElemNode().isFirst() ? pairType.getFstExprType() : pairType.getSndExprType();


                if(!(elemType.equals(new IntType()) || elemType.equals(new CharType()))) {
                    System.err.println("The read statement can only handle character or integer input.");
                }
            }

            if (!(assignLHSType.equals(new IntType()) || assignLHSType.equals(new CharType()))) {
                System.err.println("incompatible type in target");
            }

        } catch (SemanticException e){
            System.err.println("Cannot get assignLHS's node type.");
        }

        return new ReadStatNode(assignLHS);
    }

    @Override
    public ASTNode visitAssignl_pairelem(@NotNull BasicParser.Assignl_pairelemContext ctx) {
        ASTNode pairElem = visit(ctx.pairElem());
        if (pairElem instanceof PairElemNode) {
            return new PairElemAsLNode((PairElemNode) pairElem);
        }
        System.err.println("required pairElemNode not found");
        return null;
    }

    @Override
    public ASTNode visitAssignr_call(@NotNull BasicParser.Assignr_callContext ctx) {
        String functionId = ctx.IDENT().getSymbol().getText(); // TODO: [DL] is this the right way to get the identifier text

        try {
            Type fType = symbolTable.lookUpFunction(functionId);
            if (fType instanceof FunctionType) {
                List<Type> paramTypes = ((FunctionType) fType).getParams();
                ASTNode argListNode = visit(ctx.argList());
                if (argListNode instanceof ArgListNode) {
                    List<Type> argTypes = ((ArgListNode) argListNode).getNodeTypes(symbolTable);
                    if (argTypes.size() == paramTypes.size()) {
                        for (int i = 0; i < paramTypes.size(); i++) {
                            if (!argTypes.get(i).equals(argTypes.get(i))) {
                                System.err.println("params and args type mismatch");
                                return null;
                            }
                            return new CallAsRNode(new IdentNode(functionId), (ArgListNode) argListNode);
                        }
                    } else {
                        System.err.println("number of params and number of args mismatched");
                    }
                } else {
                    System.err.println("non argListNode found");
                }
            } else {
                System.err.println("non function type returned from function symbol type");
            }
        } catch (SemanticException e) {
            e.printStackTrace();
            System.err.println(e);
        }

        return null;
    }

    @Override
    public ASTNode visitAssignr_newpair(@NotNull BasicParser.Assignr_newpairContext ctx) {
        ASTNode fst = visit(ctx.expr(0));
        ASTNode snd = visit(ctx.expr(1));

        if (fst instanceof ExpressionNode && snd instanceof ExpressionNode) {
            return new NewPairAsRNode((ExpressionNode) fst, (ExpressionNode) snd);
        } else {
            System.err.println("not both pair elem instance of expressionNode");
            return null;
        }
    }

    // helper method
    private Type identifyType(BasicParser.TypeContext ctx) {
        // determine whether it's baseType, arrayType or pairType

        if (ctx.arrayType() != null) { // arrayType
            BasicParser.ArrayTypeContext actx = ctx.arrayType();
            return identifyArrayType(actx);
        }

        if (ctx.baseType() != null) { // baseType
            BasicParser.BaseTypeContext btctx = ctx.baseType();
            return identifyBaseType(btctx);
        }

        if (ctx.pairType() != null) { // pairType
            BasicParser.PairTypeContext pctx = ctx.pairType();
            return identifyPairType(pctx);
        }

        // reaching here indicates error in matching known type
        System.err.println("Unknown type encountered");
        return null;
    }

    private Type identifyArrayType(BasicParser.ArrayTypeContext ctx) {
        Type elemType = null;
        if (ctx.baseType() != null) {
            // baseType array
             elemType = identifyBaseType(ctx.baseType());

        }
        if (ctx.pairType() != null) {
            // pairType array
            elemType = identifyPairType(ctx.pairType());
        }
        Type retType  = new ArrayType(elemType);
        //
        for (int i = 0; i < ctx.OPEN_SQPARENTHESES().size() - 1; i++) {
            retType = new ArrayType(retType);
        }
        return retType;

    }

    private Type identifyBaseType(BasicParser.BaseTypeContext ctx) {
        if (ctx.BOOL() != null) {
            return new BoolType();
        }

        if (ctx.CHAR() != null) {
            return new CharType();
        }

        if (ctx.INT() != null) {
            return new IntType();
        }

        if (ctx.STRING() != null) {
            return new StringType();
        }

        System.err.println("unknown base type");
        return null;
    }

    private Type identifyPairType(BasicParser.PairTypeContext ctx) {
        BasicParser.PairElemTypeContext fst = ctx.pairElemType(0);
        BasicParser.PairElemTypeContext snd = ctx.pairElemType(1);

        return new PairType(identifyPairElemType(fst), identifyPairElemType(snd));
    }

    private Type identifyPairElemType(BasicParser.PairElemTypeContext ctx) {
        if (ctx.PAIR() != null) { // pair elem
            return new PairType(); // return a pair type which has null as its own pairElem
        }

        if (ctx.arrayType() != null) { // array elem
            return identifyArrayType(ctx.arrayType());
        }

        if (ctx.baseType() != null) { //
            return identifyBaseType(ctx.baseType());
        }

        // reaching here indicates error in matching known type
        System.err.println("unknown pair elem type encounter");
        return null;
    }


    private void semanticErrorExit(String message) {
        System.err.println(message);
        System.exit(200);
    }

    private void newSymbolTable() {
        SymbolTable st = new SymbolTable(symbolTable);
        symbolTable = st;
    }

    private void popSymbolTable() {
        if (symbolTable.getParent() != null) {
            symbolTable = symbolTable.getParent();
        } else {
            System.err.println("error in finding symbol table parent");
        }
    }

}