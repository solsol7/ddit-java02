package basic;

//���� ������ ���� ==> �ڵ� �����ϴ� ������
public class ThreadTest08 {

	public static void main(String[] args) {
		AutoSaveThread autoSave = new AutoSaveThread();
		
		autoSave.setDaemon(true); //���󾲷��尡 ��
		
		System.out.println("���� ���� : "+autoSave.isDaemon());
		
		autoSave.start();
		
		try {
			for(int i=1; i<=20; i++) {
				System.out.println(i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			
		}
		
		System.out.println("main ������ ����...");

	}

}

// �ڵ� �����ϴ� ������ (3�ʿ� �ѹ��� �����ϱ�)
class AutoSaveThread extends Thread{
	//�۾� ������ �����ϴ� �޼���
	public void save() {
		System.out.println("�۾� ������ �����մϴ�...");
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				
			}
			save();
		}
	}
}