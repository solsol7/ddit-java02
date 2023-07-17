package mvc.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import mvc.service.IMemberService;
import mvc.service.MemberServiceImpl;
import mvc.vo.MemberVO;

public class MemberController {
	private Scanner sc;
	private IMemberService service; // Service객체가 저장될 변수 선언

	// 생성자
	public MemberController() {
		sc = new Scanner(System.in);
		service = MemberServiceImpl.getInstance();
	}

	public static void main(String[] args) {
		MemberController m = new MemberController();
		m.startMember();
	}

	public void startMember() {
		while (true) {
			int choice = displayMenu();
			System.out.println("----------------------------------------------");
			switch (choice) {
			case 1:
				insertMember();
				break; // 추가
			case 2:
				deleteMember();
				break; // 삭제
			case 3:
				updateMember();
				break; // 수정
			case 4:
				displayAllMember();
				break; // 전체출력
			case 5 : updateMember2(); break;
			case 0:
				System.out.println("회원 관리 작업을 마칩니다...");
				return;
			default:
				System.out.println("번호를 잘못 입력했습니다. 다시 입력하세요...");
			}
		}
	}

	// 전체 회원 출력
	public void displayAllMember() {
		System.out.println();

		// Service객체를 통해서 전체 회원목록을 가져온다.
		List<MemberVO> memList = service.getAllMember();

		System.out.println();
		System.out.println("----------------------------------------------------------------");
		System.out.println("ID	이름	비밀번호	전화번호		주소");
		System.out.println("----------------------------------------------------------------");

		if (memList == null || memList.size() == 0) {
			System.out.println(" 등록된 회원정보가 하나도 없습니다...");
		} else {
			// List에 저장된 데이터 갯수만큼 반복해서 데이터를 출력한다.
			for (MemberVO memVo : memList) {
				String id = memVo.getMem_id();
				String name = memVo.getMem_name();
				String pass = memVo.getMem_pass();
				String tel = memVo.getMem_tel();
				String addr = memVo.getMem_addr();

				System.out.println(id + "\t" + name + "\t" + pass + "\t" + tel + "\t" + addr);
			}

		}

		System.out.println("----------------------------------------------------");
	}

	// 회원 정보를 삭제하는 메서드
	private void deleteMember() {
		System.out.println();
		System.out.println("삭제할 회원 정보를 입력하세요...");
		System.out.print("회원ID >> ");
		String memId = sc.next();

		int cnt = service.deleteMember(memId);

		if (cnt > 0) {
			System.out.println("회원ID가 " + memId + "인 회원 정보 삭제 완료!!!");
		} else {
			System.out.println("회원 정보 삭제 실패!!!");
		}

	}

	// 회원 정보 전체항목 수정
	public void updateMember() {
		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요...");
		System.out.print("회원ID >> ");
		String memId = sc.next();

		int count = service.getMemberCount(memId);
		if (count == 0) { // 없는 회원이면...
			System.out.println(memId + "은(는) 없는 회원ID 입니다...");
			System.out.println("수정 작업을 종료합니다...");
			return;
		}

		System.out.println();
		System.out.println("새로운 비밀번호 >> ");
		String newMemPass = sc.next();

		System.out.println("새로운 회원이름 >> ");
		String newMemName = sc.next();

		System.out.println("새로운 전화번호 >> ");
		String newMemTel = sc.next();

		sc.nextLine(); // 버퍼 비우기
		System.out.println("새로운 회원주소 >> ");
		String newMemAddr = sc.next();

		// 수정할 데이터를 VO객체에 저장한다.
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(memId);
		memVo.setMem_id(newMemPass);
		memVo.setMem_id(newMemName);
		memVo.setMem_id(newMemTel);
		memVo.setMem_id(newMemAddr);

		int cnt = service.updateMember(memVo);

		if (cnt > 0) {
			System.out.println(memId + " 회원 정보 수정 완료!!!");
		} else {
			System.out.println(memId + "회원 정보 수정 실패!!!");
		}
	}
	

	public void updateMember2() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요...");
		System.out.print("회원ID >> ");
		String memId = sc.next();
		
		int count = service.getMemberCount(memId);
		if(count==0) {
			System.out.println(memId + "은(는) 없는 회원ID 입니다...");
			System.out.println("수정 작업을 종료합니다...");
			 return;
		}
		
		int num;	//수정할 항목 번호가 저장될 변수
		String updateField = null;	//수정할 컬럼명이 저장될 변수
		String updateTitle = null;	//변경할 데이터를 입력할 때 출력할 메시지가 저장될 변수
		do {
			System.out.println();
			System.out.println("수정할 항목을 선택하세요...");
			System.out.println("1.비밀번호	2.회원이름	3.전화번호	4.회원주소");
			System.out.println("-------------------------------------");
			System.out.print("수정 항목 선택 >> ");
			num = sc.nextInt();
			
			switch(num) {
			case 1 : updateField = "mem_pass"; updateTitle = "비밀번호"; break;
			case 2 : updateField = "mem_name"; updateTitle = "회원이름"; break;
			case 3 : updateField = "mem_tel"; updateTitle = "전화번호"; break;
			case 4 : updateField = "mem_addr"; updateTitle = "회원주소"; break;
			default : System.out.println("수정 항목을 잘못 선택했습니다...");
					System.out.println("다시 선택하세요...");
			}
		}while(num<1 || num>4);
		
		sc.nextLine();
		System.out.println();
		System.out.print("새로운 "+updateTitle + " >> ");
		String updateData = sc.nextLine();
		
		//수정할 정보를 Map에 추가한다.
		// (Key값 정보 ==> 회원ID(memid), 수정할 컬럼명(field), 수정할 데이터(data) ) 
		Map<String, String> paramMap = new HashMap<String, String>();
		
		paramMap.put("memid", memId);
		paramMap.put("field", updateField);
		paramMap.put("data", updateData);
		
		int cnt = service.updateMember2(paramMap);
		
		if (cnt > 0) {
			System.out.println(memId + " 회원 정보 수정 완료!!!");
		} else {
			System.out.println(memId + " 회원 정보 수정 실패!!!");
		}
	}

	// 회원 삭제
	public void insertMember() {
		System.out.println();
		System.out.println("추가할 회원 정보를 입력하세요...");

		int count;
		String memId = null; // 회원 ID가 저장될 변수
		do {
			System.out.print("회원 ID >> ");
			memId = sc.next();
			count = service.getMemberCount(memId);

			if (count > 0) {
				System.out.println(memId + "는(은) 이미 등록된 회원ID입니다...");
				System.out.println("다른 회원ID를 입력하세요...");
				System.out.println();
			}
		} while (count > 0);

		System.out.print("비밀번호 >> ");
		String memPass = sc.next();

		System.out.print("회원이름 >> ");
		String memName = sc.next();

		System.out.print("전화번호 >> ");
		String memTel = sc.next();

		System.out.print("회원주소 >> ");
		sc.nextLine(); // 입력 버퍼 비우기
		String memAddr = sc.nextLine();

		// 입력 받은 insert할 데이터를 VO객체에 저장한다.
		MemberVO memVo = new MemberVO();

		memVo.setMem_id(memId);
		memVo.setMem_pass(memPass);
		memVo.setMem_name(memName);
		memVo.setMem_tel(memTel);
		memVo.setMem_addr(memAddr);

		int cnt = service.insertMember(memVo);

		if (cnt > 0) {
			System.out.println(memId + "회원 정보 insert 성공!!!");
		} else {
			System.out.println(memId + "회원 정보 insert 실패~~~");
		}

	}

	// 메뉴를 출력하고 작업 번호를 입력 받아 반환하는 메서드
	public int displayMenu() {
		System.out.println();
		System.out.println("1. 자료 추가	");
		System.out.println("2. 자료 삭제	");
		System.out.println("3. 자료 수정	");
		System.out.println("4. 전체 자료 출력");
		System.out.println("5. 개별 항목 수정");
		System.out.println("0. 작업 끝");
		System.out.println("--------------------------------");
		System.out.print("작업 번호 입력 >> ");
		return sc.nextInt();

	}

}
