package it.corso.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MioEsempio {

	public static void main(String[] args) {
		
		List<Integer> miaLista = new LinkedList<>();
		
		miaLista.add(Integer.valueOf(56));
		miaLista.add(78); 
		
		// TODO: Generics / Wrapper
		System.out.println(miaLista.get(0).intValue());
		
		Set<Integer> mySet = new TreeSet<>();
		mySet.add(9);
		mySet.add(25);
		mySet.add(100);
		mySet.add(1);
		mySet.add(25);
		mySet.add(25);
		mySet.add(25);
		mySet.add(25);
		mySet.add(25);		

		Iterator myIter = mySet.iterator();
		System.out.println(mySet.size());
		System.out.println(myIter.next());
		System.out.println(myIter.next());
		System.out.println(myIter.next());
		System.out.println(myIter.next());
		
		Iterator myIter2 = mySet.iterator();
		
		while(myIter2.hasNext()) {
			System.out.println(myIter2.next());
		}
		
		Set<Integer> mySet2 = Set.of(9,1,66,8,10);
		
		Set<Integer> intersectedSet = new HashSet<>(mySet); // Operations are mutable
		intersectedSet.retainAll(mySet2); // Intersection
		
		System.out.println("**********************");
		for (Iterator iterator = intersectedSet.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());			
		}
		
		Set<Integer> unionSet = new HashSet<>(mySet);
		unionSet.addAll(mySet2); // Union
		System.out.println("**********************");
		for (Iterator iterator = unionSet.iterator(); iterator.hasNext();) {
			System.out.println(iterator.next());			
		}
		
		
		
	}

}
