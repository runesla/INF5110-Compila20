package syntaxtree;

import java.util.*;

public class RecDecl extends Decl {

	private List<ParamFieldDecl> params;
	
	// Default constructor
	public RecDecl(String name) {
		super(name);
		this.params = new LinkedList<ParamFieldDecl>();
	}	

	// Given params
	public RecDecl(String name, List<ParamFieldDecl> params) {
		super(name);
		this.params = params;
	}

}
