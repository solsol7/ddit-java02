package basic;

import java.util.Stack;

public class StackTestPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Browser01{
	private String currentURL;
	private Stack<String> back;
	private Stack<String> forward;
	
	public void browser() {
		currentURL="";
		back=new Stack<String>();
		forward=new Stack<String>();
	}
	
	public void goURL(String url) {
		
	}
	
	public void goBack(String url) {
		
	}
	
	public void goForward(String url) {
		
	}
	
}