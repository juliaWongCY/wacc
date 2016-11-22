package backEnd.instructions;

import backEnd.RegisterARM;

public class ADD extends Instruction {
    /*ADD is mainly used to increment the stack pointer*/

    private RegisterARM dst;
    private RegisterARM src;
    private int shiftAmount;

    public ADD(RegisterARM dst, RegisterARM src, int shiftAmount) {
        this.dst = dst;
        this.src = src;
        this.shiftAmount = shiftAmount;
    }

    @Override
    public String toString(){
        return ("ADD " + dst + ", " + src + ", #" + shiftAmount + "\n");
    }
}
