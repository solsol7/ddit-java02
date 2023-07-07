package practice;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerPractice01 {

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(7777);
			
			System.out.println("서버가 준비중입니다...");
			Socket socket = server.accept();
			
			OutputStream out = socket.getOutputStream();
			DataOutputStream dout = new DataOutputStream(out);
			
			dout.writeUTF("안녕");
			
			dout.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
