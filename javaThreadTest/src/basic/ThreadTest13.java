package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
	10마리의 말들이 경주하는 경마 프로그램 작성하기...
	
	말은 Horse라는 이름의 쓰레드 클래스로 작성하는데 이 클래스는
	말이름(String), 현재위치(int), 등수(int)를 맴버변수로 갖는다.
	그리고, 이 클래스에는 등수를 오름차순으로 처리할 수 있는 내부 정렬 기준이 있다.
	(Comparable인터페이스 구현)
	
	경기 구간은 1 ~ 50구간으로 되어 있다.
	
	경기가 끝나면 등수 순으로 출력한다. (내부정렬기준)
	
	그리고 경기 중 중간 중간에 각 말들의 현재 위치를 아래와 같이 나타내시오...
	아래)
	
	01번말 : ----->---------------------------------------- (한 구간에 - 표시 하나씩)
	02번말 : --------->------------------------------------
	...
	10번말 : -->-------------------------------------------
				
 */
/*
public class ThreadTest13 {

	public static void main(String[] args) {
		List<Horse> horse=new ArrayList<>();
		
		for(int i=0; i<9; i++) {
			horse.add(new Horse("0"+(i+1)+"번말"));
		}
		horse.add(new Horse("10번말"));
		
		for(int i=0; i<horse.size(); i++) {
			horse.get(i).start();
		}

		while(Horse.endCheck.size()!=10) {
			for(int i=0; i<10; i++) {
				System.out.println();
			}
			for(int i=0; i<horse.size(); i++) {
				System.out.println(horse.get(i).getName()+" : "+horse.get(i));
			}

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}	
			}
			
			
		
		
		for(Horse h : horse) {
			try {
				h.join();
			} catch (InterruptedException e) {
				
			}
		}
		
		Collections.sort(horse);
		
		for(Horse h : horse) {
			System.out.print(h.getName()+" ");
		}
	}

}




class Horse extends Thread implements Comparable<Horse>{
	static List<String> endCheck = new ArrayList<>();
	String name;
	int loc;
	static int rankCount;
	int rank;
	
	public Horse(String name) {
		this.name=name;
		this.setName(name);
	}
	
	String[] runState = new String[50];
	
	public void setting() {
		for(int i=0; i<runState.length; i++) {
			runState[i]="-";
		}
	}
	
	@Override
	public void run() {
		setting();
		for(int i=1; i<runState.length; i++) {
			runState[i-1]="-";
			runState[i]=">";
			
			if(i==runState.length-1) {
				rankCount++;
				rank=rankCount;
				endCheck.add("");
			}
			
			try {
				Thread.sleep((int)(Math.random()*1000));
			} catch (InterruptedException e) {
				
			}
			
		}
		
	}

	@Override
	public String toString() {
		String horse="";
		for(int i=0; i<runState.length; i++) {
			horse+=runState[i];
		}
		return horse;
	}
	
	@Override
	public int compareTo(Horse h1) {
		return Integer.compare(this.rank, h1.rank);
	}

	
	
	
}
*/

//선생님답
public class ThreadTest13 {

	public static void main(String[] args) {
		Horse[] horseArr = new Horse[] {
				new Horse("01번말"), new Horse("02번말"), new Horse("03번말"), new Horse("04번말"), new Horse("05번말"),
				new Horse("06번말"), new Horse("07번말"), new Horse("08번말"), new Horse("09번말"), new Horse("10번말")
		};
		
		GameState gs= new GameState(horseArr);
		
		for(Horse h : horseArr) {
			h.start();
		}
		
		gs.start();		//말들의 경주 상태를 출력하는 쓰레드 시작
		
		//모든 말들의 경주가 끝날 때까지 기다린다..
		for(Horse h : horseArr) {
			try {
				h.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			try {
				gs.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
			
		System.out.println();
		System.out.println("경기 끝...");
		System.out.println();
		
		System.out.println("== 경기 결과 ==");
		
		/*
		//배열 정렬 기능 => Arrays.sort(배열);
		Arrays.sort(horseArr);
		*/
		
		//배열을 리스트로 바꿔서 Collections.sort() 쓰기
		ArrayList<Horse> horseList = new ArrayList<Horse>();
		for(Horse h : horseArr){
			horseList.add(h);
		}
		Collections.sort(horseList);
		
		for(Horse h : horseList) {
			System.out.println(h);
		}
	}
}

// 말의 현재 위치를 나타내는 쓰레드
class GameState extends Thread{
	private Horse[] horseArr;

	//생성자
	public GameState(Horse[] horseArr) {
		this.horseArr = horseArr;
	}
	
	@Override
	public void run() {		//currentRank는 고정적임 => 말이 추가되면 고쳐야함 ==>배열의 갯수를 구함
		while(true) {
			// 모든 말들의 경기가 종료되었는지 여부 검사
			if(Horse.currentRank==horseArr.length) {
				break;
			}
			for(int i=1; i<15; i++) {	//공백출력
				System.out.println();
			}
			
			for(int i=0; i<horseArr.length; i++) {
				System.out.print(horseArr[i].getHorseName()+" : ");
				
				for(int j=1; j<=50; j++) {	//Horse 클래스 run메소드에서 j값 맞춰줘야함
					//말의 현재 위치에는 '>'로 표시하기
					if(horseArr[i].getLocation() == j) {
						System.out.print(">");
					}else {
						System.out.print("-");
					}
				}
				System.out.println();
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
	
}

//Horse클래스 작성
class Horse extends Thread implements Comparable<Horse>{
	public static int currentRank = 0;		//말들이 공통으로 사용할 변수(현재까지의 말들의 등수를 나타낸다.)
	
	private String horseName;		//말이름
	private int location;			//현재 위치
	private int rank;				//등수
	
	//생성자
	public Horse(String horseName) {
		this.horseName = horseName;
	}

	public String getHorseName() {
		return horseName;
	}

	public void setHorseName(String horseName) {
		this.horseName = horseName;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "경주마 " + horseName + "은 " + rank + "등 입니다...";
	}
	
	@Override
	public void run() {
		for(int i=1; i<=50; i++) {
			this.location = i;		//말의 현재 위치 저장
			
			try {
				Thread.sleep((int)(Math.random() * 500));
			} catch (InterruptedException e) {
			
			}
		}
		
		//한 마리의 말의 경주가 끝나면 현재 등수를 구해서 저장한다.
		currentRank++;
		this.rank = currentRank;
	}

	//등수의 오름차순 내부 정렬 기준 만들기
	@Override
	public int compareTo(Horse horse) {
		return Integer.compare(this.rank, horse.getRank());
	}
	
	
}




