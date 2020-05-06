package syntaxtree.types;

import syntaxtree.Name;

public enum Type {
/*
    public static final String primitiveInteger = "int";
    public static final String primitiveFloat = "float";
    public static final String primitiveBool = "bool";
    public static final String primitiveString = "string";
    public static final String primitiveRecord = "struct";
*/

/*      // TODO: nope no no nope. methods not accessible
    INT {
        public DataType get() {
            return new DataType(new Name("int"));
        }
    },
    FLOAT {
            return new DataType(new Name("float"));
    },
    BOOL {
        return new DataType(new Name("bool"));
    },
    STRING {
        return new DataType(new Name("string"));
    }
 */
    // TODO: apparently, this works. Verify that it does the right job
    INT("int"),
    FLOAT("float"),
    STRING("string"),
    BOOL("bool"),
    STRUCT("struct");

    private final Name name;

    Type(String name) {
        this.name = new Name(name);
    }

    public Name getName() {
        return this.name;
    }
}
