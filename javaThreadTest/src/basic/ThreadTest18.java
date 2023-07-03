package basic;
/*
  wait(), notify()�޼��带 �̿��� �� �����尡 ������ �ѹ��� �����ϴ� ����
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

//�������� ����� ��ü
class WorkObject{
	public synchronized void testMethodA() {
		System.out.println("testMethodA() �޼��� ������...");
		notify();	//wait�� ���� ������ �Ѵ� waitingǮ�� ��
		
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("testMethodA() �޼��� ��...");
	}
	
	public synchronized void testMethodB() {
		System.out.println("testMethodB() �޼��� �ۼ���...");
		notify();
		
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("testMethodB() �޼��� ��...");
	}
}


//WorkObject�� testMethodA()�޼��常 ȣ���ϴ� ������
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

//WorkObject�� testMethodB()�޼��常 ȣ���ϴ� ������
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
