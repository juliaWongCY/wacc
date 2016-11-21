package backEnd.instructions;

import backEnd.RegisterARM;

public class POP {

    private RegisterARM reg;

    public POP(RegisterARM reg) {
        this.reg = reg;
    }

    @Override
    public String toString(){
        return ("POP {" + reg + "}\n");
    }



}
