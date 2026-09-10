package it.corso.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates polymorphism in a regular typed array
 * 
 * @author thimoty
 *
 */
abstract class Animal {
	public abstract void checkup();
}

class Dog extends Animal {
	public void checkup() { // implement Dog-specific code
		System.out.println("Dog checkup");
	}
}

class Poodle extends Dog {
	public void checkup() { // implement Dog-specific code
		System.out.println("Poodle checkup");
	}
}

class Cat extends Animal {
	public void checkup() { // implement Cat-specific cede
		System.out.println("Cat checkup");
	}
}

class Bird extends Animal {
	public void checkup() { // implement Bird-specific code
		System.out.println("Bird checkup");
	}
}

class AnimalDoctor {
	// method takes an array of any animal subtype
	public void checkAnimals(Animal[] animals) {
		for (Animal a : animals) {
			a.checkup();
		}
    }

		public static void main(String[] args) {
			// test it
			Dog[] dogs = { new Dog(), new Dog() };
			Cat[] cats = { new Cat(), new Cat(), new Cat() };
			Bird[] birds = { new Bird() };
			Poodle[] poodles = { new Poodle() } ; 
			AnimalDoctor doc = new AnimalDoctor();
			doc.checkAnimals(dogs); // pass the Dog[] 
			doc.checkAnimals(cats); // pass the Cat [)
			doc.checkAnimals(birds); // pass the Bird[]
			
			Animal[] myAnimals = cats;
			System.out.println(myAnimals);
			
			ArrayList<Animal> a1 = new ArrayList<>();
			ArrayList<Dog> d1 = new ArrayList<>();
			
			//a1 = d1;
			
			// doc.addAnimal(cats);
			List<Dog> myAlDog = Arrays.asList(dogs);
			List<Cat> myAlCat = Arrays.asList(cats);
			List<Poodle> myAlPoodle = Arrays.asList(poodles);
			System.out.println("***********************");
			doc.readAnimal(myAlDog);
			doc.readAnimal(myAlCat);
			
			List myObjectList = new ArrayList();
			myObjectList.add(new Bird());
			myObjectList.add(5);
			
			doc.printListWildCard(myAlCat);
			doc.printListWildCard(myAlDog);
			doc.printListWildCard(myObjectList);
			
			doc.addAnimal(myAlDog);
			doc.addAnimal(a1); // I can send superclasses of Dogs (Animal)
			//doc.addAnimal(myAlCat); // NO! Only dog collections
			//doc.addAnimal(myAlPoodle); // NO! Only dog collegctions (but I can add a Poodle to a List<Dog>)
			
			
		}
		
		public void addAnimal(List<? super Dog> animals) {  // ALlows me to read, and "write" only Dogs or children of Dogs
			animals.add(new Dog());
			animals.add(new Poodle()); // I can add a subclass of Dog
		}
		
		public void readAnimal(List<? extends Animal> animals) {  // Read Only! Method Invocation Only!!!
			for (Animal a : animals) {
				a.checkup(); // Dynamic binding				
			}			
		}

		public void printListWildCard(List<?> /*List<Object>*/ mylist) {
			for (Object element : mylist) {
				if (element instanceof Animal) ((Animal)element).checkup();
				System.out.println("#####"+(element instanceof Bird));
			}
			//mylist.add(4);
		}
		
		
		public void addAnimal(Animal[] animals) {
			animals[0] = new Dog(); // Eeek.We just put a Dog  in a Cat array! (ArrayStoreException)
		}
}
