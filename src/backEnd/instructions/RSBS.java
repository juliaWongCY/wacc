package backEnd.instructions;

import backEnd.RegisterARM;

public class RSBS extends Instruction {

    private RegisterARM dst;
    private RegisterARM src;
    private int constant;

    public RSBS(RegisterARM dst, RegisterARM src, int constant) {
        this.dst = dst;
        this.src = src;
        this.constant = constant;
    }

    @Override
    public String toString() {
        return "RSBS" + dst + ", " + src + ", #" + constant + "\n";
    }

}
