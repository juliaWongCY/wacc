package backEnd.instructions.load;

import backEnd.RegisterARM;
import backEnd.general.Label;

public class LDRLT extends LDR {

    public LDRLT(RegisterARM dst, Label label) {
        super(dst, label);
    }

    @Override
    public String toString(){
        return ("\t\tLDRLT " + dst + ", =" + label.getName() + "\n" );
    }
}
