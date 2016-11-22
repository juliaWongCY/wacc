package backEnd.instructions.load;

import backEnd.RegisterARM;
import backEnd.general.Label;

public class LDRLE extends LDR {

    public LDRLE(RegisterARM dst, Label label) {
        super(dst, label);
    }

    @Override
    public String toString(){
        return ("LDRLE " + dst + ", =" + label.getName() + "\n" );
    }
}
