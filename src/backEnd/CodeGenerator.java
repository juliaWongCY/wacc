package backEnd;

import ast.ASTNode;

import java.util.ArrayList;

public class CodeGenerator {

    public List<AssemblyLine> generateCode(ASTNode programNode) {
        AssemblyCode assemblyCode = progNode.transNode(new AssemblyCode(),
                new Register(), new ArrayList<Label>());
        return assemblyCode.toList();
    }

}
