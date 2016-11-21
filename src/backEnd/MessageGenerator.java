package backEnd;

import type.Type;

public class MessageGenerator {

    public AssemblyCode generatePrintTypeMessage(Type type, AssemblyCode instructions) {
        String typeInString = type.getTypeInString();
        switch(typeInString) {
            case "int": return generateIntTypeMessage(instructions);
        }
    }

    public AssemblyCode generateIntTypeMessage(AssemblyCode instructions) {
        instructions.add;
    }

}
