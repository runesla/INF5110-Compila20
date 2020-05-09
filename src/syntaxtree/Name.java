package syntaxtree;

import common.SymbolTable;
import common.error.SemanticException;
import java.util.Objects;

public class Name extends Node {

	private final String nameValue;

	public Name(String nameValue) {
		this.nameValue = nameValue;
	}

	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(NAME ");
		builder.append(this.nameValue);
		builder.append(")");
		return builder.toString();
	}

	@Override
	public void typeCheck(SymbolTable symbolTable) throws SemanticException {

	}

	public String getNameValue() {
		return this.nameValue;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Name name = (Name) o;
		return Objects.equals(nameValue, name.nameValue);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nameValue);
	}
}
