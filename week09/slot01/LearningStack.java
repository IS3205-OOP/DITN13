package week09.slot01;

import java.util.Stack;

public class LearningStack {

	public static void main(String[] args) {
		Stack<String> bookStack = new Stack<String>();
		
		bookStack.add("Java");
		bookStack.add("Python");
		bookStack.add("PHP");
		System.out.println(bookStack);
		
		System.out.println(bookStack.peek());
		System.out.println(bookStack);
		
		System.out.println(bookStack.pop());
		System.out.println(bookStack);
		
		while(!bookStack.isEmpty()) {
			System.out.println(bookStack.pop());
		}
		System.out.println(bookStack);
	}
	
}
