package backEnd.instructions.branch;

import backEnd.general.Label;
import backEnd.instructions.Instruction;

public class BL extends Instruction {

    //protected Label label;
    protected String string;

//    public BL(Label label) {
//        this.label = label;
//    }

    public BL(String string) {
        this.string = string;
    }

//    @Override
//    public String toString(){
//        if(label != null){
//            return ("BL " + label.getName() + "\n");
//        }
//        return ("BL fflush"); //TODO: check
//    }

    public String toString() {
        return ("BL " + string + "" + "\n");
    }

}
