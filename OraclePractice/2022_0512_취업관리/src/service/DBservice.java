package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBservice {
	static {
		//DB드라이버 이름: 오라클의 jdbc > driver > OracleDriver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("there is no jdbc driver");
		}
	}
	
	//DB 싱글톤 인스턴스
	public static DBservice single = null;
	
	public static DBservice getInstance() {
		if (single == null) {
			single = new DBservice();
		}
		return single;
	}
	
	private DBservice(){
		
	}
	
	//Connection 싱글톤 인스턴스 반환 메소드
	public Connection getConnection() throws SQLException{
		Connection conn = null;
				
		//서버명
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "rec_admin";
		String pwd = "rec_admin";
		
		conn = DriverManager.getConnection(url,user,pwd);
		
		return conn;
	}
	
}
