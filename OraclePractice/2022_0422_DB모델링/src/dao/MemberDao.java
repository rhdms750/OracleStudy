package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import service.DBservice;
import vo.MemberVo;

public class MemberDao {
	
	private static MemberDao single = null;
	
	private MemberDao() {};
	
	public static MemberDao getInstance() {
		
		if (single == null) {
			single = new MemberDao();
		}
		
		return single;
	}
	
	public List<MemberVo> selectList(){
		
		List<MemberVo> list = new ArrayList<MemberVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM member";
		
		try {
			conn = DBservice.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				MemberVo vo = new MemberVo();
				
				vo.setEin(rs.getInt("ein"));
				vo.setName(rs.getString("name"));
				vo.setAddr(rs.getString("addr"));
				vo.setSsn(rs.getString("ssn"));
				vo.setHireday(Integer.parseInt(rs.getString("hireday"))+1900);
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				
				list.add(vo);
				
			}
			
		} catch (Exception e) {
			
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return list;
	}
	
}
