package backEnd.instructions;

import backEnd.RegisterARM;

public class SUB extends Instruction {
    /* This is for decrementing the stack Pointer.*/

    private RegisterARM dst;
    private RegisterARM src;
    private int shiftAmount;

    public SUB(RegisterARM dst, RegisterARM src, int shiftAmount) {
        this.dst = dst;
        this.src = src;
        this.shiftAmount = shiftAmount;
    }


    @Override
    public String toString(){
        return ("\t\tSUB " + dst + ", " + src + ", #" + shiftAmount + "\n");
    }
}
