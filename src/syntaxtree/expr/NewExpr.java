package syntaxtree.expr;

import syntaxtree.DataType;

public class NewExpr extends Expr {

	private final DataType dataType;
	
	public NewExpr(DataType dataType) {
		this.dataType = dataType;
	}

	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(NEW ");
		builder.append(this.dataType.printAst(level));
		builder.append(")");

		return builder.toString();
	}

}
