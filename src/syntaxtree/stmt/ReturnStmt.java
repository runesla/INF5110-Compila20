package syntaxtree.stmt;

import common.SymbolTable;
import common.error.SemanticException;
import syntaxtree.expr.Expr;
import syntaxtree.types.DataType;

public class ReturnStmt extends Stmt {
	
	private Expr expr;

	// Empty constructor for empty return types
	public ReturnStmt() { }
	
	public ReturnStmt(Expr expr) {
		this.expr = expr;
	}
	
	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(RETURN_STMT ");
	
		if(expr != null)
			builder.append(expr.printAst(level + 1));

		builder.append(")");		

		return builder.toString();
	}

	@Override
	public void typeCheck(SymbolTable symbolTable) throws SemanticException {
		this.expr.typeCheck(symbolTable);
	}

	@Override
	public DataType getDataType() {
		return null;
	}
}
