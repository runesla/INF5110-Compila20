package syntaxtree.expr;

import common.SymbolTable;
import common.error.SemanticException;
import syntaxtree.Name;
import syntaxtree.decl.RecDecl;
import syntaxtree.decl.VarDecl;
import syntaxtree.types.DataType;
import syntaxtree.types.Type;

public class VarExpr extends Expr {

	private final Name name;
	private Expr expr;
	private DataType dataType;

	public VarExpr(String name) {
		this.name = new Name(name);
		this.dataType = null;
	}

	public VarExpr(String name, DataType dataType) {
		this.name = new Name(name);
		this.dataType = dataType;
	}

	public VarExpr(String name, Expr expr) {
		this.name = new Name(name);
		this.expr = expr;
	}

	public VarExpr(String name, DataType dataType, Expr expr) {
		this.name = new Name(name);
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

		if(this.expr == null && this.dataType == null) {			// TODO: for debugging
			System.out.println("VarExpr " + this.name.getNameValue() + " have no expr or type");
		}

		if(this.expr == null) {
			VarDecl var = symbolTable.retrieveVariable(this.name);
			this.dataType = var.getDataType();
		}

		if(this.dataType == null) {
			System.out.println("STILL NULL");
		}
		this.expr.typeCheck(symbolTable);

//		if(this.expr.getDataType().getType() != Type.UDT) {
//			throw new SemanticException("Expression is not a user-defined type");
//		}

		// Check valid type
//		if(this.dataType != null) {
//			if (this.expr.getDataType().getType() != this.dataType.getType()) {
//				throw new SemanticException("Type mismatch between variable and expression");
//			}
//		}



	}

	@Override
	public DataType getDataType() throws SemanticException {
		if(this.dataType == null) {
			throw new SemanticException("Undetermined return type in expression " + this.name.getNameValue());
		}

		return this.dataType;
	}
}
