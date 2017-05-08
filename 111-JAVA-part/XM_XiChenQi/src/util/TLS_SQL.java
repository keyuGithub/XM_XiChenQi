package util;

public class TLS_SQL {
	public static String getStrippedSQL(String sql) {
		String sqlBuild = sql;
		sqlBuild = rmOneLineComment(sqlBuild);
		sqlBuild = rmMultLineComment(sqlBuild);
		sqlBuild = rmEmptyLines(sqlBuild);
		return sqlBuild;
	}

	private static String rmEmptyLines(String sql) {
		return sql.replaceAll("(?m)^[ \t]*\r?\n", "");
	}

	private static String rmOneLineComment(String sql) {
		return sql.replaceAll("--.*(?=\\n)", "");
	}

	private static String rmMultLineComment(String sql) {
		return sql.replaceAll("/\\*.*?\\*/", "");
	}
}
