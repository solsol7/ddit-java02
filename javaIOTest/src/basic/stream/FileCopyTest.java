package basic.stream;
/*
  'd:/d_other/' 폴더에 있는 '펭귄.jpg'파일을
  'd:/d_other/연습용' 폴더에 '복사본_펭귄.jpg'파일로 복사하는 프로그램 작성하기
 */

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;

public class FileCopyTest {

	public static void main(String[] args) {
		
		try {
			FileInputStream fin = new FileInputStream("c:/d_other/펭귄.jpg");
			FileOutputStream fout = new FileOutputStream("c:/d_other2/펭귄2.jpg");
			
			int c;
			
			while( (c=fin.read())!=-1) {
				fout.write(c);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
