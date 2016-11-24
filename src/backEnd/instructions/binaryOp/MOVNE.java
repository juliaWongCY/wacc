package backEnd.instructions.binaryOp;

import backEnd.RegisterARM;

public class MOVNE extends MOV{

    public MOVNE(RegisterARM dst, int immNum) {
        super(dst, immNum);
    }

    @Override
    public String toString(){
        return ("\t\tMOVNE " + dst + ", #" + immNum + "\n");
    }
}
