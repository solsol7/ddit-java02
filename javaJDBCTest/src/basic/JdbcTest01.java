package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//JDBC(Java DataBase Connectivity) 라이브러리를 이용한 DB자료 처리하기
public class JdbcTest01 {
/*
	JDBC를 이용한 데이터베이스 처리 순서
	1. 드라이버 로딩 ==> JDBC라이브러리를 사용할 수 있게 메모리로 읽어 들이는 작업
	   Class.forName("oracle.jdbc.driver.OracleDriver");
	   (JDBC API버전 4이상에서는 getConnection()메서드에서 자동으로 로딩해주기 때문에 이 단계는 생략할 수 있다.)
	   		--> 그렇지만 생략하지 않고 사용할 예정
	2. DB에 접속하기 ==> 접속이 완료되면 Connection객체가 반환된다. (Connection -> 네트워크에서 소켓이랑 비슷)
	   DriverManager.getConnection()메서드를 이용한다.
	3. 질의 하기 ==> SQL문장을 DB서버로 보내서 실행 결과를 얻어온다.
	   (Statement객체나 PreparedStatement객체를 이용하여 작업한다.)
	4. 결과 처리하기 ==> 질의 결과를 받아서 원하는 작업을 수행한다.
	   1) SQL문이 select문일 때 select한 결과가 ResultSet객체에 저장되어 반환된다.
	   2) SQL문이 select문이 아닐 때에는 정수값이 반환된다. (insert문, update문, delete문 등)
	   	 (정수값은 보통 작업에 성공한 레코드 수를 의미한다.)
	5. 사용한 자원을 반납한다. ==> close()메서드를 이용해서 반납한다.
	
 */
	public static void main(String[] args) {
		//DB작업에 필요한 변수 선언
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			//1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. DB연결 ==> Connection객체 생성
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "pc16", "java");
					//"jdbc:oracle:thin:@DB서버IP주소:포트번호:SID", user, password
			//3. 질의
			// 3-1. SQL문 작성
			String sql = "select * from lprod";
			
			// 3-2. Statement객체 생성 ( 또는 PreparedStatement객체 생성)
			//		==> SQL문을 서버로 보내서 처리한 결과를 얻어오는 객체로 Connection객체를 이용하여 생성한다.
			stmt = conn.createStatement();
			
			// 3-3. SQL문을 DB서버로 보내서 처리한 결과를 얻어온다.
			//		(실행한 SQL문이 select문이기 때문에 결과가 ResultSet객체에 저장되어 반환된다.
			rs = stmt.executeQuery(sql);
			
			//4. 결과 처리하기 ==> 한 레코드씩 화면에 출력하기
			// ResultSet객체에 저장된 데이터를 차례로 꺼내오려면 반복문과 next()메서드를 이용한다.
			System.out.println("== 쿼리문 처리 결과 ==");
			
			//ResultSet객체의 next()메서드 ==> ResultSet객체의 데이터를 가리키는 포인터를
			//		다음 번째 레코드 위치로 이동 시키고 그 곳에 데이터가 있으면 true, 없으면 false를 반환한다.
			while(rs.next()) {
				// 포인터가 가리키는 위치의 자료를 가져오는 방법
				// 형식1) ResultSet객체.get자료형이름("컬럼명 또는 컬럼의Alias명")
				// 형식2) ResultSet객체.get자료형이름(컬럼번호) ==> 컬럼번호는 1번부터 시작한다.
				System.out.println("LPROD_ID : " + rs.getInt("LPROD_ID"));
				System.out.println("LPROD_GU : " + rs.getString(2));
				System.out.println("LPROD_NM : " + rs.getString(3));
				System.out.println("-----------------------------------------");
				
			}
					
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) try {rs.close();}catch(SQLException e) {}
			if(stmt!=null) try {stmt.close();}catch(SQLException e) {}
			if(conn!=null) try {conn.close();}catch(SQLException e) {}
		}

	}

}
