package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/*
	Vector, Hashtable��� ���� �������� �����ϴ� Collection��ü����
	���ο� ����ȭ ó���� �Ǿ� �ִ�.
	
	�׷��� ���Ӱ� ������ Collection ��ü���� ����ȭ ó���� �Ǿ����� �ʴ�.
	�׷���, ����ȭ�� �ʿ��� ���α׷����� �̷� Collection���� ����Ϸ���
	����ȭ ó���� �� �Ŀ� ����ؾ� �Ѵ�.
	(��� => Collections��ü�� synchronized�� �����ϴ� �޼��� �̿�)
 */

public class ThreadTest17 {
	public static Vector<Integer> vec=new Vector<>();
	
	//����ȭ ó���� ���� ���� List
	public static List<Integer> list = new ArrayList<Integer>();
	
	//����ȭ ó���� �� ���
	public static List<Integer> list2 = Collections.synchronizedList(new ArrayList<Integer>());
	
	public static void main(String[] args) {
		
		
		//--------------------------------------------
		//�͸���ü
		Runnable r= new Runnable() {
			
			@Override
			public void run() {
				/*
				for(int i=0; i<10000; i++) {
					vec.add(i);
				}
				*/
				/*
				for(int i=0; i<10000; i++) {
					list.add(i);
					//�����Ͱ� ���� ũ�⸦ �Ѿ�� -> �� ū ���ο� �迭 ����� ������ �����͸� ���� ������� �ű�� �߰��� -> �� �������� ������
				}
				*/
				for(int i=0; i<10000; i++) {
					list2.add(i);
				}
				
			}
		};
		//--------------------------------------------
		
		Thread[] thArr = new Thread[] {
			new Thread(r), new Thread(r), new Thread(r), new Thread(r), new Thread(r),
		};
		for(Thread th : thArr) {
			th.start();
		}
		
		for(Thread th : thArr) {
			try {
				th.join();
			} catch (InterruptedException e) {
				
			}
		}
		
		System.out.println("vec�� ���� : "+vec.size());
		System.out.println("list�� ���� : "+list2.size());
	}

}
