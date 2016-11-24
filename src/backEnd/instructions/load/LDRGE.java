package backEnd.instructions.load;

import backEnd.RegisterARM;
import backEnd.general.Label;

public class LDRGE extends LDR {

    public LDRGE(RegisterARM dst, Label label) {
        super(dst, label);
    }

    @Override
    public String toString(){
        return ("\t\tLDRGE " + dst + ", =" + label.getName() + "\n" );
    }
}
