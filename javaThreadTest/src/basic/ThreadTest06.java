package basic;

import javax.swing.JOptionPane;

public class ThreadTest06 {

	public static void main(String[] args) {
		DataInput th1 = new DataInput();
		CountDown th2 = new CountDown();
		
		th1.start();
		th2.start();

	}

}

//�����͸� �Է��ϴ� ������
class DataInput extends Thread{
	//�Է� ���θ� Ȯ���ϱ� ���� ���� ���� ==> �����忡�� �������� ���Ǵ� ����
	public static boolean inputCheck = false;
	
	@Override
	public void run() {
		String str= JOptionPane.showInputDialog("�ƹ��ų� �Է��ϼ���...");
		inputCheck = true;			//�Է��� �Ϸ�Ǹ� true���� �����Ѵ�.
		System.out.println("�Է� �� >>" + str);
	}
}

//ī��Ʈ �ٿ��� �����ϴ� ������
class CountDown extends Thread{
	@Override
	public void run() {
		for(int i=10; i>0; i--) {
			//�Է� ���θ� Ȯ���Ͽ� �Է��� �Ϸ�Ǹ� �����带 ���� ��Ų��.
			if(DataInput.inputCheck==true) {
				// run()�޼��尡 ����Ǹ� �ش� �����尡 ����Ǵ� �Ͱ� ����.
				return;
			}
			
			try {
				System.out.println(i);
				Thread.sleep(1000);				//1�� ���� �����.
			} catch (InterruptedException e) {
				
			}
		}
		
		System.out.println("10�ʰ� �������ϴ�... ���α׷��� �����մϴ�...");
		System.exit(0); 		//���α׷��� ������ �����Ŵ
	}
}