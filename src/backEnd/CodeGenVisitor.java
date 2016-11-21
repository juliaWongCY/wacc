package backEnd;

import backEnd.general.Label;
import backEnd.symbolTable.FuncSymbolTable;
import backEnd.symbolTable.VarSymbolTable;

import java.util.List;

public class CodeGenVisitor {

    private VarSymbolTable  varSymbolTable;
    private FuncSymbolTable funcSymbolTable;
    private List<Label> labels;

    ///////////////////////// assignment LHS and RHS ////////////////////////////////////
    public AssemblyCode visitArrayElemAsLNode(AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitIdentAsLNode(AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitPairElemAsLNode(AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitArgListNode(AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitArrayLiterAsRNode(AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitCallAsRNode(AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitExprAsRNode(AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitNewPairAsRNode(AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitPairElemAsRNode(AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    //////////////////////expression///////////////////////////////////////////////////////

    public AssemblyCode visitArrayElemNode(AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitBinaryOprNode(AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitBoolLiterNode(AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitCharLiterNode(AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitIdentNode(AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitIntLiterNode(AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitPairElemNode(AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitPairLiterNode(AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitStringLiterNode(AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitUnaryOprNode(AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    ////////////////////////////////parameter/////////////////////////////

    public AssemblyCode visitParamListNode(AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitParamNode(AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    /////////////////////////////////statement//////////////////////////////

    public AssemblyCode visitAssignStatNode(AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitDeclareStatNode(AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitExitStatNode(AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitFreeStatNode(AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitIfStatNode(AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitPrintlnStatNode(AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitPrintStatNode(AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitReadStatNode(AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitReturnStatNode(AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitScopingStatNode(AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitSkipStatNode(AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitStatListNode(AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitWhileStatNode(AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    ////////////////////////////function and program//////////////////////////////////////

    public AssemblyCode visitFunctionNode(AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

    public AssemblyCode visitProgramNode(AssemblyCode originalInstructions, List<Register> registers){
        return null;
    }

}
