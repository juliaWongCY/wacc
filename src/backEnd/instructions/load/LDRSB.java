package backEnd.instructions.load;

import backEnd.RegisterARM;
import backEnd.general.Label;

public class LDRSB extends LDR {

    public LDRSB(RegisterARM dst, Label label) {
        super(dst, label);
    }

    @Override
    public String toString(){
        return ("LDRSB " + dst + ", =" + label.getName() + "\n" );
    }
}
