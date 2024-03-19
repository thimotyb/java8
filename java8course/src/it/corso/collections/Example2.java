package it.corso.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstrates wildcards with Generics
 * @author thimoty
 *
 */
public class Example2 {

	public static void main(String[] args) {
		
		// Which one compiles?
		/*
		 * List<?> list = new ArrayList<Dog>();
		   List<? extends Animal> aList = new ArrayList<Dog>(); 
		   List<?> foo = new ArrayList<? extends Animal>(); 
		   List<? extends Dog> cList = new ArrayList<Integer>(); 
		   List<? super Dog> bList = new ArrayList<Animal>(); 
		   List<? super Animal> dList = new ArrayList<Dog>();
		 */
		List<?> list = new ArrayList<Dog>();
		List<? extends Animal> aList = new ArrayList<Dog>();  // Can't add more Dogs here
		List<?> foo = new ArrayList<Animal>(); 
		//List<? extends Dog> cList = new ArrayList<Integer>();
		List<? super Dog> bList = new ArrayList<Animal>(); 
		bList.add(new Dog());
		List<? super Animal> dList = new ArrayList<Object>();
		
	}

}
