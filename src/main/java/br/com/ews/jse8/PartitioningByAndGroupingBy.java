package br.com.ews.jse8;

import br.com.ews.jse8.pojo.Usuario;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PartitioningByAndGroupingBy {
	
	public static void main(String[] args) throws Exception {
		
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Ambrosio", 120, true));
		usuarios.add(new Usuario("Wallace", 160, true));
		usuarios.add(new Usuario("Eduardo", 60, true));
		usuarios.add(new Usuario("Maria", 90, true));
		usuarios.add(new Usuario("Gardenal", 450, false));
		usuarios.add(new Usuario("Joao", 320, false));
	
		
		System.out.println("Retorna a qtde de linhas por arquivo");
		
		Map<Path, Long> qtdeLinhasPorArquivo = Files.list(Paths.get("/home/wallace/files/"))
			.collect(Collectors.toMap(
					Function.identity(), p -> lines(p).count()));
		
		System.out.println(qtdeLinhasPorArquivo);
		System.out.println();
		
		System.out.println("Retorna linhas por arquivos");
		System.out.println();
		
		Map<Path, List<String>> linhasPorArquivos = Files.list(Paths.get("/home/wallace/files/"))
			.collect(Collectors.toMap(p -> fileName(p),	 
					p -> lines(p).collect(Collectors.toList()) ));
				
		System.out.println(linhasPorArquivos.keySet());
		
		
		System.out.println("------------[GroupingBy]--------------------------");
		Map<Boolean, List<Usuario>> mapGroupBye = usuarios.stream().collect(Collectors.groupingBy(Usuario::isModerador));
		System.out.println(mapGroupBye);
		System.out.println();
		
		
		System.out.println("----------------[PartitioningBy]--------------------");
		Map<Boolean, Integer> mapPartitioningBy = usuarios.stream().collect(
				Collectors.partitioningBy(Usuario::isModerador, 
				Collectors.summingInt(Usuario::getPontos)));
		System.out.println(mapPartitioningBy);
		
		
	}
	
	static Path fileName(Path path) {
		return path.getFileName();
	}
	
	
	static Stream<String> lines(Path p) {
		try {
			return Files.lines(p);
		} catch(IOException e) {
			throw new UncheckedIOException(e);
		}
	}

}