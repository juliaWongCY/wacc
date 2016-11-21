package ast.expression;

import backEnd.AssemblyCode;
import backEnd.general.Label;
import backEnd.Register;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.Type;

import java.util.List;

public class IdentNode implements ExpressionNode {

    private final String id;

    public IdentNode(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {

        try {
            return st.lookUpVariable(id);
        } catch (SemanticException e) {
            throw new SemanticException("This " + id + " not an identifier.");
        }

    }

    @Override
    public AssemblyCode toAssemblyCode(AssemblyCode originalInstructions, Register registers, List<Label> labels) {
        return null;
    }
}
