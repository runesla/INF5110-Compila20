package syntaxtree.types.operators;

public enum ArithOpr {


    ADDOP {
        @Override
        public String get() {
            return "+";
        }
    },
    SUBOP {
        @Override
        public String get() {
            return "-";
        }
    },
    MULOP {
        @Override
        public String get() {
            return "*";
        }
    },
    DIVOP {
        @Override
        public String get() {
            return "/";
        }
    },
    EXP {
        @Override
        public String get() {
            return "^";
        }
    };

    public abstract String get();
}
