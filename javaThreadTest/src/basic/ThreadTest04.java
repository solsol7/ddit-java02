package basic;
/*
 * 1~20������� �հ踦 ���ϴ� ���α׷��� �ϳ��� �����尡 �ܵ����� ó���� ����
 * ���� ���� �����尡 �����ؼ� ó���� ���� ��� �ð��� ���� ����...
 */


public class ThreadTest04 {

	public static void main(String[] args) {
		// �ܵ����� ó���ϴ� ������
		SumThread smTh = new SumThread(1, 2_000_000_000L);
		
		// ������ �����ؼ� ó���ϴ� ������
		SumThread[] sumThs = new SumThread[] {
				new SumThread(1, 500_000_000L),
				new SumThread(500_000_001L, 1_000_000_000L),
				new SumThread(1_000_000_001L, 1_500_000_000L),
				new SumThread(1_500_000_001L, 2_000_000_000L)
		};
		
		//�ܵ����� ó���ϱ�...
		
		long startTime = System.currentTimeMillis();
		smTh.start();
		try {
			smTh.join();
		} catch (InterruptedException e) {
			
		}
		long endTime = System.currentTimeMillis();
		System.out.println("�ܵ����� ó���� ���� ��� �ð� : "+(endTime-startTime));
		System.out.println();
		
		//���� �����尡 �����ؼ� ó���ϴ� ���
		startTime = System.currentTimeMillis();
		for(int i=0; i<sumThs.length; i++) {
			sumThs[i].start();
		}
		
		for(SumThread th : sumThs) {
			try {
				th.join();
			} catch (InterruptedException e) {
				
			}
		}
		
		endTime = System.currentTimeMillis();
		System.out.println("���� �����尡 �����ؼ� ó���� ���� ��� �ð� : "+(endTime-startTime));
		
	}
}


class SumThread extends Thread{
	private long start;
	private long end;
	
	
	
	public SumThread(long start, long end) {
		super();
		this.start = start;
		this.end = end;
	}


	@Override
	public void run() {
		long sum=0L;
		for(long i=start; i<=end; i++) {
			sum+=i;
		}
		System.out.println(start+"���� "+end+"������ �հ� : "+ sum);
	}
	
}