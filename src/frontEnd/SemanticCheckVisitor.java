package frontEnd;

import antlr.BasicParser;
import antlr.BasicParserBaseVisitor;
import ast.*;
import ast.expression.*;
import ast.statement.*;
import ast.assignLeft.*;
import org.antlr.v4.runtime.misc.NotNull;
import type.IntType;
import type.StatementType;

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

       ASTNode child = visitChildren(ctx);

        if(!(child instanceof ExpressionNode)){
            System.out.println("Error: need an expr for println");
        }

        try{
            child.getNodeType(symbolTable);
        } catch (SemanticException e){
            System.out.println("Error: cannot get nodeType of the expression in println statement");
        }
        return new PrintlnStatNode((ExpressionNode) child);

    }

    @Override
    public ASTNode visitScope_stat(@NotNull BasicParser.Scope_statContext ctx) {
        return super.visitScope_stat(ctx);
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
        ASTNode child = visitChildren(ctx);

        if(exitCode instanceof IntType){
            System.out.println("The exit code must be an int");
        }

        if(!(child instanceof ExpressionNode)){
            System.out.println("Must put in an expression (int) in the exit code.");
        }

        try{
            child.getNodeType(symbolTable);
        } catch (SemanticException e){
            System.out.println("Error: cannot get nodeType of the expression in exit statement");
        }

        return new ExitStatNode((ExpressionNode) child);
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
    public ASTNode visitParen(@NotNull BasicParser.ParenContext ctx) {
        return super.visitParen(ctx);
    }

    @Override
    public ASTNode visitParam(@NotNull BasicParser.ParamContext ctx) {
        return super.visitParam(ctx);
    }

    @Override
    public ASTNode visitWhile_stat(@NotNull BasicParser.While_statContext ctx) {
        return super.visitWhile_stat(ctx);
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
        return super.visitIf_stat(ctx);
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
        ASTNode child = visitChildren(ctx);

        if(!(child instanceof ExpressionNode)){
            System.out.println("Error: need an expr for println");
        }

        try{
            child.getNodeType(symbolTable);
        } catch (SemanticException e){
            System.out.println("Error: cannot get nodeType of the expression in println statement");
        }
        // We catch semanticError if child is not an
        return new PrintStatNode((ExpressionNode) child);
    }

    @Override
    public ASTNode visitArrayType(@NotNull BasicParser.ArrayTypeContext ctx) {
        return super.visitArrayType(ctx);
    }

    @Override
    public ASTNode visitAssign_stat(@NotNull BasicParser.Assign_statContext ctx) {
        return super.visitAssign_stat(ctx);
    }

    @Override
    public ASTNode visitBool_liter(@NotNull BasicParser.Bool_literContext ctx) {

        return new BoolLiterNode(Boolean.valueOf(ctx.getText()));

    }

    @Override
    public ASTNode visitReturn_stat(@NotNull BasicParser.Return_statContext ctx) {
        return super.visitReturn_stat(ctx);
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
        return super.visitFree_stat(ctx);
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
    public ASTNode visitConcat_stat(@NotNull BasicParser.Concat_statContext ctx) {
        return super.visitConcat_stat(ctx);
    }

    @Override
    public ASTNode visitRead_stat(@NotNull BasicParser.Read_statContext ctx) {
        return super.visitRead_stat(ctx);
    }

    @Override
    public ASTNode visitAssignl_pairelem(@NotNull BasicParser.Assignl_pairelemContext ctx) {
        return super.visitAssignl_pairelem(ctx);
    }

    @Override
    public ASTNode visitAssignr_paren(@NotNull BasicParser.Assignr_parenContext ctx) {
        return super.visitAssignr_paren(ctx);
    }

    @Override
    public ASTNode visitAssignr_newpair(@NotNull BasicParser.Assignr_newpairContext ctx) {
        return super.visitAssignr_newpair(ctx);
    }
}