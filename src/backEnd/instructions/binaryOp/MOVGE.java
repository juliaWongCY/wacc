package backEnd.instructions.binaryOp;

import backEnd.RegisterARM;

public class MOVGE extends MOV {

    public MOVGE(RegisterARM dst, int immNum) {
        super(dst, immNum);
    }

    @Override
    public String toString(){
        return ("MOVGE " + dst + ", #" + immNum + "\n");
    }
}
