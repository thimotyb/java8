package it.corso.exceptions;

import java.io.Closeable;
import java.io.IOException;

/**
 * Demonstrates AutoCloseable order with catch/finally
 * @author thimoty
 *
 */
public class Example2 {

	public static void main(String[] args) {

			try (One one = new One(); Two two = new Two()) { 
				System.out.println("Try"); throw new RuntimeException();
			} catch (Exception e) {
				System.out.println("Catch");
			} finally {
				System.out.println("Finally");
			} 
		}

	}

	class One implements AutoCloseable {
		public void close() {
			System.out.println("Close - One");
		}
	}

	class Two implements AutoCloseable {
		public void close() {
			System.out.println("Close - Two");
		}
	}
	
	// Differences between Closeable and AutoCloseable
	
	// ok because AutoCloseable allows throwing any Exception
	class A implements AutoCloseable { public void close() throws Exception {}}
	// ok because subclasses or implementing methods can throw // a subclass of Exception or none at all
	class B implements AutoCloseable { public void close() {}}
	class C implements AutoCloseable { public void close() throws IOException {}}
	// ILLEGAL - Closeable only allows IOExceptions or subclasses
	// class D implements Closeable { public void close() throws Exception}}}
	//ok because Closeable allows throwing IOException
	// class E implements Closeable { public void close() throws IOException}}}



