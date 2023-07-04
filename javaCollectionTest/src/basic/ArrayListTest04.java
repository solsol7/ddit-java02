package basic;


import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest04 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ArrayList<String> list = new ArrayList<>();
		ArrayList<String> maxName=new ArrayList<>();
		
		for(int i=0; i<5; i++) {
			System.out.print("별명 입력 : ");
			list.add(sc.nextLine());
		}
		
		int max=list.get(0).length();
		
		for(String str : list) {
			if(max<str.length()) {
				max=str.length();
			}
		}
		
		for(String str : list) {
			if(str.length()==max) {
				System.out.println(str);
			}
		}

	}
	

}


	