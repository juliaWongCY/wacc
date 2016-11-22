package backEnd.instructions.load;

import backEnd.RegisterARM;
import backEnd.general.Label;

public class LDRNE extends LDR {

    public LDRNE(RegisterARM dst, Label label) {
        super(dst, label);
    }

    @Override
    public String toString(){
        return ("LDRNE " + dst + ", =" + label.getName() + "\n" );
    }
}
