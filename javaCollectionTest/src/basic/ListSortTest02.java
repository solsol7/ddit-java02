package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest02 {

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
		
		Collections.sort(memList);	//�� ��� - ����� �������ı����� ���� ��� sort���� - ������
		
		System.out.println("������ ...");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("-----------------------------------------------");
		
		//ȸ���̸��� ������������ ���ĵǴ� �ܺ� ���� ������ ����� �����Ͽ� ����Ͻÿ�.
		//Ŭ������(NameSort)
		
		Collections.sort(memList, new NameSort());
		
		System.out.println("������ ...");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("-----------------------------------------------");
		
		
	}
}

class NameSort implements Comparator<Member>{//////////1
	@Override
	public int compare(Member mem1, Member mem2) {
		mem1.getName().compareTo(mem2.getName());	//String�� �������ı��� ���� - ��������
		return mem1.getName().compareTo(mem2.getName());/////////////////////2
	}
}
	

//MemberŬ���� �ۼ�
//ȸ����ȣ�� ���������� ���� ���� ���� �����
class Member implements Comparable<Member>{	/////////////3.
	private int num;	//ȸ����ȣ
	private String name;	//ȸ���̸�
	private String tel;		//��ȭ��ȣ
	
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

	//ȸ����ȣ�� �������� ���� ���� �����ϱ�
	@Override						////////////////////////////////4.
	public int compareTo(Member mem) {/*//������ ���ϰ� �Ű������� ���� ���� ���� - ������ ���� ���� �������̰� �Ű������� ���� ������
		if(this.getNum() > mem.getNum()) {		//�̰� ���� �������� -> ���� �ٲ������ -> 1 ��ȯ
			return 1;
		}else if(this.getNum()<mem.getNum()) {
			return -1;
		}else {
			return 0;
		}
		
		*/
		//if�� �Ⱦ��� �ϴ� ���
		//- WrapperŬ������ �̿��ϴ� ���1 (����Ŭ�������� �������� ������ �ִ�. - Integer)
		return new Integer(this.getNum()).compareTo(mem.getNum());	/////////////////////////////6.
		//- WrapperŬ������ �̿��ϴ� ���2
		//return Integer.compare(this.getNum(), mem.getNum());
	}
}
