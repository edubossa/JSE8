package br.com.ews.jse8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {

    //Pode ser acessado por Method references
    static void print(Integer n){
        System.out.print(n + "|");
    }

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
		
		numeros.forEach(PredicateTest::print); //print for Method references
		System.out.println();
		System.out.println("-------------------------------------------------");
		
		Predicate<Integer> filter = new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				return (t < 50);
			}
		};

		numeros.removeIf(filter);
		
		numeros.forEach(PredicateTest::print);
		System.out.println();
		System.out.println("-------------------------------------------------");
		
		System.out.println("SIZE: " + numeros2.size());
		System.out.println("-------------------------------------------------");
        System.out.println("Removendo de forma simplificada com lambda");
        System.out.println("-------------------------------------------------");
        numeros2.removeIf(n -> n.intValue() < 50); // use lambda expression
		numeros.forEach(PredicateTest::print);
		System.out.println();
		System.out.println("-------------------------------------------------");
		
	}

}