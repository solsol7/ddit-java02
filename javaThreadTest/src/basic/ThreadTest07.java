package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

/*
 	��ǻ�Ϳ� ���� ���� ���� �����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 	
 	��ǻ���� ���� ���� ���� ������ �̿��Ͽ� ���ϰ�,
 	������� �Է��� showInputDialog()�޼��带 �̿��ؼ� �Է� �޴´�.
 	
 	�Է� �ð��� 5�ʷ� �����ϰ� ī��Ʈ �ٿ��� �����Ѵ�.
 	5�� �ȿ� �Է��� ������ ���� �� ������ ó���ϰ� ���α׷��� �����.
 	
 	5�� �ȿ� �Է��� �Ϸ�Ǹ� ���и� ���ؼ� ����Ѵ�.
 	
 	��� ����)
 	1. 5�� �ȿ� �Է��� ������ ���
 	 -- �� �� --
 	 �ð� �ʰ��� ����� �����ϴ�...
 	 
 	2. 5�� �ȿ� �Է����� ���
 	 -- �� �� --
 	 ��ǻ�� : ����
 	 ����� : ����
 	 �� �� : ����� �̰���ϴ�... / �����ϴ�... / �����ϴ�...
 
 */

public class ThreadTest07 {

	public static void main(String[] args) {
		Count c = new Count();
		UserResult r = new UserResult();
		r.startGame();
		c.start();
		r.start();

	}

}

class Count extends Thread {
	@Override
	public void run() {
		try {
			for (int i = 5; i > 0; i--) {
				if (UserResult.inputCheck == true)
					return;
				System.out.println(i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
		}
		System.out.println("�ð� �ʰ��� ����� �����ϴ�...");
		System.exit(0);
	}
}

class UserResult extends Thread {
	public static boolean inputCheck = false;
	String comResult;


	public void startGame() {
		int i = (int) (Math.random() * 3);
		switch (i) {
		case 0:
			comResult = "����";
			break;
		case 1:
			comResult = "���� ";
			break;
		case 2:
			comResult = "��";
			break;
		}
	}

	@Override
	public void run() {
		String userResult = JOptionPane.showInputDialog("�Է�(����, ����, ��)");
		inputCheck = true;
		if (!(userResult.equals("����") || userResult.equals("����") || userResult.equals("��"))) {
			System.out.println("�߸� �Է��߽��ϴ�.");
			return;
		}

		System.out.println(" -- �� �� -- ");
		System.out.println("��ǻ�� : " + comResult);
		System.out.println("����� : " + userResult);
		switch (userResult) {
		case "����":
			if (comResult.equals("����")) {
				System.out.println("�����ϴ�.");
			} else if (comResult.equals("����")) {
				System.out.println("����� �����ϴ�...");
			} else if (comResult.equals("��")) {
				System.out.println("����� �̰���ϴ�...");
			}
			break;
		case "����":
			if (comResult.equals("����")) {
				System.out.println("����� �̰���ϴ�...");
			} else if (comResult.equals("����")) {
				System.out.println("�����ϴ�.");
			} else if (comResult.equals("��")) {
				System.out.println("����� �����ϴ�...");
			}
			break;
		case "��":
			if (comResult.equals("����")) {
				System.out.println("����� �����ϴ�...");
			} else if (comResult.equals("����")) {
				System.out.println("����� �̰���ϴ�...");
			} else if (comResult.equals("��")) {
				System.out.println("�����ϴ�.");
			}
			break;
		}
	}
}
