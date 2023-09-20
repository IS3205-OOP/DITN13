package week09.slot01;

import java.util.LinkedList;
import java.util.ListIterator;

public class LearningLinkedList {
	
	public static void main(String[] args) {
		LinkedList<String> cityList = new LinkedList<String>();
		
		System.out.println(cityList.isEmpty());
		
		cityList.add("BSB");
		cityList.addLast("KL");
		System.out.println(cityList);
		
		cityList.addFirst("Jakarta");
		System.out.println(cityList);
		
		cityList.removeFirst();
		// cityList.removeLast();
		System.out.println(cityList);
		
		ListIterator<String> iterator = cityList.listIterator();
		
		System.out.println(iterator.next());
		
		iterator.add("Bangkok");
		System.out.println(cityList);
		
		System.out.println(iterator.next());
		// No such element exception
//		System.out.println(iterator.next());
		
		System.out.println(iterator.hasNext());
		
		System.out.println(iterator.previous());
		System.out.println(iterator.hasPrevious());
		System.out.println(iterator.previous());
		
		iterator.set("London");
		System.out.println(cityList);
		iterator.set("Cairo");
		System.out.println(cityList);
		iterator.remove();
		System.out.println(cityList);
	}

}
