package basic;

import java.util.LinkedList;
import java.util.Stack;

public class StackQueueTest {

	public static void main(String[] args) {
		/*
		 * Stack ==> ���Լ���(LIFO)�� �ڷ� ����
		 * Queue ==> ���Լ���(FIFO)�� �ڷ� ����
		 * 
		 * Stack�� Queue�� LinkedList�� �̿��Ͽ� ����� �� �ִ�.
		 */
		
		/*
		 * Stack�� ���
		 * 1. �ڷ� �Է� : push(�Է°�)
		 * 2. �ڷ� ��� : pop() ==> �ڷḦ ������ �� ������ �����͸� Stack���� ����
		 * 			: peek() ==> �������� �ڷḦ �����´�.�������� ���� �ڷḦ Ȯ���ϰ������ ���.
		 */
		//���Ǵ°�
		//�ݽ��� : �޼ҵ� ȣ���Ҷ� ��������� ����
		//ctrl+z  --�۾��Ҷ����� �۾��� ������ ���ÿ� ��� ����, ctrl+z������ �����Ѱ� ������
		//������ ��ũ�ɶ� �ڷΰ����ư   ���....
		
		Stack<String> stack = new Stack<String>();
		//LinkedList<String> stack = new LinkedList<String>();
		
		stack.push("ȫ�浿");
		stack.push("������");
		stack.push("���е�");
		stack.push("������");
		
		System.out.println("���� Stack�� >> "+stack);
	
		String data = stack.pop();
		System.out.println("������ �� >> "+data);
		System.out.println("���� Stack�� >>" +stack);
		System.out.println("������ �� >> "+stack.pop());
		
		stack.push("������");
		System.out.println("���� Stack�� >> "+stack);
		System.out.println("������ �� >> "+stack.pop());
		
		System.out.println("������ �� >> "+stack.peek());
		System.out.println("���� Stack�� >>" +stack);
		
		System.out.println("----------------------------------------------");
		System.out.println();
		
		/*
		 * Queue�� ���
		 * �ڷ� �Է� : offer(�Է°�)
		 * �ڷ� ��� : poll() ==> �ڷḦ ������ �� ������ �ڷḦ Queue���� �����Ѵ�.
		 * 			peek() ==> �������� �ڷḦ �����´�.
		 */
		//���Ǵ°�
		
		LinkedList<String> queue = new LinkedList<String>();
		
		queue.offer("ȫ�浿");
		queue.offer("������");
		queue.offer("���е�");
		queue.offer("������");
		System.out.println("���� Queue�� >>"+queue);
		
		String temp = queue.poll();
		System.out.println("������ �� >> "+ temp);
		System.out.println("������ �� >> "+ queue.poll());
		System.out.println("���� Queue�� >> "+queue);
		
		queue.offer("������");
		System.out.println("���� Queue�� >> "+queue);
		System.out.println("������ �� >> "+ queue.poll());
		
		System.out.println("���� ���� �������� >> "+queue.peek());
		System.out.println("���� Queue�� >> "+queue);
		
	}

}