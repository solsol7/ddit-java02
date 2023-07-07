package basic.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

//이 클래스는 소켓을 통해서 메시지를 보내는 역할을 담당하는 쓰레드 클래스이다.
public class Sender extends Thread {
	
	private Socket socket;		//소켓의 참조값을 저장할 변수
	private DataOutputStream dout;		//메시지 보내는 객체
	private	String name;			//메시지를 누가 보냈는지 나타냄(사용자 이름이나 아이디 등 저장
	private Scanner sc;
	
	//생성자
	public Sender(Socket socket) {
		this.socket = socket;			//객체가 생성될 때 소켓을 받음
		sc = new Scanner(System.in);
		
		try {
			System.out.println("이름 입력 >> ");
			name = sc.nextLine();
			
			//소켓을 이용한 전송용(출력용) 스트림 객체 생성
			dout = new DataOutputStream(this.socket.getOutputStream());//소켓을 이용해 아웃풋스트림 객체 만들고 아웃풋스트림 활용하는 dout만들어줌
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	@Override
	public void run() {
		while(dout!=null) {
			try {
				//이름과 입력한 내용을 붙여서 전송한다.
				dout.writeUTF(name + " : " + sc.nextLine());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	

}
