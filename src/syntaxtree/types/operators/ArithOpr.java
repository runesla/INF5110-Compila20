package syntaxtree.types.operators;

import syntaxtree.Name;

public enum ArithOpr {


    ADDOP("+") {
        @Override
        public String get() {
            return "+";
        }
    },
    SUBOP("-") {
        @Override
        public String get() {
            return "-";
        }
    },
    MULOP("*") {
        @Override
        public String get() {
            return "*";
        }
    },
    DIVOP("/") {
        @Override
        public String get() {
            return "/";
        }
    },
    EXP("^") {
        @Override
        public String get() {
            return "^";
        }
    };

    private Name name;

    ArithOpr(String name) {
        this.name = new Name(name);
    }

    public Name getName() {
        return name;
    }

    public abstract String get();
}
