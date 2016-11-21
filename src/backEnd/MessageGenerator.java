package backEnd;

import backEnd.General.Label;
import type.Type;

public class MessageGenerator {

    public AssemblyCode generatePrintTypeMessage(Type type, AssemblyCode instructions) {
        String typeInString = type.getTypeInString();
        switch(typeInString) {
            case "int": return generateIntTypeMessage(instructions);
        }

        return null;
    }

    public AssemblyCode generateIntTypeMessage(AssemblyCode originalInstructions) {
        originalInstructions.add(new Label("msg_" + originalInstructions.getNumberOfMessage()),
                null);

        return null;
    }

}
