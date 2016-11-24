package backEnd.instructions.load;

import backEnd.RegisterARM;
import backEnd.general.Label;
import backEnd.instructions.Instruction;

public class LDR extends Instruction {

    protected RegisterARM dst;
    protected RegisterARM src;
    protected Label label;
    protected Integer constant;

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

    public LDR(RegisterARM dst, RegisterARM src, Integer constant) {
        this.dst = dst;
        this.src = src;
        this.constant = constant;
    }

    //TODO: Check LDR if there's missing cases
    @Override
    public String toString(){
        if(src != null){
            if(constant != null){
                //eg. LDR r1, [sp, #12] to move the stack pointer
                return ("\t\tLDR " + dst + ", [" + src + ", #" + constant + "]\n" );
            }
            //eg. LDR r1, [r4]
            return ("\t\tLDR " + dst + ", [" + src + "]\n" );
        }

        if(label != null){
            // eg. LDR r1, =msg_1
            return ("\t\tLDR " + dst + ", =" + label.getName() + "\n" );
        } else {
            //eg. LDR r1, =0
            return ("\t\tLDR " + dst + ", =" + constant + "\n");
        }
    }
}
