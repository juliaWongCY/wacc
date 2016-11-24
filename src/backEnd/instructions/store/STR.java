package backEnd.instructions.store;

import backEnd.RegisterARM;
import backEnd.general.Label;
import backEnd.instructions.Instruction;

public class STR extends Instruction{

    protected RegisterARM dst;
    protected RegisterARM src;
    protected Label label;
    protected int constant;
    protected int offset;
    protected boolean writeAddress;
    protected String string;

    public STR(RegisterARM dst, RegisterARM src) {
        this.dst = dst;
        this.src = src;
    }

    public STR(RegisterARM dst, RegisterARM src, int constant) {
        this.dst = dst;
        this.src = src;
        this.constant = constant;
    }

    public STR(RegisterARM dst, RegisterARM src, int offset, boolean writeAddress, String string) {
        this.dst = dst;
        this.src = src;
        this.offset = offset;
        this.writeAddress = writeAddress;
        this.string = string;

    }

    @Override
    public String toString() {
        if (writeAddress) {
            return "\t\tSTR" + string + " " + dst + ", [" + src + ", #" + offset + "]!\n";
        }
        if (constant > 0) {
            //eg. LDR r1, [sp, #12] to move the stack pointer
            return ("\t\tSTR " + dst + ", [" + src + ", #" + constant + "]\n");
        }
        //eg. LDR r1, [r4]
        return ("\t\tSTR " + dst + ", [" + src + "]\n");
    }
}