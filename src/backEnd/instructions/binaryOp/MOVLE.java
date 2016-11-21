package backEnd.instructions.binaryOp;

import backEnd.RegisterARM;

public class MOVLE extends MOV {

    public MOVLE(RegisterARM dst, int immNum) {
        super(dst, immNum);
    }

    @Override
    public String toString(){
        return ("MOVLE " + dst + ", #" + immNum + "\n");
    }
}
