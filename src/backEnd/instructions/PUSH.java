package backEnd.instructions;

import backEnd.RegisterARM;

public class PUSH {

    private RegisterARM reg;

    public PUSH(RegisterARM reg) {
        this.reg = reg;
    }

    @Override
    public String toString(){
        return ("PUSH {" + reg + "}\n");
    }

}
