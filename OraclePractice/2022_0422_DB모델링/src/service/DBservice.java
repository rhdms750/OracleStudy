package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBservice {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("����̹��� ã�� �� �����ϴ�.");
		}
	}
	
	private static DBservice single = null;
	
	public static DBservice getInstance() {
		
		if (single == null) {
			single = new DBservice();
		}
		
		return single;
		
	}
	
	private DBservice(){
		
	}
	
	public Connection getConnection() throws SQLException{
		
		Connection conn = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "test1";
		String pwd = "test1";
		
		conn = DriverManager.getConnection(url, user, pwd);
		
		return conn;
	}
	
}
