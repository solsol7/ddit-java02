package member.dao;

import java.util.List;
import java.util.Map;

import vo.MemberVO;


/**
 * 실제 DB와 연결해서 SQL문을 수행하여 결과를 작성해서 Service에게 전달하는 DAO의 interface
 * 
 * 메서드 하나가 DB와 관련된 작업 1개를 수행하도록 작성한다.
 * 
 * @author PC-16
 *
 */
public interface IMemberDao {
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
	
	/**
	 * 회원ID, 수정할 컬럼명, 수정할 데이터를 갖는 Map객체를 매개변수로 받아서
	 * 회원 정보를 수정하는 메서드
	 * (Key값 정보 ==> 회원ID(memid), 수정할 컬럼명(field), 수정할 데이터(data)
	 * 
	 * @param paramMap 수정할 회원 정보가 저장된 Map객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int updateMember2(Map<String, String> paramMap);
		//가능하면 매개변수를 하나만 들어가게 하기 위해 field, data, memid를 map으로 합쳐서
		//저장해서 map만 매개변수로 받기
	
}
