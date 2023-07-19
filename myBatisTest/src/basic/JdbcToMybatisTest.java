package basic;

import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
JdbcTest05 클래스의 기능을 Mybatis용으로 변경하시오.

mapper 파일명 : jdbc-mapper.xml

LPROD테이블에 새로운 데이터 추가하기

Lprod_gu와 Lprod_nm은 직접 입력 받아서 처리하고,
Lprod_id는 현재의 Lprod_id 중에서 제일 큰 값보다 1 크게 한다.

입력받은 Lprod_gu가 이미 등록되어 있으면 다시 입력 받아서 처리한다.
*/
public class JdbcToMybatisTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Reader rd = null;
		SqlSessionFactory sqlSessionFactory = null;
		
		try {
			rd = Resources.getResourceAsReader("mybatis/config/mybatis-config.xml");
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(rd);
			
		} catch (Exception e) {
			System.out.println("myBatis 초기화 실패!!");
			e.printStackTrace();
		}finally {
			if(rd!=null) try {rd.close();}catch(IOException e) {}
		}
		
		System.out.print("추가할 Lprod_gu 입력 >> ");
		String lprodGu = sc.next();
		
		SqlSession sqlSession = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			sqlSession.select("searchGU", lprodGu);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
