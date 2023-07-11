package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/*
	LPROD테이블에 새로운 데이터 추가하기
	
	Lprod_gu와 Lprod_nm은 직접 입력 받아서 처리하고,
	Lprod_id는 현재의 Lprod_id 중에서 제일 큰 값보다 1 크게 한다.
	
	입력받은 Lprod_gu가 이미 등록되어 있으면 다시 입력 받아서 처리한다.
 */
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
			loop : while (true) {
				System.out.print("Lprod_gu 입력 >> ");
				param1 = sc.nextLine();
				pstmt.setString(1, param1);
				rs = pstmt.executeQuery();
				if(!rs.next()) {
					break loop;
				}else {
					System.out.println("중복되는 코드입니다.");
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
