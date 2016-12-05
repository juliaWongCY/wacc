package backEnd.general;

import backEnd.instructions.Instruction;

public class HeaderInstr extends Instruction {

    private String instruction;
    private int messageLength;

    public HeaderInstr(String instruction) {
        this.instruction = instruction;
    }

    public HeaderInstr(String instruction, int messageLength) {
        this.instruction = instruction;
        this.messageLength = messageLength;
    }

    @Override
    public String toString() {
        if (messageLength > 0 || messageLength == 0 && instruction.equals("\t.word ")) {
            return "\t" + instruction + " " + messageLength + "\n";
        }
        return "\t" + instruction + "\n";
    }
}
