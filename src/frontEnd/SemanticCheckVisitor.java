package frontEnd;

import antlr.BasicParser;
import antlr.BasicParserBaseVisitor;
import ast.*;
import ast.assignRight.ArrayLiterAsRNode;
import ast.assignRight.AssignRightNode;
import ast.expression.*;
import ast.statement.*;
import ast.assignLeft.*;
import org.antlr.v4.runtime.misc.NotNull;
import type.*;
import java.util.List;

public class SemanticCheckVisitor extends BasicParserBaseVisitor<ASTNode> {

    private SymbolTable symbolTable = null;

    @Override
    public ASTNode visitAssignr_arrayliter(@NotNull BasicParser.Assignr_arrayliterContext ctx) {
        return super.visitAssignr_arrayliter(ctx);
    }

    @Override
    public ASTNode visitArgList(@NotNull BasicParser.ArgListContext ctx) {
        return super.visitArgList(ctx);
    }

    @Override
    public ASTNode visitArrayLiter(@NotNull BasicParser.ArrayLiterContext ctx) {
        return super.visitArrayLiter(ctx);
    }

    @Override
    public ASTNode visitString_liter(@NotNull BasicParser.String_literContext ctx) {
        return new StringLiterNode(ctx.getText());
    }

    @Override
    public ASTNode visitArrayElem(@NotNull BasicParser.ArrayElemContext ctx) {
        return super.visitArrayElem(ctx);
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
        ASTNode stat = visit(ctx.stat());

        if( !(stat.equals(new StatementType()))){
            System.err.println("Incompatible type in scope statement.");
        }

        try{
            stat.getNodeType(symbolTable);
        } catch (SemanticException s){
            System.err.println("Cannot get statement's type in scope statement.");
        }

        return new ScopingStatNode((StatementNode) stat);
    }

    @Override
    public ASTNode visitAssignr_expr(@NotNull BasicParser.Assignr_exprContext ctx) {
        return super.visitAssignr_expr(ctx);
    }

    @Override
    public ASTNode visitUnaryOper(@NotNull BasicParser.UnaryOperContext ctx) {
        return super.visitUnaryOper(ctx);
    }

    @Override
    public ASTNode visitIdent(@NotNull BasicParser.IdentContext ctx) {
        return new IdentNode(ctx.getText());
    }

    @Override
    public ASTNode visitAssignl_arrayelem(@NotNull BasicParser.Assignl_arrayelemContext ctx) {
        return super.visitAssignl_arrayelem(ctx);
    }

    @Override
    public ASTNode visitProgram(@NotNull BasicParser.ProgramContext ctx) {

        // initiate and getting initial variable
        symbolTable = new SymbolTable(null);
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
        return super.visitType(ctx);
    }

    @Override
    public ASTNode visitSkip_stat(@NotNull BasicParser.Skip_statContext ctx) {
        return new SkipStatNode();
    }

    @Override
    public ASTNode visitDeclare_stat(@NotNull BasicParser.Declare_statContext ctx) {
        return super.visitDeclare_stat(ctx);
    }

    @Override
    public ASTNode visitBaseType(@NotNull BasicParser.BaseTypeContext ctx) {
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
        return super.visitParen_expr(ctx);
    }

    @Override
    public ASTNode visitParam(@NotNull BasicParser.ParamContext ctx) {
        return super.visitParam(ctx);
    }

    @Override
    public ASTNode visitWhile_stat(@NotNull BasicParser.While_statContext ctx) {
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

        return new WhileStatNode((ExpressionNode) cond, (StatementNode) stat);
    }

    @Override
    public ASTNode visitAssignl_id(@NotNull BasicParser.Assignl_idContext ctx) {

        return super.visitAssignl_id(ctx);
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
        return super.visitPairElem(ctx);
    }

    @Override
    public ASTNode visitBinary_op(@NotNull BasicParser.Binary_opContext ctx) {
        return super.visitBinary_op(ctx);
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

        try{
            rhsType = assignRHS.getNodeType(symbolTable);
        } catch (SemanticException e){
            System.err.println("Cannot get assignment type in assign statement.");
        }

        if(lhsType != null && rhsType != null){
            if(assignRHS instanceof ExpressionNode || assignRHS instanceof ArrayLiterAsRNode){
                if (!lhsType.equals(rhsType)) {
                    System.err.println("Different types in target and assign value");
                }
            }
        }





        return new AssignStatNode((AssignRightNode) assignRHS, (AssignLeftNode) assignLHS);
    }

    @Override
    public ASTNode visitBool_liter(@NotNull BasicParser.Bool_literContext ctx) {

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
        return super.visitAssignr_pairelem(ctx);
    }

    @Override
    public ASTNode visitUnary_op(@NotNull BasicParser.Unary_opContext ctx) {
        return super.visitUnary_op(ctx);
    }

    @Override
    public ASTNode visitBinaryOper(@NotNull BasicParser.BinaryOperContext ctx) {
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
        return new PairLiterNode();
    }

    @Override
    public ASTNode visitPairType(@NotNull BasicParser.PairTypeContext ctx) {
        return super.visitPairType(ctx);
    }

    @Override
    public ASTNode visitPairElemType(@NotNull BasicParser.PairElemTypeContext ctx) {
      return super.visitPairElemType(ctx);
    }

    @Override
    public ASTNode visitArrayelem(@NotNull BasicParser.ArrayelemContext ctx) {
        return super.visitArrayelem(ctx);
    }

    @Override
    public ASTNode visitFunc(@NotNull BasicParser.FuncContext ctx) {


        return super.visitFunc(ctx);
    }

    @Override
    public ASTNode visitParamList(@NotNull BasicParser.ParamListContext ctx) {
        return super.visitParamList(ctx);
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
        return new SequentialStatNode((StatementNode) statFst);
    }


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
                elemType = assignLPair.isFirst() ? pairType.getFstExprType() : pairType.getSndExprType();

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
        return super.visitAssignl_pairelem(ctx);
    }

    @Override
    public ASTNode visitAssignr_call(@NotNull BasicParser.Assignr_callContext ctx) {
        return super.visitAssignr_call(ctx);
    }

    @Override
    public ASTNode visitAssignr_newpair(@NotNull BasicParser.Assignr_newpairContext ctx) {
        return super.visitAssignr_newpair(ctx);
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

}