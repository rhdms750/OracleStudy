package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import service.DBservice;
import vo.ApplyInfoVo;
import vo.ComInfoVo;
import vo.EnvInfoVo;
import vo.MyApplyListVo;
import vo.RecInfoVo;

public class MyApplyDao {
	//MyApplyDao �̱��� �����
	private static MyApplyDao single = null;
	
	private MyApplyDao() {
		
	}
	
	public static MyApplyDao getInstance() {
		if (single == null) {
			single = new MyApplyDao();
		}
		return single;
	}
	
	//insertApplyInfo(Vo)
	public void insertApplyInfo(ApplyInfoVo vo) {
		
		int res = 0;
	
		//���� - > SQL�� �غ� - > executeUpdate;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		//SQL��
		String sql = "INSERT INTO MY_APPLY VALUES(seq_my_apply_apply_no.nextVal, ?, ?, ?)";
		
		try {
			//1. ����
			conn = DBservice.getInstance().getConnection();
			//2. pstmt ������
			pstmt = conn.prepareStatement(sql);
			//3. �Ķ���� ����
			pstmt.setString(1, vo.getApply_state());
			
			String doc = vo.getApply_doc();
			if (doc != null) {
				pstmt.setString(2, doc);
			}else {
				pstmt.setString(2, null);
			}
			
			String date = vo.getApply_date();
			if (date != null) {
				pstmt.setDate(3, Date.valueOf(date)); //Date��ü�� valueOf�� ���
			}else {
				pstmt.setDate(3, null);
			}
			
			//4. insert �ϱ� (res = insert ���� ��ȯ)
			res = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	//insertComInfo(Vo)
	public void insertComInfo(ComInfoVo vo) {
		
		int res = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO COMPANY VALUES(seq_company_com_no.nextVal, ?, ?, ?, ?)";
		
		try {
			
			conn  = DBservice.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			
			//�Ķ���� ����
			pstmt.setString(1, vo.getCom_name());
			pstmt.setString(2, vo.getCom_cat());
			pstmt.setString(3, vo.getCom_focus());
//			pstmt.setString(4, vo.getCom_req());
//			pstmt.setString(5, vo.getCom_pref());
			pstmt.setInt(4, vo.getApply_no());
//			pstmt.setString(7, vo.getCom_etc());
			
			res   = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn  != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	//insertRecInfo(Vo)
	public void insertRecInfo(RecInfoVo vo) {
		
		int res = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO RECRUIT_INFO VALUES(seq_recruit_info_rec_idx.nextVal, ?, ?, ?, ?, ?, ?, ?,?,?)";
		
		try {
			conn = DBservice.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getCom_no());
			pstmt.setString(2, vo.getRec_link());
			pstmt.setString(3, vo.getDoc_date());
			pstmt.setString(4, vo.getCotest_date());
			pstmt.setString(5, vo.getIntvw_date());
			pstmt.setString(6, vo.getRec_end());
			pstmt.setString(7, vo.getRec_name());
			pstmt.setString(8, vo.getRec_req());
			pstmt.setString(9, vo.getRec_pref());
			
			res = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();;
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn  != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

	
	//insertEnvInfo(Vo)
	public void insertEnvInfo(EnvInfoVo vo) {
		int res = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO WORK_ENV VALUES(seq_work_env_env_idx, ?, ?, ?, ?, ?)";
		
		try {
			conn = DBservice.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getSalary());
			pstmt.setString(2, vo.getOvertime_pay());
			pstmt.setString(3, vo.getBonus());
			pstmt.setString(4, vo.getFacility());
			pstmt.setInt(5, vo.getCom_no());
			
			res = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	//getCompMap()
	public Map<Integer,String> getCompMap(){
		
		Map<Integer,String> compMap = new HashMap<Integer,String>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COM_NO, COM_NAME FROM COMPANY";
		
		try {
			conn = DBservice.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				compMap.put(rs.getInt("COM_NO"), rs.getString("COM_NAME"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return compMap;
		
	}
	
	//getMaxApplyNO
	public int getMaxApplyNo() {
		
		int max = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT APPLY_NO FROM MY_APPLY";
		
		try {
			conn = DBservice.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				max = rs.getInt("APPLY_NO");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return max;
	}
	
	
	//selectMyApplyList()
	public List<MyApplyListVo> selectMyApplyList(){
		
		List<MyApplyListVo> list = new ArrayList<MyApplyListVo>();
		
		//����
		Connection conn = null;
		
		//SQL PreparedStatement
		PreparedStatement pstmt = null; 
		
		//ResultSet
		ResultSet rs = null;
		
		//SQL�� �غ�
		String sql = "SELECT * FROM MY_APPLY_LIST";
		
		try {
			//���� -> pstmt�غ� -> executeQuery in rs
			conn = DBservice.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				MyApplyListVo vo = new MyApplyListVo();
				
				vo.setApply_no(rs.getInt("APPLY_NO"));
				vo.setCom_name(rs.getString("COM_NAME"));
				vo.setCom_cat(rs.getString("COM_CAT"));
				vo.setCom_focus(rs.getString("COM_FOCUS"));
				vo.setRec_name(rs.getString("REC_NAME"));
				vo.setRec_link(rs.getString("REC_LINK"));
				vo.setApply_state(rs.getString("APPLY_STATE"));
				
				list.add(vo);
				
			}
			
		} catch (Exception e) {
			
			System.out.println("Something went wrong.. check down");
			e.printStackTrace();
			
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
