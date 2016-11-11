package errorHandling;

public class ErrorHandle {
    ErrorType errorType;

    public static final ErrorHandle ERRORTYPE_INCOMPATIBLE_TYPE      = new ErrorHandle(ErrorType.INCOMPATIBLE_TYPE);
    public static final ErrorHandle ERRORTYPE_UNDEFINED_VAR          = new ErrorHandle(ErrorType.UNDEFINED_VAR);
    public static final ErrorHandle ERRORTYPE_UNDEFINED_FUNC          = new ErrorHandle(ErrorType.UNDEFINED_FUNC);
    public static final ErrorHandle ERRORTYPE_INCORRECT_NUM_PARAM    = new ErrorHandle(ErrorType.INCORRECT_NUM_PARAM);
    public static final ErrorHandle ERRORTYPE_NO_RETURN_GLOBAL_SCOPE = new ErrorHandle(ErrorType.NO_RETURN_GLOBAL_SCOPE);
    public static final ErrorHandle ERRORTYPE_DUPLICATE_FUNC         = new ErrorHandle(ErrorType.DUPLICATE_FUNC);
    public static final ErrorHandle ERRORTYPE_DUPLICATE_IDENT        = new ErrorHandle(ErrorType.DUPLICATE_IDENT);
    public static final ErrorHandle ROFL                             = new ErrorHandle(ErrorType.ROFL);


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
            case UNDEFINED_FUNC:
                return "Undefined function";
            case INCORRECT_NUM_PARAM:
                return "Incorrect number of parameters ";
            case NO_RETURN_GLOBAL_SCOPE:
                return "Cannot return from the global scope ";
            case DUPLICATE_FUNC:
                return "Duplicated function name in the same scope ";
            case DUPLICATE_IDENT:
                return "Duplicated identifier name in the same scope ";
            case INTEGER_OVERFLOW:
                return "Integer is out of range ";
            case ROFL:
                return "meow meow meow ROFL";
            default:
                return "Check error again";
        }

    }
}
