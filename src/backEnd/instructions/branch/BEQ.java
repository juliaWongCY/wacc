package backEnd.instructions.branch;

public class BEQ extends BL {

    public BEQ(String string) {
        super(string);
    }

    @Override
    public String toString() {
        return "\t\tBEQ " + string + "\n";
    }
}
