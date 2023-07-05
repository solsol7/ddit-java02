package basic.stream;

import java.awt.Panel;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DialogTest {

	public static void main(String[] args) {
		// 자바의 GUI 라이브러리 발전 과정( AWT => SWING => JAVAFX )
		// SWING의 파일 열기, 저장 창 연습
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
		
		//int result = chooser.showOpenDialog(new Panel());	//열기용 창
		int result = chooser.showSaveDialog(new Panel());	//저장용 창
		
		//Dialog창에서 '저장' 또는 '열기' 버튼을 클릭했을 때 처리하기
		if(result == JFileChooser.APPROVE_OPTION) {				//열기 또는 저장버튼을 눌렀다
			File selectedFile = chooser.getSelectedFile();		//선택한 파일 정보 가져오기
			System.out.println("선택 파일 : " + selectedFile.getAbsolutePath());
		}
	}
}

//블록지정
//alt + shift + a