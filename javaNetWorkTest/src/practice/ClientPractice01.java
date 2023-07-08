package practice;

import java.io.DataInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.Socket;

public class ClientPractice01 {
	
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost",7777);
			System.out.println("서버에 연결되었습니다.");
			
			InputStream in = socket.getInputStream();
			DataInputStream din = new DataInputStream(in);
			
			System.out.println("서버가 보낸 메세지");
			System.out.println(din.readUTF());
			
			
			
			din.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
