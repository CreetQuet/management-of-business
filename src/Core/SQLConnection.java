package Core;
import java.sql.*;
import java.util.HashMap;

import Model.Configuration;

public class SQLConnection {

	protected String user;
	protected String pwd;
	protected String db;
	protected String ip;
	protected String port;
	protected String url;
	private Connection conn = null;
	
	protected HashMap<String, String> data;
	
	public SQLConnection() {
		Configuration cfg = new Configuration();
		data = cfg.getConfiguration();
		ip = data.get("ip");
		port = data.get("port");
		user = data.get("user");
		pwd = data.get("pwd");
		db = data.get("db");
		
		url = "jdbc:mysql://" + ip + ":" + port + "/" + db;
	}
	
	public Connection getConnection() {
		try {
			
			conn = DriverManager.getConnection(url, user, pwd);
			
			/*if (conn != null)
				System.out.println("Conecction successful");*/
			
		}
		catch (SQLException e) {
			System.out.println("Error to try connect to DB " + conn.toString());
		}catch(NullPointerException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
