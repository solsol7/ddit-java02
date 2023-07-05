package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/*
  문제) Set을 이용하여 숫자 야구게임 프로그램을 작성하시오.
  	  컴퓨터의 숫자는 난수를 이용하여 구한다.
  	  (스트라이크는 S, 볼은 B로 나타낸다.)
  	  예시)
  	  컴퓨터의 난수 ==> 9 5 7
  	  실행예시)
  	  숫자입력 >> 3 4 5
  	 3 4 5 ==> 0S 1B
  	  숫자입력 >> 7 8 9
  	 7 8 9 ==> 0S 2B
  	 숫자입력 ==> 9 5 7
  	 9 5 7 ==> 3S 0B
  	 
  	 축하합니다
  	 당신은 3번째만에 맞췄습니다...
  	 
1 2 3
1 7 2 ==> 값,위치 - 스트라이크/ 갑o위치x - 볼   : 1S 1B

 */
/* 내 답
public class BaseBallTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Set<Integer> num = new HashSet<>();
		while (num.size() < 3) {
			num.add((int) (Math.random() * 9 + 1));
		}
		List<Integer> num1 = new ArrayList<>(num);
		List<Integer> userNum = new ArrayList<>();
		int cnt=0;
		
		while (true) {
			int s = 0;
			int b = 0;
			System.out.print("숫자입력 >>");
			userNum.add(0, sc.nextInt());
			userNum.add(1, sc.nextInt());
			userNum.add(2, sc.nextInt());
			
			for (int i = 0; i < userNum.size(); i++) {
				for (int j = 0; j < num1.size(); j++) {
					if (userNum.get(i) == num1.get(j) && i != j) {
						b++;
					} else if (userNum.get(i) == num1.get(j) && i == j) {
						s++;
					}
				}
			}
			cnt++;
			userNum.clear();
			System.out.println(s + "S " + b + "B");
			if(s==3) break;
		}
		System.out.println("축하합니다. 당신은 "+cnt+"번째 만에 맞췄습니다.");
	}

}

*/

//선생님답
public class BaseBallTest{
	ArrayList<Integer> numList;			//난수가 저장될 List
	ArrayList<Integer> userList;		//사용자가 입력한 값이 저장될 List
	
	int strike, ball;
	
	Scanner sc = new Scanner(System.in);
	
	// 1 ~ 9 사이의 중복되지 않는 난수 3개를 만들어서 List에 저장하는 메서드(Set 이용)
	public void createNum() {
		Set<Integer> numSet = new HashSet<Integer>();
		
		while(numSet.size() < 3) {
			numSet.add((int)(Math.random()*9+1));
		}
		
		//만들어진 난수를 List에 저장하기
		numList = new ArrayList<Integer>(numSet);
		
		Collections.shuffle(numList);
	}
	

	//사용자로부터 3개의 정수를 입력받아 List에 저장하는 메서드
	//입력한 정수는 중복되지 않게 한다.
	public void inputNum() {
		int n1, n2, n3;
		
		do {
			System.out.print("숫자 입력 >> ");
			n1=sc.nextInt();
			n2=sc.nextInt();
			n3=sc.nextInt();
			
			if(n1==n2 || n1==n3|| n2==n3) {
				System.out.println("중복되는 숫자는 입력할 수 없습니다...");
				System.out.println("다시 입력하세요...");
			}
		}while(n1==n2 || n1==n3|| n2==n3);
		
		//입력한 데이터를 List에 저장한다.
		userList = new ArrayList<Integer>();
		userList.add(n1);
		userList.add(n2);
		userList.add(n3);
		
	}
	
	//스트라이크와 볼을 판정하고 결과를 출력하는 메서드
	public void ballCount() {
		strike = 0;
		ball=0;
		
		for(int i=0; i<userList.size(); i++) {
			for(int j=0; j<numList.size(); j++) {
				if(userList.get(i) == numList.get(i)){
					if(i == j) {
						strike++;
					}else {
						ball++;
					}
				}
			}
		}
		
		//구해진 볼카운트 출력하기
		System.out.println(userList.get(0)+" "+ userList.get(1)+ " "+userList.get(2)+ "==>" + strike+"S" +ball+" B");
		
	}
	
	//게임을 진행하는 메서드
	public void startGame() {
		createNum();				//난수만드는 메서드 호출
		
		System.out.println("컴퓨터의 난수 확인 >> "+numList);
		
		int cnt=0;					//실행횟수가 저장될 변수
		
		do {
			cnt++;
			
			inputNum();
			
			ballCount();
			
		}while(strike!=3);
		
		System.out.println();
		System.out.println("축하합니다...");
		System.out.println("당신은 "+cnt+"번째만에 맞췄습니다...");
		
	}
	
	
	
	public static void main(String[] args) {
		//BaseBallTest b=new BaseBallTest();
		//b.startGame();
		
		new BaseBallTest().startGame();
		
	}
}
