package basic;

import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import util.MybatisUtil;
import vo.LprodVO;

/*
JdbcTest05 클래스의 기능을 Mybatis용으로 변경하시오.

mapper 파일명 : jdbc-mapper.xml

LPROD테이블에 새로운 데이터 추가하기

Lprod_gu와 Lprod_nm은 직접 입력 받아서 처리하고,
Lprod_id는 현재의 Lprod_id 중에서 제일 큰 값보다 1 크게 한다.

입력받은 Lprod_gu가 이미 등록되어 있으면 다시 입력 받아서 처리한다.
*/
/*
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
		} finally {
			if (rd != null) try {rd.close();} catch (IOException e) {}
		}
		String lprodGu = "";
		SqlSession sqlSession = null;
		int result = 0;
		
		try {
			while (true) {
				System.out.print("추가할 Lprod_gu 입력 >> ");
				lprodGu =  sc.next();
				sqlSession = sqlSessionFactory.openSession();
				result = sqlSession.selectOne("jdbcLprod.searchGu", lprodGu);

				if (result > 0) {
					System.out.println("이미 존재하는 Lprod_gu입니다. 다시 입력하세요.");
				}else {
					break;
				}
			}
			
			int getLprodId = sqlSession.selectOne("jdbcLprod.searchId");
			System.out.print("Lprod_nm 입력 >> ");
			String lprodNm = sc.next();
			
			LprodVO lvo = new LprodVO();
			lvo.setLprod_gu(lprodGu);
			lvo.setLprod_id(getLprodId);
			lvo.setLprod_nm(lprodNm);
			
			int cnt = sqlSession.insert("jdbcLprod.insertLprod", lvo);
			
			if(cnt>0) {
				sqlSession.commit();
				System.out.println("데이터 추가 성공!!!");
			}else {
				System.out.println("데이터 추가 실패...");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession!=null) sqlSession.close();
		}

	}

}
*/

public class JdbcToMybatisTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/*
		//myBatis 초기화 작업
		Reader rd = null;
		SqlSessionFactory sqlSessionFactory = null;
		try {
			rd = Resources.getResourceAsReader("mybatis/config/mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(rd);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rd!=null) try {rd.close();}catch(IOException e) {}
		}
		*/
		//--------------------------------------------
		
		
		SqlSession session = null;
		try {
			
			session = MybatisUtil.getSqlSession();
			
			//Lprod_id는 현재의 Lprod_id 중에서 제일 큰 값보다 1 크게 한다.
			int nextId = session.selectOne("jdbc.getMaxid");
			
			String gu;
			
			int count = 0;	//Lprod_gu의 개수가 저장될 변수
			do {
				System.out.print("상품 분류 코드(Lprod_gu) 입력 >> ");
				gu = sc.next();
				
				count = session.selectOne("jdbc.getLprodguCount", gu);
				
				if(count>0) {
					System.out.println("입력한 상품 분류 코드 " + gu + "는 이미 등록된 코드입니다.");
					System.out.println("다시 입력하세요...");
					System.out.println();
				}
				
			}while(count>0);
			
			System.out.print("상품 분류명(Lprod_nm) 입력 >> ");
			String nm = sc.next();
			
			//insert할 자료들을 VO객체에 저장한다.
			LprodVO lvo = new LprodVO();
			lvo.setLprod_id(nextId);
			lvo.setLprod_gu(gu);
			lvo.setLprod_nm(nm);
			
			int cnt = session.insert("jdbc.insertLprod", lvo);
			
			if(cnt>0) {
				session.commit();
				System.out.println("등록 성공!!!");
			}else {
				System.out.println("등록 실패...");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
	}
}
