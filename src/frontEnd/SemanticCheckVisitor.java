package frontEnd;

import antlr.BasicParser;
import antlr.BasicParserBaseVisitor;
import ast.ASTNode;
import ast.FunctionNode;
import ast.ProgramNode;
import ast.statement.StatementNode;

import java.util.List;

public class SemanticCheckVisitor extends BasicParserBaseVisitor<ASTNode> {

    @Override
    public ASTNode visitArgList(BasicParser.ArgListContext ctx) {
        // argList is only referenced in assign-rhs, as the parameter to a function,
        // so the method should a argListNode with all respective node;
        // argListNode should provide a method that return all types of variable,
        // so visitassignLHS can call and use it to compare with the param type of the function
        List<BasicParser.ExprContext> exprs = ctx.expr();

        return super.visitArgList(ctx);
    }

    @Override
    public ASTNode visitArrayLiter(BasicParser.ArrayLiterContext ctx) {
        return super.visitArrayLiter(ctx);
    }

    @Override
    public ASTNode visitArrayElem(BasicParser.ArrayElemContext ctx) {
        return super.visitArrayElem(ctx);
    }

    @Override
    public ASTNode visitArrayType(BasicParser.ArrayTypeContext ctx) {
        return super.visitArrayType(ctx);
    }

    @Override
    public ASTNode visitStat(BasicParser.StatContext ctx) {
        return super.visitStat(ctx);
    }

    @Override
    public ASTNode visitAssignRHS(BasicParser.AssignRHSContext ctx) {
        return super.visitAssignRHS(ctx);
    }

    @Override
    public ASTNode visitAssignLHS(BasicParser.AssignLHSContext ctx) {
        return super.visitAssignLHS(ctx);
    }

    @Override
    public ASTNode visitUnaryOper(BasicParser.UnaryOperContext ctx) {
        return super.visitUnaryOper(ctx);
    }

    @Override
    public ASTNode visitProgram(BasicParser.ProgramContext ctx) {
        // base case: tokens are in correct type and correct order
        // advanced:  ident are declared, assignment is same type with variable,
        // put variable/function to symbol table, etc

        // base case - didn't add to symbol table or perform type check or return error
        ProgramNode programNode = new ProgramNode();
        List<BasicParser.FuncContext> functions = ctx.func();
        BasicParser.StatContext statements      = ctx.stat();

        for (BasicParser.FuncContext f : functions) {
            programNode.addFunction((FunctionNode) visitFunc(f));
        }

        programNode.addStatement((StatementNode) visitStat(statements));

        return programNode;
    }

    @Override
    public ASTNode visitBinaryOper(BasicParser.BinaryOperContext ctx) {
        return super.visitBinaryOper(ctx);
    }

    @Override
    public ASTNode visitType(BasicParser.TypeContext ctx) {
        return super.visitType(ctx);
    }

    @Override
    public ASTNode visitPairType(BasicParser.PairTypeContext ctx) {
        return super.visitPairType(ctx);
    }

    @Override
    public ASTNode visitPairElemType(BasicParser.PairElemTypeContext ctx) {
        return super.visitPairElemType(ctx);
    }

    @Override
    public ASTNode visitBaseType(BasicParser.BaseTypeContext ctx) {
        return super.visitBaseType(ctx);
    }

    @Override
    public ASTNode visitFunc(BasicParser.FuncContext ctx) {
        return super.visitFunc(ctx);
    }

    @Override
    public ASTNode visitParam(BasicParser.ParamContext ctx) {
        return super.visitParam(ctx);
    }

    @Override
    public ASTNode visitParamList(BasicParser.ParamListContext ctx) {
        return super.visitParamList(ctx);
    }

    @Override
    public ASTNode visitExpr(BasicParser.ExprContext ctx) {
        return super.visitExpr(ctx);
    }

    @Override
    public ASTNode visitPairElem(BasicParser.PairElemContext ctx) {
        return super.visitPairElem(ctx);
    }
}
