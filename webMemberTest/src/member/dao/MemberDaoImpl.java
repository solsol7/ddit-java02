package member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import member.vo.MemberVO;
import util.MybatisUtil;

public class MemberDaoImpl implements IMemberDao{

	private static MemberDaoImpl dao;
	
	private MemberDaoImpl() {}
	
	public static MemberDaoImpl getInstance() {
		if(dao==null) dao = new MemberDaoImpl();
		return dao;
	}
	
	@Override
	public List<MemberVO> getAllMember() {
		SqlSession session = null;
		List<MemberVO> list = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			list = session.selectList("member.getAllMember");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			if(session !=null) session.close();
		}
		
		return list;
	}

	@Override
	public int insertMember(MemberVO vo) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.insert("member.insertMember", vo);
			if(cnt>0) {
				session.commit();				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session !=null) session.close();
		}
		
		return cnt;
	}

	@Override
	public int updateMember(MemberVO vo) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session= MybatisUtil.getSqlSession();
			cnt = session.update("member.updateMember", vo);
			if(cnt>0) {
				session.commit();				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session !=null) session.close();
		}
		
		return cnt;
	}

	@Override
	public MemberVO getMember(String mem_id) {
		SqlSession session = null;
		MemberVO vo = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			vo = session.selectOne("member.getMember", mem_id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			if(session !=null) session.close();
		}
		
		return vo;
	}

	@Override
	public int deleteMember(String mem_id) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.insert("member.deleteMember", mem_id);
			if(cnt>0) {
				session.commit();				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			if(session !=null) session.close();
		}
		
		return cnt;
	}

}
