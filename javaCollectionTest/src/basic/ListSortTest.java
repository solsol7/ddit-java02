package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/*
 * 정렬과 관련된 interface는 Comparable, Comparator 이렇게 두 가지가 있다.
 * 
 * Comparable은 Collection에 추가되는 데이터 자체에 정렬 기준을 넣고 싶을 때 구현하는 인터페이스 (내부정렬 기준)이고,
 * Comparator는 외부에 별도로 정렬 기준을 구현하고 싶을 때 구현하는 인터페이스(외부 정렬 기준)이다.
 * 
 * Comparable에서는 compareTo()메서드를 재정의하고
 * Comparator에서는 compare()메서드를 재정의해야 한다.
 * 
 * String클래스, Wrapper클래스, Date클래스, File클래스등에는 내부 정렬 기준이 구현되어 있다.
 * (내부 정렬 기준은 오름차순으로 처리되도록 구현되어 있다.)
 */

public class ListSortTest {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("일지매");
		list.add("홍길동");
		list.add("성춘향");
		list.add("변학도");
		list.add("이순신");
		
		System.out.println("정렬전 : "+list);
		
		//정렬은 Collections.sort()메서드를 이용하여 정렬한다.
		//Collections.sort()메서드는 기본적으로 내부 정렬 기준으로 정렬한다.
		Collections.sort(list);
		
		System.out.println("정렬후 : "+list);
		
		Collections.shuffle(list);
		System.out.println("자료 섞기 후 : "+ list);
		
		//외부 정렬 기준을 적용해서 정렬하기
		Collections.sort(list, new Desc());
		System.out.println("내림차순 정렬 후 : "+list);
	}
}

//정렬 방식을 정해주는 class 작성하기(외부 정렬 기준 클래스라고 한다.)
class Desc implements Comparator<String>{

	//compare() 메서드를 이용해서 정렬하고자 하는 기준을 정해준다.
	
	//compare() 메서드의 반환값의 의미
	//반환값이 0 	==> 두 값이 같다.
	//반환값이 양수 	==> 두 값의 순서를 바꾼다.
	//반환값이 음수 	==> 두 값의 순서를 바꾸지 않는다.
	
	//예) 오름차순일 경우	==> 앞에 있는 값이 뒤에있는 값보다 크면 양수 반환, 같으면 0반환, 앞에 있는 값이 뒤에 있는 값보다 작으면 음수를 반환시키면 된다.
		//String에 내부정렬기준이 구현되어있음 - 그것 활용
	@Override
	public int compare(String str1, String str2) {	/*//매개변수 - 비교하는 데이터 두 개
													//반환값 중요!
		//내림차순으로 정렬되도록 구현하려고 한다.
		if(str1.compareTo(str2)>0) {		//내부정렬 기준이 0보다 크다
											//=> String은 현재 오름차순으로 정렬되어있음(내부정렬기준) => 양수면 바꿔야한다는 뜻
											//=> 그러면 현재 내림차순으로 정렬되어있다는 의미
											//우리는 내림차순으로 하려고 하니까 양수가 나오면 바꾸면 안된다.
			return -1;						
		}else if(str1.compareTo(str2)<0) {
			return 1;
		}else {
			return 0;
		}
		
		*/
		//부호만 바꿔주면 됨
		return str1.compareTo(str2)*-1;
	}
	
}