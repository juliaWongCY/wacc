package backEnd.instructions.load;

import backEnd.RegisterARM;
import backEnd.general.Label;

public class LDR {

    protected RegisterARM dst;
    protected RegisterARM src;
    protected Label label;
    protected int constant;

    public LDR(RegisterARM dst, RegisterARM src) {
        this.dst = dst;
        this.src = src;
    }

    public LDR(RegisterARM dst, int constant) {
        this.dst = dst;
        this.constant = constant;
    }

    public LDR(RegisterARM dst, Label label) {
        this.dst = dst;
        this.label = label;
    }

    public LDR(RegisterARM dst, RegisterARM src, int constant) {
        this.dst = dst;
        this.src = src;
        this.constant = constant;
    }

    //TODO: Check LDR if there's missing cases
    @Override
    public String toString(){
        if(src != null){
            if(constant > 0){
                //eg. LDR r1, [sp, #12] to move the stack pointer
                return ("LDR " + dst + ", [" + src + ", #" + constant + "]\n" );
            }
            //eg. LDR r1, [r4]
            return ("LDR " + dst + ", [" + src + "]\n" );
        }

        if(label != null){
            // eg. LDR r1, =msg_1
            return ("LDR " + dst + ", =" + label.getName() + "\n" );
        } else {
            //eg. LDR r1, =0
            return ("LDR " + dst + ", =" + constant + "\n");
        }
    }
}
