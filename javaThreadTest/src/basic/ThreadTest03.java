package basic;

public class ThreadTest03 {

	public static void main(String[] args) {
		// �������� ���� �ð��� üũ�� ����...
		Thread th = new Thread(new MyRunner());
		
		//1970�� 1�� 1�� 0�� 0�� 0��(ǥ�ؽð�)���� ���� �ð����� ����� �ð��� �и������� ������ ��ȯ�Ѵ�.
		long startTime = System.currentTimeMillis();
		
		th.start();
		
		try {
			th.join();			//������ ��ġ���� ����� �Ǵ� ������(������ ���� th�� ����Ű�� ������)�� ����� �� ���� ��ٸ���.
		} catch (InterruptedException e) {
				
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("����ð� : "+(endTime - startTime));
	}
}

class MyRunner implements Runnable{
	@Override
	public void run() {
		long sum=0L;
		for(long i=1; i<=1_000_000_000L; i++) {	//���ڿ� _���� ���õ� =>ū ���� �����ϱ� ���ϰ� ��
			sum+=i;
		}
		System.out.println("�հ� : "+sum);
	}
}