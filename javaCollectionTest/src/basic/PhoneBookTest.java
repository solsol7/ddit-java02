package basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


/*
 * 문제) 이름, 전화번호, 주소를 멤버로 갖는 Phone클래스를 만들고
 * Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
 * (Map의 구조는 key값으로 '이름'을 사용하고 value값으로는 'Phone클래스의 인스턴스'로 한다.)
 * HashMap<String, Phone> 변수명;
 * 
 * 아래 메뉴를 구현하시오.
 * 1. 전화번호 등록
 * 2. 전화번호 삭제
 * 3. 전화번호 수정
 * 4. 전화번호 검색
 * 5. 전화번호 전체 출력
 * 0. 프로그램 종료
 * 
 * - 삭제, 검색기능은 '이름'을 입력받아 처리한다.
 * -----------------------------------------
 * 실행 예시) 
 * ===================================
 * 1. 전화번호 등록
 * 2. 전화번호 삭제
 * 3. 전화번호 수정
 * 4. 전화번호 검색
 * 5. 전화번호 전체 출력
 * 0. 프로그램 종료
 * ====================================
 *  번호입력 >> 1
 *  
 *  새롭게 등록할 전화번호 정보를 입력하세요.
 *  이름 >> 홍길동
 *  전화번호 >> 010-1234-5678
 *  주소 >> 대전시 중구 오류동
 *  
 *   '홍길동' 전화번호 등록 완료!!
 *   
 *    ===================================
 * 1. 전화번호 등록
 * 2. 전화번호 삭제
 * 3. 전화번호 수정
 * 4. 전화번호 검색
 * 5. 전화번호 전체 출력
 * 0. 프로그램 종료
 * ====================================
 *  번호입력 >> 1
 *  
 *  새롭게 등록할 전화번호 정보를 입력하세요.
 *  이름 >> 홍길동
 *  
 *  '홍길동'은 이미 등록된 사람입니다...
 *   ===================================
 * 1. 전화번호 등록
 * 2. 전화번호 삭제
 * 3. 전화번호 수정
 * 4. 전화번호 검색
 * 5. 전화번호 전체 출력
 * 0. 프로그램 종료
 * ====================================
 *  번호입력 >> 5
 *  
 *  ------------------------------------
 *  번호    이름         전화번호                    주소
 *  ------------------------------------
 *   1   홍길동   010-1234-5678  대전시 중구 오류동
 */
public class PhoneBookTest {
	/*
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, Phone> pBook = new HashMap<>();
		Phone p = new Phone();
		loop: while (true) {
			String str = p.start();
			switch (str) {
			case "1":
				p.add(pBook);
				break;
			case "2":
				p.remove(pBook);
				break;
			case "3":
				p.modify(pBook);
				break;
			case "4":
				p.searchOne(pBook);
				break;
			case "5":
				p.searchAll(pBook);
				break;
			case "0":
				break loop;
			default:
				break;
			}
		}

	}

}

class Phone {
	Scanner sc = new Scanner(System.in);

	private String name;
	private String tel;
	private String addr;

	public Phone() {
	}

	public Phone(String name) {
		this.name = name;
	}

	public Phone(String name, String tel, String addr) {
		this.name = name;
		this.tel = tel;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String start() {
		System.out.println("===========================================");
		System.out.println("1. 전화번호 등록");
		System.out.println("2. 전화번호 삭제");
		System.out.println("3. 전화번호 수정");
		System.out.println("4. 전화번호 검색");
		System.out.println("5. 전화번호 전체 출력");
		System.out.println("0. 프로그램 종료");
		System.out.println("===========================================");
		System.out.print("번호 입력 >> ");
		String str = sc.nextLine();

		return str;
	}

	public void add(Map<String, Phone> pBook) {
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
		System.out.print("이름 >> ");
		String name = sc.nextLine();
		if (pBook.containsKey(name)) {
			System.out.println("'" + name + "' 은 이미 등록된 사람입니다...");
		} else {
			System.out.print("전화번호 >> ");
			String tel = sc.nextLine();
			System.out.print("주소 >> ");
			String addr = sc.nextLine();
			pBook.put(name, new Phone(name, tel, addr));
			System.out.println("'" + name + "'" + "전화번호 등록 완료!!");
		}
	}

	public void remove(Map<String, Phone> pBook) {
		System.out.print("삭제할 이름을 입력하세요 >>");
		String name = sc.nextLine();
		if (pBook.containsKey(name)) {
			pBook.remove(name);
			System.out.println("전화번호 삭제 완료!!");
		} else {
			System.out.println("'" + name + "'은 등록되지 않은 사람입니다...");
		}
	}

	public void searchAll(Map<String, Phone> pBook) {
		System.out.println("전화번호 전체 출력");
		System.out.println("-------------------------------------------");
		System.out.println("이름\t\t전화번호\t\t\t주소");
		System.out.println("-------------------------------------------");
		for (String key : pBook.keySet()) {
			System.out.print(pBook.get(key).getName());
			System.out.print("\t\t" + pBook.get(key).getTel());
			System.out.print("\t\t" + pBook.get(key).getAddr());
			System.out.println();
		}
	}

	public void searchOne(Map<String, Phone> pBook) {
		System.out.print("검색할 이름 입력 >> ");
		String name = sc.nextLine();
		if (pBook.containsKey(name)) {
			System.out.println("-------------------------------------------");
			System.out.println("이름\t전화번호\t\t\t주소");
			System.out.println("-------------------------------------------");
			System.out.print(pBook.get(name).getName());
			System.out.print("\t" + pBook.get(name).getTel());
			System.out.print("\t\t" + pBook.get(name).getAddr());
			System.out.println();
		} else {
			System.out.println("'" + name + "'은 등록되지 않은 사람입니다...");
		}
	}

	public void modify(Map<String, Phone> pBook) {
		System.out.print("수정할 이름을 입력하세요 >>");
		String name = sc.nextLine();
		if (pBook.containsKey(name)) {
			System.out.print("수정할 전화번호를 입력하세요 >>");
			String tel = sc.nextLine();
			pBook.replace(name, new Phone(name, tel, pBook.get(name).getAddr()));
			System.out.println("전화번호 수정 완료!!");
		} else {
			System.out.println("'" + name + "'은 등록되지 않은 사람입니다...");
		}
	}

	@Override
	public String toString() {
		return "Phone [name=" + name + ", tel=" + tel + ", addr=" + addr + "]";
	}

}
*/

//선생님답
	private Scanner sc;
	private HashMap<String, Phone> phoneBookMap;

	// 생성자
	public PhoneBookTest() {
		sc = new Scanner(System.in);
		phoneBookMap = new HashMap<String, Phone>();
	}

	private int displayMenu() {
		System.out.println();
		System.out.println("===========================================");
		System.out.println("1. 전화번호 등록");
		System.out.println("2. 전화번호 삭제");
		System.out.println("3. 전화번호 수정");
		System.out.println("4. 전화번호 검색");
		System.out.println("5. 전화번호 전체 출력");
		System.out.println("0. 프로그램 종료");
		System.out.println("===========================================");
		System.out.print("번호 입력 >> ");
		return sc.nextInt();
		
	}

	// 프로그램을 시작하는 메서드
	public void phoneStart() {
		System.out.println();
		System.out.println("===========================================");
		System.out.println("      전 화 번 호 관 리 프 로 그 램");
		System.out.println("===========================================");
		System.out.println();
		while (true) {
			int choice = displayMenu();

			switch (choice) {
			case 1: // 등록
				insert(); break;
			case 2: // 삭제
				delete(); break;
			case 3: // 수정
				update(); break;
			case 4: // 검색
				search(); break;
			case 5: // 전체 출력
				displayAll(); break;
			case 0: // 종료
				System.out.println("프로그램을 종료합니다...");
				return;

			default:
				System.out.println("작업 번호를 잘못 입력했습니다...");
				System.out.println("다시 입력하세요");
			}

		}
	}
	
	private void search() {
		System.out.println();
		System.out.println("검색할 전화번호 정보를 입력하세요...");
		System.out.print("이름 >>");
		String name = sc.next();
		
		if(!phoneBookMap.containsKey(name)) {
			System.out.println(name+"씨의 전화번호 정보는 없습니다...");
			return;
		}
		
		Phone p=phoneBookMap.get(name);
		System.out.println(name+"씨 전화번호 정보");
		System.out.println("-------------------------------------------");
		System.out.println(" 이 름 : "+p.getName());
		System.out.println(" 전화번호 : "+p.getTel());
		System.out.println(" 주 소 : "+p.getAddr());
		System.out.println("-------------------------------------------");
		System.out.println();
	}
	
	private void update() {
		System.out.println();
		System.out.println("수정할 전화번호 정보를 입력하세요...");
		String name=sc.next();
		
		//등록된 사람인지 검사
		if(!phoneBookMap.containsKey(name)) {
			System.out.println(name+"씨는 등록되지 않은 사람입니다...");
			return;
		}
		
		System.out.print("새로운 전화번호 >> ");
		String newTel = sc.next();
		sc.nextLine();			//버퍼 비우기
		
		System.out.print("새로운 주소 >> ");
		String newAddr=sc.nextLine();

		//같은 key값으로 새로운 데이터를 추가하면 수정작업이 완료된다.
		//phoneBookMap.put(name, new Phone(name, newTel, newAddr));
		
		Phone p=phoneBookMap.get(name);
		p.setTel(newTel);
		p.setAddr(newAddr);
		
		System.out.println(name+"씨의 전화번호 정보를 변경했습니다...");
		
	}
	
	
	private void delete() {
		System.out.println();
		System.out.println("삭제할 전화번호 정보를 입력하세요...");
		System.out.print("이름 >>");
		String name=sc.next();
		
		//등록된 사람인지 검사
		if(!phoneBookMap.containsKey(name)) {
			System.out.println(name+"씨는 등록되지 않은 사람입니다...");
			return;
		}
		
		phoneBookMap.remove(name);
		System.out.println(name+ "씨의 전화번호 정보를 삭제했습니다...");
	}

	//전체 자료를 출력하는 메서드
	private void displayAll() {
		System.out.println();
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("번호\t이름\t\t전화번호\t\t\t주소");
		System.out.println("--------------------------------------------------------------------------");
		
		//Map의 key값들만 모두 가져온다.
		Set<String> phoneKeySet = phoneBookMap.keySet();
		
		if(phoneKeySet.size()==0) {
			System.out.println("등록된 전화번호 정보가 하나도 없습니다...");	
		}else {
			int num=0;		//번호
			Iterator<String> keyIt=phoneKeySet.iterator();
			while(keyIt.hasNext()) {
				num++;
				String key=keyIt.next();			//key값(이름) 구하기
				Phone p=phoneBookMap.get(key);		//value값(Phone클래스의 인스턴스) 구하기
				System.out.println(num+"\t"+p.getName()+"\t\t"+p.getTel()+"\t\t"+p.getAddr());
			}
		}
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("출력 끝...");
	}
	
	// 새로운 전화번호 정보를 등록하는 메서드
	private void insert() {
		System.out.println();
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
		System.out.print("이름 >> ");
		String name = sc.next();

		// 이미 등록된 사람인지 검사
		if (phoneBookMap.containsKey(name)) {
			System.out.println("'" + name + "' 은 이미 등록된 사람입니다...");
			return;
		}

		System.out.print("전화번호 >> ");
		String tel = sc.next();
		sc.nextLine();				//입력버퍼 비우기
		System.out.print("주 소 >> ");
		String addr = sc.nextLine();
		
		phoneBookMap.put(name, new Phone(name, tel, addr));
		System.out.println("'" + name + "'" + "전화번호 등록 완료!!");
	}

	private int test() {
		System.out.println("나랄라");
		return 1;
	}

	public static void main(String[] args) {
		//PhoneBookTest p=new PhoneBookTest();
		//int i =p.test();
		//System.out.println(i);
		new PhoneBookTest().phoneStart();

	}
}

class Phone {
	private String name;
	private String tel;
	private String addr;

	public Phone() {
	}

	public Phone(String name, String tel, String addr) {
		super();
		this.name = name;
		this.tel = tel;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Phone [name=" + name + ", tel=" + tel + ", addr=" + addr + "]";
	}

}
