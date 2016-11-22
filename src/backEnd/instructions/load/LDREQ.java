package backEnd.instructions.load;

import backEnd.RegisterARM;
import backEnd.general.Label;

public class LDREQ extends LDR {

    public LDREQ(RegisterARM dst, Label label) {
        super(dst, label);
    }

    @Override
    public String toString(){
        return ("LDREQ " + dst + ", =" + label.getName() + "\n" );
    }
}
