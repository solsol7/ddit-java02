package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import board.util.DBUtil3;
import board.vo.BoardVO;

public class BoardDaoImpl implements BoardDao {

	private static BoardDaoImpl dao;
	private BoardDaoImpl() {}
	
	public static BoardDaoImpl getInstance() {
		if(dao ==null) dao = new BoardDaoImpl();
		return dao;
	}
	
	@Override
	public int insertBoard(BoardVO boardVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			conn = DBUtil3.getConnection();
			String sql = " insert into jdbc_board(board_no, board_title, board_writer, "
					+ " board_date, board_cnt, board_content) "
					+ " values(board_seq.nextval, ?, ?, sysdate, 0, ? ) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardVo.getBoard_title());
			pstmt.setString(2, boardVo.getBoard_writer());
			pstmt.setString(3, boardVo.getBoard_content());
			
			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null)try { pstmt.close(); } catch (SQLException e2) {}
			if(conn!=null)try { conn.close(); } catch (SQLException e2) {}
		}
		
		return cnt;
	}

	@Override
	public int deleteBoard(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			conn = DBUtil3.getConnection();
			String sql = " delete from jdbc_board where board_no = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null)try { pstmt.close(); } catch (SQLException e2) {}
			if(conn!=null)try { conn.close(); } catch (SQLException e2) {}
		}
		
		return cnt;
	}

	@Override
	public int updateBoard(BoardVO boardVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			conn = DBUtil3.getConnection();
			String sql = " update jdbc_board set "
					+ " board_title = ?, board_content = ?, board_date = sysdate "
					+ " where board_no = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardVo.getBoard_title());
			pstmt.setString(2, boardVo.getBoard_content());
			pstmt.setInt(3, boardVo.getBoard_no());
			
			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null)try { pstmt.close(); } catch (SQLException e2) {}
			if(conn!=null)try { conn.close(); } catch (SQLException e2) {}
		}
		
		return cnt;
	}

	@Override
	public List<BoardVO> getAllBoard() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> boardList = null;	//반환값이 저장될 변수
		
		try {
			conn = DBUtil3.getConnection();
			String sql = " select * from jdbc_board order by board_no desc ";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			boardList = new ArrayList<BoardVO>();	//List객체 생성
			while(rs.next()) {
				BoardVO boardVo = new BoardVO();	//VO객체 생성
				//VO객체에 DB에서 가져온 데이터 저장하기
				boardVo.setBoard_no(rs.getInt("board_no"));
				boardVo.setBoard_title(rs.getString("board_title"));
				boardVo.setBoard_writer(rs.getString("board_writer"));
				boardVo.setBoard_date(rs.getString("board_date"));
				boardVo.setBoard_cnt(rs.getInt("board_cnt"));
				boardVo.setBoard_content(rs.getString("board_content"));
				
				boardList.add(boardVo);		//List에 VO객체 추가
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null)try { rs.close(); } catch (SQLException e2) {}
			if(pstmt!=null)try { pstmt.close(); } catch (SQLException e2) {}
			if(conn!=null)try { conn.close(); } catch (SQLException e2) {}
		}
		
		return boardList;
	}

	@Override
	public BoardVO getBoard(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO boardVo = null;	//반환값이 저장될 변수
		
		try {
			conn = DBUtil3.getConnection();
			String sql = " select board_no, board_title, board_writer, "
					+ " to_char(board_date, 'yyyy_mm-dd') board_date, board_cnt, board_content  "
					+ " from jdbc_board where board_no = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			rs = pstmt.executeQuery();
		
			if(rs.next()) {
				boardVo = new BoardVO();	//VO객체 생성
				//VO객체에 DB에서 가져온 데이터 저장하기
				boardVo.setBoard_no(rs.getInt("board_no"));
				boardVo.setBoard_title(rs.getString("board_title"));
				boardVo.setBoard_writer(rs.getString("board_writer"));
				boardVo.setBoard_date(rs.getString("board_date"));
				boardVo.setBoard_cnt(rs.getInt("board_cnt"));
				boardVo.setBoard_content(rs.getString("board_content"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null)try { rs.close(); } catch (SQLException e2) {}
			if(pstmt!=null)try { pstmt.close(); } catch (SQLException e2) {}
			if(conn!=null)try { conn.close(); } catch (SQLException e2) {}
		}
		
		return boardVo;
	}

	@Override
	public List<BoardVO> getSearchBoard(String title) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVO> boardList = null;	//반환값이 저장될 변수
		
		try {
			conn = DBUtil3.getConnection();
			String sql = " select * from jdbc_board "
					+ " where board_title like '%'||?||'%' "
					+ " order by board_no desc ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			
			rs = pstmt.executeQuery();
			
			boardList = new ArrayList<BoardVO>();	//List객체 생성
			while(rs.next()) {
				BoardVO boardVo = new BoardVO();	//VO객체 생성
				//VO객체에 DB에서 가져온 데이터 저장하기
				boardVo.setBoard_no(rs.getInt("board_no"));
				boardVo.setBoard_title(rs.getString("board_title"));
				boardVo.setBoard_writer(rs.getString("board_writer"));
				boardVo.setBoard_date(rs.getString("board_date"));
				boardVo.setBoard_cnt(rs.getInt("board_cnt"));
				boardVo.setBoard_content(rs.getString("board_content"));
				
				boardList.add(boardVo);		//List에 VO객체 추가
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null)try { rs.close(); } catch (SQLException e2) {}
			if(pstmt!=null)try { pstmt.close(); } catch (SQLException e2) {}
			if(conn!=null)try { conn.close(); } catch (SQLException e2) {}
		}
		
		return boardList;
	}

	@Override
	public int setCountIncrement(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			conn = DBUtil3.getConnection();
			String sql = " update jdbc_board set "
					+ " board_cnt = board_cnt +1 "
					+ " where board_no = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			
			cnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null)try { pstmt.close(); } catch (SQLException e2) {}
			if(conn!=null)try { conn.close(); } catch (SQLException e2) {}
		}
		
		return cnt;
	}
	
}
