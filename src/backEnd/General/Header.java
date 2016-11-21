package backEnd.General;

public class Header extends Label {

    public Header(String header) {
        super(header);
    }

    @Override
    public String toString() {
        return "\t" + name + "\n";
    }
}
