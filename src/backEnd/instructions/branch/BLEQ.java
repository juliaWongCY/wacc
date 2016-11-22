package backEnd.instructions.branch;

import backEnd.general.Label;

public class BLEQ extends BL {

    public BLEQ(Label label) {
        super(label);
    }

    @Override
    public String toString(){
        return ("BLEQ " + label.getName() + "\n");
    }
}
