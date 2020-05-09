package syntaxtree.types.operators;

public enum RelOpr {

    EQ {
        @Override
        public String get() {
            return "=";
        }
        },
    LT {
        @Override
        public String get() {
            return "<";
        }
        },
    GT {
        @Override
        public String get() {
            return ">";
        }
        },
    LTEQUAL {
        @Override
        public String get() {
            return "<=";
        }
        },
    GTEQUAL {
        @Override
        public String get() {
            return ">=";
        }
        },
    NEQUAL {
        @Override
        public String get() {
            return "<>";
        }
    };

    public abstract String get();

    public static RelOpr getOpr(String opr) {
        switch (opr) {
            case "=":
                return EQ;
            case "<":
                return LT;
            case ">":
                return GT;
            case "<=":
                return LTEQUAL;
            case ">=":
                return GTEQUAL;
            case "<>":
                return NEQUAL;
            default:
                throw new IllegalArgumentException("Not a valid operator: " + opr);
        }
    }
}
