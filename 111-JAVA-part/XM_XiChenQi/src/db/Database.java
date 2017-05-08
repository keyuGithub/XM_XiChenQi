package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import main.Customizing;
import util.TLS_UDF;

public class Database {
	private Connection conn = null;
	private String dbName;
	
	public Database(String env, String user) {
//		this.setDbName(Customizing.getInstance().getDB2Alias(env));
		this.establishConnection(env, user);
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	public boolean isAvailable() {
		return this.conn != null;
	}

	private void establishConnection(String env, String user) {
		try {
			String dbUrl = Customizing.getInstance().getDatabaseURL(env) + getDbName();
			Class.forName(Customizing.getInstance().getJDBCDriverClass());
			
			Properties properties = new Properties();
			
			properties.put("user", user);
			properties.put("password", this.getPwd(user));
			properties.put("retreiveMessagesFromServerOnGetMessage", "true");
			
			conn = DriverManager.getConnection(dbUrl, properties);
		} catch (Exception e) {
			conn = null;
			log("");
			log("--> Database DBConnection: error during connect: " + e.getMessage());
			log("	--> login user: " + user);
		}
	}

	public void close() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				log("--> Database DBConnection: error during disconnect: " +  e.getMessage());
			}
			conn = null;
		}
	}
	
	private String getPwd(String user) {
		return Customizing.getInstance().getDatabasePassword(user);
	}

	private void log(String msg) {
		TLS_UDF.clog(msg);
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
}
