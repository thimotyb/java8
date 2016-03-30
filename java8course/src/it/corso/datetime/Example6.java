package it.corso.datetime;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Demonstrates formatting
 * @author thimoty
 *
 */
public class Example6 {

	public static void main(String[] args) {
		
		ZonedDateTime apollo11launch = ZonedDateTime.of(1969, 7, 16, 9, 32, 0, 0,
				ZoneId.of("America/New_York"));
		
		String formatted = DateTimeFormatter.ISO_DATE_TIME.format(apollo11launch);
		// 1969-07-16T09:32:00-05:00[America/New_York]
		
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
		String formatted2 = formatter.format(apollo11launch);
		// July 16, 1969 9:32:00 AM EDT

	}

}
