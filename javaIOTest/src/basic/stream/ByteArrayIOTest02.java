package basic.stream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest02 {

	public static void main(String[] args) {
		byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		byte[] outSrc = null;
		
		byte[] temp = new byte[4];		//4개짜리 배열생성
		
		ByteArrayInputStream bin = new ByteArrayInputStream(inSrc);
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		
		try {
			//읽어올 데이터가 있는지 확인
			while(bin.available()>0) {
//				bin.read(temp);		//한번에 4개씩 읽어오겠다 (배열 갯수만큼 읽어온다)
//				bout.write(temp);
				
				int len = bin.read(temp);		//반환값 구해옴 -실제 읽어온 갯수
				
				//temp배열의 데이터 중 0번째 부터 len갯수만큼 출력한다.
				bout.write(temp,0,len);		//첫번째숫자->시작  / 두번째숫자 ->읽어 올 갯수
				
				
				System.out.println("반복문 안에서 temp => " + Arrays.toString(temp));
			}
			
			outSrc =bout.toByteArray();
			
			bin.close();
			bout.close();
			
			System.out.println();
			System.out.println(" inSrc => " + Arrays.toString(inSrc));
			System.out.println(" outSrc => "+ Arrays.toString(outSrc));
			
		} catch (IOException e) {
			// TODO: handle exception
		}

	}

}
