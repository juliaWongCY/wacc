package backEnd.instructions.binaryOp;

import backEnd.RegisterARM;
import backEnd.instructions.Instruction;

public class EOR extends Instruction {
    private RegisterARM dst;
    private int constant;

    public EOR (RegisterARM dst, int constant) {
        this.dst = dst;
        this.constant = constant;
    }

    @Override
    public String toString(){
        return ("\t\tEOR " + dst + ", " + dst + ", #" + constant + "\n");
    }
}

