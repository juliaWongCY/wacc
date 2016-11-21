package backEnd.instructions.binaryOp;

import backEnd.RegisterARM;
import backEnd.instructions.Instruction;

public class MOV extends Instruction {

    protected RegisterARM dst;
    protected RegisterARM src;

    protected int immNum;

    public MOV(RegisterARM dst, RegisterARM src) {
        this.dst = dst;
        this.src = src;
    }

    public MOV(RegisterARM dst, int immNum) {
        this.dst = dst;
        this.immNum = immNum;
    }


    @Override
    public String toString(){
        if(src != null){
            return ("MOV " + dst + ", " + src + "\n");
        } else {
            return ("MOV " + dst + ", #" + immNum + "\n");
        }
    }
}
