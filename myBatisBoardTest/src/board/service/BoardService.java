package board.service;

import java.util.List;
import java.util.Map;

import vo.BoardVO;



public interface BoardService {
	/**
	 * BoardVO객체에 저장된 데이터를 DB에 insert하는 메서드
	 * 
	 * @param boardVo insert할 데이터가 저장된 BoardVO객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int insertBoard(BoardVO boardVo);
	
	/**
	 * 게시글 번호를 매개변수로 받아서 해당 게시글을 삭제하는 메서드
	 * 
	 * @param boardNo 삭제할 게시글 번호
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int deleteBoard(int boardNo);
	
	/**
	 * 하나의 BoardVO자료를 이용하여 게시글을 update하는 메서드
	 * @param boardVo update할 게시글 정보가 저장된 JdbcBoardVO객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int updateBoard(BoardVO boardVo);
	
	/**
	 * 게시물 전체 데이터를 가져와 List에 담아서 반환하는 메서드
	 * 
	 * @return BoardVO객체를 저장하고 있는 List객체
	 */
	public List<BoardVO> getAllBoard();
	
	/**
	 * 게시글 번호를 매개변수로 받아서 해당 게시글 정보를 가져와 반환하는 메서드
	 * 
	 * @param boardNo 가져올 게시글 번호
	 * @return 게시글 번호에 맞는 자료가 있으면 해당 게시글 정보를 담고 있는 JdbcBoardVO객체,
	 * 			자료가 없으면 null 반환
	 */
	public BoardVO getBoard(int boardNo);
	
	/**
	 * 검색할 게시글 제목을 매개변수로 받아서 해당 게시글을 검색하는 메서드
	 * 
	 * @param title 검색할 게시글 제목
	 * @return 검색된 결과가 저장된 List객체
	 */
	public List<BoardVO> getSearchBoard(String title);
	
	/**
	 * 게시글 번호를 매개변수로 받아서 해당 게시글의 조회수를 증가시키는 메서드
	 * 
	 * @param boardNo 조회수를 증가할 게시글 번호
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int setCountIncrement(int boardNo);
	
	/*
	public void write(String title, String writer, String content);
	
	public Map<String, Object> read(int no);
	
	public Map<String, Object> search(String title);
	
	public int update(int no);
	
	public int delete(int no);
	*/
}
