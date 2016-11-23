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
import backEnd.instructions.*;
import backEnd.instructions.binaryOp.*;
import backEnd.instructions.branch.BL;
import backEnd.instructions.branch.BLNE;
import backEnd.instructions.branch.BLVS;
import backEnd.instructions.load.LDR;
import backEnd.instructions.load.LDRSB;
import backEnd.instructions.store.STR;
import backEnd.symbolTable.FuncSymbolTable;
import backEnd.symbolTable.Value;
import backEnd.symbolTable.VarSymbolTable;
import frontEnd.SemanticException;
import type.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodeGenVisitor {

    private static VarSymbolTable varSymbolTable;
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
        System.err.println("unrecognised assign left node");
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

        List<Instruction> instructionsToBeAdded = new ArrayList<>();
        ArrayLiterAsRNode aNode = (ArrayLiterAsRNode) node;
        int constance = 4;

        // add instructions that are on top of array declaration
        int elementSize = Util.getTypeSize(aNode.getElementTypeIndicator());
        instructionsToBeAdded.add(new LDR(registers.getR0Reg(),
                constance + elementSize * aNode.getElements().size()));
        instructionsToBeAdded.add(new BL("malloc"));
        instructionsToBeAdded.add(new MOV(registers.getNextAvailableVariableReg(), registers.getR0Reg()));

        instructions.add(instructionsToBeAdded);

        // add elements construction
        int offset = 0;
        Registers updatedRegs = registers.addRegInUsedList(registers.getNextAvailableVariableReg());

        List<ExpressionNode> elems = aNode.getElements();
        for (ExpressionNode elem : elems) {
            offset += elementSize;
            instructions = visitExpression(elem, instructions, updatedRegs);
            instructionsToBeAdded.clear();
            instructionsToBeAdded.add(new STR(registers.getNextAvailableVariableReg(),
                    registers.getPreviousReg(registers.getNextAvailableVariableReg()), offset));
            instructions.add(instructionsToBeAdded);
        }

        // add instructions below array declaration
        instructionsToBeAdded.clear();
        instructionsToBeAdded.add(new LDR(registers.getNextAvailableVariableReg(), elems.size()));
        instructionsToBeAdded.add(new STR(registers.getNextAvailableVariableReg(),
                    registers.getPreviousReg(registers.getNextAvailableVariableReg())));

        instructions.add(instructionsToBeAdded);
        registers.clearRegInUsed();

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
        System.err.println("unrecognised expression");
        return null;
    }

    public static AssemblyCode visitArrayElemNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        List<Instruction> arrayElemInstructions = new ArrayList<>();

        instructions.add(instructions.getCurrentLabel(), new ArrayList<Instruction>(Arrays.asList(
                new ADD(registers.getNextAvailableVariableReg(), registers.getStackPtrReg(), 0))));

        ExpressionNode index = ((ArrayElemNode) node).getIndexes().get(0);

        Registers updatedRegisters = registers.addRegInUsedList(registers.getNextAvailableVariableReg());
        instructions = visitExpression(index, instructions, updatedRegisters);
        registers.setRegNotInUse(registers.getPreviousReg(registers.getNextAvailableVariableReg()));

        arrayElemInstructions.add(new LDR(registers.getNextAvailableVariableReg(),
                registers.getNextAvailableVariableReg()));
        arrayElemInstructions.add(new MOV(registers.getR0Reg(),
                registers.getNextReg(registers.getNextAvailableVariableReg())));
        arrayElemInstructions.add(new MOV(registers.getR1Reg(), registers.getNextAvailableVariableReg()));

        instructions = instructions.getMessageGenerator().generateArrayOutOfBoundsMessage(instructions);

        List<Instruction> runTimeInstructions = new ArrayList<>();
        instructions.add(new Label("p_throw_runtime_error"), runTimeInstructions);

        List<Instruction> boundsInstructions = new ArrayList<>();
        instructions.add(new Label("p_check_array_bounds"), boundsInstructions);

        arrayElemInstructions.add(new BL("p_check_array_bounds"));
        arrayElemInstructions.add(new ADD(registers.getNextAvailableVariableReg(),
                registers.getNextAvailableVariableReg(),
                Util.getTypeSize(
                        (varSymbolTable.getVariable(((ArrayElemNode) node).getArrayName().getId())).getArrayElemType())));
        arrayElemInstructions.add(new ADD(registers.getNextAvailableVariableReg(), registers.getNextAvailableVariableReg(),
                registers.getNextReg(registers.getNextAvailableVariableReg()), new LSL(2)));
        arrayElemInstructions.add(new LDR(registers.getNextAvailableVariableReg(),
                registers.getNextAvailableVariableReg()));

        instructions.add(instructions.getCurrentLabel(), arrayElemInstructions);

        Label printString = new Label("p_print_string");

        instructions.add(printString, new ArrayList<>(Arrays.asList(new PUSH(registers.getLinkReg()))));
        instructions.add(printString,
                instructions.getMessageGenerator().generatePrintStringInstructions(registers, instructions));
        instructions.add(printString, new ArrayList<>(Arrays.asList(
                new ADD(registers.getR0Reg(), registers.getR0Reg(), 4), new BL("printf"))));
        instructions.add(printString,
                instructions.getMessageGenerator().generateEndPrintInstructions(instructions, registers));

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
                new ArrayList<>(Arrays.asList(new MOV(registers.getNextAvailableVariableReg(), res))));

        return instructions;
    }

    public static AssemblyCode visitCharLiterNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        char character = ((CharLiterNode) node).getValue();

        instructions.add(instructions.getCurrentLabel(),
                new ArrayList<>(Arrays.asList(new MOV(registers.getNextAvailableVariableReg(), character))));

        return instructions;
    }

    public static AssemblyCode visitIdentNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        //TODO : double check the position in stack
        IdentNode nodeID = (IdentNode) node;
        int nodeType = varSymbolTable.getVariable(nodeID.getId()).getValueType();

        if(nodeType == 0 | nodeType == 3 | nodeType == 4 | nodeType == 5){
            instructions.add(instructions.getCurrentLabel(),
                    new ArrayList<>(Arrays.asList(new LDR(registers.getNextAvailableVariableReg(),
                            registers.getStackPtrReg(), instructions.getPositionInStack(nodeID.getId())))));
        }

        if(nodeType == 1 | nodeType == 2){
            instructions.add(instructions.getCurrentLabel(),
                    new ArrayList<>(Arrays.asList(new LDRSB(registers.getNextAvailableVariableReg(),
                            registers.getStackPtrReg(), instructions.getPositionInStack(nodeID.getId())))));
        }

        return instructions;
    }

    public static AssemblyCode visitIntLiterNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        instructions.add(instructions.getCurrentLabel(),
                new ArrayList<>(Arrays.asList(new LDR(registers.getNextAvailableVariableReg(),
                        new Label(((IntLiterNode) node).getValue().toString())))));

        return instructions;
    }

    public static AssemblyCode visitPairElemNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        //TODO

        return instructions;
    }

    public static AssemblyCode visitPairLiterNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        instructions.add(instructions.getCurrentLabel(),
                Arrays.asList(new LDR(registers.getNextAvailableVariableReg(), 0))); //TODO: check the constant
        return instructions;
    }

    public static AssemblyCode visitStringLiterNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        StringLiterNode strNode = (StringLiterNode) node;
        List<Instruction> instructionsToBeAdded = new ArrayList<>();

        instructions.add(instructions.getCurrentLabel(),
                Arrays.asList(new LDR(registers.getNextAvailableVariableReg(),
                        new Label("msg_" + instructions.getNumberOfMessage()))));

        instructionsToBeAdded.add(new HeaderInstr(".word ", strNode.getStringSize()));
        instructionsToBeAdded.add(new HeaderInstr(".ascii" +  strNode.getValue()));

        instructions.add(new Label("msg_" + instructions.getNumberOfMessage()),
                instructionsToBeAdded);

        return instructions;
    }

    public static AssemblyCode visitUnaryOprNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        List<Instruction> instructionsToBeAdded = new ArrayList<>();

        instructions = visitExpression(((UnaryOprNode) node).getExpr(), instructions, registers);

        UnaryOpr unaryOpr = ((UnaryOprNode) node).getUnaryOpr();

        switch (unaryOpr) {
            case NOT:
                instructionsToBeAdded.add(new EOR(registers.getNextAvailableVariableReg(), 1));
                break;
            case NEG:
                String errorMessage = "\"OverflowError: the result is too small/large to store in a 4-byte signed-integer.\\n\"";
                instructions.getMessageGenerator().generatePrintStringTypeMessage(
                        instructions, errorMessage.length() - 2, errorMessage);

                Label printStringLabel = new Label("p_print_string");
                instructionsToBeAdded.add(new RSBS(registers.getNextAvailableVariableReg(),
                        registers.getNextAvailableVariableReg(), 0));

                Label overflowLabel = new Label("p_throw_overflow_error");
                instructionsToBeAdded.add(new BLVS("p_throw_overflow_error"));
                instructions.add(overflowLabel, instructions.getMessageGenerator().generateOverflowInstructions(
                        registers, instructions));
                instructions.add(new Label("p_throw_runtime_error"),
                        instructions.getMessageGenerator().generateRuntimeInstrs(registers, instructions));

                instructions.add(printStringLabel, new ArrayList<Instruction>(
                        Arrays.asList(new PUSH(registers.getLinkReg()))));
                instructions.add(printStringLabel, instructions.getMessageGenerator().generatePrintStringInstructions(
                        registers, instructions));
                instructions.add(printStringLabel,
                        new ArrayList<>(Arrays.asList(new ADD(registers.getR0Reg(), registers.getR0Reg(), 4),
                                new BL("printf"))));
                instructions.add(printStringLabel,
                        instructions.getMessageGenerator().generateEndPrintInstructions(instructions, registers));
                break;
            case LEN:
                instructions.add(instructions.getCurrentLabel(),
                        new ArrayList<>(Arrays.asList(new LDR(registers.getNextAvailableVariableReg(), registers.getStackPtrReg()),
                                new LDR(registers.getNextAvailableVariableReg(), registers.getNextAvailableVariableReg()))));
                break;
            case ORD:
            case CHR:
                break;
            default:
                System.err.println("NEVER");
        }

        instructions.add(instructions.getCurrentLabel(), instructionsToBeAdded);
        return instructions;
    }

    public static AssemblyCode visitBinaryOprNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        List<Instruction> instructionsToBeAdded = new ArrayList<>();

        instructions = visitExpression(((BinaryOprNode) node).getExprL(), instructions, registers);
        RegisterARM exprLReg = registers.getNextAvailableVariableReg();
        if (exprLReg == RegisterARM.R10) {
            instructions.add(instructions.getCurrentLabel(), new ArrayList<Instruction>(Arrays.asList(new PUSH(exprLReg))));
        }

        Registers updatedRegs = registers.addRegInUsedList(exprLReg);

        instructions = visitExpression(((BinaryOprNode) node).getExprL(), instructions, updatedRegs);
        RegisterARM exprRReg = registers.getNextAvailableVariableReg();

        RegisterARM resultReg = exprLReg;

        if (exprRReg == RegisterARM.R10 && exprLReg == RegisterARM.R10) {
            instructions.add(instructions.getCurrentLabel(),
                    new ArrayList<Instruction>(Arrays.asList(new POP(RegisterARM.R11))));
            exprLReg = RegisterARM.R11;
        }

        if (((BinaryOprNode) node).isLogical()) {
            if (((BinaryOprNode) node).getBinaryOpr() == BinaryOpr.AND) {
                instructionsToBeAdded.add(new AND(resultReg, exprLReg, exprRReg));
            } else if (((BinaryOprNode) node).getBinaryOpr() == BinaryOpr.OR) {
                instructionsToBeAdded.add(new ORR(resultReg, exprLReg, exprRReg));
            }
        } else {
            if (((BinaryOprNode) node).isComparison()) {
                instructionsToBeAdded.add(new CMP(exprLReg, exprRReg));
            } else {
                instructions.add(new Header(".data"), null);
                String errorMessage;
                if (((BinaryOprNode) node).getBinaryOpr().equals(BinaryOpr.DIV)
                        || ((BinaryOprNode) node).getBinaryOpr().equals(BinaryOpr.MOD)) {
                    errorMessage = "\"DivideByZeroError: divide or modulo by zero\\n\\0\"";
                } else {
                    errorMessage = "\"OverflowError: the result is too small/large to store in a 4-byte signed-integer.\\n\"";
                }

                instructions.getMessageGenerator().generatePrintStringTypeMessage(
                        instructions, errorMessage.length() - 2, errorMessage);
            }

            if (((BinaryOprNode) node).getBinaryOpr().equals(BinaryOpr.GT)) {
                instructionsToBeAdded.add(new MOVGT(resultReg, 1));
                instructionsToBeAdded.add(new MOVLE(resultReg, 0));
            } else if (((BinaryOprNode) node).getBinaryOpr().equals(BinaryOpr.GTE)) {
                instructionsToBeAdded.add(new MOVGE(resultReg, 1));
                instructionsToBeAdded.add(new MOVLT(resultReg, 0));
            } else if (((BinaryOprNode) node).getBinaryOpr().equals(BinaryOpr.LT)) {
                instructionsToBeAdded.add(new MOVLT(resultReg, 1));
                instructionsToBeAdded.add(new MOVGE(resultReg, 0));
            } else if (((BinaryOprNode) node).getBinaryOpr().equals(BinaryOpr.LTE)) {
                instructionsToBeAdded.add(new MOVLE(resultReg, 1));
                instructionsToBeAdded.add(new MOVGT(resultReg, 0));
            } else if (((BinaryOprNode) node).getBinaryOpr().equals(BinaryOpr.EQ)) {
                instructionsToBeAdded.add(new MOVEQ(resultReg, 1));
                instructionsToBeAdded.add(new MOVNE(resultReg, 0));
            } else if (((BinaryOprNode) node).getBinaryOpr().equals(BinaryOpr.NEQ)) {
                instructionsToBeAdded.add(new MOVNE(resultReg, 1));
                instructionsToBeAdded.add(new MOVEQ(resultReg, 0));
            } else {
                Label printStringLabel = new Label("p_print_string");
                if (((BinaryOprNode) node).getBinaryOpr().equals(BinaryOpr.PLUS)) {
                    instructionsToBeAdded.add(new ADDS(resultReg, exprLReg, exprRReg));
                } else if (((BinaryOprNode) node).getBinaryOpr().equals(BinaryOpr.MINUS)) {
                    instructionsToBeAdded.add(new SUBS(resultReg, exprLReg, exprRReg));
                } else if (((BinaryOprNode) node).getBinaryOpr().equals(BinaryOpr.MULT)) {
                    instructionsToBeAdded.add(new SMULL(exprLReg, exprRReg, exprLReg, exprRReg));
                    instructionsToBeAdded.add(new CMP(exprRReg, exprLReg, "ASR", 31));
                } else if (((BinaryOprNode) node).getBinaryOpr().equals(BinaryOpr.DIV)
                        || ((BinaryOprNode) node).getBinaryOpr().equals(BinaryOpr.MOD)) {
                    instructionsToBeAdded.add(new MOV(registers.getR0Reg(), exprLReg));
                    instructionsToBeAdded.add(new MOV(registers.getR1Reg(), exprRReg));
                }

                Label overflowLabel = new Label("p_throw_overflow_error");

                if (((BinaryOprNode) node).getBinaryOpr().equals(BinaryOpr.PLUS)
                        || ((BinaryOprNode) node).getBinaryOpr().equals(BinaryOpr.MINUS)) {
                    instructionsToBeAdded.add(new BLVS("p_throw_overflow_error"));
                } else if (((BinaryOprNode) node).getBinaryOpr().equals(BinaryOpr.DIV) ||
                        ((BinaryOprNode) node).getBinaryOpr().equals(BinaryOpr.MOD)) {
                    Label checkDivideByZero = new Label("p_check_divide_by_zero");
                    instructionsToBeAdded.add(new BL("p_check_divide_by_zero"));
                    instructionsToBeAdded.add(new BL(((BinaryOprNode) node).getBinaryOpr().equals(BinaryOpr.DIV) ?
                            "__aeabi_idiv" : "__aeabi_idivmod"));
                    instructionsToBeAdded.add(new MOV(resultReg,
                            ((BinaryOprNode) node).getBinaryOpr().equals(BinaryOpr.DIV) ?
                                    registers.getR0Reg() : registers.getR1Reg()));
                    instructions.add(checkDivideByZero, new ArrayList<Instruction>(Arrays.asList(
                            new PUSH(RegisterARM.LR))));
                    instructions.add(checkDivideByZero,
                            instructions.getMessageGenerator()
                                    .generateDivideByZeroInstrs(registers, instructions));
                    instructions.add(checkDivideByZero, new ArrayList<Instruction>(Arrays.asList(
                            new POP(RegisterARM.PC))));
                } else {
                    instructionsToBeAdded.add(new BLNE("p_throw_overflow_error"));
                }

                if (!(((BinaryOprNode) node).getBinaryOpr().equals(BinaryOpr.DIV)
                        || ((BinaryOprNode) node).getBinaryOpr().equals(BinaryOpr.MOD))) {
                    instructions.add(overflowLabel, instructions.getMessageGenerator().generateOverflowInstructions(
                            registers, instructions));
                }

                instructions.add(
                        new Label("p_throw_runtime_error"),
                        instructions.getMessageGenerator().generateRuntimeInstrs(
                                registers, instructions));

                instructions.add(printStringLabel, new ArrayList<Instruction>(Arrays.asList(
                        new PUSH(RegisterARM.LR))));
                instructions.add(
                        printStringLabel,
                        instructions.getMessageGenerator().generatePrintStringInstructions(
                                registers, instructions));
                instructions.add(
                        printStringLabel,
                        new ArrayList<>(Arrays.asList(new ADD(
                                        registers.getR0Reg(), registers.getR0Reg(), 4),
                                new BL("printf"))));
                instructions.add(printStringLabel,
                        instructions.getMessageGenerator()
                                .generateEndPrintInstructions(instructions, registers));

            }

        }

        registers.setRegNotInUse(resultReg);
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
        System.err.println("unrecognised statement node");
        return null;
    }

    public static AssemblyCode visitAssignStatNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        //TODO

        return instructions;
    }

    public static AssemblyCode visitDeclareStatNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        List<Instruction> instructionsToBeAdded = new ArrayList<>();
        DeclareStatNode nodeID = (DeclareStatNode) node;
        AssignRightNode rhsNode = nodeID.getAssignRightNode();

        instructions.add(instructions.getCurrentLabel(), new ArrayList<>(Arrays.asList(
                new SUB(registers.getStackPtrReg(), registers.getStackPtrReg(), );
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
        instructionsToBeAdded.add(new BL("exit"));

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

        newSymbolTable();
        ScopingStatNode sNode = (ScopingStatNode) node;
        instructions = visitStatListNode(sNode.getBody(), instructions, registers);
        popSymbolTable();
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

        newSymbolTable();

        popSymbolTable();
        return instructions;
    }

    ////////////////////////////function and program//////////////////////////////////////

    public static AssemblyCode visitFunctionNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        //TODO
        FunctionNode fNode = (FunctionNode) node;
        VarSymbolTable paramSymbolTable = new VarSymbolTable();
        String funcName = fNode.getFunctionName();
        List<String> paramNames = fNode.getParamListNode().getParamNames();
        List<Type> paramTypes = null;
        try {
            paramTypes = fNode.getParamListNode().getParamTypes();
        } catch (SemanticException e) {
            System.err.println("shouldn't reach here, as should be able to get params type");
        }
        for (int i = 0; i < paramNames.size(); i++) {
            paramSymbolTable.addVariable(
                    paramNames.get(i), covertParamToValue(null, paramTypes.get(i)));
        }
        funcSymbolTable.addFunction(funcName, paramSymbolTable);

        return instructions;
    }

    public static AssemblyCode visitProgramNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        funcSymbolTable = new FuncSymbolTable();
        varSymbolTable  = new VarSymbolTable();

        instructions.add(new Header(".text\n\n"), null);
        instructions.add(new Header(".global main\n"), null);
        List<FunctionNode> functions = ((ProgramNode) node).getFunctionNodes();

        //Visit FunctionNode and return instructions
        for (FunctionNode f : functions) {
            instructions = visitFunctionNode(f, instructions, registers);
        }

//        instructions.returnMainLabel();
//
//        //PUSH {LR}
//        instructions.add(instructions.getCurrentLabel(), Arrays.asList(new PUSH(registers.getLinkReg())));

        //PUSH {LR}
        instructions.add(instructions.getCurrentLabel(), new ArrayList<>(Arrays.asList(
                new PUSH(registers.getLinkReg()))));

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

    ////////////////////////////////////// helper method /////////////////////////////////////

    // create new symbol table with parent as current symbol table
    private static void newSymbolTable() {
        VarSymbolTable vst = new VarSymbolTable(varSymbolTable);
        varSymbolTable = vst;
    }

    // discard current symbol table and set current table as its parent
    private static void popSymbolTable() {
        if (varSymbolTable.getParent() == null) {
            System.err.println("error in finding variable symbol table parent");
        } else {
            varSymbolTable = varSymbolTable.getParent();
        }
    }

    private static Value covertParamToValue(String value, Type type) {
        if (type instanceof ArrayType) {
            int element = Util.convertTypeToIndicator(((ArrayType) type).getElemType());
            return new Value(value, true, element, -1);  //TODO check stack ptr place
        }
        if (type instanceof PairType) {
            int fst = Util.convertTypeToIndicator(((PairType) type).getFstExprType());
            int snd = Util.convertTypeToIndicator(((PairType) type).getSndExprType());
            return new Value(value, true, fst, snd);
        }
        return new Value(value, Util.convertTypeToIndicator(type), -1); //TODO check stack ptr place
    }



}
