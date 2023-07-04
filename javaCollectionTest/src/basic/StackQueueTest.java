package basic;

import java.util.LinkedList;
import java.util.Stack;

public class StackQueueTest {

	public static void main(String[] args) {
		/*
		 * Stack ==> 후입선출(LIFO)의 자료 구조
		 * Queue ==> 선입선출(FIFO)의 자료 구조
		 * 
		 * Stack과 Queue는 LinkedList를 이용하여 사용할 수 있다.
		 */
		
		/*
		 * Stack의 명령
		 * 1. 자료 입력 : push(입력값)
		 * 2. 자료 출력 : pop() ==> 자료를 꺼내온 후 꺼내온 데이터를 Stack에서 삭제
		 * 			: peek() ==> 삭제없이 자료를 꺼내온다.마지막에 들어온 자료를 확인하고싶을때 사용.
		 */
		//사용되는곳
		//콜스택 : 메소드 호출할때 만들어지는 스택
		//ctrl+z  --작업할때마다 작업한 내용이 스택에 계속 저장, ctrl+z누르면 저장한거 꺼내옴
		//페이지 링크걸때 뒤로가기버튼   등등....
		
		Stack<String> stack = new Stack<String>();
		//LinkedList<String> stack = new LinkedList<String>();
		
		stack.push("홍길동");
		stack.push("일지매");
		stack.push("변학도");
		stack.push("강감찬");
		
		System.out.println("현재 Stack값 >> "+stack);
	
		String data = stack.pop();
		System.out.println("꺼내온 값 >> "+data);
		System.out.println("현재 Stack값 >>" +stack);
		System.out.println("꺼내온 값 >> "+stack.pop());
		
		stack.push("성춘향");
		System.out.println("현재 Stack값 >> "+stack);
		System.out.println("꺼내온 값 >> "+stack.pop());
		
		System.out.println("꺼내온 값 >> "+stack.peek());
		System.out.println("현재 Stack값 >>" +stack);
		
		System.out.println("----------------------------------------------");
		System.out.println();
		
		/*
		 * Queue의 명령
		 * 자료 입력 : offer(입력값)
		 * 자료 출력 : poll() ==> 자료를 꺼내온 후 꺼내온 자료를 Queue에서 삭제한다.
		 * 			peek() ==> 삭제없이 자료를 꺼내온다.
		 */
		//사용되는곳
		
		LinkedList<String> queue = new LinkedList<String>();
		
		queue.offer("홍길동");
		queue.offer("일지매");
		queue.offer("변학도");
		queue.offer("강감찬");
		System.out.println("현재 Queue값 >>"+queue);
		
		String temp = queue.poll();
		System.out.println("꺼내온 값 >> "+ temp);
		System.out.println("꺼내온 값 >> "+ queue.poll());
		System.out.println("현재 Queue값 >> "+queue);
		
		queue.offer("성춘향");
		System.out.println("현재 Queue값 >> "+queue);
		System.out.println("꺼내온 값 >> "+ queue.poll());
		
		System.out.println("삭제 없이 꺼내오기 >> "+queue.peek());
		System.out.println("현재 Queue값 >> "+queue);
		
	}

}