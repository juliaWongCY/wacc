package backEnd.instructions;

import backEnd.RegisterARM;

public class CMP extends Instruction {

    private RegisterARM dst;
    private RegisterARM src;
    private int constant;

    public CMP(RegisterARM dst, RegisterARM src) {
        this.dst = dst;
        this.src = src;
    }

    public CMP(RegisterARM dst, int constant) {
        this.dst = dst;
        this.constant = constant;
    }

    @Override
    public String toString(){
        if(src != null) {
            return ("CMP " + dst + ", " + src + "\n");
        }
        return ("CMP " + dst + ", " + constant + "\n");
    }
}
