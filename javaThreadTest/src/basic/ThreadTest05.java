package basic;

import javax.swing.JOptionPane;

public class ThreadTest05 {

	public static void main(String[] args) {
		// ����ڷ� ���� ������ �Է� �ޱ�
		String str= JOptionPane.showInputDialog("�ƹ��ų� �Է��ϼ���...");
		System.out.println("�Է� �� >>" + str);
		
		for(int i=10; i>0; i--) {
			try {
				System.out.println(i);
				Thread.sleep(1000);				//1�� ���� �����.
			} catch (InterruptedException e) {
				
			}
		}
	}

}
