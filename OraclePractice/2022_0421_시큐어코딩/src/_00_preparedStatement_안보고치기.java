import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class _00_preparedStatement_안보고치기 {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 정보를 찾을 수 없습니다.");
		}
	}
	
	public static void main(String[] args) throws Exception{
		//1. 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "test1";
		String pwd = "test1";
		
		Connection conn = DriverManager.getConnection(url, user, pwd);
		
		//2. preparedStatement
		//1) SQL문에 '?'를 넣어 값을 넣을 parameter를 형성
		// parameter index   1        2
		//                   id = ?   pwd = ?  
		String sql = "SELECT * FROM test_member WHERE id = ? AND pwd = ?";
		
		//2) PreparedStatement안에 SQL문을 넣기
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		//3) SQL문의 parameter를 세팅한다.
		pstmt.setString(1, "one");
		pstmt.setString(2, "1234");
		
		//3. 처리
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			String name = rs.getString("name");
			String id = rs.getString("id");
			String password = rs.getString("pwd");
			
			System.out.printf("[%s]님의 아이디는 %s, 비밀번호는 %s\n",name,id,password);
		}
		
		//4. 닫기
		rs.close();
		pstmt.close();
		conn.close();
		
	}//end main

}
