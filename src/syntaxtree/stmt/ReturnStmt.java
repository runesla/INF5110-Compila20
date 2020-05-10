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

	public DataType getDataType() throws SemanticException {
		if(expr.getDataType() == null) {
			throw new SemanticException("No data type defined for return statement");
		}
		return expr.getDataType();
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
	public void generateCode(CodeProcedure proc) throws CodeGenException {
		this.expr.generateCode(proc);

		proc.addInstruction(new RETURN());
	}
}
