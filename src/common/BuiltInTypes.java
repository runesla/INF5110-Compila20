package common;

import syntaxtree.DataType;
import syntaxtree.Type;

public enum BuiltInTypes {

    INT {
        public DataType get() { return new DataType(new Type("int")); }
        },
    FLOAT {
        public DataType get() {
            return new DataType(new Type("float"));
        }
        },
    BOOL {
        public DataType get() {
            return new DataType(new Type("bool"));
        }
        },
    STRING {
        public DataType get() {
            return new DataType(new Type("string"));
        }
    }
}
