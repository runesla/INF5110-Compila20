package common.utils;

public class StringUtil {

	public static String repeat(String in, int n) {

		StringBuilder builder = new StringBuilder();

		for(int i = 0; i < n; i++) {
			builder.append(in);			
		}

		return builder.toString();
	}
}
