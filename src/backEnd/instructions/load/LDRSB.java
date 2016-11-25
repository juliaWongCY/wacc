package backEnd.instructions.load;

import backEnd.RegisterARM;
import backEnd.general.Label;

public class LDRSB extends LDR {

    public LDRSB(RegisterARM dst, Label label) {
        super(dst, label);
    }

    public LDRSB(RegisterARM dst, RegisterARM src, int constant) {
        super(dst, src, constant);
    }

    @Override
    public String toString() {
        if (src == null) {
            return ("\t\tLDRSB " + dst + ", =" + label.getName() + "\n");
        }
        if (constant > 0) {
            return ("\t\tLDRSB " + dst + ", [" + src + ", #" + constant + "]\n");
        } else {
            return ("\t\tLDRSB " + dst + ", [" + src + "]\n");
        }
    }

}
