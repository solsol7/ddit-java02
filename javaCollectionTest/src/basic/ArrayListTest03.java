package basic;

/*
 * ����1) 5���� ������ �Է¹޾� ArrayList�� �����ϰ� �̵� �� ������ ���̰� ���� ��
 * 		������ ����Ͻÿ�.(��, ������ ���̴� ��� �ٸ��� �Է��Ѵ�.)
 * 
 * ����2) 5���� ������ �Է¹޾� ArrayList�� �����ϰ� �̵� �� ������ ���̰� ���� ��
 * 		������ ����Ͻÿ�.(��, ������ ���̰� ���� �� �ִ�.)
 */

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest03 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		ArrayList<String> list = new ArrayList<>();
		for(int i=0; i<5; i++) {
			System.out.print("���� �Է� : ");
			list.add(sc.nextLine());
		}
		
		
		int max=list.get(0).length();
		String maxName=list.get(0);
		for(int i=0; i<list.size(); i++) {
			if(max<list.get(i).length()) {
				max=list.get(i).length();
				maxName=list.get(i);
			}
		}
		System.out.println(maxName);
		
		///////////////////////////////////////////////
		String maxAlias=list.get(0);
		
		for(int i=1; i<list.size(); i++) {
			if(maxAlias.length() < list.get(i).length())
				maxAlias = list.get(i);
		}
		
		System.out.println("���� �� ���� >>"+maxAlias);
		
	}

}