package basic;

//쓰레드에서 객체를 공통으로 사용하는 예제

/*
	원주율을 계산하는 쓰레드와
	계산된 원주율을 출력하는 쓰레드가 있다.
	
	원주율을 관리하는 객체가 필요하다.
	이 객체를 두 쓰레드에서 공통으로 사용해서 처리한다.
	
 */
public class ThreadTest14 {

	public static void main(String[] args) {
		//공통으로 사용할 객체 생성
		ShareData sd = new ShareData();
		
		//쓰레드 객체를 생성하고 공통으로 사용할 객체를 각각의 쓰레드에 주입한다.
		CalcPIThread cp = new CalcPIThread();
		cp.setSd(sd);
		
		PrintPIThread pp = new PrintPIThread(sd);
		
		cp.start();
		pp.start();

	}

}

//월주율을 계산하는 쓰레드
class CalcPIThread extends Thread{
	private ShareData sd;		//공통으로 사용할 객체의 참조값이 저장될 변수
	
	// Setter를 이용하여 공통으로 사용할 객체를 주입한다.
	public void setSd(ShareData sd) {
		this.sd = sd;
	}
	
	@Override
	public void run() {	//isOk가 true면 실행된다.
		while(true) {
			if(sd.isOk==true) {	//isOK가 true가 아니면 계속 공회전함
				break;
			}else {				//그래서 공회전 안시키고 양보해줌
				Thread.yield();
			}
		}
		System.out.println();
		System.out.println("결 과 : "+sd.result);
		System.out.println("PI : "+Math.PI);
	}
}


//계산이 완료되면 계산된 원주율을 출력하는 쓰레드
class PrintPIThread extends Thread{
	private ShareData sd;		//공통으로 사용할 객체의 참조값이 저장될 변수
	
	//생성자를 이용하여 공통으로 사용할 객체를 주입한다.
	public PrintPIThread(ShareData sd) {
		this.sd = sd;
	}
	
	@Override
	public void run() {
		/*
		 원주율 = (1/1 - 1/3 + 1/5 - 1/7 + 1/9 - ...) * 4
				1 - 3 + 5 - 7 + 9 -...		=>2로 나눔
				0	1	2	3	4			=>2로 나눈 몫
		 */
		double sum = 0.0;
		for(int i=1; i<2_000_000_000; i+=2) {
			if((i/2) %2 == 0) {	//2로 나눈 몫이 짝수일 때
				sum += 1.0/i;
			}else {
				sum -= 1.0/i;
			}
		}
		
		sd.result = sum * 4;	//계산 결과를 공통 객체에 저장한다.
		sd.isOk = true;
	}
	
}



// 원주율을 관리하는 클래스(공통으로 사용할 클래스)
class ShareData{	//계산하는 쓰레드가 계산을 완료하면 result에 값을 저장하고 isOK를 true로 바꾼다.
	public double result;	//계산된 원주율이 저장될 변수
	
	public boolean isOk = false;	//계산이 완료되었는지 여부를 나타내는 변수
}

