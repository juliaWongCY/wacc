package backEnd.instructions.binaryOp;

import backEnd.RegisterARM;
import backEnd.instructions.Instruction;

public class MOV extends Instruction {

    protected RegisterARM dst;
    protected RegisterARM src;

    protected Integer immNum;
    protected char immChr;

    public MOV(RegisterARM dst, RegisterARM src) {
        this.dst = dst;
        this.src = src;
    }

    public MOV(RegisterARM dst, int immNum) {
        this.dst = dst;
        this.immNum = immNum;
    }

    public MOV(RegisterARM dst, char immChr) {
        this.dst = dst;
        this.immChr = immChr;
    }


    @Override
    public String toString(){
        if (src != null) {
            return ("\t\tMOV " + dst + ", " + src + "\n");
        } else if (immNum != null) {
            return ("\t\tMOV " + dst + ", #" + immNum + "\n");
        } else {
            return ("\t\tMOV " + dst + ", #\'" + immChr + "\'\n");
        }
    }
}
