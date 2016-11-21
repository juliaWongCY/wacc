package backEnd;

import ast.ASTNode;
import ast.ProgramNode;

import java.util.List;
import java.util.ArrayList;

public class CodeGenerator {

    public List<AssemblyLine> generateCode(ASTNode programNode) {
        Registers registers = new Registers();


        AssemblyCode assemblyCode
                = CodeGenVisitor.visitProgramNode((ProgramNode)programNode,
                                                    new AssemblyCode(),
                                                    registers);
        return assemblyCode.toList();
    }

}
