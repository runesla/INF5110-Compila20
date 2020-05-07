package syntaxtree.types;

import syntaxtree.Name;

public enum Type {

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
            return null;
        }
    };

    private Name name;

    public void Name(String name) {
        this.name = new Name(name);
    }

    public abstract String get();

    public Name getName() {
        return name;
    }

}
