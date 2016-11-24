package backEnd.instructions.store;

import backEnd.RegisterARM;

public class STRB extends STR {

    public STRB(RegisterARM dst, RegisterARM src) {
        super(dst, src);
    }

    @Override
    public String toString() {
      return ("\t\tSTRB " + dst + ", [" + src + "]\n");
    }

}
