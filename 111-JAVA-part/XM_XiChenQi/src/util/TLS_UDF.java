package util;

public class TLS_UDF {
	
	//LOG functions:
	// clog -- logging in console
	// dlog -- logging in database
	
	public static void clog(String msg) {
		System.out.println(msg);
	}

	public static void dlog(String msg) {
		//System.out.println(msg);
		//write this logging msg into database. :
		//LOG-Inhalt: wer, wann, was angepasst
	}

	//Filesystem IO-Functions:
	public static void readOptionsFromCSV(String csvFile) {
		//return Options;
	}
}
