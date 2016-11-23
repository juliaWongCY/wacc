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
import backEnd.instructions.binaryOp.AND;
import backEnd.instructions.binaryOp.MOV;
import backEnd.instructions.binaryOp.ORR;
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

        //TODO

        return instructions;
    }

    public static AssemblyCode visitIdentAsLNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        //TODO

        return instructions;
    }

    public static AssemblyCode visitPairElemAsLNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        //TODO

        return instructions;
    }

    public static AssemblyCode visitArgListNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        //TODO

        return instructions;
    }

    public static AssemblyCode visitArrayLiterAsRNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        //TODO

        return instructions;
    }

    public static AssemblyCode visitCallAsRNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        //TODO

        return instructions;
    }

    public static AssemblyCode visitExprAsRNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        //TODO

        return instructions;
    }

    public static AssemblyCode visitNewPairAsRNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        //TODO

        return instructions;
    }

    public static AssemblyCode visitPairElemAsRNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        //TODO

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

        //TODO

        return instructions;
    }

    public static AssemblyCode visitBoolLiterNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        int res;

        if (((BoolLiterNode) node).getValue()) {
            res = 1;
        } else {
            res = 0;
        }

        instructions.add(instructions.getCurrentLabel(),
                Arrays.asList(new MOV(registers.getNextAvailableVariableReg(), res)));

        return instructions;
    }

    public static AssemblyCode visitCharLiterNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        char character = ((CharLiterNode) node).getValue();

        instructions.add(instructions.getCurrentLabel(),
                Arrays.asList(new MOV(registers.getNextAvailableVariableReg(), character)));

        return instructions;
    }

    public static AssemblyCode visitIdentNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        //TODO
        return instructions;
    }

    public static AssemblyCode visitIntLiterNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        instructions.add(instructions.getCurrentLabel(),
                Arrays.asList(new LDR(registers.getNextAvailableVariableReg(),
                        new Label(((IntLiterNode) node).getValue().toString()))));

        return instructions;
    }

    public static AssemblyCode visitPairElemNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        //TODO

        return instructions;
    }

    public static AssemblyCode visitPairLiterNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        //TODO

        return instructions;
    }

    public static AssemblyCode visitStringLiterNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        instructions.add(instructions.getCurrentLabel(),
                Arrays.asList(new LDR(registers.getNextAvailableVariableReg(),
                        new Label("msg_" + instructions.getNumberOfMessage()))));

        //instructions.add();

        //TODO

        return instructions;
    }

    public static AssemblyCode visitUnaryOprNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        //TODO

        return instructions;
    }

    public static AssemblyCode visitBinaryOprNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        List<Instruction> instructionsToBeAdded = new ArrayList<>();

        instructions = visitExpression(((BinaryOprNode) node).getExprL(), instructions, registers);
        RegisterARM exprLReg = registers.getNextAvailableVariableReg();
        if (exprLReg == RegisterARM.R10) {
            instructions.add(instructions.getCurrentLabel(), Arrays.asList(new PUSH(exprLReg)));
        }

        Registers updatedRegs = registers.addRegInUsedList(exprLReg);

        instructions = visitExpression(((BinaryOprNode) node).getExprL(), instructions, registers);
        RegisterARM exprRReg = registers.getNextAvailableVariableReg();

        RegisterARM resultReg = exprLReg;

        if (exprRReg == RegisterARM.R10 && exprLReg == RegisterARM.R10) {
            instructions.add(instructions.getCurrentLabel(),
                    new ArrayList<Instruction>(Arrays.asList(new POP(RegisterARM.R11))));
            exprLReg = RegisterARM.R11;
        }

        switch (((BinaryOprNode) node).getBinaryOpr()) {
            case AND:
                instructionsToBeAdded.add(new AND(resultReg, exprLReg, exprRReg));
                break;
            case OR:
                instructionsToBeAdded.add(new ORR(resultReg, exprLReg, exprRReg));
                break;
            case PLUS:
                instructionsToBeAdded.add();
                break;
            case DIV:
                instructions.add(new Header(".data"), null);
                String errorMessage = "\"DivideByZeroError: divide or modulo by zero\\n\\0\"";
                instructions.getMessageGenerator().generatePrintStringTypeMessage(
                        instructions, errorMessage.length() - 2, errorMessage);

                Label printStringLabel = new Label("p_print_string");
                instructionsToBeAdded.add(new MOV(registers.getR0Reg(), exprLReg));
                instructionsToBeAdded.add(new MOV(registers.getR1Reg(), exprRReg));

                Label overflowLabel = new Label("p_throw_overflow_error");
                Label checkDivideByZero = new Label("p_check_divide_by_zero");
                instructionsToBeAdded.add(new BL(new Label("p_check_divide_by_zero")));
                instructionsToBeAdded.add(new BL(new Label("__aeabi_idiv")));

//                instructionsToBeAdded.add(new BL("p_check_divide_by_zero"));
//                instructionsToBeAdded.add(new BL("__aeabi_idiv"));
                instructionsToBeAdded.add(new MOV(resultReg, registers.getR0Reg()));
                instructions.add(checkDivideByZero, Arrays.asList(new PUSH(RegisterARM.LR)));
                instructions.add(checkDivideByZero,
                        instructions.getMessageGenerator()
                                .generateDivideByZeroInstrs(registers, instructions));
                instructions.add(checkDivideByZero, Arrays.asList(new POP(RegisterARM.PC)));

                instructions.add(
                        new Label("p_throw_runtime_error"),
                        instructions.getMessageGenerator().generateRuntimeInstrs(
                                registers, instructions));
                instructions.add(printStringLabel, Arrays.asList(new PUSH(RegisterARM.LR)));
                instructions.add(
                        printStringLabel,
                        instructions.getMessageGenerator().generatePrintStringInstrs(
                                registers, instructions));
                instructions.add(
                        printStringLabel,
                        new ArrayList<>(Arrays.asList(new ADD(
                                        registers.getR0Reg(), registers.getR0Reg(), 4),
                                new BL(new Label("printf")))));
                instructions.add(printStringLabel,
                        instructions.getMessageGenerator()
                                .generateEndPrintInstructions(instructions, registers));


        }



        //TODO


        instructions.add(instructions.getCurrentLabel(), instructionsToBeAdded);

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

        //TODO

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

        //TODO

        return instructions;
    }

    public static AssemblyCode visitDeclareStatNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        //TODO

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

        //TODO

        return instructions;
    }

    public static AssemblyCode visitIfStatNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        //TODO

        return instructions;
    }

    public static AssemblyCode visitPrintlnStatNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        //TODO

        return instructions;
    }

    public static AssemblyCode visitPrintStatNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        //TODO

        return instructions;
    }

    public static AssemblyCode visitReadStatNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        //TODO

        return instructions;
    }

    public static AssemblyCode visitReturnStatNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        //TODO

        return instructions;
    }

    public static AssemblyCode visitScopingStatNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        //TODO

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

        //TODO

        return instructions;
    }

    ////////////////////////////function and program//////////////////////////////////////

    public static AssemblyCode visitFunctionNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        //TODO

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

        instructionsToBeAdded.add(new LDR(registers.getR0Reg(), 0));
        instructionsToBeAdded.add(new POP(registers.getPCReg()));
        instructionsToBeAdded.add(new HeaderInstr(".ltorg"));

        //Add the instructions to be added into the assembly code wrapper class.
        instructions.add(instructions.getCurrentLabel(), instructionsToBeAdded);

        return instructions;
    }

}
