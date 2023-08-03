package member.service;

import java.util.List;

import member.vo.MemberVO;

public interface IMemberService {
	public List<MemberVO> getAllMember();
	
	public int insertMember(MemberVO vo);
	
	public int updateMember(MemberVO vo);
	
	public MemberVO getMember(String mem_id);
	
	public int deleteMember(String mem_id);
}
