package syntaxtree.decl;

import common.SymbolTable;
import common.error.SemanticException;
import syntaxtree.types.DataType;
import syntaxtree.Name;
import java.util.*;
import static common.utils.StringUtil.*;

public class RecDecl extends Decl {

	private final List<ParamDecl> params;

	// Default constructor
	public RecDecl(String name) {
		super(new Name(name));
		this.params = new LinkedList<>();
	}	

	// Given params
	public RecDecl(String name, List<ParamDecl> params) {
		super(new Name(name));
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
			for(ParamDecl p: params) {
				builder.append("\n" + repeat("\t", level+1) + "(VAR_DECL " + p.printAst(level + 1));
			}
		}
		builder.append("\n" + repeat("\t", level) + ")");
		return builder.toString();
	}

	@Override
	public DataType getDataType() {
		return new DataType(this.getName());
	}

	@Override
	public void typeCheck(SymbolTable symbolTable) throws SemanticException {

		// Create symbol table for this block
		SymbolTable recSymbolTable = new SymbolTable();
		symbolTable.getChildTables().add(recSymbolTable);

		// Check params
		for(ParamDecl paramDecl: params) {
			recSymbolTable.insertVariable(paramDecl);
			paramDecl.typeCheck(recSymbolTable);
		}
	}
}
