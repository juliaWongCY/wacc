package backEnd.instructions.store;

import backEnd.RegisterARM;

public class STRB extends STR {

    private int offset = 0;

    public STRB(RegisterARM dst, RegisterARM src) {
        super(dst, src);
    }

    public STRB(RegisterARM dst, RegisterARM src, int offset) {
        super(dst, src);
        this.offset = offset;
    }

    @Override
    public String toString() {
        if (offset > 0) {
            return ("\t\tSTRB " + dst + ", [" + src + ", #" + offset + "]\n");
        }
        return ("\t\tSTRB " + dst + ", [" + src + "]\n");
    }

}
