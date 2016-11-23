package backEnd.instructions;

import backEnd.RegisterARM;

public class CMP extends Instruction {

    private RegisterARM dst;
    private RegisterARM src;
    private String string;
    private int constant;

    public CMP(RegisterARM dst, RegisterARM src) {
        this.dst = dst;
        this.src = src;
    }

    public CMP(RegisterARM dst, int constant) {
        this.dst = dst;
        this.constant = constant;
    }

    public CMP(RegisterARM dst, RegisterARM src, String string, int constant) {
        this.dst = dst;
        this.src = src;
        this.string = string;
        this.constant = constant;
    }

    @Override
    public String toString(){
        if(src != null) {
            if (string != null) {
                return ("CMP" + dst + ", " + src + ", " + string + " #" + constant + "\n");
            }
            return ("CMP " + dst + ", " + src + "\n");
        }
        return ("CMP " + dst + ", " + constant + "\n");
    }
}
