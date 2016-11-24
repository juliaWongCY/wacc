package backEnd.instructions.binaryOp;

import backEnd.RegisterARM;

public class MOVLT extends MOV {

    public MOVLT(RegisterARM dst, int immNum) {
        super(dst, immNum);
    }

    @Override
    public String toString(){
        return ("\t\tMOVLT " + dst + ", #" + immNum + "\n");
    }
}
