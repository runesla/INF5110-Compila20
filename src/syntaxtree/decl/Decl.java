package syntaxtree.decl;

import syntaxtree.Node;
import typecheck.IFieldTypeCheck;
import typecheck.ITypeCheck;

public abstract class Decl extends Node implements IFieldTypeCheck, ITypeCheck {
	
	private String name;

	public Decl(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
