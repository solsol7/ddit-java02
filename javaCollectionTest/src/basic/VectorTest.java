package basic;

import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		// 객체 생성
		Vector v1=new Vector();
		
		System.out.println("처음 크기 : "+v1.size());
		
		//데이터 추가하기1 : add(추가할데이터)
		// ==> 반환값 : 추가성공(true), 추가실패(false)
		v1.add("AAA");
		v1.add(new Integer(111)); 	//객체만 저장할 수 있기 때문에 이렇게 써야만 했었음 - 111을 integer라고하는 래퍼클래스로
		v1.add(123);				// 일반 데이터를 주면 그것을 객체화시킴 : 박싱 - 자동으로 : 오토박싱
									// 꺼내올때는 다시 일반데이터로 변환해야함 - 언박싱 - 자동으로 : 오토언박싱
		v1.add('a');
		v1.add(true);
		boolean r=v1.add(3.14);
		
		System.out.println("현재 크기 : "+ v1.size());
		System.out.println("반환값 r =>"+ r);
		
		//데이터 추가하기2 : addElement(추가할데이터) ==>벡터의 초기버전 추가용 메서드
		v1.addElement("CCC");
		
		System.out.println("v1 =>"+v1.toString());//toString 생략해도 됨
		
		//데이터 추가하기3 : add(index, 데이터)
		//		==> 'index'번째에 '데이터'를 끼워넣는다.
		//		==> 'index'는 0부터 시작한다.
		v1.add(1, "KKK");	//그러면 원래 있던 데이터는 뒤로 한칸씩 밀려남
		System.out.println("v1 =>"+v1);
		System.out.println("-------------------------------------------");
		
		//데이터 꺼내오기 : get(index)
		// ==> 'index'번째의 데이터를 꺼내서 반환한다.
		System.out.println("0번째 데이터 : "+v1.get(0));
		//꺼내온 값을 변수에 저장하고싶을 때
		Integer iTemp1 = (Integer)v1.get(2);	//Vector객체를 만들 때 변수 안에 아무거나 다 저장할 수 있도록 하기 위해 Object타입으로 받음
		int iTemp2 = (int)v1.get(2);			//언박싱되어서 int로 저장할 수 있음
		System.out.println("2번째 데이터 : "+iTemp2);
		
		// 데이터 수정하기 : set(index, 새로운데이터)
		//  ==> 'index'번째의 데이터를 '새로운데이터'로 변경한다
		//	==> 반환값 : 변경되기 전 데이터(원래의 데이터)
		String sTemp = (String)v1.set(0, "ZZZ");
		System.out.println("v1 =>"+v1);
		System.out.println("반환값 sTemp=>"+sTemp);	//변경되기 전값을 반환
		System.out.println("------------------------------");
		
		//데이터 삭제하기 : remove(index)
		//  ==> 'index'번째의 데이터를 삭제한다.
		//	==> 반환값 : 삭제된 데이터
		v1.remove(0);
		System.out.println("삭제 후 v1 =>"+ v1);
		
		sTemp = (String)v1.remove(0);
		System.out.println("삭제 후 v1 =>"+ v1);
		System.out.println("삭제된 데이터 =>"+sTemp);
		System.out.println("--------------------------------");
		
		//													--오버로딩 : 메소드 이름은 똑같은데 매개변수의 타입,갯수 등등이 다를 때
		//데이터 삭제하기2 : remove(삭제할 데이터)					--오버라이딩 : 부모와 구조는 똑같은데 내용만 바뀜
		//													--지금 경우는 오버로딩
		//	==> '삭제할 데이터'를 찾아서 삭제한다.
		//	==> '삭제할 데이터'가 여러개이면 이 중에 제일 첫번째 자료가 삭제된다.
		//	==> 반환값 : 삭제성공(true), 삭제실패(false)
		//	==> 삭제할 데이터가 '정수형'이거나 'char'형일 경우에는 반드시 객체로 변환해서 사용해야 한다.
		v1.remove("CCC");
		System.out.println("CCC 삭제 후 v1 =>"+v1);
		//v1.remove(123);		//인덱스 범위를 벗어났다는 에러 뜸
								//벡터에 숫자 저장하면 래퍼클래스로 바뀌어서 들어감(오토박싱) 
								//     - 벡터 안에 들어있는 123은 숫자 123이 아니고 Integer객체타입 123임
		//v1.remove(new Integer(123));		//자바버전 1.9 이전 : 데이터 객체화시킬 때 - new
		v1.remove(Integer.valueOf(123));		//자바버전 1.9 이상 : valueOf
		System.out.println("123 삭제 후 v1 =>"+v1);
		
		//v1.remove('a');		//문자코드 -> 숫자로 바뀌어서 저장됨 (정수형으로 형변환됨) - 에러남
		//v1.remove(new Character('a'));
		System.out.println("a 삭제 후 v1 =>"+v1);
		
		v1.remove(3.14);
		System.out.println("삭제 후 v1 =>"+v1);
		
		v1.remove(true);
		System.out.println("삭제 후 v1 =>"+v1);
		
		//전체 데이터 삭제하기 : clear();
		v1.clear();
		System.out.println("clear 삭제 후  v1 =>"+v1);
		System.out.println("---------------------------------------");
		
		/*
		 * 제네릭타입(Generic Type) ==> 클래스 내부에서 사용할 데이터 타입을 객체 생성할 때 외부에서 지정해주는 기법으로
		 * 객체를 선언할 때 <>괄호 안에 그 객체의 내부에서 사용할 데이터의 타입을 지정해 주는 것을 말한다.
		 * 이런 식으로 선언하게 되면 그 데이터 타입 이외의 다른 종류의 데이터를 저장할 수 없다.
		 * 제네릭으로 선언 될 수 있는 데이터 타입은 클래스형으로 지정해주어야 한다.
		 * (예 : int ==> Integer, boolean ==> Boolean, char ==> Character등...)
		 * 제네릭 타입으로 선언하게 되면 데이터를 꺼내올 때 별도의 형변환이 필요없다.
		 */
		
		Vector<Integer> v2=new Vector<>();	//int형 자료만 저장할 수 있는 벡터
		Vector<String> v3 = new Vector<String>();	//String형 자료만 저장할 수 있는 벡터
		
		v3.add("안녕하세요");
		//v3.add(100);			//오류  : 제네릭 타입에서 지정한 자료형과 다른 종류의 자료형은 저장할 수 없다.
		
		String sTemp2=v3.get(0);
		
		Vector<Vector> vv= new Vector<Vector>();
		Vector<Vector<Vector>> vvv=new Vector<Vector<Vector>>();
		System.out.println("-------------------------");
		
		//--------------------------------------------------
		v3.clear();
		
		v3.add("AAA");
		v3.add("BBB");
		v3.add("CCC");
		v3.add("DDD");
		v3.add("EEE");
		
		Vector<String> v4=new Vector<String>();
		v4.add("BBB");
		v4.add("CCC");
		
		System.out.println("v3 =>"+v3);
		System.out.println("v4 =>"+v4);
		
		//데이터 삭제하기3 : removeAll(Collection객체)
		//	==> 전체 데이터 중에서 'Collection객체'가 가지고 있는 모든 데이터를 삭제한다.
		//	==> 반환값 : 작업성공(true), 작업실패(false)
		v3.removeAll(v4);
		System.out.println("v3 =>"+v3);
	}

}
