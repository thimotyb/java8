package it.corso.collections;

import java.util.ArrayList;
import java.util.List;

public class Example3 {

	public static void main(String[] args) {
		// make some Cars for the pool 
		Car c1 = new Car();
		Car c2 = new Car();
		List<Car> carList = new ArrayList<Car>();
		carList.add(c1);
		carList.add(c2);
		RentalGeneric<Car> carRental = new RentalGeneric<>(2, carList);
		// now get a car out, and it won't need a cast 
		Car carToRent = carRental.getRental(); 
		carRental.returnRental(carToRent);
		// can we stick something else in the original carList? 
		// carList.add(new Cat("Fluffy"));
	}

}
	
class Car { }
class Bycicle { } 

class RentalGeneric<T> {
	private List<T> rentalPool;
	private int maxNum; 
	
	public RentalGeneric(int maxNum, List<T> rentalPool) {
		this.maxNum = maxNum; 
		this.rentalPool = rentalPool;
	}

	public T getRental() { 	
		return rentalPool.get(0);
	}

	public void returnRental(T returnedThing) {
		rentalPool.add(returnedThing); 
	}

}
