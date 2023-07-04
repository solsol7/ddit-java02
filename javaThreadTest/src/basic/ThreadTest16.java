package basic;

//은행의 입출금을 쓰레드로 처리하는 예제

public class ThreadTest16 {
	private int balance;		//잔액이 저장될 변수
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	//입금하는 메서드
	public void deposit(int money) {
		balance += money;
	}
	
	//출금하는 메서드 (출금 성공 : true, 출금 실패 : false 반환)
	public synchronized boolean withdraw(int money) {
		if(balance >= money) {
			for(int i=1; i<=100_000_000; i++) {	//시간 지연을 위해 쓸데없는 코드 넣은것
				int a = i;
			}
			
			 balance -= money;
			 System.out.println("메서드 안에서 balance = "+balance);
			 return true;
		}else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		ThreadTest16 account = new ThreadTest16();	//공통객체
		account.setBalance(10000);		//잔액을 10000원으로 설정
		
		//-------------------------------------
		// 익명 구현체로 쓰레드 작성
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				boolean result = account.withdraw(6000);	//6000원 출금하기
				System.out.println("쓰레드에서 result(출금여부) ="+result+", balance(잔액) = " + account.getBalance());
			}
		};
		//-------------------------------------

		Thread th1 = new Thread(r);
		Thread th2 = new Thread(r);
		
		th1.start();
		th2.start();

}
}
