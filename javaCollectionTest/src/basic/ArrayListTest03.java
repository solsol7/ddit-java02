package basic;

/*
 * 문제1) 5명의 별명을 입력받아 ArrayList에 저장하고 이들 중 별명의 길이가 제일 긴
 * 		별명을 출력하시오.(단, 별명의 길이는 모두 다르게 입력한다.)
 * 
 * 문제2) 5명의 별명을 입력받아 ArrayList에 저장하고 이들 중 별명의 길이가 제일 긴
 * 		별명을 출력하시오.(단, 별명의 길이가 같을 수 있다.)
 */

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest03 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		ArrayList<String> list = new ArrayList<>();
		for(int i=0; i<5; i++) {
			System.out.print("별명 입력 : ");
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
		
		System.out.println("제일 긴 별명 >>"+maxAlias);
		
	}

}