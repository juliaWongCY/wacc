package backEnd.instructions.branch;


public class BLNE extends BL {

    public BLNE(String string) {
        super(string);
    }

    @Override
    public String toString(){
        return ("\t\tBLNE " + string + "\n");
    }

}
