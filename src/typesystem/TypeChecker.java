package typesystem;

import java.util.*;

public class TypeChecker {

	public static final String[] primitives = { "int", "string", "bool", "float" };
	public static ArrayList<String> userDefinedTypes = new ArrayList<>();

	public static boolean isPrimitive(String returnType) {
		return Arrays.asList(primitives).contains(returnType);
	}

}