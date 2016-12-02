package backEnd;

import java.util.ArrayList;
import java.util.List;

public class Registers {

    //For param, we will put on the stack??`


    RegisterARM armReg;
    List<RegisterARM> regInUsed = new ArrayList<RegisterARM>();

//    public Registers(RegisterARM armReg) {
//        this.armReg = armReg;
//    }


    public RegisterARM getStackPtrReg(){
        return RegisterARM.SP;
    }

    public RegisterARM getLinkReg(){
        return RegisterARM.LR;
    }

    public RegisterARM getPCReg(){
        return RegisterARM.PC;
    }

    //Return register
    public RegisterARM getR0Reg() { return RegisterARM.R0; }

    //Param register
    public RegisterARM getR1Reg() {
        return RegisterARM.R1;
    }

    public RegisterARM getPreviousReg(RegisterARM reg) {
        return RegisterARM.values()[reg.ordinal() - 1];
    }

    public RegisterARM getLastUsedReg() {
        return regInUsed.get(regInUsed.size() - 1);
    }

    public RegisterARM getNextAvailableVariableReg() {
        if (regInUsed.contains(RegisterARM.R4)) {
            return getNextAvailableReg();
        }

        return RegisterARM.R4;
    }

    public RegisterARM getNextAvailableReg() {
        RegisterARM lastUsedReg = regInUsed.get(regInUsed.size() - 1);
        RegisterARM nextReg = getNextReg(lastUsedReg);
        return nextReg;
    }

    public RegisterARM getNextReg(RegisterARM reg) {
        if (reg == RegisterARM.R10) {
            return reg;
        }
        return RegisterARM.values()[reg.ordinal() + 1];
    }

//    public void addRegInUsedList(RegisterARM reg){
//        regInUsed.add(reg);
//    }

    public Registers addRegInUsedList(RegisterARM reg){
        regInUsed.add(reg);
        return this;
    }

    public void setRegNotInUse(RegisterARM reg) {
        regInUsed.remove(reg);
    }

    public void popRegInUsedList(){
        regInUsed.remove(regInUsed.size() - 1);
    }

    public void clearRegInUsed(){
        regInUsed.clear();
    }

    public static void saveReg(){

    }

    public static void restoreReg(){

    }



}
