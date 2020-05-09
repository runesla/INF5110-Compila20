package syntaxtree.types;

import common.SymbolTable;
import common.error.SemanticException;
import syntaxtree.Name;
import syntaxtree.Node;

import java.util.Objects;

public class DataType extends Node {

	private Name name;
	private Type type;

	// Need empty constructor in order to call RefType
	public DataType() { }

	public DataType(Name name) {
		this.name = name;
		this.type = Type.UDT;
	}

	public DataType(Type type) {
		this.name = type.getName();
		this.type = type;
	}

	public Type getType() {
		return this.type;
	}

	public Name getName() {
		return this.name;
	}

	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		if(this.name == null) {
			builder.append("(TYPE ");
		}
		else {
			builder.append("(NAME ");
		}
		builder.append(")");
		return builder.toString();
	}

	@Override
	public void typeCheck(SymbolTable symbolTable) throws SemanticException {

	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		DataType dataType = (DataType) o;

		if (!Objects.equals(name, dataType.name)) return false;
		return type == dataType.type;
	}

	@Override
	public int hashCode() {
		int result = name != null ? name.hashCode() : 0;
		result = 31 * result + (type != null ? type.hashCode() : 0);
		return result;
	}
}
