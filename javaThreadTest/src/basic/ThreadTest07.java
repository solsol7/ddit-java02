package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

/*
 	컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
 	
 	컴퓨터의 가위 바위 보는 난수를 이용하여 구하고,
 	사용자의 입력은 showInputDialog()메서드를 이용해서 입력 받는다.
 	
 	입력 시간은 5초로 제한하고 카운트 다운을 진행한다.
 	5초 안에 입력이 없으면 게임 진 것으로 처리하고 프로그램을 멈춘다.
 	
 	5초 안에 입력이 완료되면 승패를 구해서 출력한다.
 	
 	결과 예시)
 	1. 5초 안에 입력을 못했을 경우
 	 -- 결 과 --
 	 시간 초과로 당신이 졌습니다...
 	 
 	2. 5초 안에 입력했을 경우
 	 -- 결 과 --
 	 컴퓨터 : 가위
 	 사용자 : 바위
 	 결 과 : 당신이 이겼습니다... / 졌습니다... / 비겼습니다...
 
 */
/*
public class ThreadTest07 {

	public static void main(String[] args) {
		Count c = new Count();
		UserResult r = new UserResult();
		r.startGame();
		c.start();
		r.start();

	}

}

class Count extends Thread {
	@Override
	public void run() {
		try {
			for (int i = 5; i > 0; i--) {
				if (UserResult.inputCheck == true)
					return;
				System.out.println(i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
		}
		System.out.println("시간 초과로 당신이 졌습니다...");
		System.exit(0);
	}
}

class UserResult extends Thread {
	public static boolean inputCheck = false;
	String comResult;


	public void startGame() {
		int i = (int) (Math.random() * 3);
		switch (i) {
		case 0:
			comResult = "가위";
			break;
		case 1:
			comResult = "바위 ";
			break;
		case 2:
			comResult = "보";
			break;
		}
	}

	@Override
	public void run() {
		String userResult = JOptionPane.showInputDialog("입력(가위, 바위, 보)");
		inputCheck = true;
		if (!(userResult.equals("가위") || userResult.equals("바위") || userResult.equals("보"))) {
			System.out.println("잘못 입력했습니다.");
			return;
		}

		System.out.println(" -- 결 과 -- ");
		System.out.println("컴퓨터 : " + comResult);
		System.out.println("사용자 : " + userResult);
		switch (userResult) {
		case "가위":
			if (comResult.equals("가위")) {
				System.out.println("비겼습니다.");
			} else if (comResult.equals("바위")) {
				System.out.println("당신이 졌습니다...");
			} else if (comResult.equals("보")) {
				System.out.println("당신이 이겼습니다...");
			}
			break;
		case "바위":
			if (comResult.equals("가위")) {
				System.out.println("당신이 이겼습니다...");
			} else if (comResult.equals("바위")) {
				System.out.println("비겼습니다.");
			} else if (comResult.equals("보")) {
				System.out.println("당신이 졌습니다...");
			}
			break;
		case "보":
			if (comResult.equals("가위")) {
				System.out.println("당신이 졌습니다...");
			} else if (comResult.equals("바위")) {
				System.out.println("당신이 이겼습니다...");
			} else if (comResult.equals("보")) {
				System.out.println("비겼습니다.");
			}
			break;
		}
	}
}

*/

//선생님답
public class ThreadTest07 {
	//입력 여부를 나타내는 변수 선언
	public static boolean inputCheck;
	
	public static void main(String[] args) {
		GameTimer gt=new GameTimer();
		
		//난수를 이용해서 컴퓨터의 가위 바위 보 정하기
		String[] data = {"가위","바위","보"};
		int index = (int)(Math.random()*3);	//0~2사이의 난수 만들기
		String com = data[index];
		
		// 사용자로부터 가위 바위 보 입력 받기
		gt.start();
		String man = null;
		do {			
			man = JOptionPane.showInputDialog("가위 바위 보를 입력하세요.");
//		}while(!(man.equals("가위")||man.equals("바위")||man.equals("보")));
		}while(!man.equals("가위") && !man.equals("바위") && !man.equals("보"));
		//전체에 !안붙이고 개별적으로 붙이고싶으면 전체!에서 ||는 &&로 &&는 ||로 바꾸고 전체에 ! 붙이기
		inputCheck = true;
		
		//결과 판정하기
		String result = "";
		/*
		if(man.equals(com)) {
			result = "비겼습니다...";
		}else if(man.equals("가위") && com.equals("보") ||
				man.equals("바위") &com.equals("가위") ||
				man.equals("보") && com.equals("바위")) {
			result = "당신이 이겼습니다...";
		}else {
			result = "당신이 졌습니다...";
		}
		*/
		
		switch (man + com) {
		case "가위가위":
		case "가위바위":
		case "보보": result= "비겼습니다..."; break;
		case "가위보":
		case "바위가위":
		case "보바위": result = "당신이 이겼습니다..."; break;
		default : result = "당신이 졌습니다...";
		}
		
		// 결과 출력
		System.out.println(" -- 결 과 --");
		System.out.println("컴퓨터 : "+com);
		System.out.println(("사용자 : "+man));
		System.out.println("결과 : "+result);
	}
}

class GameTimer extends Thread{
	@Override
	public void run() {
		System.out.println("카운트 다운 시작...");
		for(int i=5; i>=1; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			
			}
			if(ThreadTest07.inputCheck) {
				return;
			}
		}
		
		System.out.println(" -- 결 과 --");
		System.out.println("시간초과로 당신이 졌습니다...");
		System.exit(0);

	}
	
}

