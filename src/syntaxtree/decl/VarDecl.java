package syntaxtree.decl;

import common.SymbolTable;
import common.error.SemanticException;
import syntaxtree.DataType;
import syntaxtree.Name;
import syntaxtree.expr.Expr;
import static common.StringUtil.*;

public class VarDecl extends Decl {
	
	private DataType dataType;
	private Expr expr;

	public VarDecl(String name, DataType dataType) {
		super(new Name(name));
		this.dataType = dataType;
	}

	public VarDecl(String name, Expr expr) {
		super(new Name(name));
		this.expr = expr;
	}

	public VarDecl(String name, DataType dataType, Expr expr) {
		super(new Name(name));
		this.dataType = dataType;
		this.expr = expr;
	}

	@Override
	public DataType getDataType() {
		return this.dataType;
	}

	@Override
	public void typeCheck(SymbolTable symbolTable) throws SemanticException {	// TODO: create hierarchy of symboltables because of scopes?

		if(symbolTable.retrieveVariable(this.getName()) != null) {
			throw new SemanticException("Duplicate variable declaration " + this.getName().toString());
		}

		symbolTable.insertVariable(this);
	}

	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(VAR_DECL ");
		builder.append("\n" + repeat("\t", level + 1) + this.dataType.printAst(level));
		builder.append(" : ");
		builder.append(" (NAME ");
		builder.append(this.getName());
		builder.append(")");
		builder.append("\n" + repeat("\t", level) + ")");
		return builder.toString();
	}
}
