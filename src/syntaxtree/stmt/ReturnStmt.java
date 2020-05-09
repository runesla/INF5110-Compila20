package syntaxtree.stmt;

import bytecode.CodeProcedure;
import bytecode.instructions.RETURN;
import common.SymbolTable;
import common.error.CodeGenException;
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
		if(expr != null) {
			builder.append(expr.printAst(level + 1));
		}
		builder.append(")");
		return builder.toString();
	}

	@Override
	public void typeCheck(SymbolTable symbolTable) throws SemanticException {
		this.expr.typeCheck(symbolTable);
	}

	@Override
	public DataType getDataType() throws SemanticException {				// TODO: can return have no expr? Must have null checker if so
		return this.expr.getDataType();
	}

	@Override
	public void generateCode(CodeProcedure proc) throws CodeGenException {	// TODO: can return have no expr? Must have null checker if so
		this.expr.generateCode(proc);

		proc.addInstruction(new RETURN());
	}
}
