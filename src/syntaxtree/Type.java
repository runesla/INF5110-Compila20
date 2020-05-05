package syntaxtree;

public class Type {

    public static final String primitiveInteger = "int";
    public static final String primitiveFloat = "float";
    public static final String primitiveBool = "bool";
    public static final String primitiveString = "string";
    public static final String primitiveRecord = "struct";

    private final Name name;

    private Type(String name) {
        this.name = new Name(name);
    }

    public Name getName() {
        return this.name;
    }
}
