package ews;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class CalculandoDiferencaEntreDatasHoras {
	
	
	public static void main(String[] args) {
		
		System.out.println("----------------[Diferenca Periodo/Datas]----------------");
		
		LocalDate agora = LocalDate.now();
		LocalDate outraData = LocalDate.of(1989, Month.JANUARY, 25);
		
		long dias = ChronoUnit.DAYS.between(outraData, agora );
		long meses = ChronoUnit.MONTHS.between(outraData, agora);
		long anos = ChronoUnit.YEARS.between(outraData, agora);
		System.out.printf("%s dias, %s meses e %s anos", dias, meses, anos);
		System.out.println();
		
		System.out.println("-----------[OR]---------------------------");
		
		Period periodo = Period.between(outraData, agora);
		System.out.printf("%s dias, %s meses e %s anos", periodo.getDays(), periodo.getMonths(), periodo.getYears());
		System.out.println();
		
		System.out.println("---------------[Diferenca Periodo/Horas]-------------------");
		
		LocalDateTime timeAgora = LocalDateTime.now();
		System.out.println(timeAgora.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)));
		LocalDateTime outroTime = LocalDateTime.of(timeAgora.getYear(), timeAgora.getMonth(), timeAgora.getDayOfMonth(), 12, 30, 45);
		System.out.println(outroTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM)));
		Duration duration = Duration.between(outroTime, timeAgora);
		System.out.printf("Diferenca %s horas, %s minutos e %s segundos", duration.toHours(), duration.toMinutes(), duration.getSeconds());
		
	}
	
}