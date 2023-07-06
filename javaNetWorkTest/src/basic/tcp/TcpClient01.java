package basic.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient01 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		// 자기 자신 컴퓨터를 나타내는 방법
		// 1) 원래의 IP주소		: 예) 192.168.35.43
		// 2) 지정된 IP주소 	: 예) 127.0.0.1			내 컴퓨터를 나타내는 정해진 아이피주소 => 무조건 자신의 컴퓨터를 의미함
		// 3) 원래의 컴퓨터 이름 : 예)DESKTOP-SVLBVTK
		// 4) 지정된 컴퓨터 이름 : localhost      		네트워크에서 자기자신의 컴퓨터를 나타내는 컴퓨터 이름
		
		System.out.println("서버에 접속 중입니다...");
		
		//서버의 IP주소와 Port번호를 지정하여 Socket객체를 생성한다.
		//Socket객체는 생성이 완료되면 해당 서버로 요청 신호를 보낸다.
		Socket socket = new Socket("localhost",7777);
			//서버의 아이피주소(내 컴퓨터에서 서버/클라이언트 역할 다 하니까 내 컴퓨터의 아이피주소), 포트번호
		
		//이 부분부터는 서버와 연결이 완료된 이후에 처리된다.
		System.out.println();
		System.out.println("서버에 연결이 완료되었습니다...");
		System.out.println();
		
		//서버에서 보내온 메시지를 받아서 화면에 출력하기
		
		//Socket의 InputStream객체를 이용하여 데이터를 수신한다.
		//Socket객체의 getInputStream()메서드 이용
		InputStream in = socket.getInputStream();
		DataInputStream din = new DataInputStream(in);
		
		//서버가 보낸 메시지 받아서 출력하기
		System.out.println("서버에서 보내온 메시지 : " +din.readUTF());
		System.out.println();
		
		//소켓과 스트림 닫기
		din.close();
		socket.close();
		
		
		
	}

}
