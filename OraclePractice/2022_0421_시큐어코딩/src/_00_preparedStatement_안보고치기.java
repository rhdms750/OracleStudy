import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class _00_preparedStatement_�Ⱥ���ġ�� {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� ������ ã�� �� �����ϴ�.");
		}
	}
	
	public static void main(String[] args) throws Exception{
		//1. ����
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "test1";
		String pwd = "test1";
		
		Connection conn = DriverManager.getConnection(url, user, pwd);
		
		//2. preparedStatement
		//1) SQL���� '?'�� �־� ���� ���� parameter�� ����
		// parameter index   1        2
		//                   id = ?   pwd = ?  
		String sql = "SELECT * FROM test_member WHERE id = ? AND pwd = ?";
		
		//2) PreparedStatement�ȿ� SQL���� �ֱ�
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		//3) SQL���� parameter�� �����Ѵ�.
		pstmt.setString(1, "one");
		pstmt.setString(2, "1234");
		
		//3. ó��
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			String name = rs.getString("name");
			String id = rs.getString("id");
			String password = rs.getString("pwd");
			
			System.out.printf("[%s]���� ���̵�� %s, ��й�ȣ�� %s\n",name,id,password);
		}
		
		//4. �ݱ�
		rs.close();
		pstmt.close();
		conn.close();
		
	}//end main

}
