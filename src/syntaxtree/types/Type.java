package syntaxtree.types;

import syntaxtree.Name;

public enum Type {
/*
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
    },
    UDT {
        @Override
        public String get() {
            return "UDT";
        }
    },
    NULL {
        @Override
        public String get() {
            return "null";
        }
    };

    private Name name;

    Type(String name) {
        this.name = new Name(name);
    }

    public abstract String get();

    public Name getName() {
        return name;
    }

 */

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
        this.name = new Name(name);
    }

    public Name getName() {
        return name;
    }

    public abstract String get();

}
