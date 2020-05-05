package syntaxtree.decl;

import common.SymbolTable;
import common.error.SemanticException;
import syntaxtree.DataType;
import syntaxtree.Name;
import java.util.*;
import static common.StringUtil.*;

public class RecDecl extends Decl {

	private List<ParamFieldDecl> params;
	
	// Default constructor
	public RecDecl(Name name) {
		super(name);
		this.params = new LinkedList<>();
	}	

	// Given params
	public RecDecl(Name name, List<ParamFieldDecl> params) {
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

	@Override
	public DataType getDataType() {
		return new DataType(new Name("struct"));		// TODO: nonono, this is a quickfix only. Should be static somewhere
	}

	@Override
	public void typeCheck(SymbolTable symbolTable) throws SemanticException {

	}
}
