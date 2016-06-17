package br.com.ews.jse8;

import br.com.ews.jse8.pojo.Usuario;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/*
 
9.3 Executando o pipeline em paralelo - PG. 78

Quanto a performance final?

Seu codigo vai rodar mais rapido? Não sabemos. Se a colecao for pequena, o
overhead de utilizar essa abordagem certamente tornará a execução bem mais lenta.
É necessário tomar cuidado com o uso dos streams paralelos. Eles sao uma forma
simples de realizar operações com a API de Fork/Join: o tamanho do input precisa
ser grande.
 
 */
public class ParallelStream {
	
	public static void main(String[] args) throws Exception {
		
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Wallace", 160, true));
		usuarios.add(new Usuario("Maria", 90, true));
		usuarios.add(new Usuario("Eduardo", 60, true));
		usuarios.add(new Usuario("Ambrosio", 120, true));
		usuarios.add(new Usuario("Gardenal", 450, false));
		usuarios.add(new Usuario("Joao", 320, false));
		
		for (int i = 0; i < 50000; i++) {
			usuarios.add(new Usuario(""+UUID.randomUUID().toString(), i));
		}
		
		usuarios.parallelStream().sorted(Comparator.comparing(Usuario::getNome)).collect(Collectors.toList()).forEach(System.out::println);
		
	}
	
}