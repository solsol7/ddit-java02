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
/*
public class ThreadTest13 {

	public static void main(String[] args) {
		List<Horse> horse=new ArrayList<>();
		
		for(int i=0; i<9; i++) {
			horse.add(new Horse("0"+(i+1)+"����"));
		}
		horse.add(new Horse("10����"));
		
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

//�����Դ�
public class ThreadTest13 {

	public static void main(String[] args) {
		Horse[] horseArr = new Horse[] {
				new Horse("01����"), new Horse("02����"), new Horse("03����"), new Horse("04����"), new Horse("05����"),
				new Horse("06����"), new Horse("07����"), new Horse("08����"), new Horse("09����"), new Horse("10����")
		};
		
		GameState gs= new GameState(horseArr);
		
		for(Horse h : horseArr) {
			h.start();
		}
		
		gs.start();		//������ ���� ���¸� ����ϴ� ������ ����
		
		//��� ������ ���ְ� ���� ������ ��ٸ���..
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
		System.out.println("��� ��...");
		System.out.println();
		
		System.out.println("== ��� ��� ==");
		
		/*
		//�迭 ���� ��� => Arrays.sort(�迭);
		Arrays.sort(horseArr);
		*/
		
		//�迭�� ����Ʈ�� �ٲ㼭 Collections.sort() ����
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

// ���� ���� ��ġ�� ��Ÿ���� ������
class GameState extends Thread{
	private Horse[] horseArr;

	//������
	public GameState(Horse[] horseArr) {
		this.horseArr = horseArr;
	}
	
	@Override
	public void run() {		//currentRank�� �������� => ���� �߰��Ǹ� ���ľ��� ==>�迭�� ������ ����
		while(true) {
			// ��� ������ ��Ⱑ ����Ǿ����� ���� �˻�
			if(Horse.currentRank==horseArr.length) {
				break;
			}
			for(int i=1; i<15; i++) {	//�������
				System.out.println();
			}
			
			for(int i=0; i<horseArr.length; i++) {
				System.out.print(horseArr[i].getHorseName()+" : ");
				
				for(int j=1; j<=50; j++) {	//Horse Ŭ���� run�޼ҵ忡�� j�� ���������
					//���� ���� ��ġ���� '>'�� ǥ���ϱ�
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

//HorseŬ���� �ۼ�
class Horse extends Thread implements Comparable<Horse>{
	public static int currentRank = 0;		//������ �������� ����� ����(��������� ������ ����� ��Ÿ����.)
	
	private String horseName;		//���̸�
	private int location;			//���� ��ġ
	private int rank;				//���
	
	//������
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
		return "���ָ� " + horseName + "�� " + rank + "�� �Դϴ�...";
	}
	
	@Override
	public void run() {
		for(int i=1; i<=50; i++) {
			this.location = i;		//���� ���� ��ġ ����
			
			try {
				Thread.sleep((int)(Math.random() * 500));
			} catch (InterruptedException e) {
			
			}
		}
		
		//�� ������ ���� ���ְ� ������ ���� ����� ���ؼ� �����Ѵ�.
		currentRank++;
		this.rank = currentRank;
	}

	//����� �������� ���� ���� ���� �����
	@Override
	public int compareTo(Horse horse) {
		return Integer.compare(this.rank, horse.getRank());
	}
	
	
}




