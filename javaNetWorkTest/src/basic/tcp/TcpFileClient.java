package basic.tcp;
import java.awt.Panel;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
/*
 * 클라이언트가 서버와 접속이 완료되면 'd:/d_other/펭귄.jpg'파일을
서버로 전송한다.
서버는 클라이언트가 보낸 파일을 받아서 'd:/d_other/upload/펭귄.jpg' 폴더에
저장한다.

클라이언트가 서버와 접속이 완료되면 폴더에 있는 '펭귄.jpg'파일을 전송한다.
 */
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
/*
public class TcpFileClient {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 7777);
			System.out.println("서버에 연결되었습니다.");
			
			FileInputStream fin = new FileInputStream("d:/d_other/펭귄.jpg");
			
			OutputStream out = socket.getOutputStream();
			DataOutputStream dout = new DataOutputStream(out);
			
			int c=0;
			
			byte[] temp = new byte[1024];
			while( (c=fin.read(temp)) >0 ) {
				dout.write(temp, 0, c);
			}
//			dout.flush();
			System.out.println("전송 완료");
			fin.close();
			dout.close();
					
		} catch (Exception e) {
			//e.printStackTrace();
		}
		

	}

}
*/

public class TcpFileClient {

	public void clientStart() {
		//전송용 파일 정보를 갖는 File 객체 생성
		File file = showDialog("OPEN");
		if(!file.exists()) {
			System.out.println(file.getPath() + "파일이 없습니다...");
			return;
		}
		try {
			Socket socket = new Socket("localhost", 7777);
			
			System.out.println("파일 전송 시작 ...");
			
			DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
			
			//서버에 접속하면 첫번째로 파일 이름을 전송한다.
			dout.writeUTF(file.getName());
			
			//파일 입력용 스트림 객체 생성
			BufferedInputStream bin = new BufferedInputStream(new FileInputStream(file));
			
			//서버로 전송할 출력용 스트림 객체 생성
			BufferedOutputStream bout = new BufferedOutputStream(dout);
			
			byte[] temp = new byte[1024];
			int length = 0;
			
			//파일 내용을 읽어서 소켓으로 출력한다.(전송)
			while( (length=bin.read(temp))>0) {
				bout.write(temp, 0, length);
			}
			
			bout.flush();
			
			System.out.println("파일 전송 완료...");
			
			bout.close();
			dout.close();
			
		} catch (Exception e) {
			System.out.println("파일 전송 실패!!!");
			e.printStackTrace();
		}
	}
	
	private File showDialog(String option) {
		File selectedFile = null;
		
		JFileChooser chooser = new JFileChooser();
		
		// 보여줄 파일 목록을 확장자 설정하기
		FileNameExtensionFilter doc = new FileNameExtensionFilter("Word 파일", "docx", "doc", "hwp");
				//화면에 보일 글씨, 확장자 지정-열거해도 되고 배열로 써도 됨
		FileNameExtensionFilter img = new FileNameExtensionFilter("이미지 파일", new String[] {"png", "jpg", "gif"});
		FileNameExtensionFilter txt = new FileNameExtensionFilter("text 파일", "txt");
		
		// 생성한 확장자 목록을 Chooser에 추가한다.
		chooser.addChoosableFileFilter(doc);
		chooser.addChoosableFileFilter(img);
		chooser.addChoosableFileFilter(txt);
		
		// '모든 파일' 목록 표시 설정 여부 ( true : 설정,  false : 헤제
		chooser.setAcceptAllFileFilterUsed(false);
		
		//Dialog창에 나타날 기본 경로 설정하기
		chooser.setCurrentDirectory(new File("d:/d_other"));
		
		int result;
		if("SAVE".equals(option.toUpperCase())) {
			result = chooser.showSaveDialog(new Panel());	//저장용 창
		}else if("OPEN".equals(option.toUpperCase())) {
			result = chooser.showOpenDialog(new Panel());	//열기용 창
		}else {
			System.out.println("option은 'SAVE' 또는 'OPEN'만 사용가능합니다...");
			return null;
		}
		//Dialog창에서 '저장' 또는 '열기' 버튼을 클릭했을 때 처리하기
		if(result == JFileChooser.APPROVE_OPTION) {				//열기 또는 저장버튼을 눌렀다
			selectedFile = chooser.getSelectedFile();		//선택한 파일 정보 가져오기
			//System.out.println("선택 파일 : " + selectedFile.getAbsolutePath());
		}
		
		return selectedFile;
	}
	
	
	public static void main(String[] args) {
		new TcpFileClient().clientStart();
		
	}
	
}
