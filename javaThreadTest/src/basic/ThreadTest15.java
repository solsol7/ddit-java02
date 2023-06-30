package basic;
//����ȭ
//�޼���1�� �����ϴ� ���� ���� �ɸ��� �޼���1�� ������ ���� Ǯ����
//�ٸ� ������� ���� Ǯ�������� ��ٸ� = �޼���1�� ���������� ������ �޼��� 1�� �ڽ��� ȣ���ߴ� ������ ���ư��鼭 ���� Ǯ����
//�κ������� ���ɱ� => synchronized(�� �� ��ü)��� ��� => ����ȭ���� ���� �����
public class ThreadTest15 {

	public static void main(String[] args) {
		ShareObject sObj = new ShareObject();	//���� ��ü ����
		
		TestThread th1 = new TestThread("Test1", sObj);
		TestThread th2 = new TestThread("Test2", sObj);
		
		th1.start();
		th2.start();
	}

}

class TestThread extends Thread{
	private ShareObject sObj;
	
	//������
	public TestThread(String name, ShareObject sObj) {
		super(name);	//�����忡�� ���ڿ��� ��ȣ�� �־ �θ� �����ڸ� �����ϸ� ������ �̸��� �����ϴ°��̴�.
		this.sObj = sObj;
	}
	
	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			sObj.add();		//(sObj�� add�޼ҵ� ȣ��)
		}
	}
}


//���� Ŭ����
class ShareObject{
	private int sum = 0;
	
	/*����ȭ ó��(X)
	public void add() {
		int n = sum;
		
		n+=10;
		
		sum=n;
		
		System.out.println(Thread.currentThread().getName() + " �հ� : " + sum);
	}
	*/
	
	//����ȭó�� (O)
	
	//public synchronized void add() {	//��� 1) �޼��忡 ����ȭ ������ �Ѵ�.
	public synchronized void add() {
		synchronized (this) {			//��� 2) ����ȭ ������ �����Ѵ�. =>������ �ڱ��ڽſ��� �� ��
			int n = sum;
			
			n+=10;
			
			sum=n;
			
			System.out.println(Thread.currentThread().getName() + " �հ� : " + sum);
	
		}
			}
}
