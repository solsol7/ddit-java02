package basic.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TcpMultiChatServer {
	// 접속한 클라이언트 정보를 저장할 Map객체 변수 선언
	// key값 ==> 접속한 사람 이름, value값 ==> 접속한 클라이언트와 연결된 Socket객체
			//클라이언트와 연결된 소켓이 있어야 통신을 할 수 있음 => 소켓을 어딘가에 보관만 해놓으면 됨, 어떤 소켓인지 구분하기 위해 key값 이름
			//key값이 겹치면(있는 사람의 이름을 나중 사람이 등록하면) 첫번째 사람의 소켓 정보는 두번째 사람의 소켓에 덮어씌워져버림
	private Map<String, Socket> clientMap;
	
	// 생성자
	// 채팅을 할 때 순서가 정해져있지 않고 뒤죽박죽 채팅 보냄 => 서버도 클라이언트가 전달한 내용들을 처리해주는 쓰레드가 있어야함
		// 쓰레드에서 클라이언트 목록 관리 => 동기화처리 필요
	public TcpMultiChatServer() {
		//clientMap이 동기화 처리가 되도록 생성한다.
		clientMap = Collections.synchronizedMap(new HashMap<String, Socket>());
		
	}
	
	public static void main(String[] args) {
		new TcpMultiChatServer().serverStart();
	}

	// 시작 메서드
	public void serverStart() {
		ServerSocket server = null;
		Socket socket = null;
		try {
			server = new ServerSocket(7777);
			System.out.println("서버가 시작되었습니다...");
			
			while(true) {
				//맨 처음 시작될 때는 하나의 클라이언트의 접속을 기다림 => 걔랑 연결된 소켓을 socket에 저장하고 진행
				// while문이기 때문에 끝나고 또다른 클라이언트의 접속을 기다릴 수 있음
				socket = server.accept();
				System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() +
						"]에서 접속했습니다...");
						//상대방 ip 정보와 포트번호 구함
				System.out.println();
				//--------------------------------------------------------
				
				ServerReceiver serverThread = new ServerReceiver(socket);
				serverThread.start();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(server!=null) try {server.close();}catch(Exception e) {}
		}
		
	}	//시작 메서드 끝...
	
	//clientMap에 저장된 전체 클라이언트들에게 메시지를 전송하는 메서드
	private void sendToAll(String msg) {
		//clientMap의 데이터 개수만큼 반복
		for(String name : clientMap.keySet()) {
			try {
				// 전송할 스트림 객체 생성
				DataOutputStream dout =
						new DataOutputStream(clientMap.get(name).getOutputStream());
						//맵에 있는 클라이언트의 소켓을 이용해서 dout을 구함
				dout.writeUTF(msg);	// 메시지 보내기
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}	//sendToAll()메서드 끝...
	
	// --------------------------------------------------------------
	
	// Inner Class(내부클래스)로 서버에서 클라이언트로 메시지를 전송하는 Thread를 작성한다.
	// 		==> Outer Class의 멤버 변수를 자유롭게 사용하기 위해서 내부클래스 사용
	class ServerReceiver extends Thread{
		private Socket socket;
		private DataInputStream din;
		private DataOutputStream dout;
		
		//생성자
		public ServerReceiver(Socket socket) {
			this.socket = socket;
			try {
				// 송신용 스트림 객체 생성
				dout = new DataOutputStream(this.socket.getOutputStream());
				
				// 수신용 스트림 객체 생성
				din = new DataInputStream(this.socket.getInputStream());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}	//생성자 끝...
		
		@Override
		public void run() {
			//접속한 사람의 이름을 받아서 똑같은 key값이 있는지 검사해야함
			String name = "";
			try {
				// 클라이언트가 연결이 완료되면 첫번째로 '대화명(이름)'을 입력 받아 보낸다.
				// 서버는 이 '대화명'을 받아서 현재 Map에 저장된 목록에서 중복되는지 여부를 응답으로 클라이언트에게 보낸다.
				// 중복되지 않은 이름을 클라이언트가 입력할 때 까지 반복해서 이 작업을 수행해야 함
				
				//클라이언트가 보내온 '대화명'이 중복되지 않을 때까지 반복한다.
				while(true) {
					name = din.readUTF();		// 클라이언트가 보낸 '대화명' 받기
					
					if(clientMap.containsKey(name)) {	//'대화명'이 중복되면...
						dout.writeUTF("대화명중복");			//클라이언트에게 '대화명중복'메시지 전송
					}else {		//중복되지 않으면...
						dout.writeUTF("OK"); 		//'OK'메시지 전송
						break;		//반복문 탈출...
					}
				}		//while문 끝...
				
				// 접속한 사람의 대화명을 이용하여 다른 전체 클라이언트들에게 대화방 참여 메시지를 전송한다.
				sendToAll("[" + name + "]님이 대화방에 입장했습니다...");
				
				// 접속한 사람의 대화명과 Socket정보를 Map에 추가한다.
				clientMap.put(name, this.socket);
				
				System.out.println("현재 접속자 수 : " + clientMap.size() + "명");
				
				// 한 클라이언트가 보낸 메시지를 전체 클라이언트들에게 보낸다.
				while(din!=null) {
					sendToAll(din.readUTF());
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				// 이 finally영역이 실행된다는 것은 클라이언트의 접속이 종료되었다는 의미이다.
				// 대화방에서 대화를 나누던 사람이 대화방을 빠져나갔다는 뜻
				
				// 사용자 목록에서 해당 대화명을 삭제한다.
				clientMap.remove(name);
				sendToAll("[" + name +"]님이 접속을 종료했습니다...");
				
				System.out.println("[" + this.socket.getInetAddress() + " : " + this.socket.getPort() +
						"]에서 접속했습니다...");
				System.out.println();
				System.out.println("현재 접속자 수 : " + clientMap.size() +"명");
				System.out.println();
				
			}
		}
		
	}	// 쓰레드 끝...
	
}
