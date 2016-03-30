package it.corso.datetime;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * Using LocalDate and Period
 * @author thimoty
 *
 */
public class Example3 {

	public static void main(String[] args) {
		
		LocalDate today = LocalDate.now(); // Today’s date
		LocalDate alonzosBirthday = LocalDate.of(1903, 6, 14);
		alonzosBirthday = LocalDate.of(1903, Month.JUNE, 14);
		// Uses the Month enumeration
		
		// Period
		LocalDate birthday = LocalDate.of(1973, Month.MAY, 11);
		birthday.plus(Period.ofYears(1));
		birthday.plusYears(1);
		
		// Until
		LocalDate liberationDay = LocalDate.of(2016, Month.APRIL, 25);
		LocalDate christmas = LocalDate.of(2016, Month.DECEMBER, 25);
		Period p = liberationDay.until(christmas);
		System.out.println(p.getMonths()+" "+p.getDays());
		long days = liberationDay.until(christmas, ChronoUnit.DAYS);
		System.out.println(days);
		
		// Potential non-existent dates?
		// LocalDate.of(2016, 1, 31).plusMonths(1)
		// LocalDate.of(2016, 3, 31).minusMonths(1)
		
		// DayOfWeek.MONDAY has the numerical value 1
		LocalDate.of(1900, 1, 1).getDayOfWeek().getValue();
		
		// December 25 (with the year unspecified) can be
		// represented as a MonthDay.
		MonthDay everyChristmas = MonthDay.of(Month.DECEMBER, 25);
		
		
		
		
		
		
		
	}

}
