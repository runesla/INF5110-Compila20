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


    INT {
        @Override
        public String get() {
            return "int";
        }
    },
    FLOAT {
        @Override
        public String get() {
            return "float";
        }
    },
    BOOL {
        @Override
        public String get() {
            return "bool";
        }
    },
    STRING {
        @Override
        public String get() {
            return "string";
        }
    };

    public abstract String get();

    /*
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

     */
}
