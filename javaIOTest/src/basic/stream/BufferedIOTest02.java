package basic.stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedIOTest02 {
-
	public static void main(String[] args) {
		// 문자 기반의 입력용 Buffered스트림 예제
		
		// 문자 기반의 입력용 Buffered스트림은 한 줄 단위로 데이터를 읽어올 수 있다.
		//		==> readLine()메서드
		try {
			// 이클립스를 이용하여 JAVA프로그램을 실행하면 실행된 JAVA프로그램이 소속된 project폴더가 현재 폴더가 된다.
			FileReader fr = new FileReader("./src/basic/file/FileTest01.java");
			BufferedReader br = new BufferedReader(fr);
				//사이즈 안주면 기본값 8kb
			
			String temp = "";	//한 줄 단위로(문자열) 읽어온 데이터가 저장될 변수 선언
			
			for(int i=1; (temp = br.readLine())!=null; i++) {
				System.out.printf("%4d : %s\n",i,temp);
			}
			
			br.close();
			
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}
