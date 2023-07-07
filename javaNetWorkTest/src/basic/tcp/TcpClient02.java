package basic.tcp;

import java.net.Socket;

public class TcpClient02 {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("192.168.35.86",7777);
			
			System.out.println("서버에 연결되었습니다...");
			System.out.println();
			
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			
			sender.start();
			receiver.start();
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
