package basic;
/*
 * ���� : 5���� ��� �̸��� �Է¹޾� Arraylist�� ������ �Ŀ�
 * 		�̵� �� '��' �� ���� �̸��� ��� ����Ͻÿ�.
 * 		(��, �Է��� Scanner��ü�� �̿��Ѵ�.)
 * 
 * 		substring / split / toCharArray / startsWith / charAt
 */

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			System.out.print("�̸� �Է� : ");
			list.add(sc.nextLine());
		}

		for (String str : list) {
			/*
			if (str.toCharArray()[0] == '��') {
				System.out.println(str);
			}
			*/
			/*
			if(str.charAt(0)=='��') {
				System.out.println(str);
			}
			*/
			/*
			if(str.startsWith("��")) {
				System.out.println(str);
			}
			*/
			/*
			if(str.indexOf("��")==0) {
				System.out.println(str);
			}
			 */
		}
	}
}