package backEnd;

import ast.ASTNode;
import ast.*;
import backEnd.general.*;
import ast.assignLeft.*;
import ast.assignRight.*;
import ast.expression.*;
import ast.parameter.ParamListNode;
import ast.parameter.ParamNode;
import ast.statement.*;
import backEnd.general.Label;
import backEnd.instructions.ADD;
import backEnd.instructions.Instruction;
import backEnd.instructions.POP;
import backEnd.instructions.PUSH;
import backEnd.instructions.binaryOp.MOV;
import backEnd.instructions.branch.BL;
import backEnd.instructions.load.LDR;
import backEnd.symbolTable.FuncSymbolTable;
import backEnd.symbolTable.VarSymbolTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodeGenVisitor {

    private static VarSymbolTable  varSymbolTable;
    private static FuncSymbolTable funcSymbolTable;
    private static List<Label> labels;

    ///////////////////////// assignment LHS and RHS ////////////////////////////////////

    public static AssemblyCode visitAssignLeftNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        if (node instanceof ArrayElemAsLNode) {
            return visitArrayElemAsLNode(node, instructions, registers);
        }
        if (node instanceof IdentAsLNode) {
            return visitIdentAsLNode(node, instructions, registers);
        }
        if (node instanceof PairElemAsLNode) {
            return visitPairElemAsLNode(node, instructions, registers);
        }
        System.err.println("unrecognized assign left node");
        return null;
    }

    public static AssemblyCode visitAssignRightNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        if (node instanceof ArgListNode) {
            return visitArgListNode(node, instructions, registers);
        }
        if (node instanceof ArrayLiterAsRNode) {
            return visitArrayLiterAsRNode(node, instructions, registers);
        }
        if (node instanceof CallAsRNode) {
            return visitCallAsRNode(node, instructions, registers);
        }
        if (node instanceof ExprAsRNode) {
            return visitExprAsRNode(node, instructions, registers);
        }
        if (node instanceof NewPairAsRNode) {
            return visitNewPairAsRNode(node, instructions, registers);
        }
        if (node instanceof PairElemAsRNode) {
            return visitPairElemAsRNode(node, instructions, registers);
        }
        System.err.println("unreognized assign right node");
        return null;
    }

    public static AssemblyCode visitArrayElemAsLNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        return instructions;
    }

    public static AssemblyCode visitIdentAsLNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        return instructions;
    }

    public static AssemblyCode visitPairElemAsLNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        return instructions;
    }

    public static AssemblyCode visitArgListNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        return instructions;
    }

    public static AssemblyCode visitArrayLiterAsRNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        return instructions;
    }

    public static AssemblyCode visitCallAsRNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        return instructions;
    }

    public static AssemblyCode visitExprAsRNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        return instructions;
    }

    public static AssemblyCode visitNewPairAsRNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        return instructions;
    }

    public static AssemblyCode visitPairElemAsRNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        return instructions;
    }

    //////////////////////expression///////////////////////////////////////////////////////

    public static AssemblyCode visitExpression(ASTNode node, AssemblyCode instructions, Registers registers) {
        if (node instanceof ArrayElemNode) {
            return visitArrayElemNode(node, instructions, registers);
        }
        if (node instanceof BinaryOprNode) {
            return visitBinaryOprNode(node, instructions, registers);
        }
        if (node instanceof BoolLiterNode) {
            return visitBoolLiterNode(node, instructions, registers);
        }
        if (node instanceof CharLiterNode) {
            return visitCharLiterNode(node, instructions, registers);
        }
        if (node instanceof IdentNode) {
            return visitIdentNode(node, instructions, registers);
        }
        if (node instanceof IntLiterNode) {
            return visitIntLiterNode(node, instructions, registers);
        }
        if (node instanceof PairElemNode) {
            return visitPairElemNode(node, instructions, registers);
        }
        if (node instanceof PairLiterNode) {
            return visitPairLiterNode(node, instructions, registers);
        }
        if (node instanceof StringLiterNode) {
            return visitStringLiterNode(node, instructions, registers);
        }
        if (node instanceof UnaryOprNode) {
            return visitUnaryOprNode(node, instructions, registers);
        }
        System.err.println("unrecognized expression");
        return null;
    }

    public static AssemblyCode visitArrayElemNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        return instructions;
    }

    public static AssemblyCode visitBoolLiterNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        return instructions;
    }

    public static AssemblyCode visitCharLiterNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        return instructions;
    }

    public static AssemblyCode visitIdentNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        return instructions;
    }

    public static AssemblyCode visitIntLiterNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        instructions.add(instructions.getCurrentLabel(),
                Arrays.asList(new LDR(registers.getNextAvailableVariableReg(),
                        new Label(((IntLiterNode) node).getValue().toString()));

        return instructions;
    }

    public static AssemblyCode visitPairElemNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        return instructions;
    }

    public static AssemblyCode visitPairLiterNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        return instructions;
    }

    public static AssemblyCode visitStringLiterNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        return instructions;
    }

    public static AssemblyCode visitUnaryOprNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        return instructions;
    }

    public static AssemblyCode visitBinaryOprNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        return instructions;
    }

    ////////////////////////////////parameter/////////////////////////////

    public static AssemblyCode visitParamListNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        ParamListNode pNode = (ParamListNode) node;
        List<ParamNode> pNodes = pNode.getParams();
        for (ParamNode pn : pNodes) {
            instructions = visitParamNode(pn, instructions, registers);
        }
        return instructions;
    }

    public static AssemblyCode visitParamNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        return instructions;
    }

    /////////////////////////////////statement//////////////////////////////

    public static AssemblyCode visitStatementNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        if (node instanceof AssignStatNode) {
            return visitAssignStatNode(node, instructions, registers);
        }
        if (node instanceof DeclareStatNode) {
            return visitDeclareStatNode(node, instructions, registers);
        }
        if (node instanceof ExitStatNode) {
            return visitExitStatNode(node, instructions, registers);
        }
        if (node instanceof FreeStatNode) {
            return visitFreeStatNode(node, instructions, registers);
        }
        if (node instanceof IfStatNode) {
            return visitIfStatNode(node, instructions, registers);
        }
        if (node instanceof PrintlnStatNode) {
            return visitPrintlnStatNode(node, instructions, registers);
        }
        if (node instanceof PrintStatNode) {
            return visitPrintStatNode(node, instructions, registers);
        }
        if (node instanceof ReadStatNode) {
            return visitReadStatNode(node, instructions, registers);
        }
        if (node instanceof ScopingStatNode) {
            return visitScopingStatNode(node, instructions, registers);
        }
        if (node instanceof ReturnStatNode) {
            return visitReturnStatNode(node, instructions, registers);
        }
        if (node instanceof SkipStatNode) {
            return visitSkipStatNode(node, instructions, registers);
        }
        if (node instanceof StatListNode) {
            return visitStatListNode(node, instructions, registers);
        }
        if (node instanceof WhileStatNode) {
            return visitWhileStatNode(node, instructions, registers);
        }
        System.err.println("unrecognized statement node");
        return null;
    }

    public static AssemblyCode visitAssignStatNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        return instructions;
    }

    public static AssemblyCode visitDeclareStatNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        return instructions;
    }

    public static AssemblyCode visitExitStatNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        List<Instruction> instructionsToBeAdded = new ArrayList<>();

        if (((ExitStatNode) node).getExpr() instanceof IdentNode) {


            instructionsToBeAdded.add(new LDR(registers.getNextAvailableVariableReg(), registers.getStackPtrReg()));
        } else {
            instructionsToBeAdded.add(new LDR(registers.getNextAvailableVariableReg(),
                    ((ExitStatNode) node).getExitValue(instructions.getVarSymbolTable())));
        }

        instructionsToBeAdded.add(new MOV(registers.getR0Reg(), registers.getNextAvailableReg()));
        instructionsToBeAdded.add(new BL(new Label("exit")));
//        instructionsToBeAdded.add(new BL("exit"));

        //Add the instructions to be added into the assembly code wrapper class.
        instructions.add(instructions.getCurrentLabel(), instructionsToBeAdded);

        return instructions;
    }

    public static AssemblyCode visitFreeStatNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        return instructions;
    }

    public static AssemblyCode visitIfStatNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        return instructions;
    }

    public static AssemblyCode visitPrintlnStatNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        return instructions;
    }

    public static AssemblyCode visitPrintStatNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        return instructions;
    }

    public static AssemblyCode visitReadStatNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        return instructions;
    }

    public static AssemblyCode visitReturnStatNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        return instructions;
    }

    public static AssemblyCode visitScopingStatNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        return instructions;
    }

    public static AssemblyCode visitSkipStatNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        //No instructions are added.
        return instructions;
    }

    public static AssemblyCode visitStatListNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        StatListNode sNode = (StatListNode) node;
        List<StatementNode> sNodes  = sNode.getStatList();
        for (StatementNode sn : sNodes) {
            instructions = visitStatementNode(sn, instructions, registers);
        }
        return instructions;
    }

    public static AssemblyCode visitWhileStatNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        return instructions;
    }

    ////////////////////////////function and program//////////////////////////////////////

    public static AssemblyCode visitFunctionNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        return instructions;
    }

    public static AssemblyCode visitProgramNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        instructions.add(new Header(".text\n\n"), null);
        instructions.add(new Header(".global main\n"), null);
        List<FunctionNode> functions = ((ProgramNode) node).getFunctionNodes();

        //Visit FunctionNode and return instructions
        for (FunctionNode f : functions) {
            instructions = visitFunctionNode(f, instructions, registers);
        }

        instructions.returnMainLabel();

        //PUSH {LR}
        instructions.add(instructions.getCurrentLabel(), Arrays.asList(new PUSH(registers.getLinkReg())));

        //Visit StatListNode and return instructions
        instructions = visitStatListNode(((ProgramNode) node).getStatListNode(), instructions, registers);

        List<Instruction> instructionsToBeAdded = new ArrayList<>();

        if (instructions.getVarSymbolTableLocalSize() > 0) {
            for (int i = instructions.getVarSymbolTableLocalSize(); (0 < i) && (i < 1024) ; i -= 1024) {
                instructionsToBeAdded.add(new ADD(registers.getStackPtrReg(), registers.getStackPtrReg(), i));
            }
        }

        instructionsToBeAdded.add(new LDR(registers.getR0Reg(), 0);
        instructionsToBeAdded.add(new POP(registers.getPCReg()));
        instructionsToBeAdded.add(new HeaderInstr(".ltorg"));

        //Add the instructions to be added into the assembly code wrapper class.
        instructions.add(instructions.getCurrentLabel(), instructionsToBeAdded);

        return instructions;
    }

}
