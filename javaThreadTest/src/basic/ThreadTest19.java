package basic;

public class ThreadTest19 {

	public static void main(String[] args) {
		DataBox databox = new DataBox();
		
		ProducerThread th1 = new ProducerThread(databox);
		ConsumerThread th2 = new ConsumerThread(databox);
		
		th1.start();
		th2.start();
	}

}

//�������� ����� Ŭ����
class DataBox{
	private String data;
	
	//�����͸� �������� �޼���
	// ==> data������ ���� null�̸� data������ ���ڿ��� ä���� ������ ��ٸ���
	//		data������ ���� ������ �ش� ���ڿ��� ��ȯ�Ѵ�.
	//		(���ڿ��� ��ȯ�� �Ŀ��� data������ ���� null�� �����.
	public synchronized String getData() {
		if(data==null) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		String temp = data;
		System.out.println("�����尡 ���� ������ : "+temp);
		data = null;
		
		notify();
		
		return temp;
	}
	
	//�����͸� �����ϴ� �޼���
	// ==> data������ ���� ������ data������ ���� null�� �� ������ ��ٸ���.
	//		data������ ���� null�� �Ǹ� ���ο� ���ڿ��� data������ �����Ѵ�.
	public synchronized void setData(String data) {
		if(this.data!=null) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		this.data = data;
		System.out.println("Thread���� ���� ������ ������ : "+this.data);
		notify();
	}
}

//�����͸� �����ϴ� �޼���
class ProducerThread extends Thread{
	private DataBox databox;

	//������
	public ProducerThread(DataBox databox) {
		super();
		this.databox = databox;
	}
	
	@Override
	public void run() {
		String[] dataArr = {"����", "����", "�λ�", "����"};
		for(int i=0; i<dataArr.length; i++) {
			databox.setData(dataArr[i]);
		}
	}
}

//�����͸� ������ ����ϴ� ������
class ConsumerThread extends Thread{
	private DataBox databox;

	//������
	public ConsumerThread(DataBox databox) {
		super();
		this.databox = databox;
	}
	
	@Override
	public void run() {
		for(int i=1; i<=4; i++) {
			String returnData = databox.getData();
			
			//������ �����͸� ����ϴ� �ڵ��...
		}
	}
}