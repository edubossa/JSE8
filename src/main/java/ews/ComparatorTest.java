package ews;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static java.util.Comparator.comparing;

/**
 * 5.4 Conhecendo melhor o Comparator.comparing
 * <p>
 * PG. 28
 * @author Eduardo Wallace
 *
 */
public class ComparatorTest {

	static class Pessoa {

		private String nome;

		public Pessoa(String nome) {
			this.nome = nome;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		@Override
		public String toString() {
			return "pessoa [nome=" + nome + "]";
		}

	}
	
	
	public static void main(String[] args) {
		
		List<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(new Pessoa("FABIANA"));
		pessoas.add(new Pessoa("EDUARDO"));
		pessoas.add(new Pessoa("CLAITON"));
		pessoas.add(new Pessoa("ADALBERTO"));
		pessoas.add(new Pessoa("BETO DIAS"));
		pessoas.add(new Pessoa("DANIELA"));
		
		List<Pessoa> pessoas2 = new ArrayList<>(pessoas);
		
		pessoas.forEach(p -> System.out.println(p.getNome()));
		
		System.out.println();
		System.out.println("---------------[order by comparator]----------------------------------");
		System.out.println();
		
		Comparator<Pessoa> c = new Comparator<ComparatorTest.Pessoa>() {

			@Override
			public int compare(Pessoa c1, Pessoa c2) {
				return c1.getNome().compareTo(c2.getNome());
			}
		};
		
		Collections.sort(pessoas, c);
		
		//pessoas.forEach(p -> System.out.println(p.getNome()));
		pessoas.forEach(System.out::println); //TODO imprime o toString();
		
		System.out.println();
		System.out.println("--------------------[order by lambda expression]-----------------------------");
		System.out.println();
		
		//Collections.sort(pessoas2, (c1, c2) -> c1.getNome().compareTo(c2.getNome()));
		//pessoas2.sort((c1, c2) -> c1.getNome().compareTo(c2.getNome()));
		//pessoas2.sort(comparing(p -> p.getNome()));
		pessoas2.sort(comparing(Pessoa::getNome));
		pessoas2.forEach(System.out::println); //TODO imprime o toString();
		
		System.out.println();
		System.out.println("-------------------------------------------------");
		
		
		List<Integer> numeros = new ArrayList<>();
		numeros.add(5);
		numeros.add(4);
		numeros.add(2);
		numeros.add(3);
		numeros.add(1);
		numeros.add(6);
		
		numeros.forEach(n -> System.out.print(n.intValue() + "|"));
		System.out.println();
		System.out.println("-------------------------------------------------");
				
		numeros.sort(Comparator.naturalOrder());
		numeros.forEach(n -> System.out.print(n.intValue() + "|"));
		
		System.out.println();
		System.out.println("-------------------------------------------------");

		numeros.sort(Comparator.reverseOrder());
		numeros.forEach(n -> System.out.print(n.intValue() + "|"));
		
		
	}

}