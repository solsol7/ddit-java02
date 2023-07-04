package basic;
/*
  wait(), notify()메서드를 이용한 두 쓰레드가 번갈아 한번씩 실행하는 예제
 */
public class ThreadTest18 {

	public static void main(String[] args) {
		WorkObject workObj = new WorkObject();
		
		ThreadA thA = new ThreadA(workObj);
		ThreadB thB = new ThreadB(workObj);
		
		thA.start();
		thB.start();
		
	}

}

//공통으로 사용할 객체
class WorkObject{
	public synchronized void testMethodA() {
		System.out.println("testMethodA() 메서드 실행중...");
		notify();	//wait가 먼저 있으면 둘다 waiting풀에 들어감
		
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("testMethodA() 메서드 끝...");
	}
	
	public synchronized void testMethodB() {
		System.out.println("testMethodB() 메서드 작성중...");
		notify();
		
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("testMethodB() 메서드 끝...");
	}
}


//WorkObject의 testMethodA()메서드만 호출하는 쓰레드
class ThreadA extends Thread{
	private WorkObject workObj;
	
	public ThreadA(WorkObject workObj) {
		this.workObj = workObj;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			workObj.testMethodA();
		}
		
		synchronized(workObj) {
			workObj.notify();
		}
	}
}

//WorkObject의 testMethodB()메서드만 호출하는 쓰레드
class ThreadB extends Thread{
	private WorkObject workObj;
	
	public ThreadB(WorkObject workObj) {
		this.workObj = workObj;
	}
	
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			workObj.testMethodB();
		}
		
		synchronized(workObj) {
			workObj.notify();
		}
	}
}
