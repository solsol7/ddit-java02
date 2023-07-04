package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest02 {

	public static void main(String[] args) {
		ArrayList<Member> memList = new ArrayList<Member>();
		
		memList.add(new Member(1, "홍길동", "010-1111-1111"));
		memList.add(new Member(5, "이순신", "010-2222-1111"));
		memList.add(new Member(9, "성춘향", "010-3333-1111"));
		memList.add(new Member(3, "강감찬", "010-4444-1111"));
		memList.add(new Member(6, "일지매", "010-5555-1111"));
		memList.add(new Member(2, "변학도", "010-6666-1111"));
		
		System.out.println("정렬전 ...");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("-----------------------------------------------");
		
		Collections.sort(memList);	//다 멤버 - 멤버는 내부정렬기준이 현재 없어서 sort못함 - 에러뜸
		
		System.out.println("정렬후 ...");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("-----------------------------------------------");
		
		//회원이름의 오름차순으로 정렬되는 외부 정렬 기준을 만들어 정렬하여 출력하시오.
		//클래스명(NameSort)
		
		Collections.sort(memList, new NameSort());
		
		System.out.println("정렬후 ...");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("-----------------------------------------------");
		
		
	}
}

class NameSort implements Comparator<Member>{//////////1
	@Override
	public int compare(Member mem1, Member mem2) {
		mem1.getName().compareTo(mem2.getName());	//String은 내부정렬기준 있음 - 오름차순
		return mem1.getName().compareTo(mem2.getName());/////////////////////2
	}
}
	

//Member클래스 작성
//회원번호의 오름차순의 내부 정렬 기준 만들기
class Member implements Comparable<Member>{	/////////////3.
	private int num;	//회원번호
	private String name;	//회원이름
	private String tel;		//전화번호
	
	public Member(int num, String name, String tel) {
		this.num=num;
		this.name=name;
		this.tel=tel;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}

	//회원번호의 오름차순 정렬 기준 설정하기
	@Override						////////////////////////////////4.
	public int compareTo(Member mem) {/*//현재의 값하고 매개변수로 들어온 값을 비교함 - 현재의 값이 앞의 데이터이고 매개변수가 뒤의 데이터
		if(this.getNum() > mem.getNum()) {		//이건 지금 내림차순 -> 순서 바꿔줘야함 -> 1 반환
			return 1;
		}else if(this.getNum()<mem.getNum()) {
			return -1;
		}else {
			return 0;
		}
		
		*/
		//if문 안쓰고 하는 방법
		//- Wrapper클래스를 이용하는 방법1 (래퍼클래스에도 내부정렬 기준이 있다. - Integer)
		return new Integer(this.getNum()).compareTo(mem.getNum());	/////////////////////////////6.
		//- Wrapper클래스를 이용하는 방법2
		//return Integer.compare(this.getNum(), mem.getNum());
	}
}
