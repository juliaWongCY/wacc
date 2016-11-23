package backEnd;

import backEnd.general.Header;
import backEnd.general.HeaderInstr;
import backEnd.general.Label;
import backEnd.instructions.ADD;
import backEnd.instructions.CMP;
import backEnd.instructions.Instruction;
import backEnd.instructions.POP;
import backEnd.instructions.binaryOp.MOV;
import backEnd.instructions.branch.BL;
import backEnd.instructions.branch.BLEQ;
import backEnd.instructions.load.LDR;
import backEnd.instructions.load.LDREQ;
import type.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MessageGenerator {

    private static final String HEADER_WORD = ".word";

    public AssemblyCode generatePrintTypeMessage(Type type, AssemblyCode instructions) {
        String typeInString = type.getTypeInString();
        switch(typeInString) {
            case "int":
                return generatePrintIntTypeMessage(instructions);
            case "bool":
                return generatePrintBoolTypeMessage(instructions);
            case "string":
                return generatePrintStringTypeMessage(instructions);
            case "array":
            case "pair":
                return generatePrintArrayPairTypeMessage(instructions);
            default:
                return instructions;
        }
    }




    /////////////////START OF PRINT TYPE MESSAGE FUNCTIONS//////////////////////

    public AssemblyCode generatePrintIntTypeMessage(AssemblyCode instructions) {
        instructions.add(new Label("msg_" + instructions.getNumberOfMessage()),
                headerMessages(HEADER_WORD, 3, ".ascii \"%d\0\""));

        return instructions;
    }

    public AssemblyCode generatePrintBoolTypeMessage(AssemblyCode instructions) {
        instructions.add(new Label("msg_" + instructions.getNumberOfMessage()),
                headerMessages(HEADER_WORD, 5, ".ascii \"true\0\""));
        instructions.add(new Label("msg_" + instructions.getNumberOfMessage()),
                headerMessages(HEADER_WORD, 6, ".ascii \"false\0\""));

        return instructions;
    }

    public AssemblyCode generatePrintStringTypeMessage(AssemblyCode instructions) {
        instructions.add(new Label("msg_" + instructions.getNumberOfMessage()),
                headerMessages(HEADER_WORD, 5, ".ascii \"%.*s\0\""));

        return instructions;
    }

    public AssemblyCode generatePrintStringTypeMessage(AssemblyCode instructions,
                                                       int stringSize, String string) {
        instructions.add(new Header(".data"), null);
        instructions.add(new Label("msg_" + instructions.getNumberOfMessage()),
                headerMessages("\t.word", stringSize, "\t.ascii " + string));
        instructions.add(new Label("msg_" + instructions.getNumberOfMessage()),
                headerMessages(HEADER_WORD, 5, ".ascii \"%.*s\0\""));

        return instructions;
    }

    public AssemblyCode generatePrintArrayPairTypeMessage(AssemblyCode instructions) {
        instructions.add(new Label("msg_" + instructions.getNumberOfMessage()),
                headerMessages(HEADER_WORD, 3, "\"%p\0\""));

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

    public List<Instruction> generateDivideByZeroInstrs(Registers registers, AssemblyCode instructions) {
        List<Instruction> divideByZeroInstrs = new ArrayList<Instruction>();

        divideByZeroInstrs.add(new CMP(registers.getR1Reg(), 0));
        divideByZeroInstrs.add(new LDREQ(registers.getR0Reg(), new Label(
                "msg_" + (instructions.getNumberOfMessage() - 2))));
//        divideByZeroInstrs.add(new BLEQ(new Label("p_throw_runtime_error")));
        divideByZeroInstrs.add(new BLEQ("p_throw_runtime_error"));

        return divideByZeroInstrs;
    }


    public List<Instruction> generateRuntimeInstrs(Registers registers,
                                                   AssemblyCode instructions) {
        List<Instruction> runtimeInstrs = new ArrayList<Instruction>();

        runtimeInstrs.add(new BL("p_print_string"));
//        runtimeInstrs.add(new BL(new Label("p_print_string")));
        runtimeInstrs.add(new MOV(registers.getR0Reg(), -1));
        runtimeInstrs.add(new BL("exit"));
//        runtimeInstrs.add(new BL(new Label("exit")));
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
                "\"ArrayIndexOutOfBoundsError: negative index\\n\0\"");
        instructions = generatePrintStringTypeMessage(instructions, 45,
                "\"ArrayIndexOutOfBoundsError: index too large\\n\0\"");

        return instructions;
    }

    /////////////////END OF GENERATE INSTRUCTIONS FUNCTIONS//////////////////////

    //Helper function:
    public List<Instruction> headerMessages(String word, int messageLength, String output) {
        return new ArrayList<Instruction>(Arrays.asList(
                new HeaderInstr(word, messageLength), new HeaderInstr((output))));
    }

}
