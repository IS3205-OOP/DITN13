package week09.slot01;

import java.util.LinkedList;
import java.util.Queue;

public class LearningQueue {
	
	public static void main(String[] args) {
		Queue<String> nameQueue = new LinkedList<String>();
		
		nameQueue.add("Abu");
		nameQueue.add("Bakar");
		nameQueue.add("Curi");
		nameQueue.add("Daging");
		System.out.println(nameQueue);
		
		System.out.println(nameQueue.peek());
		
		System.out.println(nameQueue);
		
		System.out.println(nameQueue.poll());
		System.out.println(nameQueue);
		
	}

}
