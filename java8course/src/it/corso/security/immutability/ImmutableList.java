package it.corso.security.immutability;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImmutableList {

	public static void main(String args[]) {
		
		// Mutable List
		String[] strArray = {"Gino", "Nino", "Pino", "Lino", "Mino", "Dino"};
		List<String> mutableList = new ArrayList<String>(Arrays.asList(strArray));
		mutableList.add("Addolorato");
		System.out.println(mutableList.toString());
		
		// Create a list using List.of()
		List<String> strList = List.of("Gino", "Nino", "Pino", "Lino", "Mino", "Dino");
		// Print the List
		System.out.println("List using Java 9 List.of() : " + strList.toString());
		// Unsupported operation on an Immutable Collection
		strList.add("Addolorato");
		
	}

}
