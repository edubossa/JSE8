package ews;

public class EmailTest {
	
	
	public static void main(String[] args) {
		
		Email<Retorno> email = new Email<Retorno>() {
			
			@Override
			public Retorno valida() {
				return new Retorno("edubossa@gmail.com", "eduardo.silva@ntk-consult.com.br");
			}
		};
		
		email.status();
		System.out.println("STATIC ID: " + Email.idEmail());
		
		System.out.println(email.valida());
		
		System.out.println();
		System.out.println("----------------------------[lambda]--------------------------------------------");
		System.out.println();
		
		Email<Retorno> e = () -> new Retorno("ntk-desenv@gmail.com", "emphasy@ntk-consult.com.br");
		e.status();
		System.out.println("STATIC ID: " + Email.idEmail());
		System.out.println(e.valida());
		
		
		
	}
}
