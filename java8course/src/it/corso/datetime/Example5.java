package it.corso.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Demonstrates the use of LocalTime and ZonedTime
 * @author thimoty
 *
 */
public class Example5 {

	public static void main(String[] args) {

		LocalTime rightNow = LocalTime.now();
		LocalTime bedtime = LocalTime.of(22, 30); // or LocalTime.of(22, 30, 0)

		ZonedDateTime apollo11launch = ZonedDateTime.of(1969, 7, 16, 9, 32, 0, 0,
				ZoneId.of("America/New_York"));
				// 1969-07-16T09:32-04:00[America/New_York]
		
		// Begin of DST
		ZonedDateTime skipped = ZonedDateTime.of(
				LocalDate.of(2013, 3, 31),
				LocalTime.of(2, 30),
				ZoneId.of("Europe/Berlin"));
				// Constructs March 31 3:30
		
		// End of DST
		ZonedDateTime ambiguous = ZonedDateTime.of(
				LocalDate.of(2013, 10, 27), // End of daylight savings time
				LocalTime.of(2, 30),
				ZoneId.of("Europe/Berlin"));
				// 2013-10-27T02:30+02:00[Europe/Berlin]
				ZonedDateTime anHourLater = ambiguous.plusHours(1);
				// 2013-10-27T02:30+01:00[Europe/Berlin]
				
			
			ZonedDateTime meeting = ZonedDateTime.of(
					LocalDate.of(2013, 10, 26), // Day before end of daylight savings time
					LocalTime.of(12, 30),
					ZoneId.of("Europe/Berlin"));
			
			// Caution! Won’t work with daylight savings time
			ZonedDateTime nextMeeting = meeting.plus(Duration.ofDays(7));
			// Instead, use a Period
			ZonedDateTime nextMeetingWithPeriod = meeting.plus(Period.ofDays(7)); // OK
				
		
		
	}

}
