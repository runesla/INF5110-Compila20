package syntaxtree.decl;

import common.SymbolTable;
import common.error.SemanticException;
import syntaxtree.types.DataType;
import syntaxtree.Name;
import syntaxtree.Node;

public abstract class Decl extends Node {
	/*
	private final String name;

	public Decl(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	 */

	private final Name name;

	public Decl(Name name) {
		this.name = name;
	}

	public Name getName() {
		return this.name;
	}

	public abstract DataType getDataType();

	public abstract void typeCheck(SymbolTable symbolTable) throws SemanticException;
}
