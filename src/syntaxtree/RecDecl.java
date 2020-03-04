package syntaxtree;

import java.util.*;

public class RecDecl extends Decl {

	private List<ParamDecl> params;
	
	// Default constructor
	public RecDecl(String name) {
		super(name);
		this.params = new ArrayList<ParamDecl>();
	}	

	// Given params
	public RecDecl(String name, List<ParamDecl> params) {
		super(name);
		this.params = params;
	}

}
