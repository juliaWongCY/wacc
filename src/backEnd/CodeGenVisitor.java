package backEnd;

import ast.ASTNode;
import ast.*;
import backEnd.general.*;
import ast.assignLeft.*;
import ast.assignRight.*;
import ast.expression.*;
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
import backEnd.symbolTable.VarProperty;
import backEnd.symbolTable.VarSymbolTable;
import frontEnd.SemanticException;
import type.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"ConstantConditions", "WeakerAccess"})
public class CodeGenVisitor {

    private static VarSymbolTable varSymbolTable = new VarSymbolTable();
    private static FuncSymbolTable funcSymbolTable;

    //private static List<Label> labels;
    private static boolean hasPrintlnMsg = false;
    private static final Integer[] printTypes = new Integer[Util.NUMBER_OF_TYPE];
    private static final Integer[] errorMsgs = new Integer[Util.NUMBER_OF_ERROR];

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
        System.err.println("unrecognised assign right node");
        return null;
    }

    public static AssemblyCode visitArrayElemAsLNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        //CHECKED
        return visitArrayElemNode(((ArrayElemAsLNode)node).getArrayElem(), instructions, registers);
    }

    @SuppressWarnings("UnusedParameters")
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
                            new ArrayList<>(Collections.singletonList(new STR(registers.getNextAvailableVariableReg(),
                                    registers.getStackPtrReg(), offset, true, "B"))));
                } else {
                    instructions.add(instructions.getCurrentLabel(),
                            new ArrayList<>(Collections.singletonList(new STR(registers.getNextAvailableVariableReg(),
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
            assert instructions != null;
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
                instructions.setCurrentStackPtrPos(instructions.getCurrentStackPtrPos() + aNode.getTypeSize());
            }
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
        List<Instruction> instructionsToBeAdded = new ArrayList<>();
        ArrayElemNode aNode = (ArrayElemNode) node;
        Type fullType = aNode.getElemType();
        int typeIndicator = aNode.getTypeIndicator();

        instructions.add(instructions.getCurrentLabel(), new ArrayList<>(Collections.singletonList(
                new ADD(registers.getNextAvailableVariableReg(), registers.getStackPtrReg(), 0))));

        // need to loop through indexes
        List<ExpressionNode> indexes = ((ArrayElemNode) node).getIndexes();


        for (ExpressionNode index : indexes) {
            Registers updatedRegisters = registers.addRegInUsedList(registers.getNextAvailableVariableReg());
            instructions = visitExpression(index, instructions, updatedRegisters);
            registers.setRegNotInUse(registers.getPreviousReg(registers.getNextAvailableVariableReg()));

            instructionsToBeAdded.add(new LDR(registers.getNextAvailableVariableReg(),
                    registers.getNextAvailableVariableReg()));
            instructionsToBeAdded.add(new MOV(registers.getR0Reg(),
                    registers.getNextReg(registers.getNextAvailableVariableReg())));
            instructionsToBeAdded.add(new MOV(registers.getR1Reg(), registers.getNextAvailableVariableReg()));
            instructionsToBeAdded.add(new BL("p_check_array_bounds"));
            instructionsToBeAdded.add(new ADD(registers.getNextAvailableVariableReg(), registers.getNextAvailableVariableReg(), 4));
            instructionsToBeAdded.add(new ADD(registers.getNextAvailableVariableReg(), registers.getNextAvailableVariableReg(),
                    registers.getNextReg(registers.getNextAvailableVariableReg()), new LSL(2)));
            instructions.add(instructions.getCurrentLabel(), instructionsToBeAdded);
            instructionsToBeAdded.clear();
        }

        //TODO: check!!!!!
        if(registers.getNextAvailableVariableReg() != RegisterARM.R4){
            if(typeIndicator == Util.INT_TYPE){
                instructionsToBeAdded.add(new STR(registers.getPreviousReg(registers.getNextAvailableVariableReg()),
                        registers.getNextAvailableVariableReg()));
            } else {
                instructionsToBeAdded.add(new STRB(registers.getPreviousReg(registers.getNextAvailableVariableReg()),
                        registers.getNextAvailableVariableReg()));
            }
        } else {
            instructionsToBeAdded.add(new LDR(registers.getNextAvailableVariableReg(),
                    registers.getNextAvailableVariableReg()));
        }

        instructions.add(instructions.getCurrentLabel(), instructionsToBeAdded);

        instructions = generateArrayError(instructions, registers);
        instructions = generatePrintStringMessage(instructions, registers);
        instructions = generateRuntimeErrorMessage(instructions, registers);

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
                new ArrayList<>(Collections.singletonList(new MOV(registers.getNextAvailableVariableReg(), res))));

        return instructions;
    }

    public static AssemblyCode visitCharLiterNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        char character = ((CharLiterNode) node).getValue();

            instructions.add(instructions.getCurrentLabel(),
                    new ArrayList<>(Collections.singletonList(new MOV(registers.getNextAvailableVariableReg(), character))));
        
        return instructions;
    }

    public static AssemblyCode visitIdentNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        //TODO : double check the position in stack
        IdentNode nodeID = (IdentNode) node;
        int nodeType = Util.convertTypeToIndicator(varSymbolTable.getVarProperty(nodeID.getId()).getType());

        if(nodeType == Util.INT_TYPE | nodeType == Util.STRING_TYPE | nodeType == Util.ARRAY_TYPE | nodeType == Util.PAIR_TYPE){
            instructions.add(instructions.getCurrentLabel(),
                    new ArrayList<>(Collections.singletonList(new LDR(registers.getNextAvailableVariableReg(),
                            registers.getStackPtrReg(), varSymbolTable.getVarProperty(nodeID.getId()).getStackPos() - instructions.getCurrentStackPtrPos()))));
        }

        if(nodeType == Util.BOOL_TYPE | nodeType == Util.CHAR_TYPE){
            instructions.add(instructions.getCurrentLabel(),
                    new ArrayList<>(Collections.singletonList(new LDRSB(registers.getNextAvailableVariableReg(),
                            registers.getStackPtrReg(), varSymbolTable.getVarProperty(nodeID.getId()).getStackPos() - instructions.getCurrentStackPtrPos()))));
        }

        return instructions;
    }

    public static AssemblyCode visitIntLiterNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        instructions.add(instructions.getCurrentLabel(),
                new ArrayList<>(Collections.singletonList(new LDR(registers.getNextAvailableVariableReg(),
                        new Label(((IntLiterNode) node).getValue().toString())))));

        return instructions;
    }

    public static AssemblyCode visitPairElemNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        PairElemNode pNode = (PairElemNode) node;
        List<Instruction> instructionsToBeAdded = new ArrayList<>();

        instructions = generateNullRefError(instructions, registers);
        instructions = generatePrintStringMessage(instructions, registers);

        instructions.add(instructions.getCurrentLabel(), instructionsToBeAdded);
        instructionsToBeAdded.clear();

        instructions = visitExpression(pNode.getExpressionNode(), instructions, registers);

        instructionsToBeAdded.add(new MOV(registers.getR0Reg(), registers.getNextAvailableVariableReg()));
        instructionsToBeAdded.add(new BL("p_check_null_pointer"));
        instructionsToBeAdded.add(new LDR(registers.getNextAvailableVariableReg(), registers.getNextAvailableVariableReg()));//todo: check
        instructionsToBeAdded.add(new LDR(registers.getNextAvailableVariableReg(), registers.getNextAvailableVariableReg()));

        instructions.add(instructions.getCurrentLabel(), instructionsToBeAdded);
        instructions = generateRuntimeErrorMessage(instructions, registers);
        instructions = generatePrintStringMessage(instructions, registers);
        
        return instructions;
    }

    @SuppressWarnings("UnusedParameters")
    public static AssemblyCode visitPairLiterNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        instructions.add(instructions.getCurrentLabel(),
                Collections.singletonList(new LDR(registers.getNextAvailableVariableReg(), 0))); //TODO: check the constant
        return instructions;
    }

    public static AssemblyCode visitStringLiterNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        StringLiterNode strNode = (StringLiterNode) node;
        List<Instruction> instructionsToBeAdded = new ArrayList<>();

            Label label = new Label("msg_" + instructions.getNumberOfMessage());

            instructions.add(instructions.getCurrentLabel(),
                new ArrayList<>(Collections.singletonList(new LDR(registers.getNextAvailableVariableReg(), label))));

            instructionsToBeAdded.add(new HeaderInstr("\t.word ", strNode.getStringSize()));
            instructionsToBeAdded.add(new HeaderInstr("\t.ascii " + strNode.getValue()));

            instructions.add(label, instructionsToBeAdded);

        return instructions;
    }

    public static AssemblyCode visitUnaryOprNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        List<Instruction> instructionsToBeAdded = new ArrayList<>();
        UnaryOpr unaryOpr = ((UnaryOprNode) node).getUnaryOpr();

        instructions = visitExpression(((UnaryOprNode) node).getExpr(), instructions, registers);
        switch (unaryOpr) {
            case NOT:
                instructionsToBeAdded.add(new EOR(registers.getNextAvailableVariableReg(), 1));
                break;
            case NEG:
                instructions = generateOverflowError(instructions, registers);
                instructions = generatePrintStringMessage(instructions, registers);
                instructions = generateRuntimeErrorMessage(instructions, registers);

                instructionsToBeAdded.add(new RSBS(registers.getNextAvailableVariableReg(),
                        registers.getNextAvailableVariableReg(), 0));

                instructionsToBeAdded.add(new BLVS("p_throw_overflow_error"));
                break;
            case LEN:
                instructionsToBeAdded.add(new LDR(registers.getNextAvailableVariableReg(), registers.getStackPtrReg()));
                instructionsToBeAdded.add(new LDR(registers.getNextAvailableVariableReg(), registers.getNextAvailableVariableReg()));
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
            instructions.add(instructions.getCurrentLabel(), new ArrayList<>(Collections.singletonList(new PUSH(exprLReg))));
        }
        Registers updatedRegs = registers.addRegInUsedList(exprLReg);

        instructions = visitExpression(((BinaryOprNode) node).getExprR(), instructions, updatedRegs);

        RegisterARM exprRReg = registers.getNextAvailableVariableReg();
        RegisterARM resultReg = exprLReg;

        if (exprRReg == RegisterARM.R10 && exprLReg == RegisterARM.R10) {
            instructions.add(instructions.getCurrentLabel(),
                    new ArrayList<>(Collections.singletonList(new POP(RegisterARM.R11))));
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
                if (((BinaryOprNode) node).getBinaryOpr().equals(BinaryOpr.DIV)
                        || ((BinaryOprNode) node).getBinaryOpr().equals(BinaryOpr.MOD)) {
                    String errorMessage = "\"DivideByZeroError: divide or modulo by zero\\n\\0\"";
                    instructions.getMessageGenerator().generatePrintErrorMessage(
                            instructions, errorMessage.length() - 3, errorMessage);
                }
                instructions = generateRuntimeErrorMessage(instructions, registers);
                instructions = generatePrintStringMessage(instructions, registers);
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

                if (((BinaryOprNode) node).getBinaryOpr().equals(BinaryOpr.PLUS)
                        || ((BinaryOprNode) node).getBinaryOpr().equals(BinaryOpr.MINUS)) {
                    instructionsToBeAdded.add(new BLVS("p_throw_overflow_error"));
                } else if (((BinaryOprNode) node).getBinaryOpr().equals(BinaryOpr.DIV) ||
                        ((BinaryOprNode) node).getBinaryOpr().equals(BinaryOpr.MOD)) {
                    instructionsToBeAdded.add(new BL("p_check_divide_by_zero"));
                    instructionsToBeAdded.add(new BL(((BinaryOprNode) node).getBinaryOpr().equals(BinaryOpr.DIV) ?
                            "__aeabi_idiv" : "__aeabi_idivmod"));
                    instructionsToBeAdded.add(new MOV(resultReg,
                            ((BinaryOprNode) node).getBinaryOpr().equals(BinaryOpr.DIV) ?
                                    registers.getR0Reg() : registers.getR1Reg()));
                    instructions = generateDivideByZeroError(instructions, registers);
                } else {
                    instructionsToBeAdded.add(new BLNE("p_throw_overflow_error"));
                }

                if (!(((BinaryOprNode) node).getBinaryOpr().equals(BinaryOpr.DIV)
                        || ((BinaryOprNode) node).getBinaryOpr().equals(BinaryOpr.MOD))) {
                    instructions = generateOverflowError(instructions, registers);
                }
            }
        }

        registers.setRegNotInUse(resultReg);
        instructions.add(instructions.getCurrentLabel(), instructionsToBeAdded);
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

        //TODO: getting the right type??
        int type = assignStatNode.getAssignRHS().getTypeIndicator();


        //TODO: takend out (type == Util.CHAR_TYPE ||)
        if (type == Util.BOOL_TYPE) {
            instructionsToBeAdded.add(new STRB(registers.getNextAvailableVariableReg(), registers.getStackPtrReg()));
        } else {
            if (assignStatNode.getAssignLHS() instanceof IdentAsLNode) {
                IdentAsLNode identAsLNode = (IdentAsLNode) assignStatNode.getAssignLHS();
                if(type == Util.CHAR_TYPE){
                instructionsToBeAdded.add(new STRB(registers.getNextAvailableVariableReg(), registers.getStackPtrReg()));
                } else {
                    VarProperty varProperty = varSymbolTable.getVarProperty(identAsLNode.getIdnode().getId());

                    instructionsToBeAdded.add(new STR(registers.getNextAvailableVariableReg(),
                        registers.getStackPtrReg(), varProperty.getStackPos() - instructions.getCurrentStackPtrPos()));
                }
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
            registers.addRegInUsedList(registers.getNextAvailableVariableReg());
//            instructionsToBeAdded.add(new STR(registers.getNextAvailableVariableReg(),
//                    registers.getNextReg(registers.getNextAvailableVariableReg())));
            visitAssignLeftNode(assignStatNode.getAssignLHS(), instructions, registers);
            registers.clearRegInUsed();
        }

        instructions.add(instructions.getCurrentLabel(), instructionsToBeAdded);

        return instructions;
    }

    public static AssemblyCode visitDeclareStatNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        List<Instruction> instructionsToBeAdded = new ArrayList<>();
        DeclareStatNode dNode = (DeclareStatNode) node;
        AssignRightNode rhsNode = dNode.getAssignRightNode();
        Type varType = dNode.getType();

        instructions.add(instructions.getCurrentLabel(),
                new ArrayList<>(Collections.singletonList(new SUB(registers.getStackPtrReg(), registers.getStackPtrReg(),
                        Util.getTypeSize(varType)))));
        instructions.setCurrentStackPtrPos(instructions.getCurrentStackPtrPos() - Util.getTypeSize(varType));

        instructions = visitAssignRightNode(rhsNode, instructions, registers);

        // construct value to put in variable symbol table
        VarProperty val = new VarProperty(varType, instructions.getCurrentStackPtrPos());
        varSymbolTable.addVariable(dNode.getId().getId(), val);

        if (varType instanceof CharType || varType instanceof BoolType) {
            instructionsToBeAdded.add(new STRB(registers.getNextAvailableVariableReg(), registers.getStackPtrReg()));
        } else {
            instructionsToBeAdded.add(new STR(registers.getNextAvailableVariableReg(), registers.getStackPtrReg()));
        }
        instructions.add(instructions.getCurrentLabel(), instructionsToBeAdded);

        return instructions;
    }

    public static AssemblyCode visitExitStatNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        List<Instruction> instructionsToBeAdded = new ArrayList<>();
        List<Instruction> instructionsForBinOp = new ArrayList<>();
        ExitStatNode eNode = (ExitStatNode) node;

        if (eNode.getExpr() instanceof BinaryOprNode) {
            instructions = visitBinaryOprNode(eNode.getExpr(), instructions, registers);
            instructionsForBinOp.add(new MOV(registers.getR0Reg(), registers.getNextAvailableVariableReg()));
            instructionsForBinOp.add(new BL("exit"));
            instructions.add(instructions.getCurrentLabel(), instructionsForBinOp);
        }

        if (eNode.getExpr() instanceof IdentNode) {
            instructionsToBeAdded.add(new LDR(registers.getNextAvailableVariableReg(), registers.getStackPtrReg()));
        } else if(eNode.getExpr() instanceof IntLiterNode){
            //TODO: BAD PROGRAMMING DESIGN!!!!!!!!!!
            instructionsToBeAdded.add(new LDR(registers.getNextAvailableVariableReg(),
                    ((IntLiterNode) eNode.getExpr()).getValue()));
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

        instructions = generateNullRefError(instructions, registers);
        instructions = generatePrintStringMessage(instructions, registers);

        Label printFreePair = new Label("p_free_pair");
        instructions.add(printFreePair, new ArrayList<>(Collections.singletonList(new PUSH(registers.getLinkReg()))));
        instructions.add(printFreePair,
                instructions.getMessageGenerator().generateRuntimeErrorInstructions(registers, instructions));

//        instructionsToBeAdded.clear();
        List<Instruction> freePairinstructions = new ArrayList<>();
        freePairinstructions.add(new PUSH(registers.getR0Reg()));
        freePairinstructions.add(new LDR(registers.getR0Reg(), registers.getR0Reg()));
        freePairinstructions.add(new BL("free"));
        freePairinstructions.add(new LDR(registers.getR0Reg(), registers.getStackPtrReg()));
        freePairinstructions.add(new LDR(registers.getR0Reg(), registers.getR0Reg(), 4));
        freePairinstructions.add(new BL("free"));
        freePairinstructions.add(new POP(registers.getR0Reg()));
        freePairinstructions.add(new BL("free"));
        freePairinstructions.add(new POP(registers.getPCReg()));
        instructions.add(printFreePair, freePairinstructions);

        instructions = generateRuntimeErrorMessage(instructions, registers);

        instructions = visitExpression(((FreeStatNode) node).getExpr(), instructions, registers);

        instructions.add(instructions.getCurrentLabel(), instructionsToBeAdded);

        return instructions;
    }

    public static AssemblyCode visitIfStatNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        String branchLabelName = instructions.getNextLabel();
        varSymbolTable.saveState();

        IfStatNode ifStatNode = (IfStatNode) node;

        instructions = visitExpression(ifStatNode.getCond(), instructions, registers);

        List<Instruction> instructionsToBeAdded = new ArrayList<>();
        instructionsToBeAdded.add(new CMP(registers.getNextAvailableVariableReg(), 0));
        instructionsToBeAdded.add(new BEQ(branchLabelName));
        instructions.add(instructions.getCurrentLabel(), instructionsToBeAdded);

        newSymbolTable();
        instructions = visitStatListNode(ifStatNode.getStatThenBody(), instructions, registers);
        popSymbolTable();
        //
        instructions.add(new Label(branchLabelName), new ArrayList<>(Collections.singletonList(new EMPTY())));

        Label currentMainLabel = instructions.getCurrentLabel();
        instructions.updateCurrentLabel();

        newSymbolTable();
        instructions = visitStatListNode(ifStatNode.getStatElseBody(), instructions, registers);

        branchLabelName = instructions.getNextLabel();
        instructions.add(currentMainLabel,
                new ArrayList<>(Collections.singletonList(new B(branchLabelName))));

//        if(varSymbolTable.hasNewVariables(varSymbolTable)){
        if (varSymbolTable.hasAddedNewVar()) {
            //TODO: getting the wrong diff?? the condition is wrong
            int diff = varSymbolTable.getVarLocalSize();
//            int diff = varSymbolTable.getOldState() - varSymbolTable.getVarTotalSize();

            instructions.add(instructions.getCurrentLabel(),
                    new ArrayList<>(Collections.singletonList(
                            new ADD(registers.getStackPtrReg(), registers.getStackPtrReg(), diff))));
        }
        popSymbolTable();

        // duplicate with line 817?
        instructions.add(instructions.getCurrentLabel(),
                new ArrayList<>(Collections.singletonList(new B(branchLabelName))));
        instructions.updateCurrentLabel();

        return instructions;
    }

    public static AssemblyCode visitPrintlnStatNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        List<Instruction> instructionsToBeAdded = new ArrayList<>();
        PrintlnStatNode pNode = (PrintlnStatNode) node;
        ExpressionNode printExp = pNode.getExpr();

        int typeIndicator = printExp.getTypeIndicator();
        String exprType = convertTypeToString(typeIndicator);

        Label printlnLabel = new Label("p_print_ln");

        instructionsToBeAdded.add(new MOV(registers.getR0Reg(), registers.getNextAvailableVariableReg()));
        instructions.add(new Header(".data"), null);

        if(typeIndicator == Util.CHAR_TYPE){
            instructionsToBeAdded.add(new BL("putchar"));
        } else {
            instructionsToBeAdded.add(new BL("p_print_" + exprType));

            instructions = generatePrintTypeMessage(instructions, registers, typeIndicator);

        }

        instructionsToBeAdded.add(new BL("p_print_ln"));

        // We need to visit the expression node inside print statement
        instructions = visitExpression(printExp, instructions, registers);

        instructions.add(instructions.getCurrentLabel(), instructionsToBeAdded);

        //Add a new line
        if (!hasPrintlnMsg) {
            instructions = instructions.getMessageGenerator().generateNewLine(instructions);

            instructions.add(printlnLabel, new ArrayList<>(Arrays.asList(
                    new PUSH(registers.getLinkReg()),
                    new LDR(registers.getR0Reg(), new Label("msg_" + (instructions.getNumberOfMessage() - 1))),
                    new ADD(registers.getR0Reg(), registers.getR0Reg(), 4),
                    new BL("puts")
            )));

            instructions.add(printlnLabel, instructions.getMessageGenerator().generateEndPrintInstructions(instructions, registers));

            hasPrintlnMsg =true;
        }

        return instructions;
    }

    public static AssemblyCode visitPrintStatNode(ASTNode node, AssemblyCode instructions, Registers registers) {

        List<Instruction> instructionsToBeAdded = new ArrayList<>();
        PrintStatNode pNode = (PrintStatNode) node;
        ExpressionNode printExp = pNode.getExpr();

        int typeIndicator = printExp.getTypeIndicator();
        String exprType = convertTypeToString(typeIndicator);

        instructionsToBeAdded.add(new MOV(registers.getR0Reg(), registers.getNextAvailableVariableReg()));
        instructions.add(new Header(".data"), null);

        if(typeIndicator == Util.CHAR_TYPE){
            instructionsToBeAdded.add(new BL("putchar"));
        } else {
            instructionsToBeAdded.add(new BL("p_print_" + exprType));

            instructions = generatePrintTypeMessage(instructions, registers, typeIndicator);

        }

        // We need to visit the expression node inside print statement
        instructions = visitExpression(printExp, instructions, registers);

        instructions.add(instructions.getCurrentLabel(), instructionsToBeAdded);

        return instructions;
    }

    public static AssemblyCode visitReadStatNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        ReadStatNode rNode = (ReadStatNode) node;
        List<Instruction> instructionsToBeAdded = new ArrayList<>();
        List<Instruction> instructionsForHeader = new ArrayList<>();

        List<Label> labels = new ArrayList<>();
        labels.add(instructions.getCurrentLabel());

        Label msgLabel = new Label("msg_" + instructions.getNumberOfMessage());
        Label readLabel;
        if (rNode.getAssignLHS() instanceof IdentAsLNode) {
            IdentAsLNode target = (IdentAsLNode) rNode.getAssignLHS();
            if (target.getIdnode().getTypeIndicator() == Util.INT_TYPE) {
                instructionsForHeader.add(new HeaderInstr("\t.word", 3));
                instructionsForHeader.add(new HeaderInstr("\t.ascii \"%d\\0\""));
            } else {
                instructionsForHeader.add(new HeaderInstr("\t.word", 4));
                instructionsForHeader.add(new HeaderInstr("\t.ascii \"%c\\0\""));

            }
            //TODO: change the header for int and other type
            instructions.add(msgLabel, instructionsForHeader);
            //todo: assumed main label didn't get changed

            //instructions under L1
                int varStackPos = varSymbolTable.getVarProperty(target.getIdnode().getId()).getStackPos();
                instructionsToBeAdded.add(new ADD(registers.getNextAvailableVariableReg(),
                    registers.getStackPtrReg(), varStackPos - instructions.getCurrentStackPtrPos()));
                instructionsToBeAdded.add(new MOV(registers.getR0Reg(), registers.getNextAvailableVariableReg()));
                instructionsToBeAdded.add(new BL("p_read_" + Util.getBaseTypeString(target.getIdnode().getTypeIndicator())));

            readLabel = new Label("p_read_" + Util.getBaseTypeString(target.getIdnode().getTypeIndicator()));
            labels.add(readLabel);

        } else if (rNode.getAssignLHS() instanceof PairElemAsLNode) {
            PairElemAsLNode pairElem = (PairElemAsLNode) rNode.getAssignLHS();
            instructions = visitPairElemAsLNode(pairElem, instructions, registers);
        }

        instructions.add(instructions.getCurrentLabel(), instructionsToBeAdded);

        instructionsToBeAdded.clear();
        instructionsToBeAdded.add(new PUSH(registers.getLinkReg()));
        instructionsToBeAdded.add(new MOV(registers.getR1Reg(), registers.getR0Reg()));
        instructionsToBeAdded.add(new LDR(registers.getR0Reg(), msgLabel));
        instructionsToBeAdded.add(new ADD(registers.getR0Reg(), registers.getR0Reg(), 4));
        instructionsToBeAdded.add(new BL("scanf"));
        instructionsToBeAdded.add(new POP(registers.getPCReg()));

        instructions.add(labels.get(1), instructionsToBeAdded);
        //instructions.add(labels.get(1), new ArrayList<>(Arrays.asList(new POP(registers.getPCReg()))));
        
        return instructions;
    }



    public static AssemblyCode visitReturnStatNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        ReturnStatNode returnStatNode = (ReturnStatNode) node;

//        varSymbolTable.saveState();

        instructions = visitExpression(returnStatNode.getExpr(), instructions, registers);
        instructions.add(instructions.getCurrentLabel(),
                new ArrayList<>(Collections.singletonList(new MOV(registers.getR0Reg(),
                        registers.getNextAvailableVariableReg()))));
//
/////////////TODO!!!!!!
//        if(varSymbolTable.hasAddedNewVar()){
////        if (varSymbolTable.getVarLocalSize() > 0) {
//            instructions.add(instructions.getCurrentLabel(),
//                    new ArrayList<>(Arrays.asList(
//                            new ADD(registers.getStackPtrReg(),
//                                    registers.getStackPtrReg(),
//                                    varSymbolTable.getVarLocalSize()))));
//        }

//        instructions.add(instructions.getCurrentLabel(), new ArrayList<>(Collections.singletonList(new POP(registers.getPCReg()))));

        return instructions;
    }

    public static AssemblyCode visitScopingStatNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        newSymbolTable();
        ScopingStatNode sNode = (ScopingStatNode) node;
        int oldState = varSymbolTable.saveState();
        instructions = visitStatListNode(sNode.getBody(), instructions, registers);

        //If size of SymbolTable is NOT the same
        if (varSymbolTable.hasAddedNewVar()) {
            int diff = Math.abs(varSymbolTable.getVarTotalSize() - oldState);
            instructions.add(instructions.getCurrentLabel(),
                    new ArrayList<>(Collections.singletonList(new ADD(registers.getStackPtrReg(),
                            registers.getStackPtrReg(), diff))));
            instructions.setCurrentStackPtrPos(instructions.getCurrentStackPtrPos() + diff);
        }

        popSymbolTable();
        return instructions;
    }

    @SuppressWarnings("UnusedParameters")
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
                new ArrayList<>(Collections.singletonList(new B(beforeWhile.getName()))));

        instructions.setCurrentLabel(beforeWhile);

        return instructions;
    }

    ////////////////////////////function and program//////////////////////////////////////

    public static AssemblyCode visitFunctionNode(ASTNode node, AssemblyCode instructions, Registers registers) {
        FunctionNode fNode = (FunctionNode) node;
        VarSymbolTable paramSymbolTable = new VarSymbolTable();
        String funcName = fNode.getFunctionName();
        List<String> paramNames;
        List<Type> paramTypes = null;
        List<Instruction> instructionsToBeAdded = new ArrayList<>();

        if (fNode.getParamListNode() != null) {
            paramNames = fNode.getParamListNode().getParamNames();
            try {
                paramTypes = fNode.getParamListNode().getParamTypes();
            } catch (SemanticException e) {
                System.err.println("shouldn't reach here, as should be able to get params type");
            }

            paramSymbolTable.addVariable(paramNames.get(0), new VarProperty(paramTypes.get(0), 4));
            for (int i = 1; i < paramNames.size(); i++) {
                paramSymbolTable.addVariable(
                        paramNames.get(i),
                        new VarProperty(paramTypes.get(i),
                                Util.getTypeSize(paramTypes.get(i - 1))
                                + paramSymbolTable.getVarProperty(paramNames.get(i - 1)).getStackPos())
                );
            }
        }

        funcSymbolTable.addFunction(
                funcName,
                Util.convertTypeToIndicator(fNode.getRetType()),
                paramSymbolTable);

        VarSymbolTable originalVarSymTable = varSymbolTable;
        varSymbolTable = paramSymbolTable;

        varSymbolTable.saveState();
        instructions.addFuncLabel(funcName);
        instructionsToBeAdded.add(new PUSH(registers.getLinkReg()));
        instructions.add(instructions.getCurrentLabel(), instructionsToBeAdded);
        instructions = visitStatListNode(fNode.getStatement(), instructions, registers);

        if(varSymbolTable.hasAddedNewVar()){
            int size = varSymbolTable.getVarTotalSize();
            System.out.println("size: " + size);
            while (size > 1024) {
                instructionsToBeAdded.add(new ADD(registers.getStackPtrReg(), registers.getStackPtrReg(), 1024));
                size -= 1024;
            }
            instructionsToBeAdded.add(new ADD(registers.getStackPtrReg(), registers.getStackPtrReg(), size));

          }

        instructions.add(instructions.getCurrentLabel(), new ArrayList<>(Collections.singletonList(new POP(registers.getPCReg()))));

        instructions.add(instructions.getCurrentLabel(), instructions.getMessageGenerator().generateEndOfFunc(registers));
        instructions.setCurrentStackPtrPos(0);

        varSymbolTable = originalVarSymTable;


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
//        instructions.setNumberOfMessage(0);
        varSymbolTable  = new VarSymbolTable(); //Todo: Commented out


        //PUSH {LR}
        instructions.add(instructions.getCurrentLabel(), new ArrayList<>(Collections.singletonList(
                new PUSH(registers.getLinkReg()))));

        //Visit StatListNode and return instructions
        instructions = visitStatListNode(((ProgramNode) node).getStatListNode(), instructions, registers);

        List<Instruction> instructionsToBeAdded = new ArrayList<>();

        if (varSymbolTable.getVarLocalSize() > 0) {
            int size = varSymbolTable.getVarTotalSize();

            while (size > 1024) {
                instructionsToBeAdded.add(new ADD(registers.getStackPtrReg(), registers.getStackPtrReg(), 1024));
                size -= 1024;
            }
            instructionsToBeAdded.add(new ADD(registers.getStackPtrReg(), registers.getStackPtrReg(), size));

        }

        instructionsToBeAdded.add(new LDR(registers.getR0Reg(), 0));
        instructionsToBeAdded.add(new POP(registers.getPCReg()));
        instructionsToBeAdded.add(new HeaderInstr("\t.ltorg"));

        //Add the instructions to be added into the assembly code wrapper class.
        instructions.add(instructions.getCurrentLabel(), instructionsToBeAdded);

        return instructions;
    }

    ////////////////////////////////////// helper method /////////////////////////////////////

    // create new symbol table with parent as current symbol table
    private static void newSymbolTable() {
        varSymbolTable = new VarSymbolTable(varSymbolTable);
    }

    // discard current symbol table and set current table as its parent
    private static void popSymbolTable() {
        if (varSymbolTable.getParent() == null) {
            System.err.println("error in finding variable symbol table parent");
        } else {
            varSymbolTable = varSymbolTable.getParent();
        }
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

    private static AssemblyCode generatePrintStringMessage(AssemblyCode instructions, Registers registers) {
        return generatePrintTypeMessage(instructions, registers, Util.STRING_TYPE);
    }

    private static AssemblyCode generatePrintTypeMessage(AssemblyCode instructions, Registers registers, int typeIndicator) {
        Label label = new Label("p_print_" + convertTypeToString(typeIndicator));

        if (printTypes[typeIndicator] == null) {
            instructions.add(label, new ArrayList<>(Collections.singletonList(new PUSH(registers.getLinkReg()))));
            printTypes[typeIndicator] = instructions.getNumberOfMessage();
            instructions = instructions.getMessageGenerator().generatePrintTypeMessage(typeIndicator, instructions);
            instructions.add(label,
                    instructions.getMessageGenerator().printInstrTypeMessage(typeIndicator, instructions, registers));
            instructions.add(label, new ArrayList<>(Arrays.asList(
                    new ADD(registers.getR0Reg(), registers.getR0Reg(), 4),
                    new BL("printf")
            )));
            instructions.add(label, instructions.getMessageGenerator().generateEndPrintInstructions(instructions, registers));
        }
        return instructions;
    }

    private static AssemblyCode generateRuntimeErrorMessage(AssemblyCode instructions, Registers registers) {
        if (errorMsgs[Util.RUNTIME_ERROR] == null) {
            List<Instruction> runTimeInstructions
                    = instructions.getMessageGenerator().generateRuntimeInstructions(registers, instructions);
            instructions.add(new Label("p_throw_runtime_error"), runTimeInstructions);
            errorMsgs[Util.RUNTIME_ERROR] = 1;
        }
        return instructions;
    }

    private static AssemblyCode generateOverflowError(AssemblyCode instructions, Registers registers) {
        if (errorMsgs[Util.OVERFLOW_ERROR] == null) {
            String errorMessage = "\"OverflowError: the result is too small/large to store in a 4-byte signed-integer.\\n\"";
            int size = errorMessage.length() - 3;
            errorMsgs[Util.OVERFLOW_ERROR] = instructions.getNumberOfMessage();
            instructions.getMessageGenerator().generatePrintErrorMessage(
                    instructions, size, errorMessage);

            Label overflowLabel = new Label("p_throw_overflow_error");
            instructions.add(overflowLabel, instructions.getMessageGenerator().generateOverflowInstructions(
                    registers, instructions, errorMsgs[Util.OVERFLOW_ERROR]));
        }

        return instructions;
    }

    private static AssemblyCode generateDivideByZeroError(AssemblyCode instructions, Registers registers) {
        if (errorMsgs[Util.DIVIDE_ZERO_ERROR] == null) {
            String errorMessage = "\"DivideByZeroError: divide or modulo by zero\\n\\0\"";
            int size = errorMessage.length() - 3;
            errorMsgs[Util.DIVIDE_ZERO_ERROR] = instructions.getNumberOfMessage();
            instructions.getMessageGenerator().generatePrintErrorMessage(
                    instructions, size, errorMessage);

            Label checkDivideByZero = new Label("p_check_divide_by_zero");
            instructions.add(checkDivideByZero, instructions.getMessageGenerator().generateDivideByZeroInstructions(
                    registers, instructions, errorMsgs[Util.DIVIDE_ZERO_ERROR]
            ));

        }
        return instructions;
    }

    private static AssemblyCode generateArrayError(AssemblyCode instructions, Registers registers) {
        if (errorMsgs[Util.ARRAY_NEG_INDEX_ERROR] == null && errorMsgs[Util.ARRAY_OUT_BOUND_ERROR] == null) {
            errorMsgs[Util.ARRAY_NEG_INDEX_ERROR] = instructions.getNumberOfMessage();
            errorMsgs[Util.ARRAY_OUT_BOUND_ERROR] = instructions.getNumberOfMessage() + 1;
            instructions = instructions.getMessageGenerator().generateArrayOutOfBoundsMessage(instructions);
            instructions.add(new Label("p_check_array_bounds"), instructions.getMessageGenerator().generateCheckArrayBoundsInstructions(
                    instructions, registers, errorMsgs[Util.ARRAY_NEG_INDEX_ERROR], errorMsgs[Util.ARRAY_OUT_BOUND_ERROR]));
        }
        return instructions;
    }

    private static AssemblyCode generateNullRefError(AssemblyCode instructions, Registers registers) {
        if (errorMsgs[Util.NULL_REF_ERROR] == null) {
            errorMsgs[Util.NULL_REF_ERROR] = instructions.getNumberOfMessage();
            String errorMessage = "\"NullReferenceError: dereference a null reference.\\n\\0\"";
            instructions.getMessageGenerator().generatePrintErrorMessage(
                    instructions, errorMessage.length() - 2 * 2 - 1, errorMessage);
            instructions.getMessageGenerator().generateNullPointerInstructions(registers, instructions, errorMsgs[Util.NULL_REF_ERROR]);
        }
        return instructions;
    }


}
