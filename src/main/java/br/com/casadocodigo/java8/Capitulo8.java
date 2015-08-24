package br.com.casadocodigo.java8;

import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.util.stream.*;
import java.util.function.*;

class Capitulo8 {
	public static void main (String... args) throws Exception {

		Usuario user1 = new Usuario("Paulo Silveira", 150);
		Usuario user2 = new Usuario("Rodrigo Turini", 120);
		Usuario user3 = new Usuario("Guilherme Silveira", 90);

		List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

		List<Usuario> filtradosOrdenados = usuarios.stream()
			.filter(u -> u.getPontos() > 100)
			.sorted(Comparator.comparing(Usuario::getNome))
			.collect(Collectors.toList());

		// peek mostra so os processados:
		usuarios.stream()
			.filter(u -> u.getPontos() > 100)
			.peek(System.out::println).findAny();

		// peek é apens intermeridiario:

		usuarios.stream()
			.filter(u -> u.getPontos() > 100)
			.peek(System.out::println);  // precisa chamar terminal!

		// sort é operador intermediario, porem stateful:
		usuarios.stream()
			.sorted(Comparator.comparing(Usuario::getNome))
			.peek(System.out::println)
			.findAny();

		usuarios.stream()
			.sorted(Comparator.comparing(Usuario::getNome))
			.peek(System.out::println)
			.findAny();

		Usuario maximaPontuacao = usuarios.stream()
			.max(Comparator.comparing(Usuario::getPontos))
			.get();
		System.out.println(maximaPontuacao.getPontos());

		int total = usuarios.stream()
			.mapToInt(Usuario::getPontos)
			.sum();
		System.out.println(total); 

		int valorInicial = 0;
		IntBinaryOperator operacao = (a, b) -> a + b;

		int total2 = usuarios.stream()
			.mapToInt(Usuario::getPontos)
			.reduce(valorInicial, operacao);
		System.out.println(total2);

		int multiplicacao = usuarios.stream()
			.mapToInt(Usuario::getPontos)
			.reduce(1, (a,b) -> a * b);
		System.out.println(multiplicacao);

		// pulando o map!
		int total3 = usuarios.stream()
			.reduce(0, (atual, u) -> atual + u.getPontos(), Integer::sum);	
		System.out.println(total3);
		
		boolean hasModerator = usuarios.stream()
			.anyMatch(Usuario::isModerador);
		System.out.println(hasModerator);

		// stream infinito:

		Random random = new Random(0);
		IntStream stream = IntStream.generate(() -> random.nextInt());
		System.out.println(stream.asDoubleStream());

		// loop infinito
		// int valor = stream.sum();

		List<Integer> list = IntStream
			.generate(() -> random.nextInt())
			.limit(100)
			.boxed()
			.collect(Collectors.toList());
		list.subList(0, 10).forEach(System.out::println);

		class Fibonacci implements IntSupplier {
			private int anterior = 0;
			private int proximo = 1;

			public int getAsInt() {
				proximo = proximo + anterior;
				anterior = proximo - anterior;
				return anterior;
			}
		}

		IntStream.generate(new Fibonacci())
			.limit(10)
			.forEach(System.out::println);

		int maiorQue100 = IntStream
			.generate(new Fibonacci())
			.filter(f -> f > 100)
			.findFirst()
			.getAsInt();

		System.out.println(maiorQue100);

		IntStream.iterate(0, x -> x + 1)
			.limit(10)
			.forEach(System.out::println);		

		// flatmap e java.nio.files

		Files.list(Paths.get("/home/wallace/projetos/vaccine/Fiscal/file/"))
			.forEach(System.out::println);

		Files.list(Paths.get("/home/wallace/projetos/vaccine/Fiscal/file/"))
			.filter(p -> p.toString().endsWith("0365"))
			.forEach(System.out::println);


		Files.list(Paths.get("/home/wallace/projetos/vaccine/Fiscal/file/"))
			.filter(p -> p.toString().endsWith(".0365"))
			.map(p -> lines(p))
			.forEach(System.out::println);

		Stream<Stream<String>> strings = 
			Files.list(Paths.get("/home/wallace/projetos/vaccine/Fiscal/file/"))
				.filter(p -> p.toString().endsWith("UNILEVER BR GELADOS DO NOR SA|"))
				.map(p -> lines(p));
		System.out.println(strings);

		Files.list(Paths.get("/home/wallace/projetos/vaccine/Fiscal/file/"))
			.filter(p -> p.toString().endsWith("UNILEVER BR GELADOS DO NOR SA|"))
			.flatMap(p -> lines(p))
			.forEach(System.out::println);

		
		IntStream chars =
			Files.list(Paths.get("/home/wallace/projetos/vaccine/Fiscal/file/"))
				.filter(p -> p.toString().endsWith("UNILEVER BR GELADOS DO NOR SA|"))
				.flatMap(p -> lines(p))
				.flatMapToInt((String s) -> s.chars());
		System.out.println(chars);


		Grupo englishSpeakers = new Grupo();
		englishSpeakers.add(user1);
		englishSpeakers.add(user2);

		Grupo spanishSpeakers = new Grupo();
		spanishSpeakers.add(user2);
		spanishSpeakers.add(user3);

		List<Grupo> groups = Arrays.asList(englishSpeakers, spanishSpeakers);
		groups.stream()
			.flatMap(g -> g.getUsuarios().stream())
			.distinct()
			.forEach(System.out::println);

	}

	static Stream<String> lines(Path p) {
		try {
			return Files.lines(p);
		} catch(IOException e) {
			throw new UncheckedIOException(e);
		}
	}
}

