package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/*
 * ���İ� ���õ� interface�� Comparable, Comparator �̷��� �� ������ �ִ�.
 * 
 * Comparable�� Collection�� �߰��Ǵ� ������ ��ü�� ���� ������ �ְ� ���� �� �����ϴ� �������̽� (�������� ����)�̰�,
 * Comparator�� �ܺο� ������ ���� ������ �����ϰ� ���� �� �����ϴ� �������̽�(�ܺ� ���� ����)�̴�.
 * 
 * Comparable������ compareTo()�޼��带 �������ϰ�
 * Comparator������ compare()�޼��带 �������ؾ� �Ѵ�.
 * 
 * StringŬ����, WrapperŬ����, DateŬ����, FileŬ������� ���� ���� ������ �����Ǿ� �ִ�.
 * (���� ���� ������ ������������ ó���ǵ��� �����Ǿ� �ִ�.)
 */

public class ListSortTest {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("������");
		list.add("ȫ�浿");
		list.add("������");
		list.add("���е�");
		list.add("�̼���");
		
		System.out.println("������ : "+list);
		
		//������ Collections.sort()�޼��带 �̿��Ͽ� �����Ѵ�.
		//Collections.sort()�޼���� �⺻������ ���� ���� �������� �����Ѵ�.
		Collections.sort(list);
		
		System.out.println("������ : "+list);
		
		Collections.shuffle(list);
		System.out.println("�ڷ� ���� �� : "+ list);
		
		//�ܺ� ���� ������ �����ؼ� �����ϱ�
		Collections.sort(list, new Desc());
		System.out.println("�������� ���� �� : "+list);
	}
}

//���� ����� �����ִ� class �ۼ��ϱ�(�ܺ� ���� ���� Ŭ������� �Ѵ�.)
class Desc implements Comparator<String>{

	//compare() �޼��带 �̿��ؼ� �����ϰ��� �ϴ� ������ �����ش�.
	
	//compare() �޼����� ��ȯ���� �ǹ�
	//��ȯ���� 0 	==> �� ���� ����.
	//��ȯ���� ��� 	==> �� ���� ������ �ٲ۴�.
	//��ȯ���� ���� 	==> �� ���� ������ �ٲ��� �ʴ´�.
	
	//��) ���������� ���	==> �տ� �ִ� ���� �ڿ��ִ� ������ ũ�� ��� ��ȯ, ������ 0��ȯ, �տ� �ִ� ���� �ڿ� �ִ� ������ ������ ������ ��ȯ��Ű�� �ȴ�.
		//String�� �������ı����� �����Ǿ����� - �װ� Ȱ��
	@Override
	public int compare(String str1, String str2) {	/*//�Ű����� - ���ϴ� ������ �� ��
													//��ȯ�� �߿�!
		//������������ ���ĵǵ��� �����Ϸ��� �Ѵ�.
		if(str1.compareTo(str2)>0) {		//�������� ������ 0���� ũ��
											//=> String�� ���� ������������ ���ĵǾ�����(�������ı���) => ����� �ٲ���Ѵٴ� ��
											//=> �׷��� ���� ������������ ���ĵǾ��ִٴ� �ǹ�
											//�츮�� ������������ �Ϸ��� �ϴϱ� ����� ������ �ٲٸ� �ȵȴ�.
			return -1;						
		}else if(str1.compareTo(str2)<0) {
			return 1;
		}else {
			return 0;
		}
		
		*/
		//��ȣ�� �ٲ��ָ� ��
		return str1.compareTo(str2)*-1;
	}
	
}