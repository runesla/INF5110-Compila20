package syntaxtree.expr;

import bytecode.CodeProcedure;
import common.SymbolTable;
import common.error.CodeGenException;
import common.error.SemanticException;
import syntaxtree.types.DataType;

public class RefVarExpr extends Expr {
	
	private final VarExpr expr;

	public RefVarExpr(VarExpr expr) {
		this.expr = expr;
	}

	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(REF_VAR ");
		builder.append(this.expr.printAst(level));
		builder.append(")");
		return builder.toString();
	}


	@Override
	public void typeCheck(SymbolTable symbolTable) throws SemanticException {
		this.expr.typeCheck(symbolTable);
	}

	@Override
	public DataType getDataType() throws SemanticException {
		return this.expr.getDataType();
	}

	@Override
	public void generateCode(CodeProcedure proc) throws CodeGenException {
		this.expr.generateCode(proc);
	}
}
