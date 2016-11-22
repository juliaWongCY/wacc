package backEnd.instructions.load;

import backEnd.RegisterARM;
import backEnd.general.Label;

public class LDRGT extends LDR {

    public LDRGT(RegisterARM dst, Label label) {
        super(dst, label);
    }

    @Override
    public String toString(){
        return ("LDRGT " + dst + ", =" + label.getName() + "\n" );
    }
}
