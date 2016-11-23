package backEnd.instructions.branch;


public class BLVS extends BL {

    public BLVS(String string) {
        super(string);
    }

    @Override
    public String toString(){
//        return ("BLVS " + label.getName() + "\n");
        return ("BLVS " + string + "\n");
    }

}
