package ast;

import backEnd.AssemblyCode;
import backEnd.general.Label;
import backEnd.Register;
import frontEnd.SemanticException;
import frontEnd.SymbolTable;
import type.Type;

import java.util.List;

public interface ASTNode {

    // return the type of the node, which will be done so by recursively telling its children to call this method.
    Type getNodeType(SymbolTable st) throws SemanticException;

    AssemblyCode toAssemblyCode(AssemblyCode originalInstructions, Register registers, List<Label> labels);


}
