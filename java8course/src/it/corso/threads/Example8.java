package it.corso.threads;

/**
 * Demonstrates thread coordination with wait/notify on the same lock
 * @author thimoty
 *
 */
public class Example8 {

	public static void main(String[] args) {
		ThreadB b = new ThreadB();
		b.start();

		synchronized (b) {
			try {
				System.out.println("Waiting for b to complete...");
				b.wait(); // This releases the lock on b so another thread can acquire it
						  // Then it needs to re-acquire the lock to go ahead
			} catch (InterruptedException e) {
			}
			System.out.println("Total is: " + b.total);
		}
	}
}

class ThreadB extends Thread {
	int total;

	public void run() {
		synchronized (this) {
			for (int i = 0; i < 1000; i++) {
				total += i;
			}
			notify();
		}
	}
}
