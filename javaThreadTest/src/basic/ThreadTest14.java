package basic;

//�����忡�� ��ü�� �������� ����ϴ� ����

/*
	�������� ����ϴ� �������
	���� �������� ����ϴ� �����尡 �ִ�.
	
	�������� �����ϴ� ��ü�� �ʿ��ϴ�.
	�� ��ü�� �� �����忡�� �������� ����ؼ� ó���Ѵ�.
	
 */
public class ThreadTest14 {

	public static void main(String[] args) {
		//�������� ����� ��ü ����
		ShareData sd = new ShareData();
		
		//������ ��ü�� �����ϰ� �������� ����� ��ü�� ������ �����忡 �����Ѵ�.
		CalcPIThread cp = new CalcPIThread();
		cp.setSd(sd);
		
		PrintPIThread pp = new PrintPIThread(sd);
		
		cp.start();
		pp.start();

	}

}

//�������� ����ϴ� ������
class CalcPIThread extends Thread{
	private ShareData sd;		//�������� ����� ��ü�� �������� ����� ����
	
	// Setter�� �̿��Ͽ� �������� ����� ��ü�� �����Ѵ�.
	public void setSd(ShareData sd) {
		this.sd = sd;
	}
	
	@Override
	public void run() {	//isOk�� true�� ����ȴ�.
		while(true) {
			if(sd.isOk==true) {	//isOK�� true�� �ƴϸ� ��� ��ȸ����
				break;
			}else {				//�׷��� ��ȸ�� �Ƚ�Ű�� �纸����
				Thread.yield();
			}
		}
		System.out.println();
		System.out.println("�� �� : "+sd.result);
		System.out.println("PI : "+Math.PI);
	}
}


//����� �Ϸ�Ǹ� ���� �������� ����ϴ� ������
class PrintPIThread extends Thread{
	private ShareData sd;		//�������� ����� ��ü�� �������� ����� ����
	
	//�����ڸ� �̿��Ͽ� �������� ����� ��ü�� �����Ѵ�.
	public PrintPIThread(ShareData sd) {
		this.sd = sd;
	}
	
	@Override
	public void run() {
		/*
		 ������ = (1/1 - 1/3 + 1/5 - 1/7 + 1/9 - ...) * 4
				1 - 3 + 5 - 7 + 9 -...		=>2�� ����
				0	1	2	3	4			=>2�� ���� ��
		 */
		double sum = 0.0;
		for(int i=1; i<2_000_000_000; i+=2) {
			if((i/2) %2 == 0) {	//2�� ���� ���� ¦���� ��
				sum += 1.0/i;
			}else {
				sum -= 1.0/i;
			}
		}
		
		sd.result = sum * 4;	//��� ����� ���� ��ü�� �����Ѵ�.
		sd.isOk = true;
	}
	
}



// �������� �����ϴ� Ŭ����(�������� ����� Ŭ����)
class ShareData{	//����ϴ� �����尡 ����� �Ϸ��ϸ� result�� ���� �����ϰ� isOK�� true�� �ٲ۴�.
	public double result;	//���� �������� ����� ����
	
	public boolean isOk = false;	//����� �Ϸ�Ǿ����� ���θ� ��Ÿ���� ����
}

