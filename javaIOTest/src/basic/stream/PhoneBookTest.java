package basic.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
 * 
 * -추가 조건)
    1) '6. 전화번호 저장'메뉴를 추가하고 그 기능을 구현한다.
       (저장 파일명 : 'phoneBookData.dat'로 한다.)
    2) 프로그램이 시작될 때 저장된 파일이 있으면 그 데이터를 읽어와서  사용한다.
       ( 읽어온 데이터를 Map에 저장한다.)
    3) 프로그램을 종료할 때 Map의 데이터가 추가, 수정, 삭제 등으로 변경되었으면 
           저장한 후에 종료되도록 한다.
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
/*
public class PhoneBookTest {
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
		System.out.println("6. 전화번호 저장");
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
		//초기설정 - 파일에 있는 전화번호 맵에 저장하기
		setting();
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
			case 6: // 저장
				store(); break;
			case 0: // 종료
				store();
				System.out.println("프로그램을 종료합니다...");
				return;
			default:
				System.out.println("작업 번호를 잘못 입력했습니다...");
				System.out.println("다시 입력하세요");
			}

		}
	}
	
	//초기설정 - 파일에 있는 전화번호 맵에 저장하기
	public void setting() {
		FileOutputStream fout = null;
		BufferedOutputStream bout = null;
		ObjectOutputStream oout = null;
		
		File file = new File("d:/d_other");
		if(!file.exists()) file.mkdirs();
		file = new File(file,"phoneBookData.dat");
		
		try {
			if(!file.exists()) file.createNewFile();
			fout = new FileOutputStream(file,true);
			bout = new BufferedOutputStream(fout);
			oout = new ObjectOutputStream(bout);
			
			oout.writeObject(null);
			
		} catch (IOException e) {
			
		}finally {
			if(oout!=null)try {oout.close();} catch (Exception e2) {}
		}
		
		FileInputStream fin = null;
		BufferedInputStream bin = null;
		ObjectInputStream oin = null;
		
		List<Phone> list = new ArrayList<>();
		
		try {
			fin = new FileInputStream(file);
			bin = new BufferedInputStream(fin);
			oin = new ObjectInputStream(bin);
			
			Object obj;
			while( (obj=oin.readObject())!=null ) {
				list.add((Phone)obj);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(oin!=null)try {oin.close();} catch (IOException e2) {}
		}
		
		for(int i=0; i<list.size(); i++) {
			phoneBookMap.put(list.get(i).getName(), list.get(i));
		}
		
	}
	
	//맵에 있는 전화번호 파일에 저장하기
	public void store() {
		File file = new File("d:/d_other/phoneBookData.dat");
		FileOutputStream fout = null;
		BufferedOutputStream bout = null;
		ObjectOutputStream oout = null;
		
		try {
			fout = new FileOutputStream(file);
			bout = new BufferedOutputStream(fout);
			oout = new ObjectOutputStream(bout);

			for(String key : phoneBookMap.keySet()) {
				oout.writeObject(phoneBookMap.get(key));
			}
			oout.writeObject(null);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(oout !=null)try {oout.close();} catch (IOException e2) {}
		}
		System.out.println("전화번호 저장 완료!!");
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

	public static void main(String[] args) {
		//PhoneBookTest p=new PhoneBookTest();
		//int i =p.test();
		//System.out.println(i);
		new PhoneBookTest().phoneStart();

	}
}

class Phone implements Serializable{
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

*/

//선생님답
public class PhoneBookTest {
	private Scanner sc;
	private HashMap<String, Phone> phoneBookMap;
	private final String filename = "d:/d_other/phoneBookData.dat";
	
	//데이터가 변경되었는지 여부를 나타내는 변수 선언
	private boolean dataChange;			//데이터가 변경되면  true로 변경된다.

	// 생성자
	public PhoneBookTest() {	//객체가 호출될 때 가장 먼저 생성자가 실행됨 => 생성자에서 파일내용 읽어와서 맵에 세팅하기
		sc = new Scanner(System.in);
		phoneBookMap = load();		//폰에 데이터가 있으면 맵을 반환하지만데이터가 없으면  null을 반환함
									//		==>null값이 되면 HashMap이 생성이 안됐으니까 뒤에서 작업을 못함
		if(phoneBookMap==null) {
			phoneBookMap = new HashMap<String, Phone>();
		}
	}
	private int displayMenu() {
		System.out.println();
		System.out.println("===========================================");
		System.out.println("1. 전화번호 등록");
		System.out.println("2. 전화번호 삭제");
		System.out.println("3. 전화번호 수정");
		System.out.println("4. 전화번호 검색");
		System.out.println("5. 전화번호 전체 출력");
		System.out.println("6. 전화번호 저장");
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
		//초기설정 - 파일에 있는 전화번호 맵에 저장하기
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
			case 6: // 저장
				save(); break;
			case 0: // 종료
				if(dataChange) save();
				System.out.println("프로그램을 종료합니다...");
				return;
			default:
				System.out.println("작업 번호를 잘못 입력했습니다...");
				System.out.println("다시 입력하세요");
			}

		}
	}
	

	   // 파일에 저장된 전화번호 정보를 읽어와서 Map 에 셋팅한 후 반환하는 메서드
	// 파일에 저장된 전화번호 정보를 읽어와서 Map 에 셋팅한 후 반환하는 메서드
	   private HashMap<String, Phone> load() {
	      HashMap<String, Phone> pMap = null; // 읽어오은 데이터가 저장될 변수
	      File file = new File(filename);
	      if (!file.exists()) { // 저장된 파일이 없으면...
	         System.out.println("");
	         return null;
	      }

	      // 객체가 저장된 파일을 읽어올 스트림 객체 변수 선언
	      ObjectInputStream oin = null;
	      try {
	         oin = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));

//	         	저장을 '방법1'로 했을 때...
//	         pMap = (HashMap<String, Phone>)oin.readObject();

	         // 저장을 '방법2'로 했을 때...
	         Object pObj; // 읽어온 Phone객체가 저장될 변수 선언

	         pMap = new HashMap<String, Phone>();

	         while ((pObj = oin.readObject()) != null) {
	            Phone p = (Phone) pObj;
	            String name = p.getName();
	            pMap.put(name, p);
	         }

	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	      }

	      return pMap;
	   }
	
	//전화번호 정보를 저장하는 메서드
	public void save() {
		ObjectOutputStream oout = null;
		try {
			//객체 출력용 스트림 객체 생성
			oout = new ObjectOutputStream(
					new BufferedOutputStream(
						new FileOutputStream(filename)));
			//객체를 저장하기
			//방법1 ==> 전화번호 정보가 저장된 Map객체를 저장한다.
						//컬렉션 객체들을 Serializable처리 다 되어있음
			//oout.writeObject(phoneBookMap);
					//읽어올 때 하나만 읽어오면 되기 때문에 null저장 안해도 됨
			
			
			//방법2 ==> Map에 저장된 Phone객체를 하나씩 저장한다.
			for(String name : phoneBookMap.keySet()) {
				Phone p = phoneBookMap.get(name);
				oout.writeObject(p);
			}
			oout.writeObject(null);		//마지막을 나타내는 null값 저장
					//읽어올 때 반복문을 이용해 읽어와야 하기 때문에 마지막을 나타내는 null값 넣어야함
			
			System.out.println("저장이 완료되었습니다...");
			dataChange = false;
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(oout !=null)try {oout.close();} catch (IOException e) {}
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
		dataChange = true;
		
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
		dataChange = true;
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
		dataChange =true;
	}

	public static void main(String[] args) {
		//PhoneBookTest p=new PhoneBookTest();
		//int i =p.test();
		//System.out.println(i);
		new PhoneBookTest().phoneStart();

	}
}

class Phone implements Serializable{
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
