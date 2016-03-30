package it.corso.exceptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Demonstrate try with Resources
 * @author thimoty
 *
 */
public class Example1 {

	public static void main(String[] args) throws IOException {

		File file = new File("C:\\temp\\text.txt");
		
		//Using a single resource
		try (Reader reader =
				new BufferedReader(new FileReader(file)))	
		{	// note the new syntax
				// read from file
		} catch (IOException e) { log(); throw e;}
		
		
		// Using multiple resources
		try (Scanner in = new Scanner(Paths.get("/usr/share/dict/words"));
				PrintWriter out = new PrintWriter("/tmp/out.txt")) {
				while (in.hasNext())
				out.println(in.next().toLowerCase());
				}
		
		// What happens using catch and finally as well?
		
	}
	
	private static void log() {
		// TODO Auto-generated method stub
		System.out.println("error!");
	}

}
