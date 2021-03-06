package backEnd.instructions.binaryOp;

import backEnd.RegisterARM;
import backEnd.instructions.Instruction;

public class AND extends Instruction {

    private RegisterARM dst;
    private RegisterARM src1;
    private RegisterARM src2;

    public AND(RegisterARM dst, RegisterARM src1, RegisterARM src2) {
        this.dst = dst;
        this.src1 = src1;
        this.src2 = src2;
    }

    @Override
    public String toString(){
        return ("\t\tAND " + dst + ", " + src1 + ", " + src2 + "\n");
    }
}
