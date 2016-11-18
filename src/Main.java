import antlr.BasicLexer;
import antlr.BasicParser;
import ast.ASTNode;
import backEnd.CodeGenerator;
import frontEnd.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Main {

    public static void main(String[] args) {
        if (args.length == 0 || !args[0].endsWith(".wacc")) {
            System.err.println("The file must be in .wacc extension");
            System.exit(1);
        }

        ANTLRInputStream inputFile = null;

        try {
            inputFile = new ANTLRInputStream(new FileInputStream(args[0]));
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Failed to read the file.");
            System.exit(1);
        }


        BasicLexer lexer = new BasicLexer(inputFile);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        BasicParser parser = new BasicParser(tokens);

        ParseTree tree = parser.program();

        SymbolTable symbolTable = new SymbolTable(null);

        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.exit(100);
        }

        SyntaxCheckIntVisitor syntaxCheckIntVisitor = new SyntaxCheckIntVisitor();
        SyntaxCheckLastStatVisitor syntaxCheckLastStatVisitor = new SyntaxCheckLastStatVisitor();
        if (!syntaxCheckIntVisitor.visit(tree) || !syntaxCheckLastStatVisitor.visit(tree)) {
            System.exit(100);
        }


        SemanticCheckVisitor semanticCheckVisitor = new SemanticCheckVisitor(symbolTable);
        ASTNode ast = semanticCheckVisitor.visit(tree);
        if (semanticCheckVisitor.hasSemanticError()) {
            System.exit(200);
        }

        //Back-end
        CodeGenerator codeGenerator = new CodeGenerator(ast);
        codeGenerator.generateCode();



    }

}
