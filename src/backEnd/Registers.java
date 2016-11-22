package backEnd;

import java.util.ArrayList;
import java.util.List;

public class Registers {

    //For param, we will put on the stack??`


    RegisterARM armReg;
    List<RegisterARM> regInUsed = new ArrayList<>();

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

    public RegisterARM getR0Reg() { return RegisterARM.R0; }

    public RegisterARM getAvailaleVariableReg() {
        if (regInUsed.contains(RegisterARM.R4)) {
            return getNextAvailableReg();
        }

        return RegisterARM.R4;
    }

    public RegisterARM getNextAvailableReg() {
        RegisterARM lastUsedReg = regInUsed.get(regInUsed.size() - 1);
        return getNextReg(lastUsedReg);
    }

    public RegisterARM getNextReg(RegisterARM reg) {
        if (reg == RegisterARM.R10) {
            return reg;
        }
        return RegisterARM.values()[reg.ordinal() + 1];
    }

    public void addRegInUsedList(RegisterARM reg){
        regInUsed.add(reg);
    }

    public void removeRegInUsedList(RegisterARM reg){
        regInUsed.remove(reg);
    }

    public void clearRegInUsed(){
        regInUsed.clear();
    }

    public static void saveReg(){

    }

    public static void restoreReg(){

    }



}
