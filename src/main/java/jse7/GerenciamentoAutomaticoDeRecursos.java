package jse7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GerenciamentoAutomaticoDeRecursos {
	
	public static void main(String[] args) throws IOException {
		
		try (BufferedReader br = new BufferedReader(new FileReader("/home/wallace/files/03650.txt"))) {			
			String linha = null;
			while( (linha = br.readLine()) != null) {
				System.out.println(linha);
			}
		} 
	}
	
}