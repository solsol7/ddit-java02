package mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mvc.vo.MemberVO;
import util.DBUtil;
import util.DBUtil3;

public class MemberDaoImpl implements IMemberDao {

	@Override
	public int insertMember(MemberVO memVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			conn = DBUtil3.getConnection();
			String sql = " insert into MYMEMBER(MEM_ID, MEM_PASS, MEM_NAME, MEM_TEL, MEM_ADDR) "
					+ " values(?, ?, ?, ?, ?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memVo.getMem_id());
			pstmt.setString(2, memVo.getMem_pass());
			pstmt.setString(3, memVo.getMem_name());
			pstmt.setString(4, memVo.getMem_tel());
			pstmt.setString(5, memVo.getMem_addr());
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = DBUtil3.getConnection();
			String sql = " delete from mymember where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			conn = DBUtil.getConnection();
			String sql = " update mymember set "
					+ " mem_pass=?, mem_name=?, mem_tel=?, mem_addr=? "
					+ "where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memVo.getMem_pass());
			pstmt.setString(2, memVo.getMem_name());
			pstmt.setString(3, memVo.getMem_tel());
			pstmt.setString(4, memVo.getMem_addr());
			pstmt.setString(5, memVo.getMem_id());
			
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMember() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO memVo = new MemberVO();
		
		try {
			conn = DBUtil3.getConnection();
			String sql = " select * from mymember";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				
				memVo.setMem_addr(rs.getString("mem_id"));
				memVo.setMem_addr(rs.getString("mem_name"));
				memVo.setMem_addr(rs.getString("mem_pass"));
				memVo.setMem_addr(rs.getString("mem_tel"));
				memVo.setMem_addr(rs.getString("mem_addr"));
				
				list.add(memVo);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		return list;
	}

	@Override
	public int getMemberCount(String memId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	      
	      int count = 0; //반환값이 저장될 변수
	      try {
	         conn = DBUtil.getConnection();
	         String sql = "select count(*) cnt from mymember where mem_id = ?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, memId);
	         rs = pstmt.executeQuery();
	         
	         if(rs.next()) {
	            count = rs.getInt("cnt");
	         }
		return 0;
	}

}
