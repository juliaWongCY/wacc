package ast;

import backEnd.AssemblyCode;
import backEnd.General.Label;
import backEnd.Register;
import errorHandling.ErrorHandle;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.Type;

import java.util.List;

public class ErrorNode implements ASTNode {

    private ErrorHandle errorType;

    public ErrorNode(ErrorHandle errorType) {
        this.errorType = errorType;
    }

    public ErrorHandle getErrorType() {
        return errorType;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
        System.err.println("should not call getNodeType on errorNode");
        return null;
    }

    @Override
    public AssemblyCode toAssemblyCode(AssemblyCode originalInstructions, Register registers, List<Label> labels) {
        return null;
    }
}
