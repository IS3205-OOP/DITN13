package week09.slot02;

import java.util.HashSet;

public class LearningSets {

	public static void main(String[] args) {
		HashSet<String> icNumbers = new HashSet<String>();
//		LinkedHashSet<String> icNumbers = new LinkedHashSet<String>();
//		TreeSet<String> icNumbers = new TreeSet<String>();
		
		icNumbers.add("51345678");
		icNumbers.add("00123456");
		icNumbers.add("00123456");
		icNumbers.add("01987654");
		System.out.println(icNumbers);
		
		System.out.println(icNumbers.contains("00123456"));
		System.out.println(icNumbers.contains("12345678"));
		
		icNumbers.remove("12345678");
		icNumbers.remove("01987654");
		System.out.println(icNumbers);
		
		for(String singleIC : icNumbers) {
			System.out.println(singleIC);
		}
		
	}
	
}
