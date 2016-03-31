package it.corso.threads;

/**
 * Demonstrate random ordering of execution in Threads
 * @author thimoty
 *
 */
public class Example2 {

	public static void main(String[] args) {
		// Make one Runnable
		NameRunnable nr = new NameRunnable();
		Thread one = new Thread(nr);
		Thread two = new Thread(nr);
		Thread three = new Thread(nr);
		one.setName("Fred");
		two.setName("Lucy");
		three.setName("Ricky");
		one.start();
		two.start();
		three.start();
	}
}

class NameRunnable implements Runnable {
	public void run() {
		for (int x = 1; x <= 3; x++) {
			System.out.println("Run by " + Thread.currentThread().getName() + ", x is " + x);
		}
	}
}


