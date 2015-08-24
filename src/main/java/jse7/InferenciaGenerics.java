package jse7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class InferenciaGenerics {
	
	public static void main(String[] args) {
		
		System.out.println("----------------[Diamond]------------------------");
		
		Map<Integer, Set<Integer>> mapSet = new HashMap<>();
		Integer key = 89_98_67;
		Set<Integer> set = new HashSet<>();
		set.add(33_99);
		
		mapSet.put(key, set);
		
		System.out.println(mapSet);
		
	}
	
}