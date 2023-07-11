package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//문제) Lprod_id값을 2개 입력 받아서 두 값 중 작은 값부터 큰 값까지의 데이터를 출력하시오.
/*
public class JdbcTest03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		System.out.print("첫번째 Lprod_id 입력 >> ");
		int param1 = sc.nextInt();
		System.out.print("두번째 Lprod_id 입력 >> ");
		int param2 = sc.nextInt();

		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","pc16","java");
			
			String sql = " select * from LPROD where LPROD_ID between ? and ? order by LPROD_ID asc ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, param1);
			pstmt.setObject(2, param2);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.print(rs.getInt("LPROD_ID")+"\t");
				System.out.print(rs.getString("LPROD_GU")+"\t");
				System.out.print(rs.getString("LPROD_NM")+"\t");
				System.out.println();
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}

	}

}
*/

public class JdbcTest03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 Lprod_id 입력 >> ");
		int num1 = sc.nextInt();
		System.out.print("두번째 Lprod_id 입력 >> ");
		int num2 = sc.nextInt();
		
		//int max = num1>num2 ? num1 : num2;
		//int min = num1 > num2 ? num2 : num1;
		int max = Math.max(num1, num2);
		int min = Math.min(num1, num2);
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","pc16","java");
			
			String sql = " select * from lprod where lprod_id >=" + min + "and lprod_id<= "+max; 
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.print(rs.getInt("LPROD_ID")+"\t");
				System.out.print(rs.getString("LPROD_GU")+"\t");
				System.out.print(rs.getString("LPROD_NM")+"\t");
				System.out.println();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
			if(stmt!=null) try {stmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		
		
	}
}
