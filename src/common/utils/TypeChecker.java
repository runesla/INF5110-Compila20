package common.utils;

import syntaxtree.types.DataType;
import syntaxtree.types.Type;
import static syntaxtree.types.Type.*;

public class TypeChecker {

    public static boolean isPrimitive(Type type) {
        return type == INT || type == BOOL || type == FLOAT || type == STRING;
    }

    public static boolean isCompatibleType(DataType left, DataType right) {
        if(left.getType() == right.getType()) {
            if(left.getType() == UDT) {
                return left.getName().equals(right.getName());
            }
            return true;
        } else if(left.getType() == INT) {
            return right.getType() == FLOAT;
        } else if (left.getType() == FLOAT) {
            return right.getType() == INT;
        }
        return false;
    }
}
