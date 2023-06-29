package basic;
/*
	3���� �����尡 ���� ���ĺ��� A~Z���� ����ϴµ�
	����� ���� ������� ����� ��Ÿ���� ���α׷� �ۼ��ϱ�
 */
public class ThreadTest12 {

	public static void main(String[] args) {
		DisplayCharacter[] disArr = new DisplayCharacter[] {
				new DisplayCharacter("ȫ�浿"),
				new DisplayCharacter("�̼���"),
				new DisplayCharacter("������"),				
		};
		
		for(DisplayCharacter dc : disArr) {
			dc.start();
		}
		
		for(DisplayCharacter dc : disArr) {
			try {
				dc.join();
			} catch (InterruptedException e) {
				
			}
		}
		
		System.out.println();
		System.out.println("...��� ��� ...");
		System.out.println("�� �� : "+DisplayCharacter.setRank);
	}

}

// A ~ Z���� ����ϴ� ������
class DisplayCharacter extends Thread{
	public static String setRank = "";
	private String name ;
	
	public DisplayCharacter(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		for(char c='A'; c<='Z'; c++) {
			System.out.println(name+"�� ��� ���� : "+c);
			try {	//�ӵ��� ���������� ��������� ���� �̿�(�Ͻ� ���� �ð� ����)
				Thread.sleep((int)(Math.random()*500));
			} catch (InterruptedException e) {
				
			}
		}
		System.out.println(name + "��� ��...");
		
		//����� ���� ������� �̸��� ��ġ�Ѵ�.
		setRank += name+" ";
	}
	
}