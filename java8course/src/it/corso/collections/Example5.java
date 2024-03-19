package it.corso.collections;

/**
 * Demonstrates boxing/unboxing in different ranges
 * @author thimo
 *
 */
public class Example5 {

	public static void main(String[] args) {
		
		/**
		 * If the value p being boxed is true, false, a byte, a char in the range \u0000
		 * to \u007f, or an int or short number between -128 and 127, then let r1 and r2
		 * be the results of any two boxing conversions of p. It is always the case that
		 * r1 == r2
		 */
		
		Integer i1 = 1000;
		Integer i2 = 1000;
		if (i1!=i2) System.out.println("different objects");
		if (i1.equals(i2)) System.out.println("meaningfully equals");
		
		Integer i3 = 126; // 129
		Integer i4 = 126; // 129
		if (i3==i4) System.out.println("same object");
		if (i3!=i4) System.out.println("different objects");		
		if (i3.equals(i4)) System.out.println("meaningfully equals");
		
		Boolean b1 = true;
		Boolean b2 = true;
		System.out.println(b1 == b2);
		System.out.println(b1.equals(b2));

	}

}
