package backEnd.instructions;

public abstract class Instruction {

    /*
      When the {S} is present, we updates the condition flags (N, Z, C, V)
      The N, Z, C, and V bits are the condition code flags.
      They can be set by arithmetic and logical operations, and also by MSR and LDM instructions.
      N = Negative result from ALU
      Z = Zero result from ALU
      C = ALU operation carried out
      V = ALU operations overflowed
     */

    public String toString(){
        return null;
    }

}
