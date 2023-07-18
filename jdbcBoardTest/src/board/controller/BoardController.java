package board.controller;

import java.util.List;
import java.util.Scanner;

import board.service.BoardService;
import board.service.BoardServiceImpl;
import board.vo.BoardVO;

public class BoardController {
	private Scanner sc;
	private BoardService service;
	
	//생성자
	public BoardController() {
		service = BoardServiceImpl.getInstance();
		sc = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		new BoardController().boardStart();

	}

	public void boardStart() {
		String searchTitle = null;
		while(true){
			int choice = displayMenu(searchTitle);
			switch (choice) {
			case 1:		//새글 작성
				insertBoard();
				searchTitle = null;
				break;
			case 2:		//게시글 보기
				viewBoard();
				searchTitle = null;
				break;
			case 3:		//검색
				searchTitle = searchBoard();
				break;
			case 0:		//작업 끝
				System.out.println();
				System.out.println("게시판 프로그램 종료...");
				return;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시 입력하세요...");
			}
		}
	}
	//검색할 제목을 입력받아 반환하는 메서드
	private String searchBoard() {
		System.out.println();
		sc.nextLine();		//버퍼 비우기
		System.out.println("검색 작업");
		System.out.println("--------------------------------------");
		System.out.print("검색할 제목 입력 >> ");
		return sc.nextLine();
		
	}
	
	//게시글 보기
	private void viewBoard() {
		System.out.println();
		System.out.print("보기를 원하는 게시글 번호 입력 >> ");
		int boardNo = sc.nextInt();
		
		BoardVO boardVo = service.getBoard(boardNo);
		
		if(boardVo == null) {
			System.out.println(boardNo + "번의 게시글이 존재하지 않습니다...");
			return;
		}
		
		System.out.println();
		System.out.println(boardNo + "번 글 내용");
		System.out.println("-------------------------------------------");
		System.out.println("제  목 : "+boardVo.getBoard_title());
		System.out.println("작성자 : "+boardVo.getBoard_writer());
		System.out.println("내  용 : "+boardVo.getBoard_content());
		System.out.println("작성일 : "+boardVo.getBoard_date());
		System.out.println("조회수: "+boardVo.getBoard_cnt());
		System.out.println("-------------------------------------------");
		
		System.out.println("메뉴 : 1.수정	2.삭제	3.리스트로 가기");
		System.out.print("작업 선택 >> ");
		int num = sc.nextInt();
		
		switch (num) {
		case 1:		//수정
			updateBoard(boardNo);
			break;
		case 2:		//삭제
			deleteBoard(boardNo);
			break;
		case 3:		//리스트로 가기
			return;

		default:
			break;
		}
	}
	//삭제작업
	private void deleteBoard(int boardNo) {
		int cnt = service.deleteBoard(boardNo);
		if(cnt>0) {
			System.out.println(boardNo + "번 글이 삭제되었습니다...");
		}else {
			System.out.println(boardNo + "번 글의 삭제 작업 실패~~~");
		}
	}
	
	
	//수정 작업
	private void updateBoard(int boardNo) {
		System.out.println();
		sc.nextLine();		//입력 버퍼 비우기
		System.out.println("수정 작업 하기");
		System.out.println("---------------------------------------------");
		System.out.print("제  목 : ");
		String newTitle = sc.nextLine();
		
		System.out.print("내  용 : ");
		String newContent = sc.nextLine();
		
		//입력한 값들을 VO에 저장한다.
		
		BoardVO boardVo = new BoardVO();
		boardVo.setBoard_no(boardNo);
		boardVo.setBoard_title(newTitle);
		boardVo.setBoard_content(newContent);
		
		int cnt = service.updateBoard(boardVo);
		
		if(cnt>0) {
			System.out.println(boardNo + "번 글이 수정되었습니다...");
		}else {
			System.out.println(boardNo + "번 글의 수정 작업 실패~~~");
		}
		
	}
	
	
	//새글 작성
	private void insertBoard() {
		System.out.println();
		
		sc.nextLine();		//입력 버퍼 비우기
		System.out.println("새글 작성하기");
		System.out.println("---------------------------------------------------");
		System.out.print("제  목 : ");
		String title = sc.nextLine();
		System.out.print("작성자 : ");
		String writer = sc.nextLine();
		System.out.print("내  용 : ");
		String content = sc.nextLine();
		
		//입력한 값을 VO에 저장하기
		BoardVO boardVo =  new BoardVO();
		boardVo.setBoard_title(title);
		boardVo.setBoard_writer(writer);
		boardVo.setBoard_content(content);
		
		int cnt = service.insertBoard(boardVo);
		
		if(cnt>0) {
			System.out.println("새 글이 추가되었습니다...");
		}else {
			System.out.println("새 글 추가 실패~~~");
		}
	}
	
	//게시판 목록을 보여주고 메뉴를 나타내며 사용자가 입력한 작업 번호를 반환하는 메서드
	private int displayMenu(String searchTitle) {
		System.out.println();
		System.out.println("-------------------------------------------------");
		System.out.println("NO		제목			작성자			조회수");
		System.out.println("-------------------------------------------------");
		
		List<BoardVO> boardList = null;
		if(searchTitle ==null) {
			boardList = service.getAllBoard();
		}else {
			boardList = service.getSearchBoard(searchTitle);
		}
		if(boardList==null || boardList.size()==0) {
			System.out.println("출력할 게시글이 하나도 없습니다...");
		}else {
			for(BoardVO boardVo : boardList) {
				System.out.println(boardVo.getBoard_no()+"\t"+boardVo.getBoard_title()
				+"\t"+boardVo.getBoard_writer()+"\t"+boardVo.getBoard_cnt());
			}
		}
		System.out.println("-------------------------------------------------");
		System.out.println("메뉴 : 1.새글작성		2.게시글보기		3.검색		0.작업끝");
		System.out.print("작업 선택 >> ");
		return sc.nextInt();
	}
	

}
