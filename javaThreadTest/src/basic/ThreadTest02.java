package basic;

public class ThreadTest02 {

	public static void main(String[] args) {
		//��Ƽ ������
		
		//Thread�� ����ϴ� ���
		//���1)
		//	-ThreadŬ������ ����� class�� �ۼ��� �� �� class�� �ν��Ͻ��� ������ ��
		//	  �� �ν��Ͻ��� start()�޼��带 ȣ���ؼ� �����Ѵ�.
		MyThread01 th1=new MyThread01();
		th1.start();	//run()�޼��带 ȣ���ϸ� �����带 �۵���Ű�°� �ƴ�, ���ξ����忡�� �ϳ��� �帧���� ����, start()ȣ���ؾ���
					//start() => �������� �帧���� ����� �� �ֵ��� �������� ȯ���� ������ִ� �޼���
					//		������ȯ���� ����� ���� ���� ȯ�濡�� run()�޼��带 �ڵ����� ȣ������
		//���2)
		//	-Runnable�������̽��� ������ class�� �ۼ��� �� �� class�� �ν��Ͻ��� �����ϰ�
		//	  �� �ν��Ͻ��� ThreadŬ������ �ν��Ͻ��� ������ �� �μ������� �Ѱ��ش�.
		//	  �׸��� �� �� ������ ThreadŬ������ �ν��Ͻ��� start()�޼��带 ȣ���ؼ� �����Ѵ�.
		MyThread02 r2 = new MyThread02();
		Thread th2 = new Thread(r2);
		th2.start();
		
		//���2-1)
		//	-Runnable�������̽��� �͸���ü�� �ۼ��Ͽ� �����ϱ� =>��ü�� �ѹ��� �����ؼ� ��������� ���
		Runnable r3 = new Runnable() {
			
			@Override
			public void run() {
				for(int i=1; i<=200; i++) {
					System.out.print("@");
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						
					}
				}
			}
		};		//�ϳ��� �������� ���⶧���� ���� ; �ٿ�����
		
		Thread th3=new Thread(r3);
		th3.start();
		
		System.out.println("main�޼��� ��...");
			//��� �����尡 �� ������ ���μ����� ���� => ���θ޼ҵ� �����ٰ� �����°� �ƴ�
	}
	
}

//���1�� class �ۼ�
class MyThread01 extends Thread{
	@Override
	public void run() {
		//�� run()�޼��� �ȿ� �����尡 ó���� ������ �ۼ��Ѵ�.
		for(int i=1; i<=200; i++) {
			System.out.print("*");
			
			try {
				// Thread.sleep(�ð�); ==> �־��� �ð����� �۾��� ��� �����.
				//	�ð��� �и������� ������ ����Ѵ�. (��, 1000�� 1�ʸ� �ǹ��Ѵ�.)
				Thread.sleep(100);
			} catch (InterruptedException e) {
				
			}
		}
	}
}


//���2�� class �ۼ�
class MyThread02 implements Runnable{
	@Override
	public void run() {
		for(int i=1; i<=200; i++) {
			System.out.print("$");

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				
			}
		}
	}
}