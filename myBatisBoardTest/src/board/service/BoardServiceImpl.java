package board.service;

import java.util.List;

import board.dao.BoardDao;
import board.dao.BoardDaoImpl;
import vo.BoardVO;


public class BoardServiceImpl implements BoardService {
	private BoardDao dao;
	
	private static BoardServiceImpl service;
	private BoardServiceImpl() {
		dao=BoardDaoImpl.getInstance();
	}
	
	public static BoardServiceImpl getInstance() {
		if(service==null) service = new BoardServiceImpl();
		return service;
	}
	
	@Override
	public int insertBoard(BoardVO boardVo) {
		return dao.insertBoard(boardVo);
	}

	@Override
	public int deleteBoard(int boardNo) {
		return dao.deleteBoard(boardNo);
	}

	@Override
	public int updateBoard(BoardVO boardVo) {
		return dao.updateBoard(boardVo);
	}

	@Override
	public List<BoardVO> getAllBoard() {
		return dao.getAllBoard();
	}

	@Override
	public BoardVO getBoard(int boardNo) {
		int cnt = dao.setCountIncrement(boardNo);	//조회수 증가
		if(cnt==0) { //조회수 증가 실패!!
			return null;
		}
		return dao.getBoard(boardNo);
	}

	@Override
	public List<BoardVO> getSearchBoard(String title) {
		return dao.getSearchBoard(title);
	}

	@Override
	public int setCountIncrement(int boardNo) {
		return dao.setCountIncrement(boardNo);
	}

}
