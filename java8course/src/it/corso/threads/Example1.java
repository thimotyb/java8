package it.corso.threads;

/**
 * Demonstrates a simple usage of Threads
 * @author thimoty
 *
 */
public class Example1 {

	public static void main(String[] args) {
		FooRunnable r = new FooRunnable();
		Thread t = new Thread(r);
		t.start();
	}

}

class FooRunnable implements Runnable {
	public void run() {
		for (int x = 1; x < 6; x++) {
			System.out.println("Runnable running");
		}
	}
}
