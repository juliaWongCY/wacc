package backEnd;

import type.*;

public class Util {

    public static final int NUMBER_OF_TYPE = 6;
    public static final int EMPTY_TYPE     = -1;
    public static final int INT_TYPE       = 0;
    public static final int BOOL_TYPE      = 1;
    public static final int CHAR_TYPE      = 2;
    public static final int STRING_TYPE    = 3;
    public static final int ARRAY_TYPE     = 4;
    public static final int PAIR_TYPE      = 5;

    public static final int NUMBER_OF_ERROR   = 4;
    public static final int RUNTIME_ERROR     = 0;
    public static final int OVERFLOW_ERROR    = 1;
    public static final int DIVIDE_ZERO_ERROR = 2;
    public static final int NULL_REF_ERROR    = 3;

    public static int convertTypeToIndicator(Type type) {
        if (type instanceof IntType) {
            return INT_TYPE;
        }
        if (type instanceof BoolType) {
            return BOOL_TYPE;
        }
        if (type instanceof CharType) {
            return CHAR_TYPE;
        }
        if (type instanceof StringType) {
            return STRING_TYPE;
        }
        if (type instanceof ArrayType) {
            if (((ArrayType) type).getElemType() instanceof  CharType) {
                return STRING_TYPE;
            }
            return ARRAY_TYPE;
        }
        if (type instanceof PairType) {
            return PAIR_TYPE;
        }
        if (type instanceof FunctionType) {
            return convertTypeToIndicator(((FunctionType) type).getReturnType());
        }
        System.err.println("unrecognised type");
        return -1;
    }

    public static int getTypeSize(int typeIndicator) {
        if (typeIndicator == BOOL_TYPE || typeIndicator == CHAR_TYPE) {
            return 1;
        } else if (typeIndicator == EMPTY_TYPE) {
            return 0;
        } else {
            return 4;
        }
    }

    public static int getTypeSize(Type type) {
        return getTypeSize(convertTypeToIndicator(type));
    }

    public static String getBaseTypeString(int typeIndicator) {
        switch (typeIndicator) {
            case BOOL_TYPE:
                return "bool";
            case INT_TYPE:
                return "int";
            case CHAR_TYPE:
                return "char";
            case STRING_TYPE:
                return "string";
            default:
                return "error";
        }
    }

}
