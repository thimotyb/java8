package it.corso.collections;

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

	}

}
