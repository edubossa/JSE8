package ews;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MethodReferenceTest {

	static class Deposito {

		private BigDecimal valor;

		public void depositar() {
			System.out.println("Efetuando deposito no valor: " +valor.toString());
		}

		public Deposito(BigDecimal valor) {
			this.valor = valor;
		}

		public BigDecimal getValor() {
			return valor;
		}

		public void setValor(BigDecimal valor) {
			this.valor = valor;
		}

		@Override
		public String toString() {
			return "Deposito [valor=" + valor + "]";
		}

	}

	public static void main(String[] args) {

		List<Deposito> depositos = new ArrayList<>();
		depositos.add(new Deposito(new BigDecimal("1145.80")));
		depositos.add(new Deposito(new BigDecimal("2345.45")));
		depositos.add(new Deposito(new BigDecimal("1600.00")));
		depositos.add(new Deposito(new BigDecimal("230.60")));
		
		/*for (Deposito deposito : depositos) {
			System.out.println(deposito);
		}*/
		
		//depositos.forEach(Deposito::depositar);
		
		depositos.forEach(System.out::println); 
		
		System.out.println("-------------------------------------------------");
		
		Deposito deposito = new Deposito(new BigDecimal("10567.76"));
		Runnable r = deposito::depositar;
		r.run();
		
	}

}