package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
	10������ ������ �����ϴ� �渶 ���α׷� �ۼ��ϱ�...
	
	���� Horse��� �̸��� ������ Ŭ������ �ۼ��ϴµ� �� Ŭ������
	���̸�(String), ������ġ(int), ���(int)�� �ɹ������� ���´�.
	�׸���, �� Ŭ�������� ����� ������������ ó���� �� �ִ� ���� ���� ������ �ִ�.
	(Comparable�������̽� ����)
	
	��� ������ 1 ~ 50�������� �Ǿ� �ִ�.
	
	��Ⱑ ������ ��� ������ ����Ѵ�. (�������ı���)
	
	�׸��� ��� �� �߰� �߰��� �� ������ ���� ��ġ�� �Ʒ��� ���� ��Ÿ���ÿ�...
	�Ʒ�)
	
	01���� : ----->---------------------------------------- (�� ������ - ǥ�� �ϳ���)
	02���� : --------->------------------------------------
	...
	10���� : -->-------------------------------------------
				
 */

public class ThreadTest13 {

	public static void main(String[] args) {
		List<Horse> horse=new ArrayList<>();
		
		for(int i=0; i<10; i++) {
			horse.add(new Horse((i+1)+"����"));
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
				System.out.println("0"+(i+1)+"���� : "+horse.get(i));
			}
				System.out.println("10���� : "+horse.get(9));
			
			
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
