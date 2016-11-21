package backEnd;

import java.util.ArrayList;
import java.util.List;

public class Register {


    RegisterARM armReg;
    List<RegisterARM> regInUsed = new ArrayList<>();

    public Register(RegisterARM armReg) {
        this.armReg = armReg;
    }

    public RegisterARM getArmReg() {
        return armReg;
    }

    public RegisterARM getStackPtrReg(){
        return RegisterARM.SP;
    }

    public RegisterARM getLinkReg(){
        return RegisterARM.LR;
    }

    public RegisterARM getPCReg(){
        return RegisterARM.PC;
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
