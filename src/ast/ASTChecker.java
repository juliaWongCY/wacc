package ast;

import frontEnd.SemanticCheckVisitor;
import org.antlr.runtime.tree.ParseTree;

public class ASTChecker {

    ProgramNode programNode;

    public AST(ParseTree parseTree) {
        SemanticCheckVisitor checkVisitor = new SemanticCheckVisitor(programNode);
        this.programNode = (ProgramNode) checkVisitor.visit(parseTree);
    }

    public void ASTAnalyser() {

    }

}
