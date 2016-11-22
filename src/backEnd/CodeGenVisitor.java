package backEnd;

import ast.ASTNode;
import ast.FunctionNode;
import ast.ProgramNode;
import ast.statement.StatListNode;
import backEnd.general.Header;
import backEnd.general.Label;
import backEnd.symbolTable.FuncSymbolTable;
import backEnd.symbolTable.VarSymbolTable;

import java.util.List;

public class CodeGenVisitor {

    private static VarSymbolTable  varSymbolTable;
    private static FuncSymbolTable funcSymbolTable;
    private static List<Label> labels;

    ///////////////////////// assignment LHS and RHS ////////////////////////////////////
    public static AssemblyCode visitArrayElemAsLNode(ASTNode node, AssemblyCode instructions, Registers registers){
        return instructions;
    }

    public static AssemblyCode visitIdentAsLNode(ASTNode node, AssemblyCode instructions, Registers registers){
        return instructions;
    }

    public static AssemblyCode visitPairElemAsLNode(ASTNode node, AssemblyCode instructions, Registers registers){
        return instructions;
    }

    public static AssemblyCode visitArgListNode(ASTNode node, AssemblyCode instructions, Registers registers){
        return instructions;
    }

    public static AssemblyCode visitArrayLiterAsRNode(ASTNode node, AssemblyCode instructions, Registers registers){
        return instructions;
    }

    public static AssemblyCode visitCallAsRNode(ASTNode node, AssemblyCode instructions, Registers registers){
        return instructions;
    }

    public static AssemblyCode visitExprAsRNode(ASTNode node, AssemblyCode instructions, Registers registers){
        return instructions;
    }

    public static AssemblyCode visitNewPairAsRNode(ASTNode node, AssemblyCode instructions, Registers registers){
        return instructions;
    }

    public static AssemblyCode visitPairElemAsRNode(ASTNode node, AssemblyCode instructions, Registers registers){
        return instructions;
    }

    //////////////////////expression///////////////////////////////////////////////////////

    public static AssemblyCode visitArrayElemNode(ASTNode node, AssemblyCode instructions, Registers registers){
        return instructions;
    }

    public static AssemblyCode visitBinaryOprNode(ASTNode node, AssemblyCode instructions, Registers registers){
        return instructions;
    }

    public static AssemblyCode visitBoolLiterNode(ASTNode node, AssemblyCode instructions, Registers registers){
        return instructions;
    }

    public static AssemblyCode visitCharLiterNode(ASTNode node, AssemblyCode instructions, Registers registers){
        return instructions;
    }

    public static AssemblyCode visitIdentNode(ASTNode node, AssemblyCode instructions, Registers registers){
        return instructions;
    }

    public static AssemblyCode visitIntLiterNode(ASTNode node, AssemblyCode instructions, Registers registers){
        return instructions;
    }

    public static AssemblyCode visitPairElemNode(ASTNode node, AssemblyCode instructions, Registers registers){
        return instructions;
    }

    public static AssemblyCode visitPairLiterNode(ASTNode node, AssemblyCode instructions, Registers registers){
        return instructions;
    }

    public static AssemblyCode visitStringLiterNode(ASTNode node, AssemblyCode instructions, Registers registers){
        return instructions;
    }

    public static AssemblyCode visitUnaryOprNode(ASTNode node, AssemblyCode instructions, Registers registers){
        return instructions;
    }

    ////////////////////////////////parameter/////////////////////////////

    public static AssemblyCode visitParamListNode(ASTNode node, AssemblyCode instructions, Registers registers){
        return instructions;
    }

    public static AssemblyCode visitParamNode(ASTNode node, AssemblyCode instructions, Registers registers){
        return instructions;
    }

    /////////////////////////////////statement//////////////////////////////

    public static AssemblyCode visitAssignStatNode(ASTNode node, AssemblyCode instructions, Registers registers){
        return instructions;
    }

    public static AssemblyCode visitDeclareStatNode(ASTNode node, AssemblyCode instructions, Registers registers){
        return instructions;
    }

    public static AssemblyCode visitExitStatNode(ASTNode node, AssemblyCode instructions, Registers registers){
        return instructions;
    }

    public static AssemblyCode visitFreeStatNode(ASTNode node, AssemblyCode instructions, Registers registers){
        return instructions;
    }

    public static AssemblyCode visitIfStatNode(ASTNode node, AssemblyCode instructions, Registers registers){
        return instructions;
    }

    public static AssemblyCode visitPrintlnStatNode(ASTNode node, AssemblyCode instructions, Registers registers){
        return instructions;
    }

    public static AssemblyCode visitPrintStatNode(ASTNode node, AssemblyCode instructions, Registers registers){
        return instructions;
    }

    public static AssemblyCode visitReadStatNode(ASTNode node, AssemblyCode instructions, Registers registers){
        return instructions;
    }

    public static AssemblyCode visitReturnStatNode(ASTNode node, AssemblyCode instructions, Registers registers){
        return instructions;
    }

    public static AssemblyCode visitScopingStatNode(ASTNode node, AssemblyCode instructions, Registers registers){
        return instructions;
    }

    public static AssemblyCode visitSkipStatNode(ASTNode node, AssemblyCode instructions, Registers registers){
        return instructions;
    }

    public static AssemblyCode visitStatListNode(ASTNode node, AssemblyCode instructions, Registers registers){
        StatListNode sNode = (StatListNode) node;

        return instructions;
    }

    public static AssemblyCode visitWhileStatNode(ASTNode node, AssemblyCode instructions, Registers registers){
        return instructions;
    }

    ////////////////////////////function and program//////////////////////////////////////

    public static AssemblyCode visitFunctionNode(ASTNode node, AssemblyCode instructions, Registers registers){
        return instructions;
    }

    public static AssemblyCode visitProgramNode(ASTNode node, AssemblyCode instructions, Registers registers){
        instructions.add(new Header(".text\n\n"), null);
        instructions.add(new Header(".global main\n"), null);
        List<FunctionNode> functions = ((ProgramNode) node).getFunctionNodes();

        for (FunctionNode f : functions) {
            instructions = visitFunctionNode(f, instructions, registers);
        }


        return instructions;
    }

}
