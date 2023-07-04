package basic;
/*
 * 문제 : 5명의 사람 이름을 입력받아 Arraylist에 저장한 후에
 * 		이들 중 '김' 씨 성의 이름을 모두 출력하시오.
 * 		(단, 입력은 Scanner객체를 이용한다.)
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
			System.out.print("이름 입력 : ");
			list.add(sc.nextLine());
		}

		for (String str : list) {
			/*
			if (str.toCharArray()[0] == '김') {
				System.out.println(str);
			}
			*/
			/*
			if(str.charAt(0)=='김') {
				System.out.println(str);
			}
			*/
			/*
			if(str.startsWith("김")) {
				System.out.println(str);
			}
			*/
			/*
			if(str.indexOf("김")==0) {
				System.out.println(str);
			}
			 */
		}
	}
}