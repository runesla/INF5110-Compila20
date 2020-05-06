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
}
