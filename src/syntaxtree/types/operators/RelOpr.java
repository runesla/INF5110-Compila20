package syntaxtree.types.operators;

import syntaxtree.Name;

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
}
