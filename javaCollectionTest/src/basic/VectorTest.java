package basic;

import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		// ��ü ����
		Vector v1=new Vector();
		
		System.out.println("ó�� ũ�� : "+v1.size());
		
		//������ �߰��ϱ�1 : add(�߰��ҵ�����)
		// ==> ��ȯ�� : �߰�����(true), �߰�����(false)
		v1.add("AAA");
		v1.add(new Integer(111)); 	//��ü�� ������ �� �ֱ� ������ �̷��� ��߸� �߾��� - 111�� integer����ϴ� ����Ŭ������
		v1.add(123);				// �Ϲ� �����͸� �ָ� �װ��� ��üȭ��Ŵ : �ڽ� - �ڵ����� : ����ڽ�
									// �����ö��� �ٽ� �Ϲݵ����ͷ� ��ȯ�ؾ��� - ��ڽ� - �ڵ����� : �����ڽ�
		v1.add('a');
		v1.add(true);
		boolean r=v1.add(3.14);
		
		System.out.println("���� ũ�� : "+ v1.size());
		System.out.println("��ȯ�� r =>"+ r);
		
		//������ �߰��ϱ�2 : addElement(�߰��ҵ�����) ==>������ �ʱ���� �߰��� �޼���
		v1.addElement("CCC");
		
		System.out.println("v1 =>"+v1.toString());//toString �����ص� ��
		
		//������ �߰��ϱ�3 : add(index, ������)
		//		==> 'index'��°�� '������'�� �����ִ´�.
		//		==> 'index'�� 0���� �����Ѵ�.
		v1.add(1, "KKK");	//�׷��� ���� �ִ� �����ʹ� �ڷ� ��ĭ�� �з���
		System.out.println("v1 =>"+v1);
		System.out.println("-------------------------------------------");
		
		//������ �������� : get(index)
		// ==> 'index'��°�� �����͸� ������ ��ȯ�Ѵ�.
		System.out.println("0��° ������ : "+v1.get(0));
		//������ ���� ������ �����ϰ���� ��
		Integer iTemp1 = (Integer)v1.get(2);	//Vector��ü�� ���� �� ���� �ȿ� �ƹ��ų� �� ������ �� �ֵ��� �ϱ� ���� ObjectŸ������ ����
		int iTemp2 = (int)v1.get(2);			//��ڽ̵Ǿ int�� ������ �� ����
		System.out.println("2��° ������ : "+iTemp2);
		
		// ������ �����ϱ� : set(index, ���ο����)
		//  ==> 'index'��°�� �����͸� '���ο����'�� �����Ѵ�
		//	==> ��ȯ�� : ����Ǳ� �� ������(������ ������)
		String sTemp = (String)v1.set(0, "ZZZ");
		System.out.println("v1 =>"+v1);
		System.out.println("��ȯ�� sTemp=>"+sTemp);	//����Ǳ� ������ ��ȯ
		System.out.println("------------------------------");
		
		//������ �����ϱ� : remove(index)
		//  ==> 'index'��°�� �����͸� �����Ѵ�.
		//	==> ��ȯ�� : ������ ������
		v1.remove(0);
		System.out.println("���� �� v1 =>"+ v1);
		
		sTemp = (String)v1.remove(0);
		System.out.println("���� �� v1 =>"+ v1);
		System.out.println("������ ������ =>"+sTemp);
		System.out.println("--------------------------------");
		
		//													--�����ε� : �޼ҵ� �̸��� �Ȱ����� �Ű������� Ÿ��,���� ����� �ٸ� ��
		//������ �����ϱ�2 : remove(������ ������)					--�������̵� : �θ�� ������ �Ȱ����� ���븸 �ٲ�
		//													--���� ���� �����ε�
		//	==> '������ ������'�� ã�Ƽ� �����Ѵ�.
		//	==> '������ ������'�� �������̸� �� �߿� ���� ù��° �ڷᰡ �����ȴ�.
		//	==> ��ȯ�� : ��������(true), ��������(false)
		//	==> ������ �����Ͱ� '������'�̰ų� 'char'���� ��쿡�� �ݵ�� ��ü�� ��ȯ�ؼ� ����ؾ� �Ѵ�.
		v1.remove("CCC");
		System.out.println("CCC ���� �� v1 =>"+v1);
		//v1.remove(123);		//�ε��� ������ ����ٴ� ���� ��
								//���Ϳ� ���� �����ϸ� ����Ŭ������ �ٲ� ��(����ڽ�) 
								//     - ���� �ȿ� ����ִ� 123�� ���� 123�� �ƴϰ� Integer��üŸ�� 123��
		//v1.remove(new Integer(123));		//�ڹٹ��� 1.9 ���� : ������ ��üȭ��ų �� - new
		v1.remove(Integer.valueOf(123));		//�ڹٹ��� 1.9 �̻� : valueOf
		System.out.println("123 ���� �� v1 =>"+v1);
		
		//v1.remove('a');		//�����ڵ� -> ���ڷ� �ٲ� ����� (���������� ����ȯ��) - ������
		//v1.remove(new Character('a'));
		System.out.println("a ���� �� v1 =>"+v1);
		
		v1.remove(3.14);
		System.out.println("���� �� v1 =>"+v1);
		
		v1.remove(true);
		System.out.println("���� �� v1 =>"+v1);
		
		//��ü ������ �����ϱ� : clear();
		v1.clear();
		System.out.println("clear ���� ��  v1 =>"+v1);
		System.out.println("---------------------------------------");
		
		/*
		 * ���׸�Ÿ��(Generic Type) ==> Ŭ���� ���ο��� ����� ������ Ÿ���� ��ü ������ �� �ܺο��� �������ִ� �������
		 * ��ü�� ������ �� <>��ȣ �ȿ� �� ��ü�� ���ο��� ����� �������� Ÿ���� ������ �ִ� ���� ���Ѵ�.
		 * �̷� ������ �����ϰ� �Ǹ� �� ������ Ÿ�� �̿��� �ٸ� ������ �����͸� ������ �� ����.
		 * ���׸����� ���� �� �� �ִ� ������ Ÿ���� Ŭ���������� �������־�� �Ѵ�.
		 * (�� : int ==> Integer, boolean ==> Boolean, char ==> Character��...)
		 * ���׸� Ÿ������ �����ϰ� �Ǹ� �����͸� ������ �� ������ ����ȯ�� �ʿ����.
		 */
		
		Vector<Integer> v2=new Vector<>();	//int�� �ڷḸ ������ �� �ִ� ����
		Vector<String> v3 = new Vector<String>();	//String�� �ڷḸ ������ �� �ִ� ����
		
		v3.add("�ȳ��ϼ���");
		//v3.add(100);			//����  : ���׸� Ÿ�Կ��� ������ �ڷ����� �ٸ� ������ �ڷ����� ������ �� ����.
		
		String sTemp2=v3.get(0);
		
		Vector<Vector> vv= new Vector<Vector>();
		Vector<Vector<Vector>> vvv=new Vector<Vector<Vector>>();
		System.out.println("-------------------------");
		
		//--------------------------------------------------
		v3.clear();
		
		v3.add("AAA");
		v3.add("BBB");
		v3.add("CCC");
		v3.add("DDD");
		v3.add("EEE");
		
		Vector<String> v4=new Vector<String>();
		v4.add("BBB");
		v4.add("CCC");
		
		System.out.println("v3 =>"+v3);
		System.out.println("v4 =>"+v4);
		
		//������ �����ϱ�3 : removeAll(Collection��ü)
		//	==> ��ü ������ �߿��� 'Collection��ü'�� ������ �ִ� ��� �����͸� �����Ѵ�.
		//	==> ��ȯ�� : �۾�����(true), �۾�����(false)
		v3.removeAll(v4);
		System.out.println("v3 =>"+v3);
	}

}
