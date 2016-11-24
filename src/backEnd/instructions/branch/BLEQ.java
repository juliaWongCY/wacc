package backEnd.instructions.branch;

import backEnd.general.Label;

public class BLEQ extends BL {

    public BLEQ(String string) {
        super(string);
    }

    @Override
    public String toString(){
        return ("\t\tBLEQ " + string + "\n");
    }
}
