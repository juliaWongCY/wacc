package backEnd.instructions.branch;

public class BLCS extends BL {

    public BLCS(String string) {
        super(string);
    }

    @Override
    public String toString() {
        return "\t\tBLCS " + string + "\n";
    }

}
