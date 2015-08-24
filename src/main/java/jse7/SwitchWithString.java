package jse7;

public class SwitchWithString {

	public static void main(String[] args) {

		for (String s : args) {

			switch (s) {
				case "teste":
					System.out.println("Teste Case");
					break;
				case "posicao2" :
					System.out.println("Posicao 02");
					break;
					default :
						System.out.println("Nenhuma Opcao Selecionada");
			}

		}

	}

}