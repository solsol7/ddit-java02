package generic;


/*
- ���׸� Ŭ������ ����� ���
����)
class Ŭ������<���׸�Ÿ�Ա���>{
	���׸�Ÿ�Ա��� ������;				//���� ���� ���׸��� ����� ���
	...
	
	���׸�Ÿ�Ա��� �޼����() {		//��ȯ���� �ִ� �޼��忡 ���׸��� ����� ���
		...
		return ��;
	}
	...
	
	��ȯ��Ÿ�� �޼����(���׸�Ÿ�Ա��� ������, ...){	//�޼����� �Ű������� ���׸��� ����� ���
		...
		
	}
 }
 
 	-- ���׸� Ÿ�� ���� --
 	T ==> Type
 	K ==> Key
 	V ==> Value
 	E ==> Element (�����͸� �ǹ���)
*/

// ���׸��� ������� �ʴ� Ŭ����
class NonGenericClass{
	private Object value;
	
	public void setValue(Object value) {
		this.value=value;
	}
	
	public Object getValue() {
		return this.value;
	}
}

// ���׸��� ������ Ŭ����
class MyGeneric<T>{
	private T value;
	
	public T getValue() {
		return value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
}

public class GenericTest {

	public static void main(String[] args) {
		NonGenericClass ng1=new NonGenericClass();
		ng1.setValue("������");
		
		NonGenericClass ng2 = new NonGenericClass();
		ng2.setValue(100);
		
		String tempNg1 = (String)ng1.getValue();
		System.out.println("���ڿ� ��ȯ��  tempNg1 => "+tempNg1);
		
		int iTempNg2 = (int)ng2.getValue();
		System.out.println("���� ��ȯ�� iTempNg2 => "+ iTempNg2);
		System.out.println();
		
		MyGeneric<String> mg1 = new MyGeneric<String>();
		MyGeneric<Integer> mg2 = new MyGeneric<Integer>();
		
		mg1.setValue("�츮����");
		mg2.setValue(500);

		String tempMg1 = mg1.getValue();
		int iTempMg2 = mg2.getValue();
		System.out.println("���׸� ���ڿ� ��ȯ�� => "+tempMg1);
		System.out.println("���׸� ���� ��ȯ�� => "+iTempMg2);
		
		NonGenericClass ng3 = new NonGenericClass();
		ng3.setValue(1000);
		
		String test = (String)ng3.getValue();
		System.out.println(test);
		
		
	}

}
