package week09.slot01;

import java.util.ArrayList;

public class LearningArrayList {
	
	public static void main(String[] args) {
		ArrayList<String> countryList = new ArrayList<String>();
		
		System.out.println(countryList.isEmpty());
		
		countryList.add("Brunei");
		System.out.println(countryList.isEmpty());
		System.out.println(countryList);
		
		countryList.add("Singapore");
		countryList.add("Malaysia");
		System.out.println(countryList);
		
		countryList.add(1, "Vietnam");
		System.out.println(countryList);
		
		System.out.println(countryList.get(3));
		
		countryList.add(2, "Cambodia");
		System.out.println(countryList.get(3));
		
		countryList.remove(0);
		System.out.println(countryList);
		
		countryList.set(1, "Philippines");
		System.out.println(countryList);
		
		// Index out of bound exception
//		countryList.set(10, "Thailand");
		
		System.out.println(countryList.size());
	}

}
