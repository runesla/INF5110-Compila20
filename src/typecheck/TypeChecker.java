package typecheck;

import java.util.*;

public class TypeChecker {

	public static final String[] primitives = { "int", "string", "bool", "float" };

	public static boolean isPrimitive(String returnType) {
		return Arrays.asList(primitives).contains(returnType);
	}
}