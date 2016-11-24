package backEnd.instructions.binaryOp;

import backEnd.RegisterARM;

public class MOVEQ extends MOV {

    public MOVEQ(RegisterARM dst, int immNum) {
        super(dst, immNum);
    }

    @Override
    public String toString(){
        return ("\t\tMOVEQ " + dst + ", #" + immNum + "\n");
    }
}
