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

public class ThreadTest13 {

	public static void main(String[] args) {
		List<Horse> horse=new ArrayList<>();
		
		for(int i=0; i<10; i++) {
			horse.add(new Horse((i+1)+"번말"));
		}
		
		for(int i=0; i<horse.size(); i++) {
			horse.get(i).start();
		}

		boolean a=true;
		while(a) {
			for(int i=0; i<10; i++) {
				System.out.println();
			}
			for(int i=0; i<horse.size()-1; i++) {
				System.out.println("0"+(i+1)+"번말 : "+horse.get(i));
			}
				System.out.println("10번말 : "+horse.get(9));
			
			
			if(horse.get(0).a==1 && horse.get(1).a==1 && horse.get(2).a==1 && horse.get(3).a==1 && horse.get(4).a==1 &&
				horse.get(5).a==1 && horse.get(6).a==1 && horse.get(7).a==1 && horse.get(8).a==1 && horse.get(9).a==1) {
				a=false;
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
	
	int a=-1;
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
				a=1;
			}
			
			try {
				Thread.sleep((int)(Math.random()*1000));
			} catch (InterruptedException e) {
				
			}
			
		}
		
	}
	
	
	
	@Override
	public int compareTo(Horse h1) {
		return Integer.compare(this.rank, h1.rank);
	}

	@Override
	public String toString() {
		String horse="";
		for(int i=0; i<runState.length; i++) {
			horse+=runState[i];
		}
		return horse;
	}
	
	
	
}
