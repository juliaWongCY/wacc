package frontEnd;

import antlr.BasicParser;
import antlr.BasicParserBaseVisitor;


public class SyntaxCheckLastStatVisitor extends BasicParserBaseVisitor<Boolean> {

    @Override
    protected Boolean defaultResult() {
        return false;
    }

    @Override
    protected Boolean aggregateResult(Boolean aggregate, Boolean nextResult) {
        return aggregate && nextResult;
    }


    @Override
    public Boolean visitProgram(BasicParser.ProgramContext ctx) {
        boolean result = true;
        for (BasicParser.FuncContext func : ctx.func()) {
            if (!visit(func)) {
                result = false;
            }
        }
        return result;
    }

    @Override
    public Boolean visitFunc(BasicParser.FuncContext ctx) {
        boolean result = visit(ctx.stat());
        if (!result) {
            System.err.println("Function '" + ctx.IDENT().getText() + "' is not ended with a return or an exit statement.");
        }
        return result;
    }

    @Override
    public Boolean visitSequential_stat(BasicParser.Sequential_statContext ctx) {
//        if (!visit(ctx.stat(1))) {
//            return true;
//        }
//
//        return false;
        return visit(ctx.stat(1));
    }

    @Override
    public Boolean visitReturn_stat(BasicParser.Return_statContext ctx) {
        return true;
    }

    @Override
    public Boolean visitExit_stat(BasicParser.Exit_statContext ctx) {
        return true;
    }

    @Override
    public Boolean visitIf_stat(BasicParser.If_statContext ctx) {
        return visit(ctx.stat(0)) && visit(ctx.stat(1));
    }
}
