package basic.stream;
/*
  'd:/d_other/' 폴더에 있는 '펭귄.jpg'파일을
  'd:/d_other/연습용' 폴더에 '복사본_펭귄.jpg'파일로 복사하는 프로그램 작성하기
 */

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyTest {

	public static void main(String[] args) {
		
		try {
			FileInputStream fin = new FileInputStream("d:/d_other/펭귄.jpg");
			FileOutputStream fout = new FileOutputStream
			
			int c;
			
			
			while( (c=fin.read())!=-1) {
				
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
