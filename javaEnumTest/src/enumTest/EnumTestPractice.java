package enumTest;


public class EnumTestPractice {
	
	public enum fruits{���, ������, ����}

	public enum Season01{
		��("3��~5��",1),
		����("6��~8��", 35),
		����("9��~11��",32),
		�ܿ�("12��~2��",23);
		
		private int num;
		private String month;
		
		public int getNum() {
			return num;
		}
		
		public String getMonth() {
			return month;
		}
		
		Season01(String month, int num){
			this.month=month;
			this.num=num;
		}
	}
	
	
	public static void main(String[] args) {
		Season01 s1=Season01.valueOf("����");
		System.out.println(s1.getMonth());
		System.out.println(s1.getNum());
		fruits f1=fruits.valueOf("���");
		System.out.println(f1.ordinal());
		System.out.println(f1.name());

	}

}
