package it.corso.threads;

/**
 * Demonstrates a potential deadlock
 * (it is still difficult to make it happen, requires a lot of runs)
 * @author thimoty
 *
 */
public class Example7 {

	private static class Resource {
		public int value;
	}

	private Resource resourceA = new Resource();
	private Resource resourceB = new Resource();

	public int read() throws InterruptedException {
		synchronized (resourceA) { // May deadlock here
			synchronized (resourceB) {
				System.out.print("r");
				Thread.sleep(50);
				return resourceB.value + resourceA.value;				
			}
		}
	}

	public void write(int a, int b) throws InterruptedException {
		synchronized (resourceB) { // May deadlock here
			synchronized (resourceA) {
				System.out.print("w");
				resourceA.value = a;
				resourceB.value = b;
				Thread.sleep(100);
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		Thread reader = new Reader();
		Thread writer = new Writer();
		reader.start();
		writer.start();
		reader.join();
		writer.join();
		
	}
}

class Reader extends Thread {
	
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			Example7 e7 = new Example7();
			try {
				e7.read();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Writer extends Thread {
	
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			Example7 e7 = new Example7();
			try {
				e7.write(i, i+1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}