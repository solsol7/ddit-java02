package member.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import util.MybatisUtil;
import vo.MemberVO;

public class IMemberDaoImpl implements IMemberDao {

	private static IMemberDaoImpl dao;
	private IMemberDaoImpl() {};
	
	public static IMemberDaoImpl getInstance() {
		if(dao==null) dao= new IMemberDaoImpl();
		return dao;
	}
	
	
	
	
	@Override
	public int insertMember(MemberVO memVo) {
		SqlSession session=null;
		int cnt = 0;
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.insert("member.insertMember",memVo);
		if(cnt>0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		SqlSession session=null;
		int cnt = 0;
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.insert("member.deleteMember",memId);
		if(cnt>0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		return cnt;
	}

	@Override		
	public int updateMember(MemberVO memVo) {
		SqlSession session=null;
		
		int cnt = 0;
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.insert("member.updateMember",memVo);
		if(cnt>0) session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMember() {
		SqlSession session=null;
		List<MemberVO> list=null;
		try {
			session = MybatisUtil.getSqlSession();
			list = session.selectList("member.getAllMember");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		
		return list;
	}

	@Override
	public int getMemberCount(String memId) {
		SqlSession session=null;
		int cnt = 0;
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.selectOne("member.getMemberCount",memId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		
		return cnt;
	}

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		SqlSession session = MybatisUtil.getSqlSession();
		int cnt = 0;
		try {
			cnt = session.update("member.updateMember2",paramMap);
			if(cnt>0) session.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(session!=null) session.close();
		}
		
		return cnt;
	}

}
