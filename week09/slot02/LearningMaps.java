package week09.slot02;

import java.util.TreeMap;

public class LearningMaps {

	public static void main(String[] args) {
//		HashMap<String, String> students = new HashMap<String, String>();
//		LinkedHashMap<String, String> students = 
//				new LinkedHashMap<String, String>();
		TreeMap<String, String> students = new TreeMap<String, String>();
		
		students.put("99654321", "Bakar");
		students.put("00123456", "Abu");
		students.put("51987654", "Daging");
		students.put("01234567", "Curi");
		System.out.println(students);
		
		if(students.containsKey("00123456") == false) {			
			students.put("00123456", "Emak");
		}
		System.out.println(students);
		
		if(students.containsKey("11223344") == false) {			
			students.put("11223344", "Fatimah");
		}
		System.out.println(students);
		
		System.out.println(students.get("11223344"));
		
		students.remove("00123456");
		System.out.println(students);
		
		students.remove("11223344", "Geli");
		System.out.println(students);
		
		students.replace("01234567", "Hati");
		System.out.println(students);
		
		students.replace("51987654", "Ikut", "Jalan");
		System.out.println(students);
		
		System.out.println(students.keySet());
		System.out.println(students.values());
	}
	
}
