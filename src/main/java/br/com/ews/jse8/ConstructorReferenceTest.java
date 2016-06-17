package br.com.ews.jse8;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReferenceTest {

	static class Funcionario {

		private int matricula;
		private String nome;
		
		public Funcionario() {
			//Construtor Default
		}
		
		public Funcionario(int matricula) {
			this.matricula = matricula;
		}

		public Funcionario(int matricula, String nome) {
			this.matricula = matricula;
			this.nome = nome;
		}

		public int getMatricula() {
			return matricula;
		}

		public void setMatricula(int matricula) {
			this.matricula = matricula;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		@Override
		public String toString() {
			return "Funcionario [matricula=" + matricula + ", nome=" + nome + "]";
		}

	}

	public static void main(String[] args) {
		
		Supplier<Funcionario> f1 = Funcionario::new;
		Funcionario iF1 = f1.get();
		System.out.println(iF1);
		
		//----------------------------------------
		
		Function<Integer, Funcionario> f2 = Funcionario::new;
		Funcionario iF2 = f2.apply(3345);
		System.out.println(iF2);		
		
		//----------------------------------------
		
		BiFunction<Integer, String, Funcionario> f3 = Funcionario::new;
		Funcionario iF3 = f3.apply(4523, "Eduardo Wallace");
		System.out.println(iF3);
		
	}

}