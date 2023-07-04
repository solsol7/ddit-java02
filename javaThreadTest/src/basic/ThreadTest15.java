package basic;
//동기화
//메서드1을 실행하는 순간 락이 걸리고 메서드1이 끝나면 락이 풀린다
//다른 쓰레드는 락이 풀릴때까지 기다림 = 메서드1이 정상적으로 끝나면 메서드 1은 자신을 호출했던 곳으로 돌아가면서 락을 풀어줌
//부분적으로 락걸기 => synchronized(락 걸 객체)블록 사용 => 동기화영역 따로 만들기
public class ThreadTest15 {

	public static void main(String[] args) {
		ShareObject sObj = new ShareObject();	//공통 객체 생성
		
		TestThread th1 = new TestThread("Test1", sObj);
		TestThread th2 = new TestThread("Test2", sObj);
		
		th1.start();
		th2.start();
	}

}

class TestThread extends Thread{
	private ShareObject sObj;
	
	//생성자
	public TestThread(String name, ShareObject sObj) {
		super(name);	//쓰레드에서 문자열을 괄호에 넣어서 부모 생성자를 생성하면 쓰레드 이름을 설정하는것이다.
		this.sObj = sObj;
	}
	
	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			sObj.add();		//(sObj의 add메소드 호출)
		}
	}
}


//공통 클래스
class ShareObject{
	private int sum = 0;
	
	/*동기화 처리(X)
	public void add() {
		int n = sum;
		
		n+=10;
		
		sum=n;
		
		System.out.println(Thread.currentThread().getName() + " 합계 : " + sum);
	}
	*/
	
	//동기화처리 (O)
	
	//public synchronized void add() {	//방법 1) 메서드에 동기화 설정을 한다.
	public synchronized void add() {
		synchronized (this) {			//방법 2) 동기화 블럭으로 설정한다. =>지금은 자기자신에게 락 검
			int n = sum;
			
			n+=10;
			
			sum=n;
			
			System.out.println(Thread.currentThread().getName() + " 합계 : " + sum);
	
		}
			}
}
