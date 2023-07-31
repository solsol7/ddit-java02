package session.login.service;

import session.login.dao.IMemberDao;
import session.login.dao.MemberDaoImpl;
import session.login.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {

	private IMemberDao dao;
	
	private static MemberServiceImpl service;
	
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}
	
	public static MemberServiceImpl getInstance() {
		if(service==null) service = new MemberServiceImpl();
		return service;
	}
	
	@Override
	public MemberVO getMemberLogin(MemberVO memVo) {
		return dao.getMemberLogin(memVo);
	}

}
