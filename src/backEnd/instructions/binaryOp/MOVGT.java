package backEnd.instructions.binaryOp;

import backEnd.RegisterARM;

public class MOVGT extends MOV {

    public MOVGT(RegisterARM dst, int immNum) {
        super(dst, immNum);
    }

    @Override
    public String toString(){
        return ("\t\tMOVGT " + dst + ", #" + immNum + "\n");
    }
}
