package syntaxtree.types.operators;

public enum LogOpr {

    LOG_OR {
        @Override
        public String get() {
            return "||";
        }
    },
    LOG_AND {
        @Override
        public String get() {
            return "&&";
        }
    };

    public abstract String get();

    public static LogOpr getOpr(String opr) {
        switch (opr) {
            case "||":
                return LOG_OR;
            case "&&":
                return LOG_AND;
            default:
                throw new IllegalArgumentException("Not a valid operator: " + opr);
        }
    }
}
