package enumTest;


/*
	enum(������) ==> ���� �����ִ� ������� ������ ��Ÿ����.
				==> Ŭ����ó�� ���̰��ϴ� ���
	�������� �ۼ��ϴ� ��ġ
	1. ������ Java���Ϸ� ���� �� �ִ�.
	2. �ϳ��� Java���Ͽ� Ŭ������ ���� ���� �� �ִ�.
	3. Ŭ���� �ȿ� ���� Ŭ����ó�� ���� �� �ִ�.
	
	- �������� �Ӽ� �� �޼���
	1. name()				==> ������ ����� �̸��� ���ڿ��� ��ȯ�Ѵ�.
	2. ordinal()			==> ������ ����� ���ǵ� ������(index��)�� ��ȯ�Ѵ�. ( 0���� ����)
	3. valueOf("�����������") ==> ���ǵ� ���������� '�����������'�� ��ġ�ϴ� ������ ����� ��ȯ�Ѵ�.
	4. �������̸�.����� 		==> valueOf()�޼���� ����.
	5. values()				==> �������� ���ǵ� ��� ������� �迭�� ��ȯ�Ѵ�.
	
	- ������ �����ϱ�
	���1)
		enum �������̸� { �����1, �����2, ...}
	���2)
		enum �������̸�{
			�����1(����� �����ϰ���� ����...),
			�����2(����...),
			...
			�����n(����...);
		
			//'��'���� ����� �������� �����Ѵ�.
			private �ڷ����̸� ������;
			...
			
			//�������� �����ڸ� �����.
			//�������� �����ڿ����� '���������'�� ������ '����'�� ������ �����ϴ� ������ �����Ѵ�.
			
			//������ �������� ���� �����ڴ� ���������� 'private'�̴�.
			
			//������ �������� �Ű������� ������ '����'�� ������ ���ƾ� �ϰ� ������ ������ �ڷ����� �¾ƾ��Ѵ�.
			private �������̸�(�ڷ��� ������1, ..., �ڷ��� ������n){
				���� ����� ������ �ʱ�ȭ �۾�;
				...
			}
			
			//������ '����'�� �ܺο��� �ҷ��� �� �ִ� getter�޼��带 �����.
			 * 
		}
*/
public class EnumTest {
	public enum Color { RED, GREEN, BLUE }		//�ۼ���ġ 3��
	
	public enum Count { ONE, TWO, THREE }
	
	public enum Season{
		��("3������ 5������", 13),
		����("6������ 8������",28),
		����("9������ 11������", 15),
		�ܿ�("12������ 2������", 1);
		
		//������ ����� ���� ����
		private String span;
		private int temp;
		
		//������
		Season(String months, int temp){	//���������� private������ - private Season(String months, int temp)�� ����
			//���� �ʱ�ȭ �۾�...
			span = months;
			this.temp = temp;
		}
		
		//getter�޼���
		public String getSpan() {
			return span;
		}
		
		public int getTemp() {
			return temp;
		}
		
	}
		
	public static void main(String[] args) {
		/*
		System.out.println("RED : " + ConstTest.RED);
		System.out.println("THREE : " + ConstTest.THREE);
		
		if(ConstTest.RED == ConstTest.TWO) {
			System.out.println(".........");
		}else {
			System.out.println("*********");
		}
		*/
		
		Color mycol = Color.valueOf("GREEN");		//������ Ÿ���� ���� ����
													//Color.GREEN �� ����.
		Count mycnt = Count.ONE;					//Count.valueOf("ONE")�� ����.
		
		System.out.println("mycol >> "+mycol.name());
		System.out.println("mycnt >> "+mycnt.name());
		
		System.out.println("mycol ordinal >> "+ mycol.ordinal());
		System.out.println("mycnt ordinal >> "+ mycnt.ordinal());
		
		/*
		// ���� �ٸ� ������ ������������ �񱳴� �Ұ��ϴ�.
		if(Color.RED == Count.TWO) {
			System.out.println(".....");
		*/
		
		if(mycol == Color.GREEN) {
			System.out.println("����...");
		}else {
			System.out.println("�ٸ���...");
		}
		
		//�������� switch������ ����� �� �ִ�.
		//��, case���� �����ϴ� ���� '�������̸�.�����'�������� ����ϴ� ���� �ƴ϶� '�������̸�'�� ������ '�����'������ ����ؾ� �Ѵ�.
		//case�� ������ ������ �̸� ���� ����� case Count.One :  �ϸ� ����
		switch (mycnt) {
		case ONE : System.out.println("��"); break;
		case TWO : System.out.println("��"); break;
		case THREE : System.out.println("����"); break;

		default:
			break;
		}
		
		System.out.println("---------------------------------------------------");
		
		Season ss= Season.valueOf("��");
		System.out.println("name : "+ss.name());
		System.out.println("ordinal : "+ ss.ordinal());
		System.out.println("span : "+ss.getSpan());
		System.out.println("temp : "+ss.getTemp());
		System.out.println();
		
		//������ ����� ��ü�� ���ʷ� ó���ϱ�...
		for(Season time : Season.values()) {
			System.out.println(time.name() + "==> "+time +" ==>" + time.getSpan()+"==> "+time.getTemp());
		}
		System.out.println();
		
		for(Color col : Color.values()) {
			System.out.println(col + "==> "+col.ordinal());
		}
	}

}
