package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTestPractice02 {

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
		
		Collections.sort(memList, new Name());
		System.out.println("정렬후 ...");
		for(Member mem : memList) {
			System.out.println(mem);
		}
	}
}

class Name implements Comparator<Member>{

	@Override
	public int compare(Member str1, Member str2) {
		return str1.getName().compareTo(str2.getName());
	}
	
	
}