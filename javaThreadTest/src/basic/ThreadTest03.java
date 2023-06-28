package basic;

public class ThreadTest03 {

	public static void main(String[] args) {
		// 쓰레드의 실행 시간을 체크해 보자...
		Thread th = new Thread(new MyRunner());
		
		//1970년 1월 1일 0시 0분 0초(표준시간)부터 현재 시간까지 경과한 시간을 밀리세컨드 단위로 반환한다.
		long startTime = System.currentTimeMillis();
		
		th.start();
		
		try {
			th.join();			//현재의 위치에서 대상이 되는 쓰레드(지금은 변수 th가 가리키는 쓰레드)가 종료될 때 까지 기다린다.
		} catch (InterruptedException e) {
				
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("경과시간 : "+(endTime - startTime));
	}
}

class MyRunner implements Runnable{
	@Override
	public void run() {
		long sum=0L;
		for(long i=1; i<=1_000_000_000L; i++) {	//숫자에 _쓰면 무시됨 =>큰 숫자 구별하기 편하게 씀
			sum+=i;
		}
		System.out.println("합계 : "+sum);
	}
}