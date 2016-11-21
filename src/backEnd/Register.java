package backEnd;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Register {


    RegisterARM armReg;
    List<RegisterARM> regInUsed = new ArrayList<>();

    public Register(RegisterARM armReg) {
        this.armReg = armReg;
    }

    public RegisterARM getArmReg() {
        return armReg;
    }

    public RegisterARM getStckPtrReg(){
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




    public static void saveReg(){

    }

    public static void restoreReg(){

    }



}
