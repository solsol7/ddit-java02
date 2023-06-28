package basic;

import java.util.ArrayList;

public class ArrayListTest01 {

	public static void main(String[] args) {
		//ArrayList�� �⺻���� ������ Vector�� ����.
		
		ArrayList list1 = new ArrayList();
		
		//add()�޼���� �����͸� �߰��Ѵ�.
		list1.add("aaa");
		list1.add("bbb");
		list1.add(123);
		list1.add('k');
		list1.add(true);
		list1.add(123.45);
		
		System.out.println("list1 =>"+list1);
		System.out.println("size==>"+list1.size());
		System.out.println();
		
		//�����ֱ⵵ ����
		list1.add(3,"zzz");
		System.out.println("list1 =>"+list1);
		
		//get()�޼���� ������ ��������
		System.out.println("1��° �ڷ� : "+list1.get(1));
		
		//������ �����ϱ�
		String sTemp=(String)list1.set(3, "yyy");
		System.out.println("list1 =>"+list1);
		System.out.println("sTemp =>"+sTemp);
		System.out.println();
		
		//������ ����.
		list1.remove(3);
		System.out.println("3��° �ڷ� ���� �� list1 =>"+list1);
		
		list1.remove("bbb");
		System.out.println("bbb �ڷ� ���� �� list1 =>"+list1);
		
		//���׸��� ����� �� �ִ�.
		ArrayList<String> list2=new ArrayList<String>();
		list2.add("AAAA");
		list2.add("BBBB");
		list2.add("CCCC");
		list2.add("DDDD");
		list2.add("EEEE");
		
		//Vector�� List�� ��ü �����͸� ���ʷ� ������ ó���� ���� �ݺ����� ����Ѵ�.
		// (�ַ� for��)
		
		for(int i=0; i<list2.size(); i++) {
			System.out.println(i + "��° ������ ==>"+list2.get(i));
		}
		System.out.println();
		
		//���� for��
		for(String str : list2) {
			System.out.println(str);
		}
		
		// contains(�񱳰�ü) ==> ����Ʈ�� ����� ������ �߿��� '�񱳰�ü'�� ������ true, ������ false�� ��ȯ
		System.out.println("DDDD���� ���� ���� : "+list2.contains("DDDD"));
		System.out.println("ZZZZ���� ���� ���� : "+list2.contains("ZZZZ"));
		
		//indexOf(�񱳰�ü)
		//lastIndexOf(�񱳰�ü) ==> ����Ʈ�� '�񱳰�ü'�� ������ '�񱳰�ü'�� ����� index���� ��ȯ
		//						  ������ -1�� ��ȯ�Ѵ�.
		//  -indexOf()�޼���� �˻� ������ �տ��� ���� �������� �˻��ϰ�
		//   lastIndexOf() �޼���� �ڿ��� ���� �������� �˻��Ѵ�.
		//  -����Ʈ�� '�񱳰�ü'�� ���� �����Ͱ� �������� ù��°�� ã���� �������� ��ġ��(index��)�� ��ȯ�Ѵ�.
		list2.clear();
		list2.add("AAAA");
		list2.add("BBBB");
		list2.add("CCCC");
		list2.add("DDDD");
		list2.add("EEEE");
		list2.add("AAAA");
		list2.add("BBBB");
		list2.add("CCCC");
		list2.add("DDDD");
		list2.add("EEEE");
		
		System.out.println("list2 =>"+list2);
		System.out.println("DDDD�� ��ġ�� : "+list2.indexOf("DDDD"));
		System.out.println("DDDD�� ��ġ�� : "+list2.lastIndexOf("DDDD"));
		System.out.println("ZZZZ�� ��ġ�� : "+list2.lastIndexOf("ZZZZ"));//ã�� �����Ͱ� ������ -1
		
		// -toArray() ==> ����Ʈ ���� �����͸� �迭�� ��ȯ�ؼ� ��ȯ�Ѵ�.
		//			  ==> �⺻������ Object�� �迭�� ��ȯ�Ѵ�.
		// -toArray(new ���׸�Ÿ���ڷ���[0]) ==> ���׸� Ÿ���� �迭�� ��ȯ�ؼ� ��ȯ�Ѵ�.
		
		Object[] strArr = list2.toArray();
		//String[] strArr = (String[])list2.toArray();	//�迭 - �������� �����Ͱ� �Ѳ����� ���� Ʋ : �迭 ��ü�� ����ȯ �� ���� ����
		System.out.println("����Ʈ�� ���� : "+list2.size());
		System.out.println("�迭�� ���� : "+strArr.length);
		for(int i=0; i<strArr.length; i++) {
			System.out.println(i+"��° �ڷ� : "+strArr[i]);
		}
		
		System.out.println("-----------------------------------------------");
		
		//���׸� Ÿ���� �迭�� ��ȯ�ؼ� ��������
		String[] strArr2 = list2.toArray(new String[0]);
		for(String s : strArr2) {
			System.out.println(s);
		}
		}
	}

