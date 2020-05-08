package syntaxtree.types;

import syntaxtree.Name;

public enum Type {

    INT("int") {
        @Override
        public String get() {
            return "int";
        }
    },
    FLOAT("float") {
        @Override
        public String get() {
            return "float";
        }
    },
    BOOL("bool") {
        @Override
        public String get() {
            return "bool";
        }
    },
    STRING("string") {
        @Override
        public String get() {
            return "string";
        }
    },
    UDT(null) {
        @Override
        public String get() {
            return "UDT";
        }
    };

    private Name name;

    Type(String name) {
        if(name != null) {
            this.name = new Name(name);
        }
    }

    public Name getName() {
        return name;
    }

    public abstract String get();

}
