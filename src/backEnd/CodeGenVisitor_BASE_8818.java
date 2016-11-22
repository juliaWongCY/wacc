package backEnd;

import ast.ASTNode;
import ast.statement.StatListNode;
import backEnd.general.Label;
import backEnd.symbolTable.FuncSymbolTable;
import backEnd.symbolTable.VarSymbolTable;

import java.util.List;

public class CodeGenVisitor {

    private VarSymbolTable  varSymbolTable;
    private FuncSymbolTable funcSymbolTable;
    private List<Label> labels;

    ///////////////////////// assignment LHS and RHS ////////////////////////////////////
    public AssemblyCode visitArrayElemAsLNode(ASTNode node, AssemblyCode instructions, List<Register> registers){
        return instructions;
    }

    public AssemblyCode visitIdentAsLNode(ASTNode node, AssemblyCode instructions, List<Register> registers){
        return instructions;
    }

    public AssemblyCode visitPairElemAsLNode(ASTNode node, AssemblyCode instructions, List<Register> registers){
        return instructions;
    }

    public AssemblyCode visitArgListNode(ASTNode node, AssemblyCode instructions, List<Register> registers){
        return instructions;
    }

    public AssemblyCode visitArrayLiterAsRNode(ASTNode node, AssemblyCode instructions, List<Register> registers){
        return instructions;
    }

    public AssemblyCode visitCallAsRNode(ASTNode node, AssemblyCode instructions, List<Register> registers){
        return instructions;
    }

    public AssemblyCode visitExprAsRNode(ASTNode node, AssemblyCode instructions, List<Register> registers){
        return instructions;
    }

    public AssemblyCode visitNewPairAsRNode(ASTNode node, AssemblyCode instructions, List<Register> registers){
        return instructions;
    }

    public AssemblyCode visitPairElemAsRNode(ASTNode node, AssemblyCode instructions, List<Register> registers){
        return instructions;
    }

    //////////////////////expression///////////////////////////////////////////////////////

    public AssemblyCode visitArrayElemNode(ASTNode node, AssemblyCode instructions, List<Register> registers){
        return instructions;
    }

    public AssemblyCode visitBinaryOprNode(ASTNode node, AssemblyCode instructions, List<Register> registers){
        return instructions;
    }

    public AssemblyCode visitBoolLiterNode(ASTNode node, AssemblyCode instructions, List<Register> registers){
        return instructions;
    }

    public AssemblyCode visitCharLiterNode(ASTNode node, AssemblyCode instructions, List<Register> registers){
        return instructions;
    }

    public AssemblyCode visitIdentNode(ASTNode node, AssemblyCode instructions, List<Register> registers){
        return instructions;
    }

    public AssemblyCode visitIntLiterNode(ASTNode node, AssemblyCode instructions, List<Register> registers){
        return instructions;
    }

    public AssemblyCode visitPairElemNode(ASTNode node, AssemblyCode instructions, List<Register> registers){
        return instructions;
    }

    public AssemblyCode visitPairLiterNode(ASTNode node, AssemblyCode instructions, List<Register> registers){
        return instructions;
    }

    public AssemblyCode visitStringLiterNode(ASTNode node, AssemblyCode instructions, List<Register> registers){
        return instructions;
    }

    public AssemblyCode visitUnaryOprNode(ASTNode node, AssemblyCode instructions, List<Register> registers){
        return instructions;
    }

    ////////////////////////////////parameter/////////////////////////////

    public AssemblyCode visitParamListNode(ASTNode node, AssemblyCode instructions, List<Register> registers){
        return instructions;
    }

    public AssemblyCode visitParamNode(ASTNode node, AssemblyCode instructions, List<Register> registers){
        return instructions;
    }

    /////////////////////////////////statement//////////////////////////////

    public AssemblyCode visitAssignStatNode(ASTNode node, AssemblyCode instructions, List<Register> registers){
        return instructions;
    }

    public AssemblyCode visitDeclareStatNode(ASTNode node, AssemblyCode instructions, List<Register> registers){
        return instructions;
    }

    public AssemblyCode visitExitStatNode(ASTNode node, AssemblyCode instructions, List<Register> registers){
        return instructions;
    }

    public AssemblyCode visitFreeStatNode(ASTNode node, AssemblyCode instructions, List<Register> registers){
        return instructions;
    }

    public AssemblyCode visitIfStatNode(ASTNode node, AssemblyCode instructions, List<Register> registers){
        return instructions;
    }

    public AssemblyCode visitPrintlnStatNode(ASTNode node, AssemblyCode instructions, List<Register> registers){
        return instructions;
    }

    public AssemblyCode visitPrintStatNode(ASTNode node, AssemblyCode instructions, List<Register> registers){
        return instructions;
    }

    public AssemblyCode visitReadStatNode(ASTNode node, AssemblyCode instructions, List<Register> registers){
        return instructions;
    }

    public AssemblyCode visitReturnStatNode(ASTNode node, AssemblyCode instructions, List<Register> registers){
        return instructions;
    }

    public AssemblyCode visitScopingStatNode(ASTNode node, AssemblyCode instructions, List<Register> registers){
        return instructions;
    }

    public AssemblyCode visitSkipStatNode(ASTNode node, AssemblyCode instructions, List<Register> registers){
        return instructions;
    }

    public AssemblyCode visitStatListNode(ASTNode node, AssemblyCode instructions, List<Register> registers){
        StatListNode sNode = (StatListNode) node;

        return instructions;
    }

    public AssemblyCode visitWhileStatNode(ASTNode node, AssemblyCode instructions, List<Register> registers){
        return instructions;
    }

    ////////////////////////////function and program//////////////////////////////////////

    public AssemblyCode visitFunctionNode(ASTNode node, AssemblyCode instructions, List<Register> registers){
        return instructions;
    }

    public AssemblyCode visitProgramNode(ASTNode node, AssemblyCode instructions, List<Register> registers){
        return instructions;
    }

}
