package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/*
	Vector, Hashtable등과 같이 예전부터 존재하던 Collection객체들은
	내부에 동기화 처리가 되어 있다.
	
	그런데 새롭게 구성된 Collection 객체들은 동기화 처리가 되어있지 않다.
	그래서, 동기화가 필요한 프로그램에서 이런 Collection들을 사용하려면
	동기화 처리를 한 후에 사용해야 한다.
	(방법 => Collections객체의 synchronized로 시작하는 메서드 이용)
 */

public class ThreadTest17 {
	public static Vector<Integer> vec=new Vector<>();
	
	//동기화 처리가 되지 않은 List
	public static List<Integer> list = new ArrayList<Integer>();
	
	//동기화 처리를 한 경우
	public static List<Integer> list2 = Collections.synchronizedList(new ArrayList<Integer>());
	
	public static void main(String[] args) {
		
		
		//--------------------------------------------
		//익명구현체
		Runnable r= new Runnable() {
			
			@Override
			public void run() {
				/*
				for(int i=0; i<10000; i++) {
					vec.add(i);
				}
				*/
				/*
				for(int i=0; i<10000; i++) {
					list.add(i);
					//데이터가 정한 크기를 넘어가면 -> 더 큰 새로운 배열 만들고 원래의 데이터를 새로 만든곳에 옮기고 추가함 -> 그 과정에서 오류남
				}
				*/
				for(int i=0; i<10000; i++) {
					list2.add(i);
				}
				
			}
		};
		//--------------------------------------------
		
		Thread[] thArr = new Thread[] {
			new Thread(r), new Thread(r), new Thread(r), new Thread(r), new Thread(r),
		};
		for(Thread th : thArr) {
			th.start();
		}
		
		for(Thread th : thArr) {
			try {
				th.join();
			} catch (InterruptedException e) {
				
			}
		}
		
		System.out.println("vec의 개수 : "+vec.size());
		System.out.println("list의 개수 : "+list2.size());
	}

}
