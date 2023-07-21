package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//JDBC드라이버를 로딩하고 Connection객체를 생성하여 반환하는 메서드로 구성된  class 작성하기
// (dbinfo.properties파일의 내용을 읽어와 설정하기)
public class DBUtil2 {
	private static Properties prop;		//Properties객체 변수 선언
	
	static {
		//초기화블럭
		//static안붙어있으면 인스턴스 초기화블럭
		//static붙어있으면 static초기화블럭
		//객체가 생성될 때 (new명령어로 생성할 때) 객체 생성하려면 클래스에 대한 정보를 알아야함
		//객체를 생성하기 전에 클래스에 대한 정보를 먼저 읽어옴
		//메소드 에리어 영역에 저장함
		//=> static초기화블럭은 클래스 정보를 읽어왕서 메소드 에리어에 저장할 때 실행되는 블럭  ==> 이 클래스를 사용할 때 백번을 사용하든 말든 맨 첫번째 사용할 때 실행됨,드라이버 로딩할 때 
		//실행될 때마다 드라이버에 로딩될 필요가 없음 - 한번만 메모리에 기억되면 되기 때문에
		//메소드 안에 같이 넣게되면 메소드를 호출할 때마다 이 작업을 계속 해야함
		
		//인스턴스 초기화블럭은 객체를 new라고하는 명령어로 생성할 때 생성자 바로 전에 실행됨
		prop = new Properties();	//Properties객체 생성
		File f = new File("res/config/dbinfo.properties");
		FileInputStream fin = null;
		
		try {
			fin = new FileInputStream(f);	//스트림 객체 생성
			prop.load(fin);
			
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName(prop.getProperty("driver"));
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!!!");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("입출력 오류...");
			System.out.println("드라이버 로딩 실패!!!");
			e.printStackTrace();
		}finally {
			if(fin!=null) try {fin.close();}catch(IOException e) {}
		}
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","pc16","java");
			conn = DriverManager.getConnection(
					prop.getProperty("url"),prop.getProperty("user"),prop.getProperty("pass"));
		} catch (SQLException e) {
			System.out.println("DB 연결 실패!!!");
		}
		return conn;
	}
}
