package syntaxtree.decl;

import bytecode.CodeFile;
import common.SymbolTable;
import common.error.CodeGenException;
import common.error.SemanticException;
import syntaxtree.types.DataType;
import syntaxtree.Name;
import syntaxtree.Node;

import java.io.IOException;

public abstract class Decl extends Node {

	private final Name name;

	public Decl(Name name) {
		//this.name = new Name(name);;
		this.name = name;
	}

	public Name getName() {
		return this.name;
	}

	public abstract DataType getDataType();

	public abstract void generateCode(CodeFile codeFile) throws CodeGenException;

	//public abstract void typeCheck(SymbolTable symbolTable) throws SemanticException;
}
