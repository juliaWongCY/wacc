package backEnd.instructions.load;

import backEnd.RegisterARM;
import backEnd.general.Label;

public class LDRCS extends LDR{

    public LDRCS(RegisterARM dst, Label label) {
        super(dst, label);
    }

    @Override
    public String toString(){
        return ("LDRCS " + dst + ", =" + label.getName() + "\n" );
    }
}
