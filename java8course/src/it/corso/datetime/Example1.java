package it.corso.datetime;

import java.time.Duration;
import java.time.Instant;

public class Example1 {

	public static void main(String[] args) {
		
		Instant start = Instant.now();
		runAlgorithm();
		Instant end = Instant.now();
		Duration timeElapsed = Duration.between(start, end);
		long millis = timeElapsed.toMillis();
		System.out.println(millis);

	}

	private static void runAlgorithm() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
