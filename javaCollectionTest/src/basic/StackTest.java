package basic;

import java.util.Stack;

public class StackTest {
	public static void main(String[] args) {
		Browser b = new Browser();
		
		b.goURL("1. ���̹�");
		b.history();
		
		b.goURL("2. ����Ʈ");
		b.history();
		
		b.goURL("3. ����");
		b.goURL("4. ����");

		b.history();
		
		System.out.println("�ڷΰ��� ��...");
		b.goBack();
		b.history();
		
		System.out.println("������ ���� ��...");
		b.goForward();
		b.history();
		
		System.out.println("���ο� ����Ʈ �����ϱ�...");
		b.goURL("5. ����");
		b.history();
	}
}

//���������� ������ ����, �ڷ� ���� ��� ���� ����(���� �̿�)
class Browser{
	private Stack<String> back;		//���� �湮 ������ ����� ����(�ּ� ����)
	private Stack<String> forward; 	//���� �湮 ������ ����� ����
	private String currentURL;		//���� ������
	
	public Browser() {
		back = new Stack<String>();
		forward = new Stack<String>();
		currentURL = "";
	}
	
	//����Ʈ�� �湮�ϴ� �޼���(�ּ�â�� ������ �Է����� �� ó���ϴ� �޼ҵ�)
	public void goURL(String url) {	//�Ű������� �Է��� �ּ�(�湮�� URL) ����
		System.out.println(url + " ����Ʈ�� �����մϴ�...");
		System.out.println();
		
		if(currentURL != null && !"".equals(currentURL)) {	//���� �������� ������..
															//ó������ false���� - currentURL�� null�̱� ����
			back.push(currentURL);				//���� �������� back���ÿ� �����Ѵ�.
		}
		currentURL = url; 		//���� �������� �̵��� �������� �ٲ���
		forward.clear();		//forward���� ������ ��� �����ϱ�
	}							
	
	//�ڷ� ���� �޼���
	public void goBack() {	//���� �ּҴ� �����ΰ��� ������ �ѱ�� �ڷΰ��� �ּҸ� ������������ �־����
		if(!back.isEmpty()) {	//isEmpty() �޼��� ==> Collection�� �����Ͱ� ������ true, ������ false�� ��ȯ
								//�ڷΰ��Ⱑ �ִ��� �˻�
			forward.push(currentURL); 		//���� �������� forward���ÿ� �߰�
			currentURL = back.pop();		//back���ÿ��� 1���� ��Ҹ� ������ ���� �������� ����
			
		}
	}
	
	//������ ���� �޼���
	public void goForward() {
		if(!forward.isEmpty()) {
			back.push(currentURL);
			currentURL = forward.pop();
		}
	}
	
	//�湮 ��� Ȯ���ϴ� �޼���
	public void history() {
		System.out.println("-----------------------");
		System.out.println("    ��      ��      ��      ��");
		System.out.println("-----------------------");
		System.out.println("back >> "+back);
		System.out.println("��    �� >>"+currentURL);
		System.out.println("forward >>"+ forward);
		System.out.println("------------------------");
		System.out.println();
	}
}