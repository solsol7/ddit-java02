package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import board.util.DBUtil3;

public class BoardDaoImpl implements BoardDao {
	
	//새 글 작성
	@Override
	public void write(String title, String writer, String content) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt;
		
		try {
			conn = DBUtil3.getConnection();
			String sql = " insert into jdbc_board(board_no, board_title, board_writer, board_content, board_date)"
					+ " values(board_seq.nextval, ?, ?, ?, sysdate ) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, title);
			pstmt.setObject(2, writer);
			pstmt.setObject(3, content);
			
			cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				System.out.println("글쓰기 성공 !!");
			}else {
				System.out.println("글쓰기 실패!!");
			}

		} catch (SQLException e) {
			// TODO: handle exception
		}finally {
			if(pstmt!=null)try { pstmt.close(); } catch (SQLException e2) {}
			if(conn!=null)try { conn.close(); } catch (SQLException e2) {}
		}
	}
	
	//게시글 보기
	@Override
	public Map<String, Object> read(int no) {
		
		return null;
	}

	//검색
	@Override
	public Map<String, Object> search(String title) {
		
		return null;
	}

	//수정
	@Override
	public int update(int no) {
		
		return 0;
	}

	//삭제
	@Override
	public int delete(int no) {
		
		return 0;
	}

}
