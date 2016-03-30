package it.corso.exceptions;

import java.io.IOException;

/**
 * Demonstrates Suppressed Exceptions
 * 
 * @author thimoty
 *
 */
public class Example4 {

	public static void main(String[] args) {
			try (Three three = new Three())	{
			throw new Exception("Try");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			for (Throwable t : e.getSuppressed())	{
				System.err.println("suppressed:" + t);
			} 
		} 
	}

}

class Three implements AutoCloseable {
	public void close() throws IOException {
		throw new IOException("Closing");
	}
}

