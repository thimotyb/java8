package it.corso.datetime;

import java.time.Duration;
import java.time.Instant;

/**
 * Using operations on Durations
 * @author thimoty
 *
 */
public class Example2 {

	public static void main(String[] args) {
		
		Instant start1 = Instant.now();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Instant end1 = Instant.now();
		
		Duration timeElapsed = Duration.between(start1, end1);
		Instant start2 = Instant.now();
		try {
			Thread.sleep(1001);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Instant end2 = Instant.now();		
		Duration timeElapsed2 = Duration.between(start2, end2);
		boolean overTenTimesFaster = timeElapsed.multipliedBy(10).minus(timeElapsed2).isNegative();
		// Or timeElapsed.toNanos() * 10 < timeElapsed2.toNanos()
		System.out.println(overTenTimesFaster);
	}

}
