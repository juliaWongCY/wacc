package backEnd;

import backEnd.general.Header;
import backEnd.general.HeaderInstr;
import backEnd.general.Label;
import backEnd.instructions.*;
import backEnd.instructions.binaryOp.ADDS;
import backEnd.instructions.binaryOp.MOV;
import backEnd.instructions.branch.BEQ;
import backEnd.instructions.branch.BL;
import backEnd.instructions.branch.BLEQ;
import backEnd.instructions.load.LDR;
import backEnd.instructions.load.LDREQ;
import backEnd.instructions.load.LDRNE;
import type.Type;

import java.util.*;

public class MessageGenerator {

    private static final String HEADER_WORD = "\t.word";


    public AssemblyCode generatePrintTypeMessage(int typeCode, AssemblyCode instructions) {
        switch(typeCode) {
            case Util.INT_TYPE:
                return generatePrintIntTypeMessage(instructions);
            case Util.BOOL_TYPE:
                return generatePrintBoolTypeMessage(instructions);
            case Util.STRING_TYPE:
                return generatePrintStringTypeMessage(instructions);
            case Util.ARRAY_TYPE:
            case Util.PAIR_TYPE:
                return generatePrintArrayPairTypeMessage(instructions);
            default:
                return instructions;
        }
    }

    public List<Instruction> printInstrTypeMessage(int typeCode, AssemblyCode instructions, Registers registers){
        switch(typeCode){
            case Util.INT_TYPE:
                return printIntInstrMessage(registers, instructions);
            case Util.BOOL_TYPE:
                return printBoolInstrMessage(registers, instructions);
            case Util.STRING_TYPE:
                return printStringInstrMessage(registers, instructions);
            case Util.ARRAY_TYPE:
            case Util.PAIR_TYPE:
                return printReferenceInstrMessage(registers, instructions);
            default:
                return null;
        }
    }





    /////////////////START OF PRINT TYPE MESSAGE FUNCTIONS//////////////////////

    ////////////////For print and println instructions/////////////////////////
    public AssemblyCode generateNewLine(AssemblyCode instructions){
        instructions.add(new Label("msg_" + instructions.getNumberOfMessage()),
                    headerMessages(HEADER_WORD, 1, "\t.ascii \"\\0\""));
        return instructions;
    }

    public List<Instruction> printIntInstrMessage(Registers registers, AssemblyCode instructions){
        List<Instruction> printInt = new ArrayList<>();

        printInt.add(new MOV(registers.getR1Reg(), registers.getR0Reg()));
        printInt.add(new LDR(registers.getR0Reg(), new Label("msg_" + (instructions.getNumberOfMessage() - 1))));

        return printInt;
    }

    public List<Instruction> printBoolInstrMessage(Registers registers, AssemblyCode instructions){
        List<Instruction> printBool = new ArrayList<>();

        printBool.add(new CMP(registers.getR0Reg(), 0));
        printBool.add(new LDRNE(registers.getR0Reg(), new Label("msg_" + (instructions.getNumberOfMessage() - 2))));
        printBool.add(new LDREQ(registers.getR0Reg(), new Label("msg_" + (instructions.getNumberOfMessage() - 1))));

        return printBool;

    }

    public List<Instruction> printStringInstrMessage(Registers registers, AssemblyCode instructions){
        List<Instruction> printString = new ArrayList<>();

        printString.add(new LDR(registers.getR1Reg(), registers.getR0Reg()));
        printString.add(new ADD(registers.getNextReg(RegisterARM.R1), registers.getR0Reg(), 4));
        printString.add(new LDR(registers.getR0Reg(), new Label("msg_" + (instructions.getNumberOfMessage() - 1))));

        return printString;

    }

    public List<Instruction> printReferenceInstrMessage(Registers registers, AssemblyCode instructions){
        List<Instruction> printRef = new ArrayList<>();

        printRef.add(new MOV(registers.getR1Reg(), registers.getR0Reg()));
        printRef.add(new LDR(registers.getR0Reg(), new Label("msg_" + (instructions.getNumberOfMessage() - 1))));

        return printRef;

    }



    ///////////////For printing header messages////////////////////////////////

    public AssemblyCode generatePrintIntTypeMessage(AssemblyCode instructions) {
        instructions.add(new Label("msg_" + instructions.getNumberOfMessage()),
                headerMessages(HEADER_WORD, 3, "\t.ascii \"%d\\0\""));

        return instructions;
    }

    public AssemblyCode generatePrintBoolTypeMessage(AssemblyCode instructions) {
        instructions.add(new Label("msg_" + instructions.getNumberOfMessage()),
                headerMessages(HEADER_WORD, 5, "\t.ascii \"true\\0\""));
        instructions.add(new Label("msg_" + instructions.getNumberOfMessage()),
                headerMessages(HEADER_WORD, 6, "\t.ascii \"false\\0\""));

        return instructions;
    }

    public AssemblyCode generatePrintStringTypeMessage(AssemblyCode instructions) {
        instructions.add(new Label("msg_" + instructions.getNumberOfMessage()),
                headerMessages(HEADER_WORD, 5, "\t.ascii \"%.*s\\0\""));

        return instructions;
    }

    public AssemblyCode generatePrintStringTypeMessage(AssemblyCode instructions,
                                                       int stringSize, String string) {
        instructions.add(new Header(".data"), null);
        instructions.add(new Label("msg_" + instructions.getNumberOfMessage()),
                headerMessages("\t.word", stringSize, "\t.ascii " + string));
        instructions.add(new Label("msg_" + instructions.getNumberOfMessage()),
                headerMessages(HEADER_WORD, 5, "\t.ascii \"%.*s" + "\\0" + "\""));

        return instructions;
    }

    public AssemblyCode generatePrintArrayPairTypeMessage(AssemblyCode instructions) {
        instructions.add(new Label("msg_" + instructions.getNumberOfMessage()),
                headerMessages(HEADER_WORD, 3, "\t.ascii \"%p\\0\""));

        return instructions;
    }





    public List<Instruction> generatePrintStringInstructions(Registers registers,
                                                             AssemblyCode instructions) {
        List<Instruction> printStringInstructions = new ArrayList<Instruction>();

        printStringInstructions.add(new LDR(registers.getR1Reg(), registers
                .getR0Reg()));
        printStringInstructions.add(new ADD(RegisterARM.R2, registers.getR0Reg(),
                4));
        printStringInstructions.add(new LDR(registers.getR0Reg(),
                new Label("msg_" + (instructions.getNumberOfMessage() - 1))));

        return printStringInstructions;
    }


    /////////////////END OF PRINT TYPE MESSAGE FUNCTIONS//////////////////////


    /////////////////START OF GENERATE INSTRUCTIONS FUNCTIONS/////////////////

    public List<Instruction> generateDivideByZeroInstructions(Registers registers, AssemblyCode instructions) {
        List<Instruction> divideByZeroInstrs = new ArrayList<Instruction>();

        divideByZeroInstrs.add(new CMP(registers.getR1Reg(), 0));
        divideByZeroInstrs.add(new LDREQ(registers.getR0Reg(), new Label(
                "msg_" + (instructions.getNumberOfMessage() - 2))));
        divideByZeroInstrs.add(new BLEQ("p_throw_runtime_error"));

        return divideByZeroInstrs;
    }


    public List<Instruction> generateRuntimeErrorInstructions(Registers registers,
                                                         AssemblyCode instructions) {
        List<Instruction> runtimeErrorInstructions = new ArrayList<Instruction>();

        runtimeErrorInstructions.add(new CMP(registers.getR0Reg(), 0));
        runtimeErrorInstructions.add(new LDREQ(registers.getR0Reg(),
                new Label("msg_" + (instructions.getNumberOfMessage() - 2))));
        runtimeErrorInstructions.add(new BEQ("p_throw_runtime_error"));

        return runtimeErrorInstructions;
    }

    public List<Instruction> generateRuntimeInstructions(Registers registers,
                                                         AssemblyCode instructions) {
        List<Instruction> runtimeInstrs = new ArrayList<Instruction>();

        runtimeInstrs.add(new BL("p_print_string"));
        runtimeInstrs.add(new MOV(registers.getR0Reg(), -1));
        runtimeInstrs.add(new BL("exit"));
        return runtimeInstrs;
    }

    public List<Instruction> generateEndPrintInstructions(
            AssemblyCode instructions, Registers registers) {
        List<Instruction> endPrintInstructions = new ArrayList<Instruction>();

        endPrintInstructions.add(new MOV(registers.getR0Reg(), 0));
        endPrintInstructions.add(new BL("fflush"));
//        endPrintInstructions.add(new BL(new Label("fflush")));
        endPrintInstructions.add(new POP(RegisterARM.PC));

        return endPrintInstructions;
    }

    public List<Instruction> generateOverflowInstructions(Registers registers,
                                                          AssemblyCode instructions) {
        List<Instruction> overflowInstructions = new ArrayList<Instruction>();

        overflowInstructions.add(new LDR(registers.getR0Reg(), new Label(
                "msg_" + (instructions.getNumberOfMessage() - 1))));
        overflowInstructions.add(new BL("p_throw_runtime_error"));

        return overflowInstructions;
    }

    public AssemblyCode generateArrayOutOfBoundsMessage(AssemblyCode instructions) {
        instructions = generatePrintStringTypeMessage(instructions, 44,
                "\"ArrayIndexOutOfBoundsError: negative index\\n\\0\"");
        instructions = generatePrintStringTypeMessage(instructions, 45,
                "\"ArrayIndexOutOfBoundsError: index too large\\n\\0\"");

        return instructions;
    }

    public List<Instruction> generateNullReferenceInstructions(Registers registers, AssemblyCode instructions) {
        List<Instruction> nullReferenceInstructions = new ArrayList<>();
        nullReferenceInstructions.add(new LDR(registers.getNextAvailableVariableReg(),
                registers.getStackPtrReg()));
        nullReferenceInstructions.add(new MOV(registers.getR0Reg(), registers.getNextAvailableVariableReg()));
        nullReferenceInstructions.add(new BL("p_free_pair"));

        return nullReferenceInstructions;
    }

    public AssemblyCode generateNullPointerInstructions(Registers registers, AssemblyCode instructions) {
        List<Instruction> nullPointerInstructions = new ArrayList<>();
        nullPointerInstructions.add(new PUSH(registers.getLinkReg()));
        nullPointerInstructions.add(new CMP(registers.getR0Reg(), 0));
        nullPointerInstructions.add(new LDREQ(registers.getR0Reg(), new Label("msg_" + (instructions.getNumberOfMessage() - 2))));
        nullPointerInstructions.add(new BLEQ("p_throw_runtime_error"));
        nullPointerInstructions.add(new POP(registers.getPCReg()));

        instructions.add(new Label("p_check_null_pointer"), nullPointerInstructions);

        instructions.add(new Label("p_throw_runtime_error"), generateRuntimeInstructions(registers, instructions));

        List<Instruction> printStringInstructions= new ArrayList<>();
        printStringInstructions.addAll(generatePrintStringInstructions(registers, instructions));
        printStringInstructions.add(new ADD(registers.getR0Reg(), registers.getR0Reg(), 4));
        printStringInstructions.add(new BL("printf"));
        printStringInstructions.addAll(generateEndPrintInstructions(instructions, registers));

        instructions.add(new Label("p_print_string"), printStringInstructions);
        return instructions;
    }

    public List<Instruction> generateEndOfFunc(Registers registers) {
        List<Instruction> instructionsToBeAdded = new ArrayList<Instruction>();
        //TODO check if right
        instructionsToBeAdded.add(new POP(registers.getPCReg()));
        instructionsToBeAdded.add(new HeaderInstr("\t.ltorg"));

        return instructionsToBeAdded;

    }

    /////////////////END OF GENERATE INSTRUCTIONS FUNCTIONS//////////////////////

    //Helper function:
    public List<Instruction> headerMessages(String word, int messageLength, String output) {
        return new ArrayList<Instruction>(Arrays.asList(
                new HeaderInstr(word, messageLength), new HeaderInstr((output))));
    }

}
