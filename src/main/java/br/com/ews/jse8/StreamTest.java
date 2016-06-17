package br.com.ews.jse8;

import br.com.ews.jse8.pojo.Pessoa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {

		List<Pessoa> pessoas = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			pessoas.add(new Pessoa("PESSOA " + i, Math.random()));
		}

		pessoas.subList(55, 60).forEach(System.out::println);

		// OBS: a interface Stream nao altera o resultado da lista original
		Stream<Pessoa> stream = pessoas.stream().filter(p -> p.getNome().equals("PESSOA 55"));
		// stream.filter(p -> p.getNome().equals("PESSOA 55")); TODO OBS: assim nao compilaria
		Optional<Pessoa> findFirst = stream.findFirst();

		System.out.println();
		System.out.println("---------------[OPCAO 01]-------------------------");
		System.out.println();
		System.out.println(findFirst.get());
		System.out.println();

		System.out.println();
		System.out.println("--------[OPCAO 02 - DE FORMA FLUENTE]-------------");
		System.out.println();
		pessoas.stream().filter(p -> p.getNome().equals("PESSOA 55")).forEach(System.out::println);

		System.out.println();
		System.out.println("---[OBTENDO RESULTADO EM UMA LISTA - COLLECTORS]--");
		System.out.println();

		List<Pessoa> collect = pessoas.stream()
				.filter(p -> p.getNome().equals("PESSOA 99") || p.getNome().equals("PESSOA 1"))
				.collect(Collectors.toList());

		collect.forEach(System.out::println);
		
		System.out.println();
		System.out.println("--[OBTENDO APENAS LISTA DOS 10 PRIMEIROS RG's - MAP]---");
		System.out.println();
		
		
		//7.6 Liste apenas os pontos de todos os usuarios com o map - PG. 49
		List<Double> collect2 = pessoas.subList(0, 10).stream().map(Pessoa::getRg).collect(Collectors.toList());
		collect2.forEach(System.out::println);
		
		System.out.println();
		System.out.println("---[7.7 IntStream e a familia de Streams]----------");
		System.out.println();
		
		
		//7.7 IntStream e a familia de Streams - PG. 50
		double somaRG = pessoas.stream().mapToDouble(Pessoa::getRg).sum();
		System.out.println("Total RG: " + somaRG);
		
		double mediaRG = pessoas.stream().mapToDouble(Pessoa::getRg).average().getAsDouble();
		System.out.println("Media RG: " + mediaRG);
		
		double totalRG = pessoas.stream().mapToDouble(Pessoa::getRg).count();
		System.out.println("Total RG: " + totalRG);
		
		System.out.println();
		System.out.println("----------[7.8 O Optional em java.util]-----------");
		System.out.println();
		
		//7.8 O Optional em java.util PG.51
		List<Pessoa> lista = new ArrayList<>();
		/*lista.add(new Pessoa("JOAO", 50.99));
		lista.add(new Pessoa("PAULO", 25d));*/
		OptionalDouble average = lista.stream().mapToDouble(Pessoa::getRg).average();
		double averageDefault = average.orElse(10.99); //valor default caso a lista esteja vazia
		System.out.println("Average: " + averageDefault);
		
		System.out.println();
		System.out.println("------------------[Maior RG]-----------------------");
		System.out.println();
		Optional<Pessoa> maxRG = pessoas.stream().max(Comparator.comparingDouble(Pessoa::getRg));
		//Pessoa pessoa = maxRG.get(); TODO OBS: nesse caso se a lista esteja vazia, retornara uma exception
		Pessoa pessoa = maxRG.orElse(null);
		System.out.println(pessoa);
	}

}