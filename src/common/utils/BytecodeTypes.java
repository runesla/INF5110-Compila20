package common.utils;

import bytecode.instructions.*;
import bytecode.type.*;
import common.error.CodeGenException;
import syntaxtree.types.DataType;
import syntaxtree.types.operators.ArithOpr;
import syntaxtree.types.operators.LogOpr;
import syntaxtree.types.operators.RelOpr;

public class BytecodeTypes {

    public static CodeType getCodeType(DataType dataType) throws CodeGenException {

        switch (dataType.getType()) {
            case INT:
                return IntType.TYPE;
            case FLOAT:
                return BoolType.TYPE;
            case STRING:
                return StringType.TYPE;
            case VOID:
                return VoidType.TYPE;
            default:
                throw new CodeGenException("Could not determine return type");
        }
    }

    public static Instruction getArithmeticOperator(String operator) throws CodeGenException {

        switch (ArithOpr.getOpr(operator)) {
            case ADDOP:
                return new ADD();
            case SUBOP:
                return new SUB();
            case MULOP:
                return new MUL();
            case DIVOP:
                return new DIV();
            case EXP:
                return  new EXP();
            default:
                throw new CodeGenException("Could not determine arithmetic operator type");
        }
    }

    public static Instruction getLogicalOperator(String operator) throws CodeGenException {

        switch (LogOpr.getOpr(operator)) {
            case LOG_AND:
                return new AND();
            case LOG_OR:
                return new OR();
            default:
                throw new CodeGenException("Could not determine logical operator type");
        }
    }

    public static Instruction getRelationalOperator(String operator) throws CodeGenException {

        switch (RelOpr.getOpr(operator)) {
            case EQ:
                return new EQ();
            case LT:
                return new LT();
            case GT:
                return new GT();
            case LTEQUAL:
                return new LTEQ();
            case GTEQUAL:
                return new GTEQ();
            case NEQUAL:
                return new NEQ();
            default:
                throw new CodeGenException("Could not determine relational operator type");
        }
    }
}
