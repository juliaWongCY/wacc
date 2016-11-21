package backEnd;

import ast.ASTNode;

import java.util.List;
import java.util.ArrayList;

public class CodeGenerator {

    public List<AssemblyLine> generateCode(ASTNode programNode) {
        AssemblyCode assemblyCode = programNode.toAssemblyCode(new AssemblyCode(),
                new Register(), new ArrayList<Label>());
        return assemblyCode.toList();
    }

}
