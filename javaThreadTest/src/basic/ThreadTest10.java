package basic;

//yield()메서드 연습용 예제

public class ThreadTest10 {
	public static void main(String[] args) {
		YieldThread th1 = new YieldThread("1번 쓰레드");
		YieldThread th2 = new YieldThread("2번 쓰레드");
		
		th1.start();
		th2.start();
		
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			
		}
		th1.setWork(false);
		System.out.println("----------------------------------11111111111111111");
		
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			
		}
		System.out.println("----------------------------------22222222222222222");
		th1.setWork(false);
		
		th1.setWork(true);
		
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			
		}
		System.out.println("----------------------------------33333333333333333");
		th1.setStop(true);
		th2.setStop(true);
	}
}


//yield() 메서드 연습용 쓰레드
class YieldThread extends Thread{
	private boolean stop = false;
	private boolean work = true;
	
	public void setWork(boolean work) {
		this.work = work;
	}
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	public YieldThread(String name) {
		super(name);		//쓰레드의 이름 설정하기
	}
	
	@Override
	public void run() {
		while(!stop) {
			if(work) {
				System.out.println(getName() + " 작업 중...");
			}else {			//어떤 조건을 만족할 때만 실행하고 다른 때는 실행을 안하게 하고싶다 ==>yield
				System.out.println(getName() + " 양보...");
				Thread.yield();
			}
			
		}
	
	}
	
	
}