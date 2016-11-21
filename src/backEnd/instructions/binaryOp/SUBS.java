package backEnd.instructions.binaryOp;

import backEnd.RegisterARM;
import backEnd.instructions.Instruction;

public class SUBS extends Instruction {
    /* SUBS is used for arithmetic subtraction.
       We need to check fo integer underflow.
     */

    private RegisterARM dst;
    private RegisterARM src1;
    private RegisterARM src2;

    public SUBS(RegisterARM dst, RegisterARM src1, RegisterARM src2) {
        this.dst = dst;
        this.src1 = src1;
        this.src2 = src2;
    }

    @Override
    public String toString(){
        return ("SUBS " + dst + ", " + src1 + ", " + src2 + "\n");
    }
}
