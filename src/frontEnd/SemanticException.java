package frontEnd;

public class SemanticException extends Exception {

    public SemanticException() {
        super();
    }

    public SemanticException(String message) {
        super(message);
    }

    private enum {
        REF, UNDEF
    }

}
