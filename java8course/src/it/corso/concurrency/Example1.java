package it.corso.concurrency;

/**
 * Demonstrates unsafe use of a share variable between threads
 * @author barbieri
 *
 */
public class Example1 {

	public static void main(String[] args) throws InterruptedException {
		
		Counter counter = new Counter();
		IncrementerThread it1 = new IncrementerThread(counter);
		IncrementerThread it2 = new IncrementerThread(counter);
		it1.start();
		it2.start();
		it1.join();
		it2.join(); // Main thread waits the two spawn threads to complete

		// Are we supposed to get 20000 here?
		System.out.println(counter.getValue());
		
	}

}

class Counter {
	private int count;
	public void increment() {
		count++; // THIS IS NOT ATOMIC! EVEN IF IT IS ONE LINE
	}
	public int getValue() {
		return count;
	}
}

class IncrementerThread extends Thread {
	
	private Counter counter;
	// All threads work on the same counter instance
	public IncrementerThread(Counter counter) {
		this.counter = counter;
	}
	public void run() {
		// i is thread safe because it's local to the thread
		for (int i = 0; i < 10000; i++ ) {
			counter.increment();
		}
	}
	
}
