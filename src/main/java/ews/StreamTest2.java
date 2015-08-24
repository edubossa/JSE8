package ews;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamTest2 {

	static class Usuario {

		private int pontos;
		private String nome;
		private boolean moderador;

		public Usuario(String nome) {
			this.nome = nome;
		}

		public Usuario(String nome, int pontos) {
			this.pontos = pontos;
			this.nome = nome;
			this.moderador = false;
		}

		public Usuario(String nome, int pontos, boolean moderador) {
			this.pontos = pontos;
			this.nome = nome;
			this.moderador = moderador;
		}

		public int getPontos() {
			return pontos;
		}

		public String getNome() {
			return nome;
		}

		public void tornaModerador() {
			this.moderador = true;
		}

		public boolean isModerador() {
			return moderador;
		}

		@Override
		public String toString() {
			return "Usuario [nome=" + nome + ", pontos=" + pontos + "]";
		}

	}
	
	private static void linha() {
		System.out.println();
		System.out.println("------------------------------------------------");
		System.out.println();
	}

	public static void main(String[] args) throws IOException {

		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Wallace", 120));
		usuarios.add(new Usuario("Andre", 90));
		usuarios.add(new Usuario("Bia", 150));
		usuarios.add(new Usuario("Douglas", 200));
		usuarios.add(new Usuario("Eduardo", 50));

		List<Usuario> filtroUsuarios = usuarios.stream().filter(u -> u.getPontos() > 100)
				.sorted(Comparator.comparing(Usuario::getNome)).collect(Collectors.toList());

		filtroUsuarios.forEach(System.out::println);
		
		linha();
		
		Optional<Usuario> findAny = usuarios.stream().filter(u -> u.getPontos() > 100)
				.findAny();
		
		System.out.println(findAny.orElse(null));
		
		linha();
		
		//OPERACAO EQUIVALENTE A LINHA 78, NAO PRECISANDO USAR O System.out.println 
		usuarios.stream().filter(u -> u.getPontos() > 100)
			.peek(System.out::println)
			.findAny();
		
		linha();
		
		boolean existeAlgumUsuarioModerador = usuarios.stream().anyMatch(Usuario::isModerador);
		System.out.println(existeAlgumUsuarioModerador);
		
		linha();
		
		boolean todosUsuariosSaoModeradores = usuarios.stream().allMatch(u -> u.isModerador());
		System.out.println(todosUsuariosSaoModeradores);
		
		linha();
		
		boolean nenhumUsuarioModerador = usuarios.stream().noneMatch(Usuario::isModerador);
		System.out.println(nenhumUsuarioModerador);
		
		
		//8.8 Praticando o que aprendemos com java.nio.file.Files PG. 67
		
		linha();
		
		System.out.println("---[LISTANDO TODOS OS ARQUIVOS DE DETERMINADO DIRETORIO]----");
		System.out.println();
		//java.nio.file.
	
		Files.list(Paths.get("/home/wallace/projetos/vaccine/Fiscal/file/")).forEach(System.out::println);
		
		linha();
				
		List<String> readAllLines = Files.readAllLines(Paths.get("/home/wallace/projetos/vaccine/Fiscal/file/03651.txt"));
		System.out.println(readAllLines.size());
		
		//Files.copy(Paths.get("/home/wallace/projetos/vaccine/Fiscal/file/03651.txt"), new FileOutputStream("/home/wallace/ews.txt"));
		
		linha();
		
		Files.list(Paths.get("/home/wallace/projetos/vaccine/Fiscal/file/")).filter(s -> s.getFileName().toString().contains("0365"))
			.forEach(System.out::println);
		
		linha();
		
		//Files.lines(Paths.get("/home/wallace/projetos/vaccine/Fiscal/file/03651.txt")).forEach(System.out::println);
	
	}

}