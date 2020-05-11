package syntaxtree.stmt;

import bytecode.CodeProcedure;
import common.SymbolTable;
import common.error.CodeGenException;
import common.error.SemanticException;
import common.utils.TypeChecker;
import syntaxtree.expr.DerefVarExpr;
import syntaxtree.expr.Expr;
import syntaxtree.expr.VarExpr;
import static common.utils.StringUtil.*;

public class AssignStmt extends Stmt {

	private VarExpr varExpr;
	private DerefVarExpr derefExpr;
	private Expr expr;

	public AssignStmt(VarExpr varExpr, Expr expr) {
		this.varExpr = varExpr;
		this.expr = expr;
	}
	
	public AssignStmt(DerefVarExpr derefExpr, Expr expr) {
		this.derefExpr = derefExpr;
		this.expr = expr;
	}
	
	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(ASSIGN_STMT ");
		if(this.varExpr != null) {
			builder.append("\n" + repeat("\t", level + 1) + this.varExpr.printAst(level + 1));
		}
		else {
			builder.append("\n" + repeat("\t", level + 1) + this.derefExpr.printAst(level + 1));
		}
		builder.append("\n" + repeat("\t", level + 1) + " := ");
		builder.append("\n" + repeat("\t", level + 1) + this.expr.printAst(level + 1));
		builder.append("\n" + repeat("\t", level) + ")");
		return builder.toString();
	}

	@Override
	public void typeCheck(SymbolTable symbolTable) throws SemanticException {

		// AssignStmt can reduce to one of two types, ensure only one is used and do type check
		if(this.varExpr != null) {
			this.varExpr.typeCheck(symbolTable);
			this.expr.typeCheck(symbolTable);

			if(!(TypeChecker.isCompatibleType(this.varExpr.getDataType(), this.expr.getDataType()))) {
				throw new SemanticException("Variable type " + this.varExpr.getDataType().getName().getNameValue() +
						" does not match expression type " + this.expr.getDataType().getName().getNameValue());
			}

			return;
		}

		if (this.derefExpr != null) {
			this.derefExpr.typeCheck(symbolTable);
			this.expr.typeCheck(symbolTable);

			if(!(TypeChecker.isCompatibleType(this.derefExpr.getDataType(), this.expr.getDataType()))) {
				throw new SemanticException("Dereference type " + this.derefExpr.getDataType().getName().getNameValue() +
						" does not match expression type " + this.expr.getDataType().getName().getNameValue());
			}
		}
	}

	@Override
	public void generateCode(CodeProcedure proc) throws CodeGenException {

		// Generate code for left- and right-hand side expressions
		// Only one of two possible right-hand side expressions, do code generation only for one
		// Left-hand side need to do STORE instructions, while right-hand side need to do LOAD instructions
		if(this.varExpr != null) {
			this.varExpr.generateStoreCode(proc);
		} else {
			this.derefExpr.generateStoreCode(proc);
		}
		this.expr.generateCode(proc);
	}
}
