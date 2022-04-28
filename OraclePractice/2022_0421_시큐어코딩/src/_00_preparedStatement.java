import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class _00_preparedStatement {

	//DB driver loading
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
		}
	}
	
	public static void main(String[] args) throws Exception{
		//1. 서버 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "test1";
		String pwd = "test1";
		
		Connection conn = DriverManager.getConnection(url, user, pwd);
		
		//2. preparedStatement
		String sql = "SELECT * FROM test_member WHERE id = ? and pwd = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "one");
		pstmt.setString(2, "1234");
		
		//3. 처리 = 나는 조회를 할 것임
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			String name = rs.getString("name");
			String id = rs.getString("id");
			String password = rs.getString("pwd");
			
			System.out.printf("[%s]-[%s]-[%s]\n",name,id,password);
		}
		
		
	}//end main

}
