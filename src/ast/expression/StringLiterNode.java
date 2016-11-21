package ast.expression;

import backEnd.AssemblyCode;
import backEnd.general.Label;
import backEnd.Register;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.ArrayType;
import type.CharType;
import type.Type;

import java.util.List;

public class StringLiterNode implements ExpressionNode {

    private final String value;

    public StringLiterNode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public Type getNodeType(SymbolTable st) throws SemanticException {
//        StringType stringType = new StringType();
//        return stringType.getType();
        return new ArrayType(new CharType());
    }

    @Override
    public AssemblyCode toAssemblyCode(AssemblyCode originalInstructions, Register registers, List<Label> labels) {
        return null;
    }
}
