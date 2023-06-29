package basic;

/*
	Thread�� stop()�޼��带 ȣ���ϸ� �����尡 �ٷ� �����.
	
	�� �� ����ϴ� �ڿ��� �������� ���ϰ� ���α׷��� ����Ǿ� ���߿� ����Ǵ�
	���α׷��� ������ �� �� �ִ�. �׷��� stop()�޼���� ����õ���� �Ǿ� �ִ�.
*/

public class ThreadTest11 {

	public static void main(String[] args) {
/*		ThreadStopTest01 th1=new ThreadStopTest01();
		th1.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

		}
		
//		th1.stop();
		th1.setStop(true);
*/
		//-------------------------------------------------
		
		//interrupt()�޼��带 �̿��� ������ ���߱�
		ThreadStopTest02 th2 = new ThreadStopTest02();
		th2.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

		}
		th2.interrupt();
	}

}

// �����带 ���߰� �ϴ� ������ ������
class ThreadStopTest01 extends Thread{
	private boolean stop;
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	@Override
	public void run() {
		while(!stop) {
			System.out.println("������ ���� ��..");
		}
		
		System.out.println("�ڿ� ����");
		System.out.println("������ ����...");
		
		
	}
}

// interrupt() �޼��带 �̿��Ͽ� �����带 ���߰� �ϱ�
class ThreadStopTest02 extends Thread{
	@Override
	public void run() {
		//���1 ==> interrupt()�޼���� sleep()�޼��带 �̿��ϴ� ���
		/*
		try {
			while(true) {
				System.out.println("....������...");
				Thread.sleep(1);
			}
		} catch (InterruptedException e) {
			//Interrupt ������ try�����ϴ� �߰��� ����� �� => �ƹ��͵� �Ⱦ������� => ������ ������
		}
		
		System.out.println("�ڿ� ����...");
		System.out.println("������ ����...");
		*/
		
		while(true) {
			System.out.println("Thread ������...");
			//���2 ==> interrupt()�޼��尡 ȣ��Ǿ����� ���θ� �˻��ؼ� ó���Ѵ�.
			
			//�˻���1 ==> �������� �ν��Ͻ� �޼����� isInterrupted()�޼��� �̿��ϱ�
			// isInterrupted() ==> interrupt()�޼��尡 ȣ��Ǹ� true�� ��ȯ�Ѵ�.
			/*
			if(this.isInterrupted()) {
				break;
			}
			*/
			
			//�˻���2 ==> �������� ���� �޼����� interrupted()�޼��� �̿��ϱ�
			//interrupted() ==> interrupt()�޼��尡 ȣ��Ǹ� true�� ��ȯ�Ѵ�.
			if(Thread.interrupted()) {
				break;
			}
		}
	}
	
}
