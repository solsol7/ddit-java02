package basic;

import java.util.HashSet;
import java.util.Objects;

public class EqualsHashCodeTest {

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setId(2);
		p1.setName("홍길동");
		
		Person p2 = new Person();
		p2.setId(1);
		p2.setName("홍길동");
		
		Person p3 = p1;
		
		System.out.println(p1==p2);		//참조값(주소값) 비교
		System.out.println(p1==p3);
		System.out.println();
		
		System.out.println(p1.equals(p2));
		System.out.println(p1.equals(p3));
		//.equals -> 참조값 비교  .. String에서는 값비교 ->오버라이딩된것임
		
		System.out.println("p1 ==> "+p1);
		System.out.println("p2 ==> "+p2);
		System.out.println("p3 ==> "+p3);
		
		//데이터가 같은지 안같은지 검사 - 이퀄스만 쓰면 되는데 이건 해시코드까지 같이 검사함
		HashSet<Person> testSet = new HashSet<Person>();
		testSet.add(p1);
		testSet.add(p2);
		System.out.println("set의 갯수 >> "+ testSet.size());		//Set앞에 Hash가 붙음 - 객체마다 그 객체의 해시코드가 있음 - 해시코드는 객체가 만들어질 때마다 만들어짐 
																//그 객체라고 하는 것을 나타내는 값 참조값하고 다름
																//해시코드도 오브젝트에 정의되어있는 메소드
				//이퀄스를 재정의해도 해시코드는 변하지 않음 해시코드는 참조값을 비교해서 만듦 - p1, p2 참조값 자체는 다름 - 해시코드값 자체도 다름
				//해시셋같은 곳에 데이터를 넣어서 데이터가 같으면 
				//평상시 비교할 때는 이퀄스비교 - 해시셋에 데이터 넣을때는 해시코드까지 같이 같아야함
				//해시코드도 재정의해야함
		
		System.out.println("p1 hashCode >> "+p1.hashCode());
		System.out.println("p2 hashCode >> "+p2.hashCode());
		System.out.println("p3 hashCode >> "+p3.hashCode());
		/*
  			equals()메서드 ==> 두 객체의 내용이 같은지 비교하는 메서드
  			hashCode()메서드 ==> 두 객체가 같은 객체인지를 비교하는 메서드
  			
  			-HashSet, HashMap, Hashtable과 같이 Hash로 시작하는 컬렉션 객체들은
  			 객체의 의미상의 동일성 비교를 위해서 hashCode()메서드와  equals()메서드를
  			 호출해서 비교한다.
  			-그래서 객체가 같은지 여부를 결정하려면 equals()메서드와  hashCode()메서드를
  			 같이 재정의해야 한다.
  			-hashCode()메서드에서 사용되는 '해싱 알고리즘'은 서로 다른 객체들에 대해 같은
  			 hashCode값을 만들어 낼 수 있다.
		 */
	
	
	}

}

//id변수 값과 name변수값이 모두 같으면 true가 반환되는 equals()메서드 재정의하기
class Person{		//extends Object 가 기본으로 들어가있음 - 생략되어있음
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
		public boolean equals(Object obj) {
			if(this==obj) {					//참조값 비교 - 같으면 같은것
				return true;
			}
			if(obj==null) {			//equals라는 메소드를 썼다는건 나 자신은 뭔가가 있다는건데 상대방은 아무것도 없을때
				return false;
			}
			if(this.getClass()!=obj.getClass()) {		//클래스종류를 구해서 상대방과 다른 종류라면 false반환
				return false;
			}
			//여기까지 통과했으면 참조값은 서로 다르면서 나하고 상대방하고 같은 종류의 클래스라는 뜻
			
			Person that=(Person)obj;	//Object로 감싸져있는 것을 다시 원래의 객체로 형변환한다.
			return this.id ==that.id && Objects.equals(this.name, that.name);
										//Object.equals() -> null값까지 비교할 수 있는 메서드
			
			
	}
	
	@Override
		public int hashCode() {
			return Objects.hash(id, name);
			
		}

}