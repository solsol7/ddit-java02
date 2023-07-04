package basic.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//파일 생성, 파일 
public class FileIOPractice {

	public static void main(String[] args) {
		//FileInputStream  ->바이트 기반
		//FileReader		->문자열 기반
		//InputStreamReader	-> 바이트기반 ->문자열로 읽어옴
		try {
			File f1 = new File("d:/d_other/practice.txt");
			FileInputStream fin = new FileInputStream(f1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

