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
import backEnd.instructions.branch.*;
import backEnd.instructions.load.LDR;
import backEnd.instructions.load.LDRSB;
import backEnd.instructions.store.STR;
import backEnd.instructions.store.STRB;
import backEnd.symbolTable.FuncSymbolTable;
import backEnd.symbolTable.Value;
import backEnd.symbolTable.VarSymbolTable;
import frontEnd.SemanticException;
import type.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodeGenVisitor {

    private static VarSymbolTable varSymbolTable;
    private static FuncSymbolTable funcSymbolTable;
    //private static List<Label> labels;

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
//        if (node instanceof ArgListNode) {
//            return visitArgListNode(node, instructions, registers);
//        }
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
        //CHECKED
        return visitArrayElemNode(((ArrayElemAsLNode)node).getArrayElem(), instructions, registers);
    }

    public static AssemblyCode visitIdentAsLNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        return instructions;
    }

    public static AssemblyCode visitPairElemAsLNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        //CHECKED
        return visitPairElemNode(((PairElemAsLNode)node).getPairElemNode(), instructions, registers);
    }

    public static AssemblyCode visitArgListNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        ArgListNode argListNode = (ArgListNode) node;
        if (argListNode != null) {
            for (int i = argListNode.getSize() - 1; i >= 0; i--) {
                ExpressionNode arg = argListNode.getArgs().get(i);

                instructions = visitExpression(arg, instructions, registers);

                int exprType = arg.getTypeIndicator();
                int offset = -1 * Util.getTypeSize(exprType);

                if (exprType == Util.CHAR_TYPE || exprType == Util.BOOL_TYPE) {
                    instructions.add(instructions.getCurrentLabel(),
                            new ArrayList<>(Arrays.asList(new STR(registers.getNextAvailableVariableReg(),
                                    registers.getStackPtrReg(), offset, true, "B"))));
                } else {
                    instructions.add(instructions.getCurrentLabel(),
                            new ArrayList<>(Arrays.asList(new STR(registers.getNextAvailableVariableReg(),
                                    registers.getStackPtrReg(), offset, true, ""))));
                }

                instructions.setCurrentStackPtrPos(instructions.getCurrentStackPtrPos() + offset);
            }
        }

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

        instructions.add(instructions.getCurrentLabel(), instructionsToBeAdded);

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
            instructions.add(instructions.getCurrentLabel(), instructionsToBeAdded);
        }

        // add instructions below array declaration
        instructionsToBeAdded.clear();
        instructionsToBeAdded.add(new LDR(registers.getNextAvailableVariableReg(), elems.size()));
        instructionsToBeAdded.add(new STR(registers.getNextAvailableVariableReg(),
                    registers.getPreviousReg(registers.getNextAvailableVariableReg())));

        instructions.add(instructions.getCurrentLabel(), instructionsToBeAdded);
        registers.clearRegInUsed();

        return instructions;
    }

    public static AssemblyCode visitCallAsRNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        CallAsRNode cNode = (CallAsRNode) node;
        ArgListNode aNode = cNode.getArgList();

        List<Instruction> instructionsToBeAdded = new ArrayList<>();
        instructions = visitArgListNode(cNode.getArgList(), instructions, registers);

        String funcName = cNode.getFunctionId().getId();
        instructionsToBeAdded.add(new BL("f_" + funcName));

        if (aNode != null) {
            if (aNode.getSize() != 0) {
                instructionsToBeAdded.add(new ADD(registers.getStackPtrReg(), registers.getStackPtrReg(), aNode.getTypeSize()));
            }
            instructions.setCurrentStackPtrPos(instructions.getCurrentStackPtrPos() + aNode.getTypeSize());
        }
        instructionsToBeAdded.add(new MOV(registers.getNextAvailableVariableReg(), registers.getR0Reg()));
        instructions.add(instructions.getCurrentLabel(), instructionsToBeAdded);

        return instructions;
    }

    public static AssemblyCode visitExprAsRNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        //TODO check if correct logic
        return visitExpression(((ExprAsRNode)node).getExpr(), instructions, registers);
    }

    public static AssemblyCode visitNewPairAsRNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        NewPairAsRNode nNode = (NewPairAsRNode) node;
        List<Instruction> instructionsToBeAdded = new ArrayList<>();
        instructionsToBeAdded.add(new LDR(registers.getR0Reg(), 8));
        instructionsToBeAdded.add(new BL("malloc"));
        instructionsToBeAdded.add(new MOV(registers.getNextAvailableVariableReg(), registers.getR0Reg()));
        registers.addRegInUsedList(registers.getNextAvailableVariableReg());
        instructions.add(instructions.getCurrentLabel(), instructionsToBeAdded);

        instructions = visitExpression(((NewPairAsRNode) node).getFst(), instructions, registers);

        instructionsToBeAdded = new ArrayList<>();

        instructionsToBeAdded.add(new LDR(registers.getR0Reg(),
                Util.getTypeSize(nNode.getFst().getTypeIndicator())));
        instructionsToBeAdded.add(new BL("malloc"));
        instructionsToBeAdded.add(new STR(registers.getNextAvailableVariableReg(), registers.getR0Reg()));
        instructionsToBeAdded.add(new STR(registers.getR0Reg(), registers.getLastUsedReg()));
        instructions.add(instructions.getCurrentLabel(), instructionsToBeAdded);

        instructions = visitExpression(((NewPairAsRNode) node).getSnd(), instructions, registers);

        instructionsToBeAdded = new ArrayList<>();

        instructionsToBeAdded.add(new LDR(registers.getR0Reg(),
                Util.getTypeSize(nNode.getSnd().getTypeIndicator())));
        instructionsToBeAdded.add(new BL("malloc"));
        instructionsToBeAdded.add(new STRB(registers.getNextAvailableVariableReg(), registers.getR0Reg()));
        registers.clearRegInUsed();
        instructionsToBeAdded.add(new STR(registers.getR0Reg(), registers.getNextAvailableVariableReg(), 4));
        instructions.add(instructions.getCurrentLabel(), instructionsToBeAdded);
        
        return instructions;
    }

    public static AssemblyCode visitPairElemAsRNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        //TODO check if correct logic
        return visitPairElemNode(((PairElemAsRNode)node).getPairElemNode(), instructions, registers);
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

        if(nodeType == Util.INT_TYPE | nodeType == Util.STRING_TYPE | nodeType == Util.ARRAY_TYPE | nodeType == Util.PAIR_TYPE){
            instructions.add(instructions.getCurrentLabel(),
                    new ArrayList<>(Arrays.asList(new LDR(registers.getNextAvailableVariableReg(),
                            registers.getStackPtrReg(), varSymbolTable.getVariable(nodeID.getId()).getLocationInStack() - instructions.getCurrentStackPtrPos()))));
        }

        if(nodeType == Util.BOOL_TYPE | nodeType == Util.CHAR_TYPE){
            instructions.add(instructions.getCurrentLabel(),
                    new ArrayList<>(Arrays.asList(new LDRSB(registers.getNextAvailableVariableReg(),
                            registers.getStackPtrReg(),  varSymbolTable.getVariable(nodeID.getId()).getLocationInStack() - instructions.getCurrentStackPtrPos()))));
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

        PairElemNode pNode = (PairElemNode) node;
        List<Instruction> instructionsToBeAdded = new ArrayList<>();
        instructions.getMessageGenerator().
                generatePrintStringTypeMessage(
                        instructions, 50, "\"NullReferenceError: dereference a null reference\\n\\0\""); // todo: check const
        instructionsToBeAdded.add(new STR(registers.getNextAvailableVariableReg(), registers.getStackPtrReg(), 4));
        instructions.add(instructions.getCurrentLabel(), instructionsToBeAdded);
        instructionsToBeAdded.clear();

        instructions = visitExpression(pNode.getExpressionNode(), instructions, registers);

        instructionsToBeAdded.add(new MOV(registers.getR0Reg(), registers.getNextAvailableVariableReg()));
        instructionsToBeAdded.add(new BL("p_check_null_pointer"));
        instructionsToBeAdded.add(new LDR(registers.getNextAvailableVariableReg(), registers.getNextAvailableVariableReg())); //todo: check

        instructions.add(instructions.getCurrentLabel(), instructionsToBeAdded);
        instructions = instructions.getMessageGenerator().generateNullPointerInstructions(registers, instructions);
        
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
                new ArrayList<>(Arrays.asList(new LDR(registers.getNextAvailableVariableReg(),
                        new Label("msg_" + instructions.getNumberOfMessage())))));

        instructionsToBeAdded.add(new HeaderInstr("\t.word ", strNode.getStringSize()));
        instructionsToBeAdded.add(new HeaderInstr("\t.ascii " +  strNode.getValue()));

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
                        instructions.getMessageGenerator().generateRuntimeInstructions(registers, instructions));

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

        instructions = visitExpression(((BinaryOprNode) node).getExprR(), instructions, updatedRegs);
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
                                    .generateDivideByZeroInstructions(registers, instructions));
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
                        instructions.getMessageGenerator().generateRuntimeInstructions(
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

        //Seems like it doesn't require anything.

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

        AssignStatNode assignStatNode = (AssignStatNode) node;

        List<Instruction> instructionsToBeAdded = new ArrayList<>();

        int type = Util.getTypeSize(assignStatNode.getAssignRHS().getTypeIndicator());

        if (type == Util.CHAR_TYPE || type == Util.BOOL_TYPE) {
            instructionsToBeAdded.add(new STRB(registers.getNextAvailableVariableReg(), registers.getStackPtrReg()));
        } else {
            if (assignStatNode.getAssignLHS() instanceof IdentAsLNode) {
                IdentAsLNode identAsLNode = (IdentAsLNode) assignStatNode.getAssignLHS();
                instructionsToBeAdded.add(new STR(registers.getNextAvailableVariableReg(), registers.getStackPtrReg(),
                        varSymbolTable.getVariable(identAsLNode.getId().getId()).getLocationInStack() - instructions.getCurrentStackPtrPos()));
            } else if (assignStatNode.getAssignLHS() instanceof ArrayElemAsLNode) {
            } else {
                instructionsToBeAdded.add(new STR(registers.getNextAvailableVariableReg(), registers.getStackPtrReg()));
            }
        }

        instructions = visitAssignRightNode(assignStatNode.getAssignRHS(), instructions, registers);

        if (assignStatNode.getAssignLHS() instanceof PairElemAsLNode) {
            registers.addRegInUsedList(registers.getNextAvailableVariableReg());
            instructions = visitAssignLeftNode(assignStatNode.getAssignLHS(), instructions, registers);
            registers.clearRegInUsed();
        }

        if (assignStatNode.getAssignLHS() instanceof ArrayElemAsLNode) {
            instructionsToBeAdded.add(new STR(registers.getNextAvailableVariableReg(),
                    registers.getNextReg(registers.getNextAvailableVariableReg())));
            visitAssignLeftNode(assignStatNode.getAssignLHS(), instructions, registers);
        }

        instructions.add(instructions.getCurrentLabel(), instructionsToBeAdded);

        return instructions;
    }

    public static AssemblyCode visitDeclareStatNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        List<Instruction> instructionsToBeAdded = new ArrayList<>();
        DeclareStatNode dNode = (DeclareStatNode) node;
        AssignRightNode rhsNode = dNode.getAssignRightNode();
        int typeIndicator = Util.convertTypeToIndicator(dNode.getType());

        instructionsToBeAdded.add(new SUB(registers.getStackPtrReg(),
                registers.getStackPtrReg(), Util.getTypeSize(typeIndicator)));
        instructions.add(instructions.getCurrentLabel(), instructionsToBeAdded);
        instructions.setCurrentStackPtrPos(instructions.getCurrentStackPtrPos() - Util.getTypeSize(typeIndicator));

        instructions = visitAssignRightNode(rhsNode, instructions, registers);


        // construct value to put in variable symbol table

        Value val = convertAssignRHSToValue(rhsNode, instructions.getCurrentStackPtrPos());

        varSymbolTable.addVariable(dNode.getId().getId(), val);

        instructionsToBeAdded.clear();
        if (typeIndicator == Util.CHAR_TYPE || typeIndicator == Util.BOOL_TYPE) {
            instructionsToBeAdded.add(new STRB(registers.getNextAvailableVariableReg(), registers.getStackPtrReg()));
        } else {
            instructionsToBeAdded.add(new STR(registers.getNextAvailableVariableReg(), registers.getStackPtrReg()));
        }
        instructions.add(instructions.getCurrentLabel(), instructionsToBeAdded);

        return instructions;
    }

    public static AssemblyCode visitExitStatNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        List<Instruction> instructionsToBeAdded = new ArrayList<>();

        if (((ExitStatNode) node).getExpr() instanceof IdentNode) {


            instructionsToBeAdded.add(new LDR(registers.getNextAvailableVariableReg(), registers.getStackPtrReg()));
        } else {
            //TODO: BAD PROGRAMMING DESIGN!!!!!!!!!!
            instructionsToBeAdded.add(new LDR(registers.getNextAvailableVariableReg(),
                    ((IntLiterNode) ((ExitStatNode) node).getExpr()).getValue()));
        }

        instructionsToBeAdded.add(new MOV(registers.getR0Reg(), registers.getNextAvailableVariableReg()));
        instructionsToBeAdded.add(new BL("exit"));

        //Add the instructions to be added into the assembly code wrapper class.
        instructions.add(instructions.getCurrentLabel(), instructionsToBeAdded);

        return instructions;
    }

    public static AssemblyCode visitFreeStatNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        List<Instruction> instructionsToBeAdded = new ArrayList<>();
        instructionsToBeAdded.addAll(instructions.getMessageGenerator().generateNullReferenceInstructions(
                registers, instructions));

        instructions.add(new Header(".data"), null);
        String errorMessage = "\"NullReferenceError: dereference a null reference.\\n\"";
        instructions.getMessageGenerator().generatePrintStringTypeMessage(
                instructions, errorMessage.length() - 2, errorMessage);

        Label printFreePair = new Label("p_free_pair");
        instructions.add(printFreePair, new ArrayList<>(Arrays.asList(new PUSH(registers.getLinkReg()))));
        instructions.add(printFreePair,
                instructions.getMessageGenerator().generateRuntimeInstructions(registers, instructions));

        List<Instruction> printFreePairInstructions = new ArrayList<>();
        printFreePairInstructions.add(new PUSH(registers.getR0Reg()));
        printFreePairInstructions.add(new LDR(registers.getR0Reg(), registers.getR0Reg()));
        printFreePairInstructions.add(new BL("free"));
        printFreePairInstructions.add(new LDR(registers.getR0Reg(), registers.getStackPtrReg()));
        printFreePairInstructions.add(new LDR(registers.getR0Reg(), registers.getR0Reg(), 4));
        printFreePairInstructions.add(new BL("free"));
        printFreePairInstructions.add(new POP(registers.getR0Reg()));
        printFreePairInstructions.add(new BL("free"));
        printFreePairInstructions.add(new POP(registers.getPCReg()));
        instructions.add(printFreePair, printFreePairInstructions);;

        Label printThrowRunTime = new Label("p_throw_runtime_error");

        List<Instruction> printThrowRunTimeInstructions = new ArrayList<>();
        printThrowRunTimeInstructions.add(new BL("p_print_string"));
        printThrowRunTimeInstructions.add(new MOV(registers.getR0Reg(), -1));
        printThrowRunTimeInstructions.add(new BL("exit"));
        instructions.add(printThrowRunTime, printFreePairInstructions);

        Label printString = new Label("p_print_string");
        instructions.add(printString, new ArrayList<Instruction>(Arrays.asList(
                new PUSH(registers.getLinkReg()))));
        instructions.add(printString,
                instructions.getMessageGenerator().generatePrintStringInstructions(registers, instructions));
        instructions.add(printString, new ArrayList<Instruction>(Arrays.asList(
                new ADD(registers.getR0Reg(), registers.getR0Reg(), 4),
                new BL("printf"))));
        instructions.add(printString,
                instructions.getMessageGenerator().generateEndPrintInstructions(instructions, registers));

        instructions = visitExpression(((FreeStatNode) node).getExpr(), instructions, registers);

        instructions.add(instructions.getCurrentLabel(), instructionsToBeAdded);

        return instructions;
    }

    public static AssemblyCode visitIfStatNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        varSymbolTable.saveState();

        IfStatNode ifStatNode = (IfStatNode) node;

        instructions = visitExpression(ifStatNode.getCond(), instructions, registers);

        List<Instruction> instructionsToBeAdded = new ArrayList<>();
        instructionsToBeAdded.add(new CMP(registers.getNextAvailableVariableReg(), 0));
        instructionsToBeAdded.add(new BEQ(instructions.getNextLabel()));
        instructions.add(instructions.getCurrentLabel(), instructionsToBeAdded);

        instructions = visitStatListNode(ifStatNode.getStatThenBody(), instructions, registers);

        newSymbolTable();
        Label currentMainLabel = instructions.getCurrentLabel();
        popSymbolTable();

        instructions.updateCurrentLabel();

        newSymbolTable();
        instructions = visitStatListNode(ifStatNode.getStatElseBody(), instructions, registers);
        popSymbolTable();

        String branchLabelName = instructions.getNextLabel();
        instructions.add(currentMainLabel,
                new ArrayList<>(Arrays.asList(new B(branchLabelName))));

        if (!varSymbolTable.checkSameState()) {
            int diff = varSymbolTable.getState() - varSymbolTable.getVarTotalSize();
            instructions.add(instructions.getCurrentLabel(),
                    new ArrayList<>(Arrays.asList(new ADD(registers.getStackPtrReg(),
                            registers.getStackPtrReg(), diff))));
        }

        instructions.add(instructions.getCurrentLabel(),
                new ArrayList<>(Arrays.asList(new B(branchLabelName))));
        instructions.updateCurrentLabel();

        return instructions;
    }

    public static AssemblyCode visitPrintlnStatNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        List<Instruction> instructionsToBeAddedMain = new ArrayList<>();

        List<Label> labels = new ArrayList<>();


        PrintlnStatNode printNode = (PrintlnStatNode) node;

        ExpressionNode printExp = (ExpressionNode) printNode.getExpr();


        int typeIndicator = printExp.getTypeIndicator();
        String exprType = convertTypeToString(typeIndicator);

        instructionsToBeAddedMain.add(new MOV(registers.getR0Reg(), registers.getNextAvailableVariableReg()));
        instructions.add(new Header(".data"), null);

        if(typeIndicator == Util.CHAR_TYPE){
            instructionsToBeAddedMain.add(new BL("putchar"));
        } else {
            instructionsToBeAddedMain.add(new BL("p_print_" + exprType));

            labels.add(new Label("p_print_" + exprType));

            instructions.add(labels.get(0), new ArrayList<>(Arrays.asList(new PUSH(registers.getLinkReg()))));

            instructions = instructions.getMessageGenerator().generatePrintTypeMessage(typeIndicator, instructions);

            instructions.add(labels.get(0),
                    instructions.getMessageGenerator().printInstrTypeMessage(typeIndicator, instructions, registers));
        }


        instructionsToBeAddedMain.add(new BL("p_print_ln"));

        labels.add(new Label("p_print_ln"));

        if (typeIndicator != Util.CHAR_TYPE) {
            instructions.add(labels.get(1), new ArrayList<>(
                    Arrays.asList(new PUSH(registers.getLinkReg()))));
        } else {
            instructions.add(labels.get(0), new ArrayList<>(
                    Arrays.asList(new PUSH(registers.getLinkReg()))));
        }

        // We need to visit the expression node inside print statement
        instructions = visitExpression(printExp, instructions, registers);
        //Add a new line
        instructions = instructions.getMessageGenerator().generateNewLine(instructions);



        if (typeIndicator != Util.CHAR_TYPE) {
            instructions.add(labels.get(1), new ArrayList<>(Arrays.asList(
                    new LDR(registers.getR0Reg(), new Label("msg_" + (instructions.getNumberOfMessage() - 1))))));
        } else {
            instructions.add(labels.get(0), new ArrayList<>(Arrays.asList(
                    new LDR(registers.getR0Reg(), new Label("msg_" + (instructions.getNumberOfMessage() - 1))))));
        }


        instructions.add(instructions.getCurrentLabel(), instructionsToBeAddedMain);

        //printings under the label p_print_println

        instructions.add(labels.get(0), new ArrayList<>(Arrays.asList(
                new ADD(registers.getR0Reg(), registers.getR0Reg(), 4),
                new BL(typeIndicator == Util.CHAR_TYPE ? "puts" : "printf")
        )));


        instructions.add(labels.get(0), instructions.getMessageGenerator().generateEndPrintInstructions(instructions, registers));

        //For types other than char. Printings under the label p_print_TYPE
        if(typeIndicator != Util.CHAR_TYPE){

            instructions.add(labels.get(1), new ArrayList<>(Arrays.asList(
            new ADD(registers.getR0Reg(), registers.getR0Reg(), 4),
                    new BL("puts")
            )));

            instructions.add(labels.get(1), instructions.getMessageGenerator().generateEndPrintInstructions(instructions, registers));

        }

        return instructions;
    }

    public static AssemblyCode visitPrintStatNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        List<Instruction> instructionsToBeAddedMain = new ArrayList<>();

        Label labelPrintType = null;

        PrintStatNode printNode = (PrintStatNode) node;
        ExpressionNode printExp = printNode.getExpr();

        if (printExp instanceof PairLiterNode) {
            instructions = visitPairElemNode(printExp, instructions, registers);
            return instructions;
        }

        int typeIndicator = printExp.getTypeIndicator();
        String exprType = convertTypeToString(typeIndicator);

        instructionsToBeAddedMain.add(new MOV(registers.getR0Reg(), registers.getNextAvailableVariableReg()));
        instructions.add(new Header(".data"), null);


        if(typeIndicator == Util.CHAR_TYPE){
            // We do not need a new label when printing a char
            instructionsToBeAddedMain.add(new BL("putchar"));
        } else {
            instructionsToBeAddedMain.add(new BL("p_print_" + exprType));
            labelPrintType = new Label("p_print_" + exprType); //0

            instructions.add(labelPrintType, new ArrayList<>(Arrays.asList(new PUSH(registers.getLinkReg()))));

            instructions = instructions.getMessageGenerator().generatePrintTypeMessage(typeIndicator, instructions);

            instructions.add(labelPrintType,
                    instructions.getMessageGenerator().printInstrTypeMessage(typeIndicator, instructions, registers));
        }

        // We need to visit the expression node inside print statement
        instructions = visitExpression(printExp, instructions, registers);

        instructions.add(instructions.getCurrentLabel(), instructionsToBeAddedMain);

        if(typeIndicator != Util.CHAR_TYPE){
            instructions.add(labelPrintType,
                    new ArrayList<>(Arrays.asList(
                            new ADD(registers.getR0Reg(), registers.getR0Reg(), 4),
                            new BL("printf")
                    )));

            instructions.add(labelPrintType,
                    instructions.getMessageGenerator()
                            .generateEndPrintInstructions(instructions, registers));
        }
        
        return instructions;
    }

    public static AssemblyCode visitReadStatNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        ReadStatNode rNode = (ReadStatNode) node;
        List<Instruction> instructionsToBeAdded = new ArrayList<>();
        Label msgLabel = new Label("msg_" + instructions.getNumberOfMessage());
        Label readLabel = null;
        if (rNode.getAssignLHS() instanceof IdentAsLNode) {
            IdentAsLNode target = (IdentAsLNode) rNode.getAssignLHS();
            if (target.getId().getTypeIndicator() == Util.INT_TYPE) {
                instructionsToBeAdded.add(new HeaderInstr("\t.word", 3));
            } else {
                instructionsToBeAdded.add(new HeaderInstr("\t.word", 4));
            }
            instructionsToBeAdded.add(new HeaderInstr("\t.ascii \"%d\\0\""));
            instructions.add(msgLabel, instructionsToBeAdded);
            //todo: assumed main label didn't get changed
            instructionsToBeAdded.clear();
            instructionsToBeAdded.add(new ADD(registers.getNextAvailableVariableReg(),
                    registers.getStackPtrReg(), varSymbolTable.getVariable(target.getId().getId()).getLocationInStack() - instructions.getCurrentStackPtrPos()));
            instructionsToBeAdded.add(new MOV(registers.getR0Reg(), registers.getNextAvailableVariableReg()));
            instructionsToBeAdded.add(new BL("p_read_" + Util.getBaseTypeString(target.getId().getTypeIndicator())));
            readLabel = new Label("p_read_" + Util.getBaseTypeString(target.getId().getTypeIndicator()));
        }

        instructions.add(instructions.getCurrentLabel(), instructionsToBeAdded);
        instructions.add(readLabel, new ArrayList<>(Arrays.asList(new PUSH(registers.getLinkReg()))));
        instructionsToBeAdded.clear();
        instructionsToBeAdded.add(new MOV(registers.getR1Reg(), registers.getR0Reg()));
        instructionsToBeAdded.add(new LDR(registers.getR0Reg(), msgLabel));
        instructionsToBeAdded.add(new ADD(registers.getR0Reg(), registers.getR0Reg(), 4));
        instructionsToBeAdded.add(new BL("scanf"));
        instructions.add(readLabel, instructionsToBeAdded);
        instructions.add(readLabel, new ArrayList<>(Arrays.asList(new POP(registers.getPCReg()))));
        
        return instructions;
    }

    public static AssemblyCode visitReturnStatNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        ReturnStatNode returnStatNode = (ReturnStatNode) node;

        instructions = visitExpression(returnStatNode.getExpr(), instructions, registers);
        instructions.add(instructions.getCurrentLabel(),
                new ArrayList<>(Arrays.asList(new MOV(registers.getR0Reg(),
                        registers.getNextAvailableVariableReg()))));

        if (varSymbolTable.getVarLocalSize() > 0) {
            instructions.add(instructions.getCurrentLabel(),
                    new ArrayList<>(Arrays.asList(
                            new ADD(registers.getStackPtrReg(),
                                    registers.getStackPtrReg(),
                                    varSymbolTable.getVarLocalSize()))));
        }

        instructions.add(instructions.getCurrentLabel(), new ArrayList<>(Arrays.asList(new POP(registers.getPCReg()))));

        return instructions;
    }

    public static AssemblyCode visitScopingStatNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        newSymbolTable();
        ScopingStatNode sNode = (ScopingStatNode) node;
        varSymbolTable.saveState();
        instructions = visitStatListNode(sNode.getBody(), instructions, registers);

        //If size of SymbolTable is NOT the same
        if (!varSymbolTable.checkSameState()) {
            int diff = varSymbolTable.getState() - varSymbolTable.getVarTotalSize();
            instructions.add(instructions.getCurrentLabel(),
                    new ArrayList<>(Arrays.asList(new ADD(registers.getStackPtrReg(),
                            registers.getStackPtrReg(), diff))));
            instructions.setCurrentStackPtrPos(instructions.getCurrentStackPtrPos() + diff);
        }

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

        WhileStatNode whileStateNode = (WhileStatNode) node;

        String nextLabel = instructions.getNextLabel();

        List<Instruction> instructionsToBeAdded = new ArrayList<>();
        instructionsToBeAdded.add(new B(nextLabel));
        instructions.add(instructions.getCurrentLabel(), instructionsToBeAdded);
        instructions.updateCurrentLabel();

        Label beforeWhile = instructions.getCurrentLabel();

        instructions = visitExpression(whileStateNode.getCondition(), instructions, registers);

        instructionsToBeAdded = new ArrayList<>();
        instructionsToBeAdded.add(new CMP(registers.getNextAvailableVariableReg(), 1));

        nextLabel = instructions.getNextLabel();
        instructionsToBeAdded.add(new BEQ(nextLabel));

        instructions.add(instructions.getCurrentLabel(), instructionsToBeAdded);

        instructions.updateCurrentLabel();

        newSymbolTable();
        instructions = visitStatListNode(whileStateNode.getBody(), instructions, registers);
        popSymbolTable();

        instructions.add(instructions.getCurrentLabel(),
                new ArrayList<>(Arrays.asList(new B(beforeWhile.getName()))));

        instructions.setCurrentLabel(beforeWhile);

        return instructions;
    }

    ////////////////////////////function and program//////////////////////////////////////

    public static AssemblyCode visitFunctionNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        //TODO
        FunctionNode fNode = (FunctionNode) node;
        VarSymbolTable paramSymbolTable = new VarSymbolTable();
        String funcName = fNode.getFunctionName();
        List<String> paramNames = null;
        List<Type> paramTypes = null;
        if (fNode.getParamListNode() != null) {
            paramNames = fNode.getParamListNode().getParamNames();
            try {
                paramTypes = fNode.getParamListNode().getParamTypes();
            } catch (SemanticException e) {
                System.err.println("shouldn't reach here, as should be able to get params type");
            }
            for (int i = 0; i < paramNames.size(); i++) {
                paramSymbolTable.addVariable(
                        paramNames.get(i), covertParamToValue(null, paramTypes.get(i)));
            }
        }
        funcSymbolTable.addFunction(
                funcName,
                Util.convertTypeToIndicator(fNode.getRetType()),
                paramSymbolTable);
        varSymbolTable = funcSymbolTable.getFunctionParams(funcName);

        List<Instruction> instructionsToBeAdded = new ArrayList<>();
        instructions.addFuncLabel(funcName);
        instructionsToBeAdded.add(new PUSH(registers.getLinkReg()));
        instructions.add(instructions.getCurrentLabel(), instructionsToBeAdded);
        instructions = visitStatListNode(fNode.getStatement(), instructions, registers);
        instructions.add(instructions.getCurrentLabel(), instructions.getMessageGenerator().generateEndOfFunc(registers));
        instructions.setCurrentStackPtrPos(0);

        return instructions;
    }

    public static AssemblyCode visitProgramNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        funcSymbolTable = new FuncSymbolTable();

        instructions.add(new Header(".text\n\n"), null);
        instructions.add(new Header(".global main\n"), null);
        List<FunctionNode> functions = ((ProgramNode) node).getFunctionNodes();

        //Visit FunctionNode and return instructions
        for (FunctionNode f : functions) {
            instructions = visitFunctionNode(f, instructions, registers);
        }

        instructions.returnMainLabel();
        varSymbolTable  = new VarSymbolTable();


        //PUSH {LR}
        instructions.add(instructions.getCurrentLabel(), new ArrayList<Instruction>(Arrays.asList(
                new PUSH(registers.getLinkReg()))));

        //Visit StatListNode and return instructions
        instructions = visitStatListNode(((ProgramNode) node).getStatListNode(), instructions, registers);

        List<Instruction> instructionsToBeAdded = new ArrayList<>();

        if (varSymbolTable.getVarLocalSize() > 0) {
//        if (instructions.getVarSymbolTableLocalSize() > 0) {
            for (int i = varSymbolTable.getVarLocalSize(); (0 < i) && (i < 1024) ; i -= 1024) {
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

    private static Value convertAssignRHSToValue(AssignRightNode node, int stackPtrPos) {
        int typeIndicator = Util.EMPTY_TYPE;
        if (node instanceof ArrayLiterAsRNode) {
            return new Value(true, ((ArrayLiterAsRNode) node).getElementTypeIndicator(), stackPtrPos);
        }
        if (node instanceof CallAsRNode) {
            String funcName = ((CallAsRNode) node).getFunctionId().getId();
            return new Value(funcSymbolTable.getFunctionRetType(funcName), stackPtrPos);
        }
        if (node instanceof ExprAsRNode) {
            typeIndicator = ((ExprAsRNode)node).getExpr().getTypeIndicator();
            if (typeIndicator == Util.ARRAY_TYPE) {
                // only correct occasion is when node is instance of IdentNode which referecnce an array
                IdentNode iNode = null;
                try {
                    iNode = (IdentNode) node;
                } catch (ClassCastException e) {
                    System.err.println("RHS should be a identifier for it to be instance of expressionNode and has array type");
                }
                return varSymbolTable.getVariable(iNode.getId());
            }
            if (typeIndicator == Util.PAIR_TYPE) {
                if (node instanceof PairLiterNode
                        || node instanceof ExprAsRNode && ((ExprAsRNode) node).getExpr() instanceof PairLiterNode) {
                    return new Value(true, Util.EMPTY_TYPE, Util.EMPTY_TYPE, stackPtrPos);
                }
                if (node instanceof IdentNode) {
                    return varSymbolTable.getVariable(((IdentNode) node).getId());
                }
                System.err.println("No other instance of RHS for it to be of type pair");
            }
            return new Value(typeIndicator, stackPtrPos);
        }
        if (node instanceof NewPairAsRNode) {
            int fst = ((NewPairAsRNode) node).getFstTypeIndicator();
            int snd = ((NewPairAsRNode) node).getSndTypeIndicator();
            return new Value(true, fst, snd, stackPtrPos);
        }
        if (node instanceof PairElemAsRNode) {
            typeIndicator = ((PairElemAsRNode) node).getPairElemNode().getExpressionNode().getTypeIndicator();
            return new Value(typeIndicator, stackPtrPos);
        }
        System.err.println("unrecognised assign rhs instance");
        return null;
    }

    private static String convertTypeToString(int typeIndicator){
        switch (typeIndicator){
            case 0: return "int";
            case 1 : return "bool";
            case 2: return "char";
            case 3 : return "string";
            case 4 : return "array";
            case 5: return "pair";
            default: return "No such type";
        }

    }



}
