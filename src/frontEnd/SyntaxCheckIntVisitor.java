package frontEnd;


import antlr.BasicParser;
import antlr.BasicParserBaseVisitor;
import errorHandling.ErrorHandle;
import errorHandling.ErrorType;
import org.antlr.v4.runtime.tree.TerminalNode;

public class SyntaxCheckIntVisitor extends BasicParserBaseVisitor<Boolean> {

    @Override
    protected Boolean defaultResult() {
        return true;
    }

    @Override
    protected Boolean aggregateResult(Boolean aggregate, Boolean nextResult) {
        return aggregate && nextResult;
    }

    @Override
    public Boolean visitInt_liter(BasicParser.Int_literContext ctx) {
        TerminalNode int_liter = ctx.intliter().INTEGER();
        try {
                Integer.parseInt(int_liter.getText());

        } catch (NumberFormatException e) {
            ErrorHandle errType = new ErrorHandle(ErrorType.INTEGER_OVERFLOW);
            int line = int_liter.getSymbol().getLine();
            int charI = int_liter.getSymbol().getCharPositionInLine();
            handleError(line, charI, errType);
            return false;
        } catch (NullPointerException e) {
            return visitChildren(ctx);
        }
        return true;
    }

    private void handleError(int line, int charIndex, ErrorHandle errorType){
        String errorMSG = errorType.getErrorMsg();
        System.err.println("Syntax Error detected at line " + line + ": " + charIndex + "-- " + errorMSG);
    }





}
