package mvc.service;

import java.util.List;

import mvc.vo.MemberVO;

/**
 * Service객체는 DAO에 만들어진 메서드를 원하는 작업에 맞게 호출하여 결과를 받아오고
 * 받아온 결과 자료를 Controller에게 보내주는 역할을 한다.
 * 
 * 보통은 Service의 메서드 구조는 DAO의 메서드 구조와 같게 작성한다.
 * 
 * @author PC-16
 *
 */
public interface IMemberService {
	/**
	 * MemberVO객체를 인수값으로 받아서 MemberVO에 저장된 데이터를 DB에 insert하는 메서드
	 * 
	 * @param memVo insert할 데이터가 저장된 MemberVO객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int insertMember(MemberVO memVo);	//데이터가 여러개면 여러개를 뭉쳐서 매개변수 줄이기

	/**
	 * 회원ID를 매개변수로 받아서 해당 회원 정보를 삭제하는 메서드
	 * 
	 * @param memId 삭제할 회원ID
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int deleteMember(String memId);
	
	/**
	 * MemberVO 자료를 이용하여 DB에 update하는 메서드
	 * 
	 * @param memVo update할 회원 정보가 저장된 MemberVO객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int updateMember(MemberVO memVo);
	
	/**
	 * DB의 전체 회원 정보를 가져와 List에 담아서 반환하는 메서드
	 * 
	 * @return MemberVO객체가 저장된 List
	 */
	public List<MemberVO> getAllMember();
	
	/**
	 * 회원ID를 매개변수로 받아서 해당 회원ID의 개수를 반환하는 메서드
	 * 
	 * @param memId 검색할 회원ID
	 * @return 검색된 회원ID의 개수
	 */
	public int getMemberCount(String memId);
}
