package backEnd.instructions.branch;

public class BLLT extends BL {

     public BLLT(String string) {
         super(string);
     }

     @Override
    public String toString() {
         return "\t\tBLLT " + string + "\n";
     }

}
