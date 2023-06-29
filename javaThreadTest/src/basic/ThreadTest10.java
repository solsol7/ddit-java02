package basic;

//yield()�޼��� ������ ����

public class ThreadTest10 {
	public static void main(String[] args) {
		YieldThread th1 = new YieldThread("1�� ������");
		YieldThread th2 = new YieldThread("2�� ������");
		
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


//yield() �޼��� ������ ������
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
		super(name);		//�������� �̸� �����ϱ�
	}
	
	@Override
	public void run() {
		while(!stop) {
			if(work) {
				System.out.println(getName() + " �۾� ��...");
			}else {			//� ������ ������ ���� �����ϰ� �ٸ� ���� ������ ���ϰ� �ϰ�ʹ� ==>yield
				System.out.println(getName() + " �纸...");
				Thread.yield();
			}
			
		}
	
	}
	
	
}