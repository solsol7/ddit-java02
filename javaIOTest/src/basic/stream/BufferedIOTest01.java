package basic.stream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedIOTest01 {

	public static void main(String[] args) {
		// Buffered스트림 사용 예제
		
		try {
			FileOutputStream fout = new FileOutputStream("d:/d_other/bufferTest.txt");
			
			// 버퍼의 크기가 5인 버퍼스트림 객체 생성
			BufferedOutputStream bout = new BufferedOutputStream(fout, 5);	//5바이트
			
			for(int i='1'; i<='9'; i++) {
				bout.write(i);
			}
			// 출력용 버퍼는 가득 차야만 출력함 =>12345 가득 차면 그 때 12345출력, 그 후 자동으로 비워짐
			// 그 후 6789 => 데이터 4개밖에 안됨, 버퍼는 가득 차지 않았으니까 출력 안함, 반복문 끝남
			// 이를 방지하기 위해 출력작업이 끝나면 flush()를 호출해서 작업 종료 전 버퍼에 남은 데이터를 모두 출력시킴
			
			bout.flush();	//작업을 종료하기 전에 버퍼에 남아있는 데이터를 모두 출력시킨다.
			
//			fout.close();
			bout.close();	//보조 스트림을 닫으면 보조 스트림에서 사용한 기반 스트림도 같이 닫힌다.
							//버퍼의 close()는 flush()기능도 있다.
							//그래도 flush() 따로 써주는게 좋음
			
			System.out.println("작업 끝...");
			
			
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}
