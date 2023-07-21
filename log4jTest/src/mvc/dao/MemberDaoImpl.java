package mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import mvc.vo.MemberVO;
import util.DBUtil;
import util.DBUtil3;
//클래스에 메서드만 있을 경우에는 객체가 여러 개 생성될 필요가 없음 => 싱글톤 사용
public class MemberDaoImpl implements IMemberDao {
	private static final Logger logger = Logger.getLogger(MemberDaoImpl.class);
	// 1번
	private static MemberDaoImpl dao;
	
	//2번
	private MemberDaoImpl() {}
	
	//3번
	public static MemberDaoImpl getInstance() {
		if(dao==null) dao = new MemberDaoImpl();
		return dao;
	}
	
	
	@Override
	public int insertMember(MemberVO memVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			conn = DBUtil3.getConnection();
			logger.info("Connection객체 생성 완료!!");
			String sql = " insert into MYMEMBER(MEM_ID, MEM_PASS, MEM_NAME, MEM_TEL, MEM_ADDR) "
					+ " values(?, ?, ?, ?, ?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memVo.getMem_id());
			pstmt.setString(2, memVo.getMem_pass());
			pstmt.setString(3, memVo.getMem_name());
			pstmt.setString(4, memVo.getMem_tel());
			pstmt.setString(5, memVo.getMem_addr());
			
			logger.info("PreparedStatement객체 생성...");
			logger.debug("실행 SQl ==> "+sql);
			logger.info("사용 데이터 ==> ["+memVo.getMem_id() + ", "+ memVo.getMem_pass()
						+"," + memVo.getMem_name() +", "+memVo.getMem_tel() + ", "
					+ memVo.getMem_addr() + "]");
			
			cnt = pstmt.executeUpdate();
			logger.info("실행 작업 성공!!!");
			
		} catch (SQLException e) {
			logger.error("DB 작업 실패!!!", e);
			e.printStackTrace();
		}finally {
			if(pstmt!=null) try {
				pstmt.close();
				logger.info("PreparedStatement객체 반납...");
				} catch(SQLException e) {}
			if(conn!=null) try {
					conn.close();
					logger.info("Connection객체 반납...");
				} catch(SQLException e) {}
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
			logger.info("Connection 객체 생성 완료!");
			String sql = " delete from mymember where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			logger.info("PreparedStatement객체 생성...");
			logger.debug("실행 SQl ==> "+sql);
			logger.info("사용 데이터 ==> ["+ memId + "]");
			
			cnt = pstmt.executeUpdate();
			logger.info("실행 작업 성공!!!");
			
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
			conn = DBUtil3.getConnection();
			String sql = " update mymember set "
					+ " mem_pass=?, mem_name=?, mem_tel=?, mem_addr=? "
					+ "where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memVo.getMem_pass());
			pstmt.setString(2, memVo.getMem_name());
			pstmt.setString(3, memVo.getMem_tel());
			pstmt.setString(4, memVo.getMem_addr());
			pstmt.setString(5, memVo.getMem_id());
			
			logger.info("PreparedStatement객체 생성...");
			logger.debug("실행 SQl ==> "+sql);
			logger.info("사용 데이터 ==> ["+memVo.getMem_id() + ", "+ memVo.getMem_pass()
										+"," + memVo.getMem_name() +", "+memVo.getMem_tel() + ", "
										+ memVo.getMem_addr() + "]");
			
			cnt = pstmt.executeUpdate();
			
			logger.info("실행 작업 성공!!!");
			
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
		
		try {
			conn = DBUtil3.getConnection();
			String sql = " select * from mymember ";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				MemberVO memVo = new MemberVO();
				memVo.setMem_id(rs.getString("mem_id"));
				memVo.setMem_name(rs.getString("mem_name"));
				memVo.setMem_pass(rs.getString("mem_pass"));
				memVo.setMem_tel(rs.getString("mem_tel"));
				memVo.setMem_addr(rs.getString("mem_addr"));
				
				
				list.add(memVo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
			if(stmt!=null) try {stmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
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
	         conn = DBUtil3.getConnection();
	         String sql = "select count(*) cnt from mymember where mem_id = ?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, memId);
	         rs = pstmt.executeQuery();
	         
	         if(rs.next()) {
	            count = rs.getInt("cnt");
	         }
	      }catch(SQLException e){
	    	  e.printStackTrace();
	      }finally {
	    	  if(rs!=null) try {rs.close();} catch(SQLException e) {}
				if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
				if(conn!=null) try {conn.close();} catch(SQLException e) {}
			}
	      
		return count;
	 }

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		// (Key값 정보 ==> 회원ID(memid), 수정할 컬럼명(field), 수정할 데이터(data)
		try {
			conn = DBUtil3.getConnection();
			String sql = " update mymember set "+paramMap.get("field") +"= ? where mem_id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, paramMap.get("data"));
			pstmt.setString(2, paramMap.get("memid"));
		
			logger.info("PreparedStatement객체 생성...");
			logger.debug("실행 SQl ==> "+sql);
			logger.info("사용 데이터 ==> ["+paramMap.get("field") + ", "+ paramMap.get("data")
										+"," + paramMap.get("memid") + "]");
			
			cnt = pstmt.executeUpdate();
			logger.info("실행 작업 성공!!!");
			

		} catch (SQLException e) {
			// TODO: handle exception
		}finally {
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
		return cnt;
	}
	

}
