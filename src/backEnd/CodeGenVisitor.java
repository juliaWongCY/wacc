package backEnd;

import ast.ASTNode;
import backEnd.general.Label;
import backEnd.symbolTable.FuncSymbolTable;
import backEnd.symbolTable.VarSymbolTable;

import java.util.List;

public class CodeGenVisitor {

    private VarSymbolTable  varSymbolTable;
    private FuncSymbolTable funcSymbolTable;
    private List<Label> labels;

    ///////////////////////// assignment LHS and RHS ////////////////////////////////////
    public AssemblyCode visitArrayElemAsLNode(ASTNode node, AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitIdentAsLNode(ASTNode node, AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitPairElemAsLNode(ASTNode node, AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitArgListNode(ASTNode node, AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitArrayLiterAsRNode(ASTNode node, AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitCallAsRNode(ASTNode node, AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitExprAsRNode(ASTNode node, AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitNewPairAsRNode(ASTNode node, AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitPairElemAsRNode(ASTNode node, AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    //////////////////////expression///////////////////////////////////////////////////////

    public AssemblyCode visitArrayElemNode(ASTNode node, AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitBinaryOprNode(ASTNode node, AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitBoolLiterNode(ASTNode node, AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitCharLiterNode(ASTNode node, AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitIdentNode(ASTNode node, AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitIntLiterNode(ASTNode node, AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitPairElemNode(ASTNode node, AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitPairLiterNode(ASTNode node, AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitStringLiterNode(ASTNode node, AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitUnaryOprNode(ASTNode node, AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    ////////////////////////////////parameter/////////////////////////////

    public AssemblyCode visitParamListNode(ASTNode node, AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitParamNode(ASTNode node, AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    /////////////////////////////////statement//////////////////////////////

    public AssemblyCode visitAssignStatNode(ASTNode node, AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitDeclareStatNode(ASTNode node, AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitExitStatNode(ASTNode node, AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitFreeStatNode(ASTNode node, AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitIfStatNode(ASTNode node, AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitPrintlnStatNode(ASTNode node, AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitPrintStatNode(ASTNode node, AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitReadStatNode(ASTNode node, AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitReturnStatNode(ASTNode node, AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitScopingStatNode(ASTNode node, AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitSkipStatNode(ASTNode node, AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitStatListNode(ASTNode node, AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitWhileStatNode(ASTNode node, AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    ////////////////////////////function and program//////////////////////////////////////

    public AssemblyCode visitFunctionNode(ASTNode node, AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitProgramNode(ASTNode node, AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

}
