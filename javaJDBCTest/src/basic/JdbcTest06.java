package basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import util.DBUtil;

/*
	회원 관리를 하는 프로그램을 작성하시오 (MYMEMBER테이블 이용)
	
	아래의 메뉴의 기능을 모두 구현하시오. (CRUD기능 구현하기)
	메뉴 예시)
		1. 자료 추가			--> insert(C)
		2. 자료 삭제			--> delete(D)
		3. 자료 수정			--> update(U)
		4. 전체 자료 출력		--> select(R)
		0. 작업 끝
	------------------------
	조건)
	1) 자료 추가 기능에서 '회원ID'는 중복되지 않는다.(중복되면 다시 입력받는다.)
	2) 자료 삭제는 '회원ID'를 입력 받아 처리한다.
	3) 자료 수정에서 '회원ID'는 변경되지 않는다.
	
 */
public class JdbcTest06 {
	Scanner sc = new Scanner(System.in);
	Connection conn = DBUtil.getConnection();
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;

	public static void main(String[] args) {
		JdbcTest06 j = new JdbcTest06();
		j.start();
	}

	public String displayMenu() {
		System.out.println("----------------------------------------------");
		System.out.println("1. 자료 추가	");
		System.out.println("2. 자료 삭제	");
		System.out.println("3. 자료 수정	");
		System.out.println("4. 전체 자료 출력");
		System.out.println("0. 작업 끝");
		System.out.println("----------------------------------------------");
		System.out.print("메뉴 선택 >> ");
		return sc.nextLine();

	}

	public void start() {
		
		loop: while (true) {
			String choice = displayMenu();
			System.out.println("----------------------------------------------");
			switch (choice) {
			case "1": insert(); break;
			case "2": delete(); break;
			case "3": update(); break;
			case "4": select(); break;
			case "0":
				System.out.println("작업을 종료합니다.");
				break loop;
			default:
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

	public void insert() {
		try {
			String sql1 = " select * from mymember where mem_id= ? ";

			String mem_id = "";
			while (true) {
				System.out.print("회원ID 입력 >> ");
				mem_id = sc.nextLine();
				pstmt = conn.prepareStatement(sql1);
				pstmt.setString(1, mem_id);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					System.out.println("중복되는 ID입니다.");
				} else
					break;
			}

			System.out.print("회원 이름 입력 >> ");
			String mem_name = sc.nextLine();
			System.out.print("회원 비밀번호 입력 >> ");
			String mem_pass = sc.nextLine();
			System.out.print("회원 전화번호 입력 >> ");
			String mem_tel = sc.nextLine();
			System.out.print("회원 주소 입력 >> ");
			String mem_addr = sc.nextLine();

			String sql2 = " insert into MYMEMBER(MEM_ID, MEM_NAME, MEM_PASS, MEM_TEL, MEM_ADDR) "
					+ " values(?, ?, ?, ?, ?) ";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, mem_id);
			pstmt.setString(2, mem_name);
			pstmt.setString(3, mem_pass);
			pstmt.setString(4, mem_tel);
			pstmt.setString(5, mem_addr);

			int cnt = pstmt.executeUpdate();
			if (cnt > 0) {
				System.out.println("회원 정보 등록 완료!!!");
			} else {
				System.out.println("회원 정보 등록 실패!!!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete() {
		System.out.print("삭제할 회원ID 입력 >> ");
		String mem_id = sc.nextLine();
		try {
			String sql1 = " select * from mymember where mem_id = ? ";
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, mem_id);
			rs = pstmt.executeQuery();
			if(!rs.next()) {
				System.out.println("존재하지 않는 회원 ID입니다.");
				return;
			}
			
			String sql2 = " delete mymember where mem_id = ? ";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, mem_id);
			
			int cnt = pstmt.executeUpdate();
			if(cnt > 0) {
				System.out.println("회원 정보 삭제 완료!!!");
			}else {
				System.out.println("회원 정보 삭제 실패!!!"); 
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}

	public void update() {
		System.out.print("수정할 회원 ID 입력 >> ");
		String mem_id = sc.nextLine();
		
		try {
			String sql1 = " select * from mymember where mem_id = ? ";
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, mem_id);
			rs = pstmt.executeQuery();
			if(!rs.next()) {
				System.out.println("존재하지 않는 회원ID입니다.");
				return;
			}
			System.out.println("회원정보");
			System.out.println("----------------------------------------------");
			System.out.println("ID\t비밀번호\t이름\t전화번호\t\t\t주소");
			System.out.print(rs.getString("mem_id")+"\t");
			System.out.print(rs.getString("mem_pass")+"\t");
			System.out.print(rs.getString("mem_name")+"\t");
			System.out.print(rs.getString("mem_tel")+"\t\t");
			System.out.print(rs.getString("mem_addr")+"\t");
			System.out.println();
			System.out.println("----------------------------------------------");
			
			System.out.println("1. 비밀번호");
			System.out.println("2. 이름");
			System.out.println("3. 전화번호");
			System.out.println("4. 주소");
			System.out.println("5. 전체수정");
			System.out.print("변경할 정보 >> ");
			
			String choice = sc.nextLine();
			String info="";
			switch (choice) {
			case "1": info = "mem_pass"; break;
			case "2": info = "mem_name"; break;
			case "3": info = "mem_tel"; break;
			case "4": info = "mem_addr"; break;
			case "5": updateAll(mem_id); return;
			default:
				System.out.println("잘못된 입력입니다.");
			}
			
			updateInfo(info, mem_id);
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public void updateInfo(String info, String mem_id) {
		System.out.print("변경할 정보 입력 >> ");
		String updateInfo = sc.nextLine();
		try {
			String sql = " update mymember set " + info + "='" + updateInfo+"'"
					+ "where mem_id = '"+mem_id+"'";
			stmt = conn.createStatement();
			int cnt = stmt.executeUpdate(sql);
			
			if(cnt>0) {
				System.out.println("정보 수정 완료!!!");
			}else {
				System.out.println("정보 수정 실패!!!");
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public void updateAll(String mem_id) {
		try {
			String sql = " update mymember set mem_pass = ?, mem_name=?, mem_tel=?, mem_addr =?"
					+ "where mem_id=? ";
			System.out.println("수정할 비밀번호 입력 : ");
			String mem_pass = sc.nextLine();
			System.out.println("수정할 이름 입력 : ");
			String mem_name = sc.nextLine();
			System.out.println("수정할 전화번호 입력 : ");
			String mem_tel = sc.nextLine();
			System.out.println("수정할 주소 입력 : ");
			String mem_addr = sc.nextLine();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem_pass);
			pstmt.setString(2, mem_name);
			pstmt.setString(3, mem_tel);
			pstmt.setString(4, mem_addr);
			pstmt.setString(5, mem_id);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				System.out.println("정보 수정 완료!!!");
			}else {
				System.out.println("정보 수정 실패!!!");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}

	public void select() {
		try {
			String sql = " select * from mymember ";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println("ID\t비밀번호\t이름\t전화번호\t\t\t주소");
			while(rs.next()) {
				System.out.print(rs.getString("mem_id")+"\t");
				System.out.print(rs.getString("mem_pass")+"\t");
				System.out.print(rs.getString("mem_name")+"\t");
				System.out.print(rs.getString("mem_tel")+"\t\t");
				System.out.print(rs.getString("mem_addr")+"\t");
				System.out.println();
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}
}
