package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import util.DBUtil;

/*
	LPROD테이블에 새로운 데이터 추가하기
	
	Lprod_gu와 Lprod_nm은 직접 입력 받아서 처리하고,
	Lprod_id는 현재의 Lprod_id 중에서 제일 큰 값보다 1 크게 한다.
	
	입력받은 Lprod_gu가 이미 등록되어 있으면 다시 입력 받아서 처리한다.
 */
/*
public class JdbcTest05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "pc16", "java");

			String sql = " select * from LPROD where lprod_gu= ? ";
			pstmt = conn.prepareStatement(sql);
			String param1 ="";
			
			while (true) {
				System.out.print("Lprod_gu 입력 >> ");
				param1 = sc.nextLine();
				pstmt.setString(1, param1);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					System.out.println("중복되는 코드입니다.");
				}else {
					break;
				}
			}
			System.out.print("Lprod_nm 입력 >>");
			String param2 = sc.nextLine();
			
			String sql2 = " insert into lprod(Lprod_id, Lprod_gu, Lprod_nm)"
					+ " values((select max(lprod_id)+1 from lprod) , ?, ?) ";
			
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, param1);
			pstmt.setString(2, param2);
			
			int cnt = pstmt.executeUpdate();
			System.out.println("cnt : "+cnt);
			
		} catch (SQLException e) {
			// TODO: handle exception
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
*/

public class JdbcTest05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			/*
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","pc16","java");
			
			*/
			conn = DBUtil.getConnection();
			//Lprod_id는 현재의 Lprod_id 중에서 제일 큰 값보다 1 크게 한다.
			String sql = " select nvl(max(lprod_id),0)+1 maxid from lprod";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			int maxId = 0;
			if(rs.next()) {
				maxId = rs.getInt("maxId");
			}
			
			//-------------------------------------------------------
			//입력받은 Lprod_gu가 이미 등록되어 있으면 다시 입력 받아서 처리한다.
			String gu;		//입력 받은 상품 분류 코드가 저장될 변수
			int count = 0;	//입력한 상품 분류 코드의 갯수가 저장될 변수
			
			do {
				System.out.print("상품 분류 코드(LPROD_GU) 입력 >> ");
				gu = sc.next();
				
				String sql2 = " select count(*) cnt from lprod where lprod_gu = ? ";
				
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, gu);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					count = rs.getInt("cnt");
				}
				
				if(count>0) {
					System.out.println("입력한 상품 분류 코드 " + gu + "는 이미 등록된 코드입니다.");
					System.out.println("다시 입력하세요...");
					System.out.println();
				}
				
			}while(count>0);
			
			System.out.print("상품 분류명(LPORD_NM 입력 >> ");
			String nm = sc.next();
			
			String sql3 = " insert into lprod(lprod_id, lprod_gu, lprod_nm) "
					+ " values(?, ?, ?)";
			pstmt = conn.prepareStatement(sql3);
			pstmt.setInt(1, maxId);
			pstmt.setString(2, gu);
			pstmt.setString(3, nm);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt>0) {
				System.out.println("등록 성공~~~");
			}else {
				System.out.println("등록 실패!!!");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}
}
