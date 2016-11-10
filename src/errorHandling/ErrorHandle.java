package errorHandling;

public class ErrorHandle {
    ErrorType errorType;

    public ErrorHandle(ErrorType errorType) {
        this.errorType = errorType;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public String getErrorMsg(){
        switch (errorType){
            case INCOMPATIBLE_TYPE:
                return "Incompatible type ";
            case UNDEFINED_VAR:
                return "Undefined variable ";
            case INCORRECT_NUM_PARAM:
                return "Incorrect number of parameters ";
            case NO_RETURN_GLOBAL_SCOPE:
                return "Cannot return from the global scope ";
            case DUPLICATE_FUNC:
                return "Duplicated function name in the same scope ";
            case DUPLICATE_IDENT:
                return "Duplicated identifier name in the same scope ";
            default:
                return "Check error again";
        }

    }
}
