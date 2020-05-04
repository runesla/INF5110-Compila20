package syntaxtree;

import java.util.*;
import static syntaxtree.StringUtil.*;

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

	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(STRUCT ");
		builder.append("(NAME ");
		builder.append(this.getName());
		builder.append(")");		

		if(params != null) {
			for(ParamFieldDecl p: params) {
				builder.append("\n" + repeat("\t", level+1) + "(VAR_DECL " + p.printAst(level + 1));
			}
		}
			
		builder.append("\n" + repeat("\t", level) + ")");
		
		return builder.toString();
	}
}
