import antlr.BasicLexer;
import antlr.BasicParser;
import frontEnd.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Main {

    private final int FILEERROR_EXITCODE = 1;
    private final int SYNTAXERROR_EXITCODE = 100;
    private final int SEMANTICERROR_EXITCODE = 200;

    public static void main(String[] args) {
        if (args.length == 0 || !args[0].endsWith(".wacc")) {
            System.err.println("The file must be in .wacc extension");
            System.exit(FILEERROR_EXITCODE);
        }

        ANTLRInputStream inputFile = null;

        try {
            inputFile = new ANTLRInputStream(new FileInputStream(args[0]));
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
            System.exit(FILEERROR_EXITCODE);
        } catch (IOException e) {
            System.err.println("Failed to read the file.");
            System.exit(FILEERROR_EXITCODE);
        }

        BasicLexer lexer = new BasicLexer(inputFile);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        BasicParser parser = new BasicParser(tokens);

        ParseTree tree = parser.program();

        SymbolTable symbolTable = new SymbolTable(null);

        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.exit(SYNTAXERROR_EXITCODE);
        }

        SyntaxCheckIntVisitor syntaxCheckIntVisitor = new SyntaxCheckIntVisitor();
        SyntaxCheckLastStatVisitor syntaxCheckLastStatVisitor = new SyntaxCheckLastStatVisitor();
        if (!syntaxCheckIntVisitor.visit(tree) || !syntaxCheckLastStatVisitor.visit(tree)) {
            System.exit(SYNTAXERROR_EXITCODE);
        }


        SemanticCheckVisitor semanticCheckVisitor = new SemanticCheckVisitor(symbolTable);
        semanticCheckVisitor.visit(tree);
        if (semanticCheckVisitor.hasSemanticError()) {
            System.exit(SEMANTICERROR_EXITCODE);
        }

    }

}
