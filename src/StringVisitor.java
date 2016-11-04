import antlr.BasicParser;
import antlr.BasicParserBaseVisitor;
import org.antlr.v4.runtime.misc.NotNull;

public class StringVisitor extends BasicParserBaseVisitor<String> {

    @Override
    public String visitArgList(@NotNull BasicParser.ArgListContext ctx) {
        return super.visitArgList(ctx);
    }

    @Override
    public String visitArrayLiter(@NotNull BasicParser.ArrayLiterContext ctx) {
        return super.visitArrayLiter(ctx);
    }

    @Override
    public String visitArrayElem(@NotNull BasicParser.ArrayElemContext ctx) {
        return super.visitArrayElem(ctx);
    }

    @Override
    public String visitArrayType(@NotNull BasicParser.ArrayTypeContext ctx) {
        return super.visitArrayType(ctx);
    }

    @Override
    public String visitStat(@NotNull BasicParser.StatContext ctx) {
        return super.visitStat(ctx);
    }

    @Override
    public String visitAssignRHS(@NotNull BasicParser.AssignRHSContext ctx) {
        return super.visitAssignRHS(ctx);
    }

    @Override
    public String visitAssignLHS(@NotNull BasicParser.AssignLHSContext ctx) {
        return super.visitAssignLHS(ctx);
    }

    @Override
    public String visitUnaryOper(@NotNull BasicParser.UnaryOperContext ctx) {
        return super.visitUnaryOper(ctx);
    }

    @Override
    public String visitProgram(@NotNull BasicParser.ProgramContext ctx) {
        return super.visitProgram(ctx);
    }

    @Override
    public String visitBinaryOper(@NotNull BasicParser.BinaryOperContext ctx) {
        return super.visitBinaryOper(ctx);
    }

    @Override
    public String visitType(@NotNull BasicParser.TypeContext ctx) {
        return super.visitType(ctx);
    }

    @Override
    public String visitPairType(@NotNull BasicParser.PairTypeContext ctx) {
        return super.visitPairType(ctx);
    }

    @Override
    public String visitPairElemType(@NotNull BasicParser.PairElemTypeContext ctx) {
        return super.visitPairElemType(ctx);
    }

    @Override
    public String visitBaseType(@NotNull BasicParser.BaseTypeContext ctx) {
        return super.visitBaseType(ctx);
    }

    @Override
    public String visitFunc(@NotNull BasicParser.FuncContext ctx) {
        return super.visitFunc(ctx);
    }

    @Override
    public String visitParam(@NotNull BasicParser.ParamContext ctx) {
        return super.visitParam(ctx);
    }

    @Override
    public String visitParamList(@NotNull BasicParser.ParamListContext ctx) {
        return super.visitParamList(ctx);
    }

    @Override
    public String visitExpr(@NotNull BasicParser.ExprContext ctx) {
        return super.visitExpr(ctx);
    }

    @Override
    public String visitPairElem(@NotNull BasicParser.PairElemContext ctx) {
        return super.visitPairElem(ctx);
    }
}
