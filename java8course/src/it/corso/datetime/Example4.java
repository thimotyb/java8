package it.corso.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

/**
 * Demonstrate Temporal Adjusters
 * @author thimoty
 *
 */
public class Example4 {

	public static void main(String[] args) {
		
		LocalDate firstTuesday = LocalDate.of(2016, Month.APRIL, 1).with(
				TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));

	}

}
