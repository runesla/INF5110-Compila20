package syntaxtree;

public abstract class Decl extends Node {
	
	private String name;

	public Decl(String name) {
		this.name = name;
	}
}
