package basic.stream;
/*
  'd:/d_other/' 폴더에 있는 '펭귄.jpg'파일을
  'd:/d_other/연습용' 폴더에 '복사본_펭귄.jpg'파일로 복사하는 프로그램 작성하기
 */

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;
/*
public class FileCopyTest {

	public static void main(String[] args) {
		
		try {
			FileInputStream fin = new FileInputStream("d:/d_other/펭귄.jpg");
			FileOutputStream fout = new FileOutputStream("d:/d_other/연습용/펭귄2.jpg");
			
			int c;
			
			while( (c=fin.read())!=-1) {
				fout.write(c);
			}
			
			System.out.println("복사 완료");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

*/
public class FileCopyTest {

	public static void main(String[] args) {
		File file = new File("d:/d_other/펭귄.jpg");
		
		if(!file.exists()) {
			System.out.println(file.getPath() + " 파일이 없습니다...");
			System.out.println("복사 작업을 마칩니다...");
			return;
		}
		
		File dir = new File("d:/d_other/연습용");
		if(!dir.exists()) {		//복사될 대상 폴더가 없으면 새로 만든다...
			dir.mkdirs();
		}
		
		FileInputStream fin=null;			//복사작업은 byte기반 스트림 쓰는게 좋음
		FileOutputStream fout = null;
		
		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;
		
		try {
			//원본 파일을 읽어올 스트림 객체 생성
			fin = new FileInputStream(file);
			bin = new BufferedInputStream(fin);
			
			//대상 파일을 출력할 스트림 객체 생성
			fout = new FileOutputStream(new File(dir, "복사본_펭귄.jpg"));	//그 안에 들어있는 파일 - 파일객체 만들때 지정할 수 있음
			bout = new BufferedOutputStream(fout);
			
			System.out.println("복사 작업 시작...");
			
			int data; 	// 읽어온 데이터가 저장될 변수
			
			while( (data=bin.read())!=-1) {
				bout.write(data);
			}
			
			fout.flush();
			
			System.out.println("복사 작업 완료...");
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fin!=null)try {bin.close(); } catch (Exception e2) {}
					//생성하다가 exception발생하면 fin이 null인 상태에서 닫아버릴 수 있음 => 오류남
			if(fout!=null)try {bout.close(); } catch (Exception e2) {}
		}
		
	}
}

