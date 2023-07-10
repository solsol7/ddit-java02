package basic.tcp;

import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer02 {

	public static void main(String[] args) {
		// 서버소켓을 만들고 클라이언트가 접속해 오면 소켓을 만들어서 메시지를 받는 쓰레드와
		// 메시지를 보내는 쓰레드에 이 소켓을 넣어준다.
		try {
			ServerSocket server = new ServerSocket(7777);
			System.out.println("서버가 준비 중입니다...");
			System.out.println();
			
			Socket socket = server.accept();	//여기까지 하면 소켓이 만들어짐
			//accept() 명령이 한번만 실행됨 - 한 사람한테만 : 1대1 채팅밖에 못함
			// 다대다 채팅하려면 accept() 명령이 여러 번 실행되어야함
			// 다대다  - 데이터를 여러 개 저장할 수 있는 컬렉션/배열 등을 이용해서 클라이언트의 접속 정보를 저장해놔야함
				// 어딘가에서 메세지를 받으면 받은 후 메세지를 그대로 배열/컬렉션에 있는 클라이언트 목록에서 하나씩 데이터를 꺼내서 각각의 클라이언트힌테 보내야함
			
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			
			sender.start();
			receiver.start();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		

	}

}
