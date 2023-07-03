package basic.file;

import java.io.File;

public class FileTest01 {

	public static void main(String[] args) {
		//File��ü ����� ����
		
		//1. new File(String ���� �Ǵ� ���)
		//	==> ���丮�� ���丮 ���� �Ǵ� ���丮�� ���ϸ� ������ ���й��ڴ�
		//		��������('\')�� ����ϰų� ������('/')�� ����� �� �ִ�.
		
		//File file1 = new File("d:\\D_Other\\test.txt");	//���й��ڸ� ��������('\')�� ��� - ���������� ū ����ǥ �ȿ� �� �� �ι� �������
		File file1 = new File("d:/D_Other/test.txt");	//���й��ڸ� ������('/')�� ���
		
		System.out.println("���ϸ� : "+file1.getName());
		System.out.println("���丮 �ΰ�? ==> "+file1.isDirectory());
		System.out.println("���� �ΰ�? ==> "+ file1.isFile());
		System.out.println();
		
		File file2 = new File("d:/D_Other");
		System.out.println("���ϸ� : "+file2.getName());
		System.out.println("���丮 �ΰ�? ==> "+file2.isDirectory());
		System.out.println("���� �ΰ�? ==> "+file2.isFile());
		System.out.println();
		
		//2. new File(File parent, String child)
		//	==> 'parent'���丮 �ȿ� �ִ� 'child'������ ������ ���� File��ü ����
		File file3 = new File(file2, "test.txt");
		System.out.println("���ϸ� : "+file3.getName());
		System.out.println("���丮 �ΰ�? ==> "+file3.isDirectory());
		System.out.println("���� �ΰ�? ==> "+file3.isFile());
		System.out.println();
		
		//3. new File(String parent, String child)
		//	==> 'parent'���丮 �ȿ� �ִ� 'child'������ ������ ���� File��ü ����
		File file4 = new File("d:/D_Other", "test.txt");
		System.out.println("���ϸ� : "+file4.getName());
		System.out.println("���丮 �ΰ�? ==> "+file4.isDirectory());
		System.out.println("���� �ΰ�? ==> "+file4.isFile());
		System.out.println();
		System.out.println("----------------------------------------------------");
		System.out.println();
		
		// ���丮(����) �����
		/*
		 - mkdir() ==> File��ü�� ��� �� ������ ��ġ�� ���丮�� �����.
		 		==> ��ȯ�� : ����� ����(true), ����� ����(false)
		 		==> ������ ��ü ��� �߿��� �߰� �κ��� ��ΰ� ��� ������� �־�� ������ ��ġ�� ��θ� ���� �� �ִ�.
		 - mkdirs()	==> ��ü ��� �߿��� �߰� �κ��� ������ �߰� �κ��� ��ε� ���� ����� �ش�.
		 */
		File file5 = new File("d:/d_Other/������");
		System.out.println(file5.getName() + "�� ���� ���� : "+file5.exists());
		System.out.println();
		
		if(file5.mkdir()) {
			System.out.println(file5.getName()+ "����� ����!!!");
		}else {
			System.out.println(file5.getName()+ "����� ����!!!");		
		}
		System.out.println();
		
		File file6 = new File("d:/d_other/test/java/src");
		System.out.println(file6.getName() + "�� ���� ���� : "+ file6.exists());
		System.out.println();
		if(file6.mkdirs()) {
			System.out.println(file6.getName() + " ����� ����!!!");
		}else {
			System.out.println(file6.getName() + " ����� ����!!!");
		}
	}

}
