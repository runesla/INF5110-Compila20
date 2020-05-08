package syntaxtree.decl;

import common.SymbolTable;
import common.error.SemanticException;
import syntaxtree.types.DataType;
import syntaxtree.Name;
import syntaxtree.expr.Expr;
import static common.utils.StringUtil.*;

public class VarDecl extends Decl {
	
	private DataType dataType;
	private Expr expr;

	public VarDecl(
			Name name,
			DataType dataType) {
		super(name);
		this.dataType = dataType;
	}

	public VarDecl(
			Name name,
			Expr expr) {
		super(name);
		this.expr = expr;
	}

	public VarDecl(
			Name name,
			DataType dataType,
			Expr expr) {
		super(name);
		this.dataType = dataType;
		this.expr = expr;
	}

	@Override
	public DataType getDataType() {
		return this.dataType;
	}

	@Override
	public void typeCheck(SymbolTable symbolTable) throws SemanticException {

		if(this.expr != null) {
			this.expr.typeCheck(symbolTable);
		}

// TODO: for debugging
		if(this.dataType == null) {
			System.out.println("VarDecl " + this.getName().getNameValue() + " has no type");
		}
		if (this.expr == null) {
			System.out.println("VarDecl " + this.getName().getNameValue() + " has no expr");
		}
		if (this.dataType != null) {
			System.out.println("VarDecl " + this.getName().getNameValue() + " has type " + this.getDataType().getName().getNameValue());
		}

		// Check type matching between declaration and expression
		if(this.expr != null && (this.dataType != this.expr.getDataType())) {
			throw new SemanticException("Type mismatch between variable declaration and expression");
		}
	}

	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(VAR_DECL ");
		builder.append("\n" + repeat("\t", level + 1) + this.dataType.printAst(level));
		builder.append(" : ");
		builder.append(" (NAME ");
		builder.append(this.getName().getNameValue());
		builder.append(")");
		builder.append("\n" + repeat("\t", level) + ")");
		return builder.toString();
	}
}
