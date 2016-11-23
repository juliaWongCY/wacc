package backEnd.instructions.branch;

import backEnd.general.Label;

public class BLEQ extends BL {

//    public BLEQ(Label label) {
//        super(label);
//    }

    public BLEQ(String string) {
        super(string);
    }

    @Override
    public String toString(){
//        return ("BLEQ " + label.getName() + "\n");
        return ("BLEQ " + string + "\n");
    }
}
