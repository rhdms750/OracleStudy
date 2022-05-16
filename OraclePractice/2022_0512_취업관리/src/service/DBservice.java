package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBservice {
	static {
		//DB����̹� �̸�: ����Ŭ�� jdbc > driver > OracleDriver
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("there is no jdbc driver");
		}
	}
	
	//DB �̱��� �ν��Ͻ�
	public static DBservice single = null;
	
	public static DBservice getInstance() {
		if (single == null) {
			single = new DBservice();
		}
		return single;
	}
	
	private DBservice(){
		
	}
	
	//Connection �̱��� �ν��Ͻ� ��ȯ �޼ҵ�
	public Connection getConnection() throws SQLException{
		Connection conn = null;
				
		//������
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "rec_admin";
		String pwd = "rec_admin";
		
		conn = DriverManager.getConnection(url,user,pwd);
		
		return conn;
	}
	
}
