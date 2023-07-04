
package basic.stream;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

//파일 생성, 파일 
public class FileIOPractice {

	public static void main(String[] args) {
		//FileInputStream  ->바이트 기반
		//FileReader		->문자열 기반
		//InputStreamReader	-> 바이트기반 ->문자열로 읽어옴
		try {
			/*
			File f1 = new File("c:/d_other/test.txt");
			File f2 = new File("c:/d_other/test1.txt");
			System.out.println("파일인가? > "+f1.isFile());
			System.out.println("디렉토리인가? > "+f1.isDirectory());
			
			FileInputStream fin = new FileInputStream(f1);
			InputStreamReader isr = new InputStreamReader(fin,"utf-8");
			
			
			int c=0;
			while((c=isr.read())!=-1) {
				System.out.print((char)c);
			}
			System.out.println();
			isr.close();
			
			InputStreamReader isr2 = new InputStreamReader(System.in);
			//FileOutputStream fout = new FileOutputStream(f2);
			FileWriter fout = new FileWriter(f2);
			
			int d=0;
			while( (d=isr2.read())!= -1 ) {
				fout.write(d);
			}
			
			isr2.close();
			fout.close();
			*/
			File f1 = new File("c:/d_other/test1.txt");
			FileReader fr = new FileReader(f1);
			BufferedReader bfr = new BufferedReader(fr);
			//FileInputStream fin = new FileInputStream(f1);
			//BufferedInputStream bfin = new BufferedInputStream(fin);
			//InputStreamReader isr = new InputStreamReader(bfin,"utf-8");
			
			
			String temp = "";
			while( (temp=bfr.readLine())!=null ) {
				System.out.print(temp);
				System.out.println();
			}
			
			bfr.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

