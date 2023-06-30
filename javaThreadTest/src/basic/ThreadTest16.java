package basic;

//������ ������� ������� ó���ϴ� ����

public class ThreadTest16 {
	private int balance;		//�ܾ��� ����� ����
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	//�Ա��ϴ� �޼���
	public void deposit(int money) {
		balance += money;
	}
	
	//����ϴ� �޼��� (��� ���� : true, ��� ���� : false ��ȯ)
	public synchronized boolean withdraw(int money) {
		if(balance >= money) {
			for(int i=1; i<=100_000_000; i++) {	//�ð� ������ ���� �������� �ڵ� ������
				int a = i;
			}
			
			 balance -= money;
			 System.out.println("�޼��� �ȿ��� balance = "+balance);
			 return true;
		}else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		ThreadTest16 account = new ThreadTest16();	//���밴ü
		account.setBalance(10000);		//�ܾ��� 10000������ ����
		
		//-------------------------------------
		// �͸� ����ü�� ������ �ۼ�
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				boolean result = account.withdraw(6000);	//6000�� ����ϱ�
				System.out.println("�����忡�� result(��ݿ���) ="+result+", balance(�ܾ�) = " + account.getBalance());
			}
		};
		//-------------------------------------

		Thread th1 = new Thread(r);
		Thread th2 = new Thread(r);
		
		th1.start();
		th2.start();

}
}
