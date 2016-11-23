package backEnd.general;

import backEnd.AssemblyLine;

public class Label extends AssemblyLine {

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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Label) {
            return ((Label) obj).getName().equals(this.getName());
        }

        return false;
    }
}
