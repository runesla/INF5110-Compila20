package syntaxtree;

public class TypeName {

	private String typeNameValue;

	public TypeName(String typeNameValue) {
		this.typeNameValue = typeNameValue;
	}
	
	@Override
	public String toString() {
		return this.typeNameValue;
	}
}
