package basic.file;

import java.io.File;

public class FileTest02 {

	public static void main(String[] args) {
		File f1 = new File("d:/d_other/test.txt");
		System.out.println(f1.getName() + "�� ���� ũ�� : " + f1.length() + "bytes");
		System.out.println();
		
		System.out.println("path : "+f1.getPath());
		System.out.println("absolutePath : "+f1.getAbsolutePath());
		
		// ��Ŭ������ �̿��Ͽ� JAVA���α׷��� �����ϸ� ����� JAVA���α׷��� �Ҽӵ� project������ ���� ������ �ȴ�.
		File f2 = new File(".");
		System.out.println("path : "+ f2.getPath());
		System.out.println("absolutePath : "+ f2.getAbsolutePath());
		System.out.println();
		
	}

}
