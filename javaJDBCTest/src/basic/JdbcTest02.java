package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//문제) 사용자로부터 Lprod_id값을 입력 받아 입력한 값보다 Lprod_id가 큰 자료들을 출력하시오.
/*
public class JdbcTest02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","pc16","java");
			
			String sql = "select * from lprod where lprod_id > ?";
			pstmt = conn.prepareStatement(sql);
			System.out.print("Lprod_id 입력 >> ");
			int param = sc.nextInt();
			pstmt.setObject(1, param);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.print(rs.getInt("LPROD_ID")+"\t");
				System.out.print(rs.getString("LPROD_GU")+"\t");
				System.out.print(rs.getString("LPROD_NM")+"\t");
				System.out.println();
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
			if(pstmt!=null) try {pstmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
		

	}

}
*/

public class JdbcTest02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("LPROD_ID값 입력 >> ");
		int num = sc.nextInt();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","pc16","java");
			
			String sql = " select * from lprod where lprod_od > " +num;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println("==결과 출력==");
			while(rs.next()) {
				System.out.print(rs.getInt("LPROD_ID")+"\t");
				System.out.print(rs.getString("LPROD_GU")+"\t");
				System.out.print(rs.getString("LPROD_NM")+"\t");
				System.out.println();
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close();} catch(SQLException e) {}
			if(stmt!=null) try {stmt.close();} catch(SQLException e) {}
			if(conn!=null) try {conn.close();} catch(SQLException e) {}
		}
	}
	
}
