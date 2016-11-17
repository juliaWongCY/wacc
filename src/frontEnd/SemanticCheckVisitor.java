package frontEnd;

import errorHandling.ErrorHandle;
import antlr.BasicParser;
import antlr.BasicParserBaseVisitor;
import ast.*;
import ast.assignRight.*;
import ast.expression.*;
import ast.parameter.*;
import ast.statement.*;
import ast.assignLeft.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import type.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SemanticCheckVisitor extends BasicParserBaseVisitor<ASTNode> {

    private boolean hasSemanticError = false;
    private SymbolTable symbolTable = null;

    public SemanticCheckVisitor(SymbolTable symbolTable) {
    }

    /////////////////////////assignment LHS and RHS////////////////////////////////////

    @Override
    public ASTNode visitAssignl_arrayelem(@NotNull BasicParser.Assignl_arrayelemContext ctx) {
        ASTNode arrayElem = visit(ctx.arrayElem());

        if (arrayElem instanceof ArrayElemNode) {
            return new ArrayElemAsLNode((ArrayElemNode) arrayElem);
        } else {
            return handleError(ctx.arrayElem(), ((ErrorNode)arrayElem).getErrorType());
        }
    }

    @Override
    public ASTNode visitAssignl_id(@NotNull BasicParser.Assignl_idContext ctx) {
        return new IdentAsLNode(new IdentNode(ctx.IDENT().getText()));
    }

    @Override
    public ASTNode visitAssignl_pairelem(@NotNull BasicParser.Assignl_pairelemContext ctx) {
        ASTNode pairElem = visit(ctx.pairElem());
        if (pairElem instanceof PairElemNode) {
            return new PairElemAsLNode((PairElemNode) pairElem);
        }
        return handleError(ctx.pairElem(), ((ErrorNode) pairElem).getErrorType());
        //System.err.println("required pairElemNode not found");
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
                return handleError(context, ((ErrorNode) node).getErrorType());
            }
        }

        return new ArgListNode(exprs);
    }

    @Override
    public ASTNode visitAssignr_arrayliter(@NotNull BasicParser.Assignr_arrayliterContext ctx) {
        List<BasicParser.ExprContext> ectxs = ctx.arrayLiter().expr();
        List<ExpressionNode> elements = new ArrayList<>();

        if (ectxs == null) {
            return new ArrayLiterAsRNode();
        }

        for (BasicParser.ExprContext ectx : ectxs) {
            ASTNode node = visit(ectx);
            if (node instanceof ExpressionNode) {
                elements.add((ExpressionNode) node);
            } else {
                return handleError(ectx, ((ErrorNode) node).getErrorType());
            }
        }

        return new ArrayLiterAsRNode(elements);
    }

    @Override
    public ASTNode visitAssignr_call(@NotNull BasicParser.Assignr_callContext ctx) {
        String functionId = ctx.IDENT().getText();
        Type fType = null;
        try {
            fType = symbolTable.lookUpFunction(functionId);
            if (fType instanceof FunctionType) {
                List<Type> paramTypes = ((FunctionType) fType).getParams();
                BasicParser.ArgListContext actx = ctx.argList();
                if (paramTypes == null && actx == null) {
                    return new CallAsRNode(new IdentNode(functionId));
                }
                if (paramTypes == null && actx != null
                        || paramTypes != null && actx == null
                        || paramTypes.size() != actx.expr().size()) {
                    return handleError(ctx.argList(), ErrorHandle.ERRORTYPE_INCORRECT_NUM_PARAM);
                }
                ASTNode argListNode = visit(actx);
                if (argListNode instanceof ArgListNode) {
                    List<Type> argTypes = null;
                    try {
                        argTypes = ((ArgListNode) argListNode).getNodeTypes(symbolTable);
                    } catch (SemanticException e){
                        handleError(actx, ErrorHandle.ERRORTYPE_UNDEFINED_VAR);
                    }
                    if (argTypes.size() == paramTypes.size()) {
                        for (int i = 0; i < paramTypes.size(); i++) {
                            if (!argTypes.get(i).equals(paramTypes.get(i))) {
                                return handleEAError(actx, ErrorHandle.ERRORTYPE_INCOMPATIBLE_TYPE, paramTypes.get(i), argTypes.get(i));
                            }
                            return new CallAsRNode(new IdentNode(functionId), (ArgListNode) argListNode);
                        }
                    } else {
                        System.err.println("number of params and number of args mismatched");
                        return handleError(actx, ErrorHandle.ERRORTYPE_INCORRECT_NUM_PARAM);
                    }
                } else {
                    System.err.println("non argListNode found");

                }
            } else {
                System.err.println("non function type returned from function symbol type");
                return handleError(ctx, ErrorHandle.ERRORTYPE_INCOMPATIBLE_TYPE);
            }
        } catch (SemanticException e) {
            System.err.println("cannot get func type");
            return handleError(ctx, ErrorHandle.ERRORTYPE_UNDEFINED_FUNC);
        }
        return null;
    }

    @Override
    public ASTNode visitAssignr_expr(@NotNull BasicParser.Assignr_exprContext ctx) {
        ASTNode exprNode = visit(ctx.expr());
        if (exprNode instanceof ExpressionNode) {
            return new ExprAsRNode((ExpressionNode) exprNode);
        } else {
            return handleError(ctx.expr(), ((ErrorNode)exprNode).getErrorType());
        }
    }

    @Override
    public ASTNode visitAssignr_newpair(@NotNull BasicParser.Assignr_newpairContext ctx) {
        ASTNode fst = visit(ctx.expr(0));
        ASTNode snd = visit(ctx.expr(1));

        if (fst instanceof ExpressionNode && snd instanceof ExpressionNode) {
            return new NewPairAsRNode((ExpressionNode) fst, (ExpressionNode) snd);
        } else if (!(fst instanceof ExpressionNode)){
            return handleError(ctx.expr(0), ((ErrorNode)fst).getErrorType());
        } else {
            return handleError(ctx.expr(1), ((ErrorNode)snd).getErrorType());
            //System.err.println("Incompatible type -- not both pair elem instance of expressionNode");
            //return null;
        }
    }

    @Override
    public ASTNode visitAssignr_pairelem(@NotNull BasicParser.Assignr_pairelemContext ctx) {
        ASTNode pairElem = visit(ctx.pairElem());
        if (pairElem instanceof PairElemNode) {
            return new PairElemAsRNode((PairElemNode) pairElem);
        }
        return handleError(ctx.pairElem(), ((ErrorNode)pairElem).getErrorType());
        //System.err.println("required pairElemNode not found");
    }

    //////////////////////expression///////////////////////////////////////////////////////

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
                    handleEAError(ctx.expr(i), ErrorHandle.ERRORTYPE_INCOMPATIBLE_TYPE, new IntType(), indexType );
                    System.err.println("Semantic error");
                    return null;
                }
                indexes.add((ExpressionNode) a);
            } catch (SemanticException e) {
                System.err.println("Semantic error");
                return handleError(ctx.expr(i), ErrorHandle.ERRORTYPE_UNDEFINED_VAR);
            }
        }

        try {
            symbolTable.lookUpVariable(id);
        } catch (SemanticException e) {
            System.err.println("Semantic error: Identifier not found.");
            return handleError(ctx, ErrorHandle.ERRORTYPE_UNDEFINED_VAR);
        }

        return new ArrayElemNode(identNode, indexes);
    }

    @Override
    public ASTNode visitBool_liter(@NotNull BasicParser.Bool_literContext ctx) {
        //Only return a BoolLiterNode with the value.
        return new BoolLiterNode(Boolean.valueOf(ctx.getText()));

    }

    @Override
    public ASTNode visitChar_liter(@NotNull BasicParser.Char_literContext ctx) {
        return new CharLiterNode(ctx.getText());
    }

    @Override
    public ASTNode visitIdent(@NotNull BasicParser.IdentContext ctx) {
        return new IdentNode(ctx.IDENT().getText());
    }

    @Override
    public ASTNode visitInt_liter(@NotNull BasicParser.Int_literContext ctx) {
        IntLiterNode i = null;
        try {
            i = new IntLiterNode(Integer.parseInt(ctx.getText()));
        } catch (Exception e) {

        }
        return i;
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
//                //TODO
//                System.err.println("Semantic error: Cannot find pair elem type.");
//                return null;
                return handleError(ctx.expr(), ErrorHandle.ERRORTYPE_UNDEFINED_VAR);
            }
        }

        if (!(type instanceof PairType)) {
            return handleError(ctx.expr(), ErrorHandle.ERRORTYPE_INCOMPATIBLE_TYPE);
            //System.err.println("Semantic error: It can only be pairtype.");
        }

        final String fst = "fst";

        if (fstOrSnd.equals(fst)) {
            return new PairElemNode((ExpressionNode) valueNode, true);
        } else {
            return new PairElemNode((ExpressionNode) valueNode, false);
        }

    }

    @Override
    public ASTNode visitPair_liter(@NotNull BasicParser.Pair_literContext ctx) {
        //Only return a new PairLiterNode.
        return new PairLiterNode();
    }

    @Override
    public ASTNode visitString_liter(@NotNull BasicParser.String_literContext ctx) {
        //Nothing to add, juts a new StringLiterNode needed.
        return new StringLiterNode(ctx.getText());
    }

    @Override
    public ASTNode visitBinary_opIntHigher(@NotNull BasicParser.Binary_opIntHigherContext ctx) {
        String operator = ctx.binaryOper_IntHigher().getText();
        ASTNode exprL = visit(ctx.exprL);
        ASTNode exprR = visit(ctx.exprR);

        if (!(exprL instanceof ExpressionNode)) {
            return handleError(ctx.exprL, ((ErrorNode)exprL).getErrorType());
        }

        if (!(exprR instanceof ExpressionNode)) {
            return handleError(ctx.exprR, ((ErrorNode)exprR).getErrorType());
        }

        try {
            Type exprLType = exprL.getNodeType(symbolTable);
            if (!exprLType.equals(new IntType())) {
                return handleError(ctx.exprL, ErrorHandle.ERRORTYPE_INCOMPATIBLE_TYPE);
            }
        } catch (SemanticException e) {
            return handleError(ctx.exprL, ErrorHandle.ERRORTYPE_UNDEFINED_VAR);
        }

        try {
            Type exprRType = exprR.getNodeType(symbolTable);
            if (!exprRType.equals(new IntType())) {
                return handleError(ctx.exprR, ErrorHandle.ERRORTYPE_INCOMPATIBLE_TYPE);
            }
        } catch (SemanticException e) {
            return handleError(ctx.exprR, ErrorHandle.ERRORTYPE_UNDEFINED_VAR);
        }

        BinaryOpr binaryOpr = BinaryOpr.MULT;

        switch (operator) {
            case "*":
                binaryOpr = BinaryOpr.MULT;
                break;
            case "/":
                binaryOpr = BinaryOpr.DIV;
                break;
            case "%":
                binaryOpr = BinaryOpr.MOD;
                break;
            default:
                System.err.println("Unrecognized operator, should not reach here");
        }

        return new BinaryOprNode(binaryOpr, (ExpressionNode) exprL, (ExpressionNode) exprR);
    }

    @Override
    public ASTNode visitBinary_opIntLower(@NotNull BasicParser.Binary_opIntLowerContext ctx) {
        String operator = ctx.binaryOper_IntLower().getText();
        ASTNode exprL = visit(ctx.exprL);
        ASTNode exprR = visit(ctx.exprR);

        if (!(exprL instanceof ExpressionNode)) {
            return handleError(ctx.exprL, ((ErrorNode)exprL).getErrorType());
        }

        if (!(exprR instanceof ExpressionNode)) {
            return handleError(ctx.exprR, ((ErrorNode)exprR).getErrorType());
        }

        try {
            Type exprLType = exprL.getNodeType(symbolTable);
            if (!exprLType.equals(new IntType())) {
                return handleError(ctx.exprL, ErrorHandle.ERRORTYPE_INCOMPATIBLE_TYPE);
            }
        } catch (SemanticException e) {
            return handleError(ctx.exprL, ErrorHandle.ERRORTYPE_UNDEFINED_VAR);
        }

        try {
            Type exprRType = exprR.getNodeType(symbolTable);
            if (!exprRType.equals(new IntType())) {
                return handleError(ctx.exprR, ErrorHandle.ERRORTYPE_INCOMPATIBLE_TYPE);
            }
        } catch (SemanticException e) {
            return handleError(ctx.exprR, ErrorHandle.ERRORTYPE_UNDEFINED_VAR);
        }


        BinaryOpr binaryOpr = BinaryOpr.PLUS;

        switch (operator) {
            case "+":
                binaryOpr = BinaryOpr.PLUS;
                break;
            case "-":
                binaryOpr = BinaryOpr.MINUS;
                break;
            default:
                System.err.println("Unrecognized operator, should not reach here");
        }

        return new BinaryOprNode(binaryOpr, (ExpressionNode) exprL, (ExpressionNode) exprR);
    }

    @Override
    public ASTNode visitBinary_opCompareHigher(@NotNull BasicParser.Binary_opCompareHigherContext ctx) {
        String operator = ctx.binaryOper_CompareHigher().getText();
        ASTNode exprL = visit(ctx.exprL);
        ASTNode exprR = visit(ctx.exprR);

        if (!(exprL instanceof ExpressionNode)) {
            return handleError(ctx.exprL, ((ErrorNode)exprL).getErrorType());
        }

        if (!(exprR instanceof ExpressionNode)) {
            return handleError(ctx.exprR, ((ErrorNode)exprR).getErrorType());
        }


        try {
            Type exprLType = exprL.getNodeType(symbolTable);

            if (!(exprLType.equals(new IntType()) || exprLType.equals(new CharType()))) {

                return handleError(ctx.exprL, ErrorHandle.ERRORTYPE_INCOMPATIBLE_TYPE);
            }
        } catch (SemanticException e) {
            return handleError(ctx.exprL, ErrorHandle.ERRORTYPE_UNDEFINED_VAR);
        }

        try {
            Type exprLType = exprL.getNodeType(symbolTable);
            Type exprRType = exprR.getNodeType(symbolTable);

            if (!(exprRType.equals(new IntType()) || exprRType.equals(new CharType()))) {
                return handleError(ctx.exprR, ErrorHandle.ERRORTYPE_INCOMPATIBLE_TYPE);
            }
        } catch (SemanticException e) {
            return handleError(ctx.exprR, ErrorHandle.ERRORTYPE_UNDEFINED_VAR);
        }

        BinaryOpr binaryOpr = BinaryOpr.GT;

        switch (operator) {
            case ">":
                binaryOpr = BinaryOpr.GT;
                break;
            case ">=":
                binaryOpr = BinaryOpr.GTE;
                break;
            case "<":
                binaryOpr = BinaryOpr.LT;
                break;
            case "<=":
                binaryOpr = BinaryOpr.LTE;
                break;
            default:
                System.err.println("Operator not found.");
        }

        return new BinaryOprNode(binaryOpr, (ExpressionNode) exprL, (ExpressionNode) exprR);

    }

    @Override
    public ASTNode visitBinary_opCompareLower(@NotNull BasicParser.Binary_opCompareLowerContext ctx) {
        String operator = ctx.binaryOper_CompareLower().getText();
        ASTNode exprL = visit(ctx.exprL);
        ASTNode exprR = visit(ctx.exprR);


        if (exprL instanceof ExpressionNode && exprR instanceof ExpressionNode) {
            BinaryOpr binaryOpr = BinaryOpr.EQ;

            switch (operator) {
                case "==":
                    binaryOpr = BinaryOpr.EQ;
                    break;
                case "!=":
                    binaryOpr = BinaryOpr.NEQ;
                    break;
                default:
                    System.err.println("Operator not found.");
            }

            return new BinaryOprNode(binaryOpr, (ExpressionNode) exprL, (ExpressionNode) exprR);
        } else if (!(exprL instanceof ExpressionNode)) {
            return handleError(ctx.exprL, ErrorHandle.ERRORTYPE_INCOMPATIBLE_TYPE);
        } else {
            return handleError(ctx.exprR, ErrorHandle.ERRORTYPE_INCOMPATIBLE_TYPE);
            //System.err.println("not instance of expressionNode");
            //return null;
        }
    }

    @Override
    public ASTNode visitBinary_opAnd(@NotNull BasicParser.Binary_opAndContext ctx) {
        ASTNode exprL = visit(ctx.exprL);
        ASTNode exprR = visit(ctx.exprR);

        if (!(exprL instanceof ExpressionNode)) {
            return handleError(ctx.exprL, ((ErrorNode)exprL).getErrorType());
        }

        if (!(exprR instanceof ExpressionNode)) {
            return handleError(ctx.exprR, ((ErrorNode)exprR).getErrorType());
        }


        try {
            Type exprLType = exprL.getNodeType(symbolTable);
            if (!exprLType.equals(new BoolType())) {
                return handleError(ctx.exprL, ErrorHandle.ERRORTYPE_INCOMPATIBLE_TYPE);
            }
        } catch (SemanticException e) {
            return handleError(ctx.exprL, ErrorHandle.ERRORTYPE_UNDEFINED_VAR);
        }

        try {
            Type exprRType = exprR.getNodeType(symbolTable);
            if (!exprRType.equals(new BoolType())) {
                return handleError(ctx.exprR, ErrorHandle.ERRORTYPE_INCOMPATIBLE_TYPE);
            }
        } catch (SemanticException e) {
            return handleError(ctx.exprR, ErrorHandle.ERRORTYPE_UNDEFINED_VAR);
        }

        return new BinaryOprNode(BinaryOpr.AND, (ExpressionNode) exprL, (ExpressionNode) exprR);

    }

    @Override
    public ASTNode visitBinary_opOr(@NotNull BasicParser.Binary_opOrContext ctx) {
        ASTNode exprL = visit(ctx.exprL);
        ASTNode exprR = visit(ctx.exprR);

        if (!(exprL instanceof ExpressionNode)) {
            return handleError(ctx.exprL, ((ErrorNode)exprL).getErrorType());
        }

        if (!(exprR instanceof ExpressionNode)) {
            return handleError(ctx.exprR, ((ErrorNode)exprR).getErrorType());
        }


        try {
            Type exprLType = exprL.getNodeType(symbolTable);
            if (!exprLType.equals(new BoolType())) {
                return handleError(ctx.exprL, ErrorHandle.ERRORTYPE_INCOMPATIBLE_TYPE);
            }
        } catch (SemanticException e) {
            return handleError(ctx.exprL, ErrorHandle.ERRORTYPE_UNDEFINED_VAR);
        }

        try {
            Type exprRType = exprR.getNodeType(symbolTable);
            if (!exprRType.equals(new BoolType())) {
                return handleError(ctx.exprR, ErrorHandle.ERRORTYPE_INCOMPATIBLE_TYPE);
            }
        } catch (SemanticException e) {
            return handleError(ctx.exprR, ErrorHandle.ERRORTYPE_UNDEFINED_VAR);
        }

        return new BinaryOprNode(BinaryOpr.OR, (ExpressionNode) exprL, (ExpressionNode) exprR);

    }

    @Override
    public ASTNode visitParen_expr(@NotNull BasicParser.Paren_exprContext ctx) {
        //just visit the expr part but ignoring others.
        return visit(ctx.expr());
    }

    @Override
    public ASTNode visitUary_opNot(@NotNull BasicParser.Uary_opNotContext ctx) {
        ASTNode expr = visit(ctx.expr());

        if (expr instanceof ExpressionNode) {
            return new UnaryOprNode(UnaryOpr.NOT, (ExpressionNode) expr);
        } else {
            return handleError(ctx.expr(), ErrorHandle.ERRORTYPE_INCOMPATIBLE_TYPE);
            //System.err.println("not instance of expressionNode");
            //return null;
        }
    }

    @Override
    public ASTNode visitUnary_opNeg(@NotNull BasicParser.Unary_opNegContext ctx) {
        ASTNode expr = visit(ctx.expr());

        if (expr instanceof ExpressionNode) {
            return new UnaryOprNode(UnaryOpr.NEG, (ExpressionNode) expr);
        } else {
            return handleError(ctx.expr(), ErrorHandle.ERRORTYPE_INCOMPATIBLE_TYPE);
            //System.err.println("not instance of expressionNode");
            //return null;
        }
    }

    @Override
    public ASTNode visitUnary_opLen(@NotNull BasicParser.Unary_opLenContext ctx) {
        ASTNode expr = visit(ctx.expr());

        if (expr instanceof ExpressionNode) {
            return new UnaryOprNode(UnaryOpr.LEN, (ExpressionNode) expr);
        } else {
            return handleError(ctx.expr(), ErrorHandle.ERRORTYPE_INCOMPATIBLE_TYPE);
            //System.err.println("not instance of expressionNode");
            //return null;
        }
    }

    @Override
    public ASTNode visitUnary_opOrd(@NotNull BasicParser.Unary_opOrdContext ctx) {
        ASTNode expr = visit(ctx.expr());

        if (expr instanceof ExpressionNode) {
            return new UnaryOprNode(UnaryOpr.ORD, (ExpressionNode) expr);
        } else {
            return handleError(ctx.expr(), ErrorHandle.ERRORTYPE_INCOMPATIBLE_TYPE);
            //System.err.println("not instance of expressionNode");
            //return null;
        }
    }

    @Override
    public ASTNode visitUnary_opChr(@NotNull BasicParser.Unary_opChrContext ctx) {
        ASTNode expr = visit(ctx.expr());

        if (expr instanceof ExpressionNode) {
            return new UnaryOprNode(UnaryOpr.CHR, (ExpressionNode) expr);
        } else {
            return handleError(ctx.expr(), ErrorHandle.ERRORTYPE_INCOMPATIBLE_TYPE);
            //System.err.println("not instance of expressionNode");
            //return null;
        }
    }

    ////////////////////////////////parameter/////////////////////////////

    @Override
    public ASTNode visitParamList(@NotNull BasicParser.ParamListContext ctx) {
        List<ParamNode> params = new ArrayList<>();
        List<BasicParser.ParamContext> pctx = ctx.param();
        for (BasicParser.ParamContext context : pctx) {
            ASTNode node = visit(context);
            if (node instanceof ParamNode) {
                params.add((ParamNode) node);
            } else {
                System.err.println("Incompatible type : non paramNode returned from param context");
                return handleError(ctx, ErrorHandle.ERRORTYPE_INCOMPATIBLE_TYPE);
            }
        }
        return new ParamListNode(params);
    }

    @Override
    public ASTNode visitParam(@NotNull BasicParser.ParamContext ctx) {
        Type paramType = identifyType(ctx.type());
        String ident = ctx.IDENT().getText();

        try{
            symbolTable.addVariable(ident, paramType);
        } catch (SemanticException e){
            return handleError(ctx, ErrorHandle.ERRORTYPE_DUPLICATE_IDENT);
        }
        return new ParamNode(paramType, new IdentNode(ident));

    }

    /////////////////////////////////statement//////////////////////////////

    @Override
    public ASTNode visitAssign_stat(@NotNull BasicParser.Assign_statContext ctx) {
        ASTNode assignLHS = visit(ctx.assignLHS());
        ASTNode assignRHS = visit(ctx.assignRHS());
        Type lhsType = null;

        if(!(assignLHS instanceof AssignLeftNode)){
            return handleError(ctx.assignLHS(), ((ErrorNode)assignLHS).getErrorType());
            //System.err.println("Incompatible type in target statement in Assign stat.");
        }
        if(!(assignRHS instanceof AssignRightNode)){
            return handleError(ctx.assignRHS(), ((ErrorNode)assignRHS).getErrorType());
            //System.err.println("Incompatible type in the assign statement in Assign stat.");
        }

        try{
            lhsType = assignLHS.getNodeType(symbolTable);
        } catch (SemanticException e){
            //TODO
            System.err.println("Cannot get target type in assign statement.");
            return handleError(ctx.assignLHS(), ErrorHandle.ERRORTYPE_UNDEFINED_VAR);
        }

        if (operandsTypeCheck(lhsType, (AssignRightNode) assignRHS)) {
            return new AssignStatNode((AssignRightNode) assignRHS, (AssignLeftNode) assignLHS);
        } else {
            return handleError(ctx.assignRHS(), ErrorHandle.ERRORTYPE_INCOMPATIBLE_TYPE);
        }

    }

    @Override
    public ASTNode visitDeclare_stat(@NotNull BasicParser.Declare_statContext ctx) {
        Type variableType = identifyType(ctx.type());
        String ident = ctx.IDENT().getText();
        ASTNode assignRhs = visit(ctx.assignRHS());

        if (assignRhs instanceof AssignRightNode) {
            if (operandsTypeCheck(variableType, (AssignRightNode) assignRhs)) {
                try {
                    symbolTable.addVariable(ident, variableType);
                } catch (SemanticException e){
                    return handleError(ctx, ErrorHandle.ERRORTYPE_DUPLICATE_IDENT);
                }
                return new DeclareStatNode(variableType, new IdentNode(ident), (AssignRightNode) assignRhs);
            } else {
                return handleError(ctx.assignRHS(), ErrorHandle.ERRORTYPE_INCOMPATIBLE_TYPE);
            }
        } else {
            return handleError(ctx.assignRHS(), ((ErrorNode)assignRhs).getErrorType());
            //System.err.println("type mismatch");
        }
    }

    @Override
    public ASTNode visitExit_stat(@NotNull BasicParser.Exit_statContext ctx) {

        ASTNode exitCode = visit(ctx.expr());
        Type exitCodeType = null;

        if(!(exitCode instanceof ExpressionNode)){
//            System.err.println("Incompatible type in exitCode.");
            return handleError(ctx.expr(), ((ErrorNode)exitCode).getErrorType());
        }

        try{
            exitCodeType = exitCode.getNodeType(symbolTable);
        } catch (SemanticException e){
            //TODO:
            System.err.println("Cannot get exitCode's type in exit stat.");
            return handleError(ctx.expr(), ErrorHandle.ERRORTYPE_UNDEFINED_VAR);
        }

        if(!(exitCodeType instanceof IntType)){
            return handleError(ctx.expr(), ErrorHandle.ERRORTYPE_INCOMPATIBLE_TYPE);
            //System.err.println("The exit code must be an int");
        }

        return new ExitStatNode((ExpressionNode) exitCode);
    }

    @Override
    public ASTNode visitFree_stat(@NotNull BasicParser.Free_statContext ctx) {
        ASTNode expr = visit(ctx.expr());
        Type exprType = null;

        if(!(expr instanceof ExpressionNode)){
            return handleError(ctx.expr(), ((ErrorNode) expr).getErrorType());
            //System.err.println("Please put an expression(pair) to free.");
        }

        try{
            exprType = expr.getNodeType(symbolTable);
        } catch (SemanticException e){
            System.err.println("Cannot get the expressionType in free statement.");
            return handleError(ctx.expr(), ErrorHandle.ERRORTYPE_UNDEFINED_VAR);
        }

        if(!((exprType instanceof PairType) || (exprType instanceof ArrayType))) {
            return handleError(ctx.expr(), ErrorHandle.ERRORTYPE_INCOMPATIBLE_TYPE);
            //System.err.println("Free is used to free the heap memory for pairType");
        }

        return new FreeStatNode((ExpressionNode) expr);
    }

    @Override
    public ASTNode visitIf_stat(@NotNull BasicParser.If_statContext ctx) {
        ASTNode cond = visit(ctx.expr());
        newSymbolTable();
        ASTNode statListIF = visit(ctx.statList(0));
        popSymbolTable();
        newSymbolTable();
        ASTNode statListELSE = visit(ctx.statList(1));
        popSymbolTable();

        Type condType;

        if(!(cond instanceof ExpressionNode)){
            return handleError(ctx.expr(), ((ErrorNode)cond).getErrorType());
            //System.err.println("Incompatible type in condition expr in If statement");
        }

        if(!(statListIF instanceof StatListNode)){
            return handleError(ctx.statList(0), ((ErrorNode)statListIF).getErrorType());
            //System.err.println("Incompatible type in IF stat body in if statement");
        }

        if(!(statListELSE instanceof StatListNode)){
            return handleError(ctx.statList(1), ((ErrorNode)statListELSE).getErrorType());
            //System.err.println("Incompatible type in Else stat body in if statement");
        }

        try{
            condType = cond.getNodeType(symbolTable);
            if(!condType.equals(new BoolType())){
                return handleError(ctx.expr(), ErrorHandle.ERRORTYPE_INCOMPATIBLE_TYPE);
                //System.err.println("The condition should result in a boolean type.");
            }
        } catch (SemanticException e){
            //TODO:
            System.err.println("Cannot get condition's type in if statement");
            return handleError(ctx.expr(), ErrorHandle.ERRORTYPE_UNDEFINED_VAR);
        }

        return new IfStatNode((ExpressionNode) cond, (StatListNode) statListIF, (StatListNode) statListELSE);
    }

    @Override
    public ASTNode visitPrintln_stat(@NotNull BasicParser.Println_statContext ctx) {
        ASTNode expr = visit(ctx.expr());

        if(!(expr instanceof ExpressionNode)){
            return handleError(ctx, ((ErrorNode)expr).getErrorType());
        }

        if (expr instanceof IdentNode) {
            if (!symbolTable.hasVariable(((IdentNode) expr).getId())) {
                handleError(ctx.expr(), ErrorHandle.ERRORTYPE_UNDEFINED_VAR);
            }
        }

        return new PrintlnStatNode((ExpressionNode) expr);

    }

    @Override
    public ASTNode visitPrint_stat(@NotNull BasicParser.Print_statContext ctx) {
        ASTNode expr = visit(ctx.expr());

        if(!(expr instanceof ExpressionNode)){
            return handleError(ctx.expr(), ErrorHandle.ERRORTYPE_INCOMPATIBLE_TYPE);
        }


        if (expr instanceof IdentNode) {
            if (!symbolTable.hasVariable(((IdentNode) expr).getId())) {
                handleError(ctx.expr(), ErrorHandle.ERRORTYPE_UNDEFINED_VAR);
            }
        }

        return new PrintlnStatNode((ExpressionNode) expr);
    }

    @Override
    public ASTNode visitReturn_stat(@NotNull BasicParser.Return_statContext ctx) {
        ASTNode expr = visit(ctx.expr());
        if(!(expr instanceof ExpressionNode)){
            return handleError(ctx.expr(), ((ErrorNode)expr).getErrorType());
            //System.out.println("Error: need an expr for println");
        }

        try{
            expr.getNodeType(symbolTable);
        } catch (SemanticException e){
            System.err.println("Cannot get exprType in return statement.");
            return handleError(ctx.expr(), ErrorHandle.ERRORTYPE_UNDEFINED_VAR);
        }

        return new ReturnStatNode((ExpressionNode) expr);
    }

    @Override
    public ASTNode visitRead_stat(@NotNull BasicParser.Read_statContext ctx) {
        ASTNode assignLHS = visit(ctx.assignLHS());
        Type assignLHSType;

        if(!(assignLHS instanceof AssignLeftNode)){
            handleError(ctx.assignLHS(), ErrorHandle.ERRORTYPE_INCOMPATIBLE_TYPE);
            System.out.println("Error: need type assignLHS for read");
        }
        try{
            assignLHSType = assignLHS.getNodeType(symbolTable);
            if (assignLHSType.equals(new IntType()) || assignLHSType.equals(new CharType())) {
                return new ReadStatNode(assignLHS);
            } else {
                return handleError(ctx.assignLHS(), ErrorHandle.ERRORTYPE_INCOMPATIBLE_TYPE);
            }
//            if(assignLHSType instanceof PairType){
//                PairType pairType = (PairType) assignLHSType;
//                PairElemAsLNode assignLPair = (PairElemAsLNode) assignLHS;
//
//                Type elemType;
//                elemType = assignLPair.getPairElemNode().isFirst() ? pairType.getFstExprType() : pairType.getSndExprType();
//
//
//                if(!(elemType.equals(new IntType()) || elemType.equals(new CharType()))) {
////                    System.err.println("Incompatible type -- The read statement can only handle character or integer input.");
//                    return handleError(ctx.assignLHS(), ErrorHandle.ERRORTYPE_INCOMPATIBLE_TYPE);
//                }
//            }
//
//            if (!(assignLHSType.equals(new IntType()) || assignLHSType.equals(new CharType()))) {
////                System.err.println("Incompatible type in target");
//                return handleError(ctx.assignLHS(), ErrorHandle.ERRORTYPE_INCOMPATIBLE_TYPE);
//
//
//            }

        } catch (SemanticException e){
            //todo: throw semantic exception
            System.err.println("Cannot get assignLHS's node type.");
            return handleError(ctx.assignLHS(), ErrorHandle.ERRORTYPE_UNDEFINED_VAR);
        }
    }

    @Override
    public ASTNode visitScope_stat(@NotNull BasicParser.Scope_statContext ctx) {
        newSymbolTable();

        ParserRuleContext sctx = ctx.statList();
        ASTNode statListNode = visit(sctx);

        if( !(statListNode instanceof StatListNode)){
            return handleError(ctx.statList(), ((ErrorNode)statListNode).getErrorType());
        }

        if (statListNode instanceof StatListNode) {
            // check if statList contains return stat
            Type retType = getRetTypeInStatList((BasicParser.StatListContext) sctx, sctx);
            if (retType != null && !retType.equals(new StatementType())) {
                return handleError(sctx, ErrorHandle.ERRORTYPE_NO_RETURN_GLOBAL_SCOPE);
            }
        } else {
            return handleError(ctx.statList(), ((ErrorNode)statListNode).getErrorType());
        }

        popSymbolTable();
        return new ScopingStatNode((StatListNode) statListNode);
    }

    @Override
    public ASTNode visitSkip_stat(@NotNull BasicParser.Skip_statContext ctx) {
        return new SkipStatNode();
    }

    @Override
    public ASTNode visitStatList(@NotNull BasicParser.StatListContext ctx) {
        List<BasicParser.StatContext> sctxs = ctx.stat();
        List<StatementNode> nodes = new ArrayList<>();
        for (BasicParser.StatContext sctx : sctxs) {
            ASTNode statNode = visit(sctx);
            if (statNode instanceof StatementNode) {
                nodes.add((StatementNode) statNode);
            } else {
                return handleError(sctx, ((ErrorNode)statNode).getErrorType());
            }
        }
        return new StatListNode(nodes);
    }

    @Override
    public ASTNode visitWhile_stat(@NotNull BasicParser.While_statContext ctx) {
        newSymbolTable();

        ASTNode cond = visit(ctx.expr());
        Type condType;
        ASTNode statListNode = visit(ctx.statList());

        if(!(cond instanceof ExpressionNode)){
            return handleError(ctx.expr(), ((ErrorNode)cond).getErrorType());
            //System.err.println("Incompatible type in While.");
        }

        if(!(statListNode instanceof StatListNode)){
            return handleError(ctx.statList(), ((ErrorNode)statListNode).getErrorType());
            //System.err.println("Incompatible type in While.");
        }

        //Checking if the condition returns a boolean
        try{
            condType = cond.getNodeType(symbolTable);
            if(!condType.equals(new BoolType())){
                return handleError(ctx.expr(), ErrorHandle.ERRORTYPE_INCOMPATIBLE_TYPE);
                //System.err.println("Incompatible type in condition.");
            }
        } catch (SemanticException e){
            System.err.println("Cannot get condition's type.");
            return handleError(ctx.expr(), ErrorHandle.ERRORTYPE_UNDEFINED_VAR);
        }

        /*
        try{
            statListNode.getNodeType(symbolTable);
        } catch (SemanticException e){
            System.err.println("Should not reach here since statListNode is an instance of StatementNode and getNodeType should return StatType directly");
            return handleError(ctx.statListNode(), ErrorHandle.UNDEFINED);
        }
        */

        popSymbolTable();
        return new WhileStatNode((ExpressionNode) cond, (StatListNode) statListNode);
    }

    @Override
    public ASTNode visitFunc(@NotNull BasicParser.FuncContext ctx) {
        newSymbolTable();

        String fname = ctx.IDENT().getText();
        Type actualRetType = null;
        StatListNode statListNode = null;
        ParamListNode paramListNode = null;

        BasicParser.ParamListContext pctx = ctx.paramList();

        ASTNode pNode;
        if (pctx != null) {
            pNode = visit(ctx.paramList());
            if (pNode instanceof ParamListNode) {
                paramListNode = (ParamListNode) pNode;
            } else {
                return handleError(ctx.paramList(), ((ErrorNode)pNode).getErrorType());
            }
        }

        // get statList
        ParserRuleContext sctx = ctx.statList();
                ASTNode sNode = visit(sctx);
        if (sNode instanceof StatListNode) {
            statListNode = (StatListNode) sNode;
        } else {
            return handleError(ctx.statList(), ((ErrorNode)sNode).getErrorType());
        }

        // get acutal return type
        actualRetType = getRetTypeInStatList((BasicParser.StatListContext) sctx, sctx);

        // compare expected and actual return type
        try {
            Type fType = symbolTable.lookUpFunction(fname);
            if (!((FunctionType)fType).getReturnType().equals(actualRetType)
                    && !actualRetType.equals(new StatementType())) {
                return handleError(ctx, ErrorHandle.ERRORTYPE_INCOMPATIBLE_TYPE) ;
            }
        } catch (SemanticException e) {
            return handleError(ctx, ErrorHandle.ERRORTYPE_UNDEFINED_FUNC) ;
        }



        popSymbolTable();
        return new FunctionNode(actualRetType, new IdentNode(fname), paramListNode, statListNode);
    }

    @Override
    public ASTNode visitProgram(@NotNull BasicParser.ProgramContext ctx) {

        symbolTable = new SymbolTable();

        // add function declaration to program symbol table
        List<BasicParser.FuncContext> fctxs = ctx.func();

        for (BasicParser.FuncContext fctx : fctxs) {
            String funcName = fctx.IDENT().getText();
            Type retType = identifyType(fctx.type());
            List<Type> paramTypes = null;
            BasicParser.ParamListContext pctx = fctx.paramList();
            ASTNode paramListNode;
            if (pctx == null ) {
                try {
                    symbolTable.addFunction(funcName, new FunctionType(retType));
                } catch (SemanticException e) {
                    return handleError(fctx, ErrorHandle.ERRORTYPE_DUPLICATE_FUNC);
                }
            } else {
                paramListNode = visit(fctx.paramList());
                try {
                    if (paramListNode instanceof ParamListNode) {
                        paramTypes = ((ParamListNode) paramListNode).getNodeTypes(symbolTable);
                    } else {
                        return handleError(fctx, ((ErrorNode) paramListNode).getErrorType());
                    }
                    if (retType != null) {
                        symbolTable.addFunction(funcName, new FunctionType(retType ,paramTypes));
                    } else {
                        return handleError(fctx, ErrorHandle.ERRORTYPE_UNDEFINED_FUNC);
                    }
                } catch (SemanticException e) {
                    return handleError(fctx, ErrorHandle.ERRORTYPE_DUPLICATE_FUNC);
                }
            }
            symbolTable.clearParamsInVarTable();
        }

        // visit and parse functions
        List<FunctionNode> functions = new ArrayList<>();
        for (BasicParser.FuncContext fctx : fctxs) {
            ASTNode fnode = visit(fctx);
            if (fnode instanceof FunctionNode) {
                functions.add((FunctionNode) fnode);
            } else {
                return handleError(fctx, ((ErrorNode)fnode).getErrorType());
            }
        }

        // visit statlist
        ParserRuleContext sctx = ctx.statList();
        ASTNode statListNode = visit(sctx);
        if (statListNode instanceof StatListNode) {
            // check if statList contains return stat
            Type retType = getRetTypeInStatList((BasicParser.StatListContext) sctx, sctx);
            if (retType != null && !retType.equals(new StatementType())) {
                return handleError(sctx, ErrorHandle.ERRORTYPE_NO_RETURN_GLOBAL_SCOPE);
            }
        } else {
            return handleError(ctx.statList(), ((ErrorNode)statListNode).getErrorType());
        }

        return new ProgramNode(functions, (StatListNode) statListNode);
    }


    /////////////////////////// helper method //////////////////////////////////

    // get Type from typeContext
    private Type identifyType(BasicParser.TypeContext ctx) {
        // determine whether it's baseType, arrayType or pairType

        if (ctx.arrayType() != null) { // arrayType
            BasicParser.ArrayTypeContext actx = ctx.arrayType();
            return identifyArrayType(actx);
        }

        if (ctx.baseType() != null) { // baseType
            BasicParser.BaseTypeContext btctx = ctx.baseType();
            if (btctx.STRING() != null) {
                return new ArrayType(new CharType());
            }
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
//            if (ctx.baseType().STRING() != null) {
//                return new ArrayType(new CharType());
//            }
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
            return new ArrayType(new CharType());
        }

        System.err.println("Incompatible type -- unknown base type");
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
        System.err.println("Incompatible type -- unknown pair elem type encounter.");
        return null;
    }

    // ensure the LHS and RHS of assignment and declaration are of same type
    private boolean operandsTypeCheck(Type targetType, AssignRightNode node) {
        Type rhsType;
        try{
            rhsType = node.getNodeType(symbolTable);
        } catch (SemanticException e){
            //TODO
            System.err.println("Cannot get assignment type in assign statement.");
            return false;
        }

        if(targetType != null && rhsType != null){
            if(node instanceof AssignRightNode && !(node instanceof ArgListNode)) {
                if (node instanceof NewPairAsRNode) {
                    if (!(targetType instanceof PairType)) {
                        //TODO
                        System.err.println("target type is not pair type");
                        return false;
                    }
                    PairType lhsType = (PairType) targetType;

                    if (!(lhsType.equals(rhsType))) {
                        //TODO
                        System.err.println("target pair elements mismatched with assignments");
                        return false;
                    }
                    return true;
                }

                if (targetType.equals(rhsType)) {
                    return true;
                }
                //TODO
                System.err.println("Different types in target and assign value");
            }

            return false;
        } else if (node instanceof PairLiterNode && targetType instanceof PairType) {
            return true;
        }
        return false;
    }

    // handle semantic error
    private ASTNode handleEAError(ParserRuleContext ctx, ErrorHandle errorType, Type exp, Type act){
        hasSemanticError = true;
        String errorMSG = errorType.getErrorMsg();
        int line = ctx.start.getLine();
        int charIndex = ctx.start.getCharPositionInLine();
        System.err.println("Semantic Error detected at line " + line + ": " + charIndex + "-- " + errorMSG
                            + "(expected: " + exp + ")"
                            + "(actual: " + act + ")");
        return new ErrorNode(errorType);
    }

    private ASTNode handleError(ParserRuleContext ctx, ErrorHandle errorType){
        hasSemanticError = true;
        String errorMSG = errorType.getErrorMsg();
        int line = ctx.start.getLine();
        int charIndex = ctx.start.getCharPositionInLine();
        System.err.println("Semantic Error detected at line " + line + ": " + charIndex + "-- " + errorMSG);
        return new ErrorNode(errorType);
    }

    public boolean hasSemanticError() {
        return hasSemanticError;
    }

    // create new symbol table with parent as current symbol table
    private void newSymbolTable() {
        SymbolTable st = new SymbolTable(symbolTable);
        symbolTable = st;
    }

    // discard current symbol table and set current table as its parent
    private void popSymbolTable() {
        if (symbolTable.getParent() == null) {
            System.err.println("error in finding symbol table parent");
        } else {
            symbolTable = symbolTable.getParent();
        }
    }

    // get actual return type from statlist, two arguments should be the same, the second is to identify where does the error (if any) occurs
    private Type getRetTypeInStatList(@NotNull BasicParser.StatListContext ctx, @NotNull ParserRuleContext errorCtx) {
        List<BasicParser.StatContext> stats = ctx.stat();
        for (BasicParser.StatContext stat : stats) {
            if (stat instanceof BasicParser.Return_statContext) {
                ASTNode node = visit((BasicParser.Return_statContext) stat);
                if (node instanceof ReturnStatNode) {
                    try {
                        return ((ReturnStatNode) node).getReturnType(symbolTable);
                    } catch (SemanticException e) {
                        System.err.println(e);
                    }
                    errorCtx = stat;
                    return null;
                }
            }

            if (stat instanceof BasicParser.If_statContext) {
                newSymbolTable();
                visit(((BasicParser.If_statContext) stat).statList(0));
                Type trueType = getRetTypeInStatList(
                        ((BasicParser.If_statContext) stat).statList(0),
                        ((BasicParser.If_statContext) stat).statList(0));
                popSymbolTable();

                newSymbolTable();
                visit(((BasicParser.If_statContext) stat).statList(1));
                Type falseType = getRetTypeInStatList(
                        ((BasicParser.If_statContext) stat).statList(1),
                        ((BasicParser.If_statContext) stat).statList(1));
                popSymbolTable();
                if (trueType != null && falseType != null) {
                    if (trueType.equals(falseType)) {
                        return trueType;
                    }
                    if (trueType.equals(new StatementType())) {
                        return falseType;
                    }
                    if (falseType.equals(new StatementType())) {
                        return trueType;
                    }
                }
            }

            if (stat instanceof BasicParser.While_statContext) {
                newSymbolTable();
                visit(((BasicParser.While_statContext) stat).statList());
                Type type = getRetTypeInStatList(
                        ((BasicParser.While_statContext) stat).statList(),
                        ((BasicParser.While_statContext) stat).statList());
                popSymbolTable();
                if (type != null) {
                    return type;
                }
            }

            if (stat instanceof BasicParser.Scope_statContext) {
                newSymbolTable();
                visit(((BasicParser.Scope_statContext) stat).statList());
                Type type = getRetTypeInStatList(
                        ((BasicParser.Scope_statContext) stat).statList(),
                        ((BasicParser.Scope_statContext) stat).statList());
                popSymbolTable();
                if (type != null) {
                    return type;
                }
            }

            if (stat instanceof BasicParser.Exit_statContext) {
                return new StatementType();
            }

        }
        return null;
    }

}