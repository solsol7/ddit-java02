package basic;


import java.util.ArrayList;
import java.util.Collections;

public class ListSortTestPractice {

	public static void main(String[] args) {
		ArrayList<Member> memList = new ArrayList<Member>();
		
		memList.add(new Member(1, "ȫ�浿", "010-1111-1111"));
		memList.add(new Member(5, "�̼���", "010-2222-1111"));
		memList.add(new Member(9, "������", "010-3333-1111"));
		memList.add(new Member(3, "������", "010-4444-1111"));
		memList.add(new Member(6, "������", "010-5555-1111"));
		memList.add(new Member(2, "���е�", "010-6666-1111"));
		
		System.out.println("������ ...");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("-----------------------------------------------");
		
		Collections.sort(memList);
		
		System.out.println("���� ��");
		for(Member mem : memList) {
			System.out.println(mem);
		}
	}

}

//��ȣ ��������
class Number implements Comparable<Number>{
	private int num;
	private String name;
	private String tel;
	
	public Number(int num, String name, String tel) {
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
		return "Number [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}

	@Override
	public int compareTo(Number mem) {
		if(this.getNum()<mem.getNum()) {
			return 1;
		}else if(this.getNum()>mem.getNum()) {
			return -1;
		}else {
			return 0;
		}
	}
	
	
}
