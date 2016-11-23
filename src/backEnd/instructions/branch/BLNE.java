package backEnd.instructions.branch;


public class BLNE extends BL {

    public BLNE(String string) {
        super(string);
    }

    @Override
    public String toString(){
//        return ("BLNE " + label.getName() + "\n");
        return ("BLNE " + string + "\n");
    }

}
