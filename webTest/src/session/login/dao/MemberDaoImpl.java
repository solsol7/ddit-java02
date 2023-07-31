package session.login.dao;

import org.apache.ibatis.session.SqlSession;

import session.login.vo.MemberVO;
import util.MybatisUtil;

public class MemberDaoImpl implements IMemberDao{

	private static MemberDaoImpl dao;
	
	private MemberDaoImpl() {}
	
	public static MemberDaoImpl getInstance() {
		if(dao==null) dao=new MemberDaoImpl();
		return dao;
	}
	
	@Override
	public MemberVO getMemberLogin(MemberVO memVo) {
		SqlSession session = null;
		MemberVO LoginMemVo = null;		//반환값이 저장될 변수
		
		try {
			session = MybatisUtil.getSqlSession();
			LoginMemVo = session.selectOne("member.getMemberLogin",memVo);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session !=null) session.close();
		}
		
		return LoginMemVo;
	}

}
