package it.corso.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

/**
 * Demonstrates Multicatch
 * 
 * @author thimoty
 *
 */
public class Example3 {

	public static void main(String[] args) {

		try {
			// access the database and write to a file
			Reader reader = new BufferedReader(new FileReader("C:\\temp\\test.txt"));
			throw new SQLException();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
		// This will not compile
		// catch (FileNotFoundException | IOException e)

	}

}
