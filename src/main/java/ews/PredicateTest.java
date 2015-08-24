package ews;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {

	public static void main(String[] args) {

		List<Integer> numeros = new ArrayList<>();

		numeros.add(10);
		numeros.add(20);
		numeros.add(30);
		numeros.add(40);
		numeros.add(50);
		numeros.add(60);
		numeros.add(70);
		numeros.add(80);
		numeros.add(90);
		numeros.add(100);
		
		List<Integer> numeros2 = new ArrayList<>(numeros);
		
		numeros.forEach(n -> System.out.print(n.intValue() + "|"));
		System.out.println();
		System.out.println("-------------------------------------------------");
		
		Predicate<Integer> filter = new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				return (t < 50);
			}
		};
		
		
		numeros.removeIf(filter);
		
		numeros.forEach(n -> System.out.print(n.intValue() + "|"));
		System.out.println();
		System.out.println("-------------------------------------------------");
		
		System.out.println("SIZE: " + numeros2.size());
		System.out.println("-------------------------------------------------");
		numeros2.removeIf(n -> n.intValue() < 50); // use lambda expression
		numeros.forEach(n -> System.out.print(n.intValue() + "|"));
		System.out.println();
		System.out.println("-------------------------------------------------");
		
	}

}