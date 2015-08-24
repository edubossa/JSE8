package ews;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.Locale;

public class JodaTime {
	
	public static void main(String[] args) {
		
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);
		System.out.println(localDate.plusMonths(3));
		System.out.println(localDate.plusYears(2));
		
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(dateTime.minusMonths(2));
		
		LocalTime time = LocalTime.now();
		System.out.println(time);
		
		LocalDateTime dateTime2 = LocalDate.now().atTime(12, 30);
		System.out.println(dateTime2); 
		
		LocalDate localDate2 = LocalDate.of(1999, Month.JANUARY, 1);
		System.out.println(localDate2);
		
		LocalDate localDate3 = LocalDate.now().withYear(2014).withMonth(1).withDayOfMonth(30);
		System.out.println(localDate3);
		System.out.println(localDate3.getYear());
		
		System.out.println(localDate2.isEqual(localDate3));
		System.out.println(localDate2.isBefore(localDate3));
		System.out.println(localDate3.isAfter(localDate3));
		
		System.out.println(MonthDay.now());
		System.out.println(MonthDay.now().getDayOfMonth());
		
		System.out.println(YearMonth.now());
		System.out.println(YearMonth.now().getMonthValue());
		
		System.out.println(Month.DECEMBER.getDisplayName(TextStyle.FULL, Locale.getDefault()));
		System.out.println(DayOfWeek.FRIDAY.getDisplayName(TextStyle.FULL, Locale.getDefault())); 
		
		
	}
	
}