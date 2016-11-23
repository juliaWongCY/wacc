package backEnd;

import backEnd.general.Header;
import backEnd.general.Label;
import backEnd.instructions.Instruction;
import backEnd.symbolTable.Value;
import backEnd.symbolTable.VarSymbolTable;

import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;


public class AssemblyCode {

    HashMap<Label, List<Instruction>> instructionsPerLabel = new LinkedHashMap<Label, List<Instruction>>();
    private VarSymbolTable varSymbolTable = new VarSymbolTable();
    private int numberOfMessage = 0;
    private Label currentLabel = new Label("main");
    private int currentStackPtrPos = 0;
    private int newLabels = 0;
    private MessageGenerator messageGenerator = new MessageGenerator();



    public List<AssemblyLine> toList() {

        List<AssemblyLine> assemblyCode = new ArrayList<>();
        List<AssemblyLine> allMessages = new ArrayList<>();

        Iterator<Entry<Label, List<Instruction>>> iter = instructionsPerLabel.entrySet().iterator();

        while (iter.hasNext()) {
            Map.Entry<Label, List<Instruction>> entry = iter.next();
            if (entry.getKey().equals(new Header(".data"))) {
                allMessages.add(0, entry.getKey());
            } else if (entry.getKey().isMessage()) {
                allMessages.add(entry.getKey());
                if (entry.getValue() != null) {
                    allMessages.addAll(entry.getValue());
                }
            } else {
                assemblyCode.add(entry.getKey());
                if (entry.getValue() != null) {
                    assemblyCode.addAll(entry.getValue());
                }
            }
        }

        allMessages.addAll(assemblyCode);

        return allMessages;

    }

    public void add(Label label, List<Instruction> instructions) {

        if (!hasThatLabel(label, instructions)) {
            instructionsPerLabel.put(label, instructions);
        }

        if (label.isMessage()) {
            numberOfMessage++;
        }

    }

    public void add(List<Instruction> instructions) {
        instructionsPerLabel.put(getCurrentLabel(), instructions);

        // redundant?
        if (currentLabel.isMessage()) {
            numberOfMessage++;
        }
    }


    private boolean hasThatLabel(Label label, List<Instruction> instructions) {
        Iterator<Entry<Label, List<Instruction>>> entryIterator = instructionsPerLabel.entrySet().iterator();

        while (entryIterator.hasNext()) {
            Map.Entry<Label, List<Instruction>> entry = entryIterator.next();
            if (entry.getKey().equals(new Label(label.getName()))) {
               if (entry.getValue() != null) {
                   List<Instruction> storedInstructions = entry.getValue();
                   storedInstructions.addAll(instructions);
                   instructionsPerLabel.put(entry.getKey(), storedInstructions);
               }
               return true;
            }

        }

        return false;
    }



    public VarSymbolTable getVarSymbolTable() {
        return varSymbolTable;
    }

    public int getVarSymbolTableLocalSize() {
        return varSymbolTable.getVarLocalSize();
    }


    public int getNumberOfMessage() {
        return numberOfMessage;
    }

    public void returnMainLabel() {
        currentLabel = new Label("main");
    }

    public Label getCurrentLabel() {
        return currentLabel;
    }

    public MessageGenerator getMessageGenerator() {
        return messageGenerator;
    }

    public int getCurrentStackPtrPos(){
        return currentStackPtrPos;
    }

    public void setCurrentStackPtrPos(int currentStackPtrPos) {
        this.currentStackPtrPos = currentStackPtrPos;
    }

    public String getNextLabel() {
        return "L" + newLabels;
    }

    public void updateCurrentLabel() {
        currentLabel = new Label("L" + newLabels);
        newLabels++;
    }

    public void setCurrentLabel(Label label) {
        currentLabel = label;
    }

    public Value lookUpVar(String var){
        return varSymbolTable.getVariable(var);
    }
    public int getPositionInStack(String var) {
        int variablePos = lookUpVar(var).getLocationInStack();
        return variablePos - getCurrentStackPtrPos();
    }


}
