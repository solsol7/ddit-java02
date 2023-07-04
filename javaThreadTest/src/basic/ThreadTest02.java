package basic;

public class ThreadTest02 {

	public static void main(String[] args) {
		//멀티 쓰레드
		
		//Thread를 사용하는 방법
		//방법1)
		//	-Thread클래스를 상속한 class를 작성한 후 이 class의 인스턴스를 생성한 후
		//	  이 인스턴스의 start()메서드를 호출해서 실행한다.
		MyThread01 th1=new MyThread01();
		th1.start();	//run()메서드를 호출하면 쓰레드를 작동시키는게 아님, 메인쓰레드에서 하나의 흐름으로 실행, start()호출해야함
					//start() => 여러개의 흐름으로 진행될 수 있도록 쓰레드의 환경을 만들어주는 메서드
					//		쓰레드환경을 만들고 새로 만든 환경에서 run()메서드를 자동으로 호출해줌
		//방법2)
		//	-Runnable인터페이스를 구현한 class를 작성한 후 이 class의 인스턴스를 생성하고
		//	  이 인스턴스를 Thread클래스의 인스턴스를 생성할 때 인수값으로 넘겨준다.
		//	  그리고 이 때 생성된 Thread클래스의 인스턴스의 start()메서드를 호출해서 실핸한다.
		MyThread02 r2 = new MyThread02();
		Thread th2 = new Thread(r2);
		th2.start();
		
		//방법2-1)
		//	-Runnable인터페이스를 익명구현체로 작성하여 실행하기 =>객체를 한번만 생성해서 쓰고싶을때 사용
		Runnable r3 = new Runnable() {
			
			@Override
			public void run() {
				for(int i=1; i<=200; i++) {
					System.out.print("@");
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						
					}
				}
			}
		};		//하나의 문장으로 보기때문에 끝에 ; 붙여야함
		
		Thread th3=new Thread(r3);
		th3.start();
		
		System.out.println("main메서드 끝...");
			//모든 스레드가 다 끝나야 프로세스가 끝남 => 메인메소드 끝났다고 끝나는거 아님
	}
	
}

//방법1의 class 작성
class MyThread01 extends Thread{
	@Override
	public void run() {
		//이 run()메서드 안에 쓰레드가 처리할 내용을 작성한다.
		for(int i=1; i<=200; i++) {
			System.out.print("*");
			
			try {
				// Thread.sleep(시간); ==> 주어진 시간동안 작업을 잠시 멈춘다.
				//	시간은 밀리세컨드 단위를 사용한다. (즉, 1000은 1초를 의미한다.)
				Thread.sleep(100);
			} catch (InterruptedException e) {
				
			}
		}
	}
}


//방법2의 class 작성
class MyThread02 implements Runnable{
	@Override
	public void run() {
		for(int i=1; i<=200; i++) {
			System.out.print("$");

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				
			}
		}
	}
}