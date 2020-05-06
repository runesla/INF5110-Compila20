package syntaxtree.expr;

import common.SymbolTable;
import common.error.SemanticException;
import syntaxtree.types.DataType;

public class VarExpr extends Expr {

	private final String name;
	private Expr expr;
	private DataType dataType;

	public VarExpr(String name) {
		this.name = name;
	}

	public VarExpr(String name, DataType dataType) {
		this.name = name;
		this.dataType = dataType;
	}

	public VarExpr(String name, Expr expr) {
		this.name = name;
		this.expr = expr;
	}

	public VarExpr(String name, DataType dataType, Expr expr) {
		this.name = name;
		this.dataType = dataType;
		this.expr = expr;
	}

	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();

		if(this.expr != null) {
			builder.append(this.expr.printAst(level + 1));
			builder.append(" . ");
		}

		builder.append("(NAME ");
		builder.append(this.name);
		builder.append(")");

		return builder.toString();
	}

	@Override
	public void typeCheck(SymbolTable symbolTable) throws SemanticException {

		expr.typeCheck(symbolTable);

		if(expr.getDataType() != this.dataType) {
			throw new SemanticException("Type mismatch between variable and expression");
		}
	}

	@Override
	public DataType getDataType() {
		return this.dataType;
	}
}
