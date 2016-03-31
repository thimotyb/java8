package it.corso.threads;

/**
 * Demonstrates how to synchronize a block of code
 * @author thimoty
 *
 */
public class Example4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class SyncTest {
		public void doStuff() {
			System.out.println("not synchronized");
			synchronized (this) {
				System.out.println("synchronized");
			}
		}
	}

}
