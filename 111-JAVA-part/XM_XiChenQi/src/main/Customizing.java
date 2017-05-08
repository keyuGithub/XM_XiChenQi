package main;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Customizing {

	private static final Customizing instance = new Customizing();
	private static SimpleDateFormat df = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
	
	private Customizing() {	}

	public static Customizing getInstance() {
		return instance;
	}
	
	public String getCreationDate() {
		return df.format(new Date());
	}
	

	public String getDatabaseURL (String environment) {
		String protocol = "jdbc:db2://";
		String server = "localhost";
		String port = ":50000/";
		return protocol + server + port;
	}
	
	public String getJDBCDriverClass() {
		return "com.ibm.db2.jcc.DB2Driver";
	}
	

	public String getDatabasePassword (String user) {
		return "PASSWORD";
	}

}
