package ews;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class JodaTimeFormatAndParse {
	
	
	public static void main(String[] args) {
		
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyy")));
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)));
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG, FormatStyle.MEDIUM)));
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.MEDIUM)));
		System.out.println("");
		
		System.out.println("-------------------[PARSE]-------------------------------");
		
		LocalDateTime agora = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String resultado = format.format(agora);
		System.out.println("Parse Object String: " + resultado);
		LocalDate localDateParse = LocalDate.parse(resultado, format);
		System.out.println("Parse String Object: " + localDateParse);
		System.out.println();
		
	}

}