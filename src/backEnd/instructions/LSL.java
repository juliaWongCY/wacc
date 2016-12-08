package backEnd.instructions;

public class LSL extends Instruction {

    private int shiftNum;

    public LSL(int shiftNum) {
        this.shiftNum = shiftNum;
    }

    @Override
    public String toString() {
        return "LSL #" + shiftNum + "\n";
    }

}
