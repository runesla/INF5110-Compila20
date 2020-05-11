package syntaxtree.decl;

import bytecode.CodeFile;
import bytecode.CodeProcedure;
import common.error.CodeGenException;
import syntaxtree.types.DataType;
import syntaxtree.Name;
import syntaxtree.Node;

public abstract class Decl extends Node {

	private final Name name;

	public Decl(Name name) {
		this.name = name;
	}

	public Name getName() {
		return this.name;
	}

	public abstract DataType getDataType();

	public abstract void generateCode(CodeFile codeFile) throws CodeGenException;

	public abstract void generateCode(CodeProcedure proc) throws CodeGenException;
}
