package backEnd.instructions;

import backEnd.RegisterARM;

public class ADD extends Instruction {
    /*ADD is mainly used to increment the stack pointer*/

    private RegisterARM dst;
    private RegisterARM src;
    private RegisterARM src2;
    private int shiftAmount;
    private LSL shiftInstruction;

    public ADD(RegisterARM dst, RegisterARM src, int shiftAmount) {
        this.dst = dst;
        this.src = src;
        this.shiftAmount = shiftAmount;
    }

    public ADD(RegisterARM dst, RegisterARM src, RegisterARM src2, LSL shiftInstruction) {
        this.dst = dst;
        this.src = src;
        this.src2 = src2;
        this.shiftInstruction = shiftInstruction;
    }

    @Override
    public String toString(){
        if (shiftInstruction != null) {
            return "ADD " + dst + ", " + src + ", " + src2 + ", " + shiftInstruction;
        }
        return ("ADD " + dst + ", " + src + ", #" + shiftAmount + "\n");
    }
}
