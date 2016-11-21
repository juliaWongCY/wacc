package backEnd;

import backEnd.general.Label;
import backEnd.instructions.Instruction;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class AssemblyCode {

    HashMap<Label, List<Instruction>> instructionsPerLabel = new LinkedHashMap<Label, List<Instruction>>();
    private int numberOfMessage = 0;
    private Label currentLabel = new Label("main");

    private MessageGenerator messageGenerator = new MessageGenerator();

    public List<AssemblyLine> toList() {

        return null;

    }

    public void add(Label label, List<Instruction> instructions) {
        instructionsPerLabel.put(label, instructions);

        if (label.isMessage()) {
            numberOfMessage++;
        }

    }

    public int getNumberOfMessage() {
        return numberOfMessage;
    }


}
