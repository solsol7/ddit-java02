package basic;

//�������� ���¸� ����ϴ� ����

public class ThreadTest09 {
	
	public static void main(String[] args) {
		StatePrintThread th = new StatePrintThread(new TargetThread());
		
		th.start();
	}
}

// ������ ������ �˻� ����� �Ǵ� ������
class TargetThread extends Thread{
	@Override
	public void run() {
		long temp = 0;
		
		//ó������ ���� ��������� �ƹ� �ݺ��� �� // �ð� ������...
		for(long i=1L; i<=20_000_000_000L; i++) {
			temp = i % 8L;
		}
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			
		}
		
		for(long i=1L; i<=20_000_000_000L; i++) {
			temp = i % 8L;
		}
	}
}

//�˻� ����� �������� ���¸� ����ϴ� ������
class StatePrintThread extends Thread{
	private TargetThread target;

	//������
	public StatePrintThread(TargetThread target) {
		super();
		this.target = target;
	}
	
	//Ÿ�پ������� ���¸� ���
	@Override
	public void run() {
		while(true) {
			//�������� ���� ���°� ���ϱ� - ���������� ǥ�õǵ��� �����Ǿ�����
			// getState() ==> �������� ���� ���°��� Thread.State���� ���������� ��ȯ�Ѵ�.
			Thread.State state = target.getState(); 
			System.out.println("TargetThread�� ���� ���°� : "+state);
			
			//TargetThread�� ���°� NEW�����̸�...  => TargetThread�� �������� �ƴϴ�
			if(state == Thread.State.NEW) {
				target.start();
			}
			
			//TargetThread�� ���°� TERMINATED�����̸�... =>TargetThread�� ���� ���´�
			if(state == Thread.State.TERMINATED) {
				break;	//�ݺ��� ����������
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
			}
		}
	}
}