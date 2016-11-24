package backEnd.instructions.branch;

import backEnd.general.Label;
import backEnd.instructions.Instruction;

public class BL extends Instruction {

    protected String string;


    public BL(String string) {
        this.string = string;
    }


    public String toString() {
        return ("\t\tBL " + string + "" + "\n");
    }

}
