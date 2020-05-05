package syntaxtree;

public class RefDataType extends DataType implements ITypeCheck {

	private DataType dataType;

	public RefDataType(DataType dataType) {
		this.dataType = dataType;
	}
/*
	@Override
	public String get() {
		return "(REF " + this.type.getTypeNameValue() + ")";
	}
*/
	@Override
	public String printAst(int level) {
		StringBuilder builder = new StringBuilder();
		builder.append("(REF_TYPE ");
		builder.append(this.dataType.printAst(level));
		builder.append(")");
		return builder.toString();
	}

	@Override
	public String getDataType() {
		return dataType.getTypeNameValue();
	}
}
