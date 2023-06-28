package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
  ����) �й�, �̸�, ��������, ��������, ��������, ����, ����� ����� ���� StudentŬ������ �����.
    �� Ŭ������ �����ڿ����� �й�, �̸�, ��������, ��������, ���������� �Ű������� �޾Ƽ�
    �ʱ�ȭ ó���� �Ѵ�.
    
    �� Student��ü�� List�� �����Ͽ� �����Ѵ�.

  List�� ����� �����͵��� �й��� ������������ ������ �� �ִ� ���� ���� ������ �����ϰ�,
    ������ �������� �����ϴµ� ������ ������ �̸��� ������������ ������ �Ǵ� �ܺ� ���� ���� 
    Ŭ������ �ۼ��Ͽ� ���ĵ� ����� ����Ͻÿ�.

    (��, ����� List�� ��ü �����Ͱ� �߰��� �Ŀ� ���ؼ� ����ǵ��� �Ѵ�.)

 */


public class StudentTest {

	public static void main(String[] args) {
/*		List<Student> list=new ArrayList<>();
		
		list.add(new Student("15348","��ٶ�",80,60,90));
		list.add(new Student("11526","��Ű��",70,65,80));
		list.add(new Student("19462","������",100,90,40));
		list.add(new Student("11564","��Ƴ�",80,75,80));
		list.add(new Student("26745","���׳�",75,65,90));
		list.add(new Student("12684","������",80,65,95));

		for(int i=0; i<list.size(); i++) {
			list.get(i).setRank(1);
		}
		for(int i=0; i<list.size(); i++) {
			for(int j=0; j<list.size(); j++) {
				if(list.get(i).getSum()<list.get(j).getSum()) {
					int a=list.get(i).getRank();
					list.get(i).setRank(a+1);
				}
			}
		}
		
		System.out.println("���� �� ...");
		for(Student std : list) {
			System.out.println(std);
		}
		
		Collections.sort(list);
		System.out.println("�й� �������� ...");
		for(Student std : list) {
			System.out.println(std);
		}
		
		Collections.sort(list, new Sum());
		System.out.println("���� ��������...");
		for(Student std : list) {
			System.out.println(std);
		}
		
		
	}

}
 �� ��
class Sum implements Comparator<Student>{

	@Override
	public int compare(Student std1, Student std2) {
		if(std1.getSum()>(std2.getSum())){
			return -1;
		}else if(std1.getSum()<(std2.getSum())) {
			return 1;
		}else {
			return std1.getStdName().compareTo(std2.getStdName());
			}
		}
	}


class Student implements Comparable<Student>{
	private String stdNo;
	private String stdName;
	private int korScore;
	private int engScore;
	private int mathScore;
	private int sum;
	private int rank;
	
	public Student(String stdNo, String stdName, int korScore, int engScore, int mathScore) {
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.korScore = korScore;
		this.engScore = engScore;
		this.mathScore = mathScore;
		sum=korScore+engScore+mathScore;
	}

	public String getStdNo() {
		return stdNo;
	}

	public void setStdNo(String stdNo) {
		this.stdNo = stdNo;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public int getKorScore() {
		return korScore;
	}

	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}

	public int getEngScore() {
		return engScore;
	}

	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	
	@Override
	public String toString() {
		return "Student [stdNo=" + stdNo + ", stdName=" + stdName + ", korScore=" + korScore + ", engScore=" + engScore
				+ ", mathScore=" + mathScore + ", sum=" + sum + ", rank=" + rank + "]";
	}

	@Override
	public int compareTo(Student std) {
		return this.getStdNo().compareTo(std.getStdNo());
	}

	

	
}

*/

//�����Դ�	
		
		
		
		
		List<Student> stdList=new ArrayList<>();

		stdList.add(new Student(15348,"��ٶ�",80,60,90));
		stdList.add(new Student(11526,"��Ű��",70,65,80));
		stdList.add(new Student(19462,"������",100,90,40));
		stdList.add(new Student(11564,"��Ƴ�",80,75,80));
		stdList.add(new Student(26745,"���׳�",75,65,90));
		stdList.add(new Student(12684,"������",80,65,95));
		
		StudentTest stdTest=new StudentTest();
		stdTest.createRank(stdList);
		
		System.out.println("������...");
		for( Student std : stdList) {
			System.out.println(std);
		}
		System.out.println("----------------------------------------------");
		
		//�й��� �������� �����ϱ�
		Collections.sort(stdList);
		
		System.out.println("�й��� �������� ���� ��...");
		for( Student std : stdList) {
			System.out.println(std);
		}
		System.out.println("----------------------------------------------");
		
		//������ ����(��������)���� �����ϱ�
		Collections.sort(stdList, new SortByTotal());

		System.out.println("������ �������� ���� ��...");
		for( Student std : stdList) {
			System.out.println(std);
		}
	}


	//����� ���ϴ� �޼���
	public void createRank(List<Student> list) {
		for(Student std1 : list) {								//���� �����͸� ���ϱ� ���� �ݺ���
			int rank = 1;										//ó������ 1������ ������ ���� �����Ѵ�.
			
			for(Student std2 : list) {							//�� ����� ��Ÿ���� �ݺ���
				if(std1.getTot() < std2.getTot()) {				//���ذ����� ����� ũ��
					rank++;										//rank�� ����
				}
			}
			
			std1.setRank(rank);//������ ����� Student��ü�� rank������ �����Ѵ�
		}
	}
}





class Student implements Comparable<Student>{
	private int num;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private int rank;
	
	public Student(int num, String name, int kor, int eng, int mat) {
		super();
		this.num = num;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = kor+eng+mat;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", mat=" + mat + ", tot="
				+ tot + ", rank=" + rank + "]";
	}

	@Override
	public int compareTo(Student std) {
		return Integer.compare(this.num, std.getNum());
	}
	
}

//������ �������� �����ϴµ� ������ ������ �̸��� ������������ ������ �Ǵ� �ܺ����� ����
class SortByTotal implements Comparator<Student>{

	@Override
	public int compare(Student std1, Student std2) {
		if(std1.getTot() == std2.getTot()) {
			return std1.getName().compareTo(std2.getName());
		}else {
			return Integer.compare(std1.getTot(), std2.getTot())*-1;
		}
	}
}
