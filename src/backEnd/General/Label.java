package backEnd.general;

public class Label {

    protected String name;

    public Label(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isMessage() {
        return name.startsWith("msg_");
    }

    @Override
    public String toString() {
        return "\t" + name + ":\n";
    }
}
