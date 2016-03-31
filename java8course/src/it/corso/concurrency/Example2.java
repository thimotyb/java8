package it.corso.concurrency;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrate non-safe thread use of Collections
 * Can you add some synchronized blocks to solve the situation?
 * @author thimoty
 *
 */

public class Example2 implements Runnable { // shared by all threads
	
	private List<Integer> list = new ArrayList<>();
	
	public Example2() {
		// add some elements 
		for (int i = 0; i < 100000; i++) { 
			list.add(i);
		}
	}
		// might run concurrently, you cannot be sure 
	   // to be safe you must assume it does 
	public void run() {
		String tName = Thread.currentThread().getName (); 
		while (!list.isEmpty()) {
			System.out.println(tName + " removed " + list.remove(0));
		}
	}
		
	public static void main(String[] args) {
		Example2 air = new Example2(); 
		Thread tl = new Thread(air);
		Thread t2 = new Thread(air); // shared list in the Runnable
		tl.start(); 
		t2.start();
		}
	}
