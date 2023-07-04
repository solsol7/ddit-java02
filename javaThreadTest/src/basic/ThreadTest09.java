package basic;

//쓰레드의 상태를 출력하는 예제

public class ThreadTest09 {
	
	public static void main(String[] args) {
		StatePrintThread th = new StatePrintThread(new TargetThread());
		
		th.start();
	}
}

// 쓰레드 상태의 검사 대상이 되는 쓰레드
class TargetThread extends Thread{
	@Override
	public void run() {
		long temp = 0;
		
		//처리중인 상태 만들기위해 아무 반복문 씀 // 시간 지연용...
		for(long i=1L; i<=20_000_000_000L; i++) {
			temp = i % 8L;
		}
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			
		}
		
		for(long i=1L; i<=20_000_000_000L; i++) {
			temp = i % 8L;
		}
	}
}

//검사 대상의 쓰레드의 상태를 출력하는 쓰레드
class StatePrintThread extends Thread{
	private TargetThread target;

	//생성자
	public StatePrintThread(TargetThread target) {
		super();
		this.target = target;
	}
	
	//타겟쓰레드의 상태를 출력
	@Override
	public void run() {
		while(true) {
			//쓰레드의 현재 상태값 구하기 - 열거형으로 표시되도록 설정되어있음
			// getState() ==> 쓰레드의 현재 상태값을 Thread.State형의 열거형으로 반환한다.
			Thread.State state = target.getState(); 
			System.out.println("TargetThread의 현재 상태값 : "+state);
			
			//TargetThread의 상태가 NEW상태이면...  => TargetThread는 실행중이 아니다
			if(state == Thread.State.NEW) {
				target.start();
			}
			
			//TargetThread의 상태가 TERMINATED상태이면... =>TargetThread가 끝난 상태다
			if(state == Thread.State.TERMINATED) {
				break;	//반복문 빠져나가기
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
			}
		}
	}
}