package backEnd;

import backEnd.general.Label;
import backEnd.instructions.Instruction;
import backEnd.symbolTable.Value;
import backEnd.symbolTable.VarSymbolTable;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class AssemblyCode {

    HashMap<Label, List<Instruction>> instructionsPerLabel = new LinkedHashMap<Label, List<Instruction>>();
    private VarSymbolTable varSymbolTable = new VarSymbolTable();
    private int numberOfMessage = 0;
    private Label currentLabel = new Label("main");
    private int currentStackPtrPos = 0;
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

    public void add(List<Instruction> instructions) {
        instructionsPerLabel.put(getCurrentLabel(), instructions);

        // redundant?
        if (currentLabel.isMessage()) {
            numberOfMessage++;
        }
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

    public Value lookUpVar(String var){
        return varSymbolTable.getVariable(var);
    }
    public int getPositionInStack(String var) {
        int variablePos = lookUpVar(var).getLocationInStack();
        return variablePos - getCurrentStackPtrPos();
    }


}
