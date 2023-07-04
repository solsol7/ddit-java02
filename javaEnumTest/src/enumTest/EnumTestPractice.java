package enumTest;


public class EnumTestPractice {
	
	public enum fruits{사과, 오렌지, 포도}

	public enum Season01{
		봄("3월~5월",1),
		여름("6월~8월", 35),
		가을("9월~11월",32),
		겨울("12월~2월",23);
		
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
		Season01 s1=Season01.valueOf("여름");
		System.out.println(s1.getMonth());
		System.out.println(s1.getNum());
		fruits f1=fruits.valueOf("사과");
		System.out.println(f1.ordinal());
		System.out.println(f1.name());

	}

}
