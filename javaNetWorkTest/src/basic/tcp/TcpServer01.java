package basic.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//클라이언트가 접속하면 접속한 소켓과 연결되어있는 소켓을 만듦 => 그 소켓을 통해 메세지를 클라이언트한테 보냄 => 클라이언트는 접속을 해서 접속이 성공하면 서버가 보낸 메세지를 받아 화면에 출력함
public class TcpServer01 {

	public static void main(String[] args) throws IOException {
		// TCP소켓 통신을 위해서 ServerSocket객체를 생성한다.
		ServerSocket server = new ServerSocket(7777); 
				//포트번호 - 0~1204 시스템용 번호		//1024번 뒤 포트번호 사용해야함  포트번호 중복되면 나중에 쓰는 프로그램 실행안됨
		System.out.println("클라이언트의 접속을 기다립니다...");
		
		// accept()메서드 ==> 클라이언트에서 연결 요청이 올 때까지 계속 기다린다.
		//				==> 연결 요청이 오면 새로운 Socket객체를 생성해서 클라이언트의 Socket과 연결하고, 연결된 Socket객체를 반환한다.
		Socket socket = server.accept();		//클라이언트와 연결된 소켓 =>클라이언트 요청이 와서 소켓이 연결이 되면 연결된 소켓 반환하면서 그 다음 진행
		
		//accept()메서드 명령 이후는 클라이언트와 연결된 후에 처리할 내용을 기술하면 된다.
		System.out.println();
		System.out.println("클라이언트와 연결되었습니다...");
		System.out.println();
		
		// Socket객체를 이용하여 상대방의 정보를 구할 수 있다.
		System.out.println("상대방의 정보 확인...");
		System.out.println("IP주소 : " + socket.getInetAddress().getHostAddress());
		System.out.println("Port 번호 " + socket.getPort());
		System.out.println();
		
		// 자신의 정보도 구할 수 있다.		=>다른 컴퓨터와연결되어있는 내 컴퓨터의 정보
		 System.out.println("자기자신의 정보 확인...");
		 System.out.println("IP 주소 : " + socket.getLocalAddress());
		 System.out.println("Port 번호 : " + socket.getLocalPort());
		 System.out.println();
		 //---------------------------------------------------------------------------
		 
		 //클라이언트에게 메시지 보내기 ==> Socket의 OutputStream객체를 이용하여 보낸다.
		 OutputStream out = socket.getOutputStream();
		 DataOutputStream dout = new DataOutputStream(out);
		
		 //클라이언트에게 메시지 전송
		 dout.writeUTF("환영합니다. 어서오세요...");
		 
		 System.out.println("메시지를 보냈습니다...");
		
		 //소켓과 스트림 닫기
		 dout.close();
		 socket.close();
		 server.close();
		
//		 클라이언트 포트번호 지정하지 않으면 알아서 포트번호 씀
		
	}

}

/*
	일대일 통신
 * 데이터 보내고 받는 작업이 동시에 일어남 => 쓰레드 씀 .. 채팅 프로그램 등에 필수적으로 들어감
 * 하나는 보내는 쓰레드 / 하나는 받는 쓰레드
 * 
*/