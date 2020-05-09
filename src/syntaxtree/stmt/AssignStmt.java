package syntaxtree.stmt;

import bytecode.CodeFile;
import bytecode.CodeProcedure;
import common.SymbolTable;
import common.error.CodeGenException;
import common.error.SemanticException;
import syntaxtree.expr.DerefVarExpr;
import syntaxtree.expr.Expr;
import syntaxtree.expr.VarExpr;
import syntaxtree.types.DataType;
import static common.utils.StringUtil.*;

public class AssignStmt extends Stmt {

	private VarExpr varExpr;
	private Expr expr;
	private DerefVarExpr derefExpr;

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
		
		if(this.varExpr != null)
			builder.append("\n" + repeat("\t", level + 1) + this.varExpr.printAst(level + 1));
		else
			builder.append("\n" + repeat("\t", level + 1) + this.derefExpr.printAst(level + 1));
		
		builder.append("\n" + repeat("\t", level + 1) + " := ");
		builder.append("\n" + repeat("\t", level + 1) + this.expr.printAst(level + 1));
		builder.append("\n" + repeat("\t", level) + ")");
		
		return builder.toString();
	}

	@Override
	public void typeCheck(SymbolTable symbolTable) throws SemanticException {

		this.varExpr.typeCheck(symbolTable);
		//this.expr.typeCheck(symbolTable);

		//TODO: add typecheck for derefExpr

		// AssignStmt can reduce to one of two types, ensure only one is used and do type check
		if(this.expr != null) {
			this.expr.typeCheck(symbolTable);
			System.out.println("varExpr type " + this.varExpr.hashCode() + ", expr type " + this.expr.hashCode());
			if(this.varExpr.getDataType() != this.expr.getDataType()) {
				throw new SemanticException("Variable type does not match expression type");
			}
		} else {
			this.derefExpr.typeCheck(symbolTable);

			if(this.derefExpr.getDataType() != this.expr.getDataType()) {
				throw new SemanticException("Dereference types does not match expression type");
			}
		}

	}

	@Override
	public void generateCode(CodeProcedure proc) throws CodeGenException {

		// Generate code for left- and right-hand side expressions
		// Only one of two possible right-hand side expressions, do code generation only for one
		this.varExpr.generateCode(proc);

		if(this.expr != null) {
			this.expr.generateCode(proc);
		} else {
			this.derefExpr.generateCode(proc);
		}
	}

	@Override
	public DataType getDataType() {
		return null;
	}
}
