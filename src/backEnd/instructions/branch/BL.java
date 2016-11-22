package backEnd.instructions.branch;

import backEnd.general.Label;

public class BL {

    protected Label label;

    public BL(Label label) {
        this.label = label;
    }

    @Override
    public String toString(){
        if(label != null){
            return ("BL " + label.getName() + "\n");
        }
        return ("BL fflush"); //TODO: check
    }
}
