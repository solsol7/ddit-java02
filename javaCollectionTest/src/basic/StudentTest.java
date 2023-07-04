package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
  문제) 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는 Student클래스를 만든다.
    이 클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만 매개변수로 받아서
    초기화 처리를 한다.
    
    이 Student객체는 List에 저장하여 관리한다.

  List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현하고,
    총점의 역순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬이 되는 외부 정렬 기준 
    클래스를 작성하여 정렬된 결과를 출력하시오.

    (단, 등수는 List에 전체 데이터가 추가된 후에 구해서 저장되도록 한다.)

 */


public class StudentTest {

	public static void main(String[] args) {
/*		List<Student> list=new ArrayList<>();
		
		list.add(new Student("15348","김다라",80,60,90));
		list.add(new Student("11526","김키주",70,65,80));
		list.add(new Student("19462","하진나",100,90,40));
		list.add(new Student("11564","양아나",80,75,80));
		list.add(new Student("26745","이잉나",75,65,90));
		list.add(new Student("12684","전가나",80,65,95));

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
		
		System.out.println("변경 전 ...");
		for(Student std : list) {
			System.out.println(std);
		}
		
		Collections.sort(list);
		System.out.println("학번 오름차순 ...");
		for(Student std : list) {
			System.out.println(std);
		}
		
		Collections.sort(list, new Sum());
		System.out.println("총점 내림차순...");
		for(Student std : list) {
			System.out.println(std);
		}
		
		
	}

}
 내 답
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

//선생님답	
		
		
		
		
		List<Student> stdList=new ArrayList<>();

		stdList.add(new Student(15348,"김다라",80,60,90));
		stdList.add(new Student(11526,"김키주",70,65,80));
		stdList.add(new Student(19462,"하진나",100,90,40));
		stdList.add(new Student(11564,"양아나",80,75,80));
		stdList.add(new Student(26745,"이잉나",75,65,90));
		stdList.add(new Student(12684,"전가나",80,65,95));
		
		StudentTest stdTest=new StudentTest();
		stdTest.createRank(stdList);
		
		System.out.println("정렬전...");
		for( Student std : stdList) {
			System.out.println(std);
		}
		System.out.println("----------------------------------------------");
		
		//학번의 오름차순 정렬하기
		Collections.sort(stdList);
		
		System.out.println("학번의 오름차순 정렬 후...");
		for( Student std : stdList) {
			System.out.println(std);
		}
		System.out.println("----------------------------------------------");
		
		//총점의 역순(내림차순)으로 정렬하기
		Collections.sort(stdList, new SortByTotal());

		System.out.println("총점의 내림차순 정렬 후...");
		for( Student std : stdList) {
			System.out.println(std);
		}
	}


	//등수를 구하는 메서드
	public void createRank(List<Student> list) {
		for(Student std1 : list) {								//기준 데이터를 구하기 위한 반복문
			int rank = 1;										//처음에는 1등으로 설정해 놓고 시작한다.
			
			for(Student std2 : list) {							//비교 대상을 나타내는 반복문
				if(std1.getTot() < std2.getTot()) {				//기준값보다 대상값이 크면
					rank++;										//rank값 증가
				}
			}
			
			std1.setRank(rank);//구해진 등수를 Student객체의 rank변수에 저장한다
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

//총점의 역순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬이 되는 외부정렬 기준
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
