package backEnd.instructions.binaryOp;

import backEnd.RegisterARM;

public class SMULL {
    /*
      Multiplying signed long
     */

    private RegisterARM dst1;
    private RegisterARM dst2;
    private RegisterARM src1;
    private RegisterARM src2;

    public SMULL(RegisterARM dst1, RegisterARM dst2, RegisterARM src1, RegisterARM src2) {
        this.dst1 = dst1;
        this.dst2 = dst2;
        this.src1 = src1;
        this.src2 = src2;
    }

    @Override
    public String toString(){
        return ("SMULL " + dst1 + ", " + dst2 + ", " + src1 + ", " + src2 + "\n");
    }




}
