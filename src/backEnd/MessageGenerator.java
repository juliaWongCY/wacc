package backEnd;

import backEnd.general.HeaderInstr;
import backEnd.general.Label;
import backEnd.instructions.Instruction;
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

    public AssemblyCode generatePrintArrayPairTypeMessage(AssemblyCode instructions) {
        instructions.add(new Label("msg_" + instructions.getNumberOfMessage()),
                headerMessages(HEADER_WORD, 3, "\"%p\0\""));

        return instructions;
    }

    /////////////////END OF PRINT TYPE MESSAGE FUNCTIONS//////////////////////

    //Helper function:
    public List<Instruction> headerMessages(String word, int messageLength, String output) {
        return new ArrayList<Instruction>(Arrays.asList(
                new HeaderInstr(word, messageLength), new HeaderInstr((output))));
    }

}
