package util;

import java.util.List;
import java.util.UUID;

public class TLS_String {
	public static String md5(String txt) {
		return TLS_Security.getHash(txt, "MD5");
	}
	
	public static String sha1(String txt) {
		return TLS_Security.getHash(txt, "SHA1");
	}

	public static String padRight(String input, int len) {
		return String.format("%1$-" + len + "s", input);
	}
	
	public static String padLeft(String input, int len) {
		return String.format("%1$" + len + "s", input);
	}

	public static String abbreviateString(String input, int maxLen) {
		if (input.length() <= maxLen)
			return input;
		else
			return input.substring(0, Math.min(input.length(), maxLen));
	}
	
	public static String combinListCSVwithDelimiter (List<String> list, String delimiter) {
		String result = delimiter;
		for (String s : list) {
			result += s + delimiter + ", " + delimiter;
		}
		String randomPattern = UUID.randomUUID().toString();
		result += randomPattern;
		result = result.replace(", " + delimiter + randomPattern, "");
		return result;
	}
}
