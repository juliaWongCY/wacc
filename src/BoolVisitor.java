import antlr.BasicParser;
import antlr.BasicParserBaseVisitor;
import org.antlr.v4.runtime.misc.NotNull;

public class BoolVisitor extends BasicParserBaseVisitor<Boolean> {

    @Override
    public Boolean visitArgList(@NotNull BasicParser.ArgListContext ctx) {
        return super.visitArgList(ctx);
    }

    @Override
    public Boolean visitArrayLiter(@NotNull BasicParser.ArrayLiterContext ctx) {
        return super.visitArrayLiter(ctx);
    }

    @Override
    public Boolean visitArrayElem(@NotNull BasicParser.ArrayElemContext ctx) {
        return super.visitArrayElem(ctx);
    }

    @Override
    public Boolean visitArrayType(@NotNull BasicParser.ArrayTypeContext ctx) {
        return super.visitArrayType(ctx);
    }

    @Override
    public Boolean visitStat(@NotNull BasicParser.StatContext ctx) {
        return super.visitStat(ctx);
    }

    @Override
    public Boolean visitAssignRHS(@NotNull BasicParser.AssignRHSContext ctx) {
        return super.visitAssignRHS(ctx);
    }

    @Override
    public Boolean visitAssignLHS(@NotNull BasicParser.AssignLHSContext ctx) {
        return super.visitAssignLHS(ctx);
    }

    @Override
    public Boolean visitUnaryOper(@NotNull BasicParser.UnaryOperContext ctx) {
        return super.visitUnaryOper(ctx);
    }

    @Override
    public Boolean visitProgram(@NotNull BasicParser.ProgramContext ctx) {
        return super.visitProgram(ctx);
    }

    @Override
    public Boolean visitBinaryOper(@NotNull BasicParser.BinaryOperContext ctx) {
        return super.visitBinaryOper(ctx);
    }

    @Override
    public Boolean visitType(@NotNull BasicParser.TypeContext ctx) {
        return super.visitType(ctx);
    }

    @Override
    public Boolean visitPairType(@NotNull BasicParser.PairTypeContext ctx) {
        return super.visitPairType(ctx);
    }

    @Override
    public Boolean visitPairElemType(@NotNull BasicParser.PairElemTypeContext ctx) {
        return super.visitPairElemType(ctx);
    }

    @Override
    public Boolean visitBaseType(@NotNull BasicParser.BaseTypeContext ctx) {
        return super.visitBaseType(ctx);
    }

    @Override
    public Boolean visitFunc(@NotNull BasicParser.FuncContext ctx) {
        return super.visitFunc(ctx);
    }

    @Override
    public Boolean visitParam(@NotNull BasicParser.ParamContext ctx) {
        return super.visitParam(ctx);
    }

    @Override
    public Boolean visitParamList(@NotNull BasicParser.ParamListContext ctx) {
        return super.visitParamList(ctx);
    }

    @Override
    public Boolean visitExpr(@NotNull BasicParser.ExprContext ctx) {
        return super.visitExpr(ctx);
    }

    @Override
    public Boolean visitPairElem(@NotNull BasicParser.PairElemContext ctx) {
        return super.visitPairElem(ctx);
    }
}
