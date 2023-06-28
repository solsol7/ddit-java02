package args;


public class ArgsTest {
	/*
	-������ �μ� ==> �޼����� �μ��� ������ ȣ��� ������ �ٸ� �� ����Ѵ�.
		* ������ �μ��� �޼��� �ȿ����� �迭�� ó���ȴ�.
		* ������ �μ��� �Ѱ��� �ڷ����� ����� �� �ִ�.
	*/

	//�Ű������� ���� �������� �հ踦 ���ϴ� �޼��带 �ۼ��Ͻÿ�.
	//(�� �� �������� ������ ��Ȳ�� ���� �ٸ���..)

	//�迭�� �̿��� ���
	public int sumArr(int[] data) {
		int sum = 0;
		
		for(int i=0; i<data.length; i++) {
			sum += data[i];
		}
		
		return sum;
	}
	
	//������ �μ��� �̿��� ���
	public int sumArg(int... data) {
		int sum = 0;
		
		for(int i=0; i<data.length; i++) {
			sum += data[i];
		}
		
		return sum;		
	}
	
	//������ �μ��� �Ϲ����� �μ��� ���� ����� ��쿡�� ������ �μ��� ���� ���ʿ� ��ġ�ؾ� �Ѵ�.
	public String sumArg2(String name, int...data) {
		int sum = 0;
		
		for(int i=0; i<data.length; i++) {
			sum += data[i];
		}
		
		return name+ "���� �ղ� : " + sum;		
		
	}
	
	public static void main(String[] args) {
		ArgsTest at = new ArgsTest();
		
		int[] nums = {100, 200, 300};
		
//		int[] nums2 = {1,2,3,4,5};
//		int[] nums3;
//		nums3= new int[] {1,2,3,4,5};
		
		System.out.println(at.sumArr(nums));
		System.out.println(at.sumArr(new int[] {1,2,3,4,5}));		//1,2,3,4,5�� �迭�� �־ ������
		System.out.println();
		System.out.println(at.sumArg(100,200,300));
		System.out.println(at.sumArg(1,2,3,4,5));
		System.out.println();
		
		System.out.println(at.sumArg2("ȫ�浿", 10,20,30,60,70,80));
	}
	
}
