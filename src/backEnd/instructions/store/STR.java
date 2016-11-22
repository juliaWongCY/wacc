package backEnd.instructions.store;

import backEnd.RegisterARM;
import backEnd.general.Label;
import backEnd.instructions.Instruction;

public class STR extends Instruction{

    protected RegisterARM dst;
    protected RegisterARM src;
    protected Label label;
    protected int constant;


    public STR(RegisterARM dst, RegisterARM src) {
        this.dst = dst;
        this.src = src;
    }

    public STR(RegisterARM dst, RegisterARM src, int constant) {
        this.dst = dst;
        this.src = src;
        this.constant = constant;
    }

    @Override
    public String toString() {
        if (constant > 0) {
            //eg. LDR r1, [sp, #12] to move the stack pointer
            return ("STR " + dst + ", [" + src + ", #" + constant + "]\n");
        }
        //eg. LDR r1, [r4]
        return ("STR " + dst + ", [" + src + "]\n");
    }
}