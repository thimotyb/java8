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
		RentalGeneric<Car> carRental = new RentalGeneric<Car>(2, carList);
		// now get a car out, and it won't need a cast 
		Car carToRent = carRental.getRental(); 
		carRental.returnRental(carToRent);
		// can we stick something else in the original carList? 
		// carList.add(new Cat("Fluffy"));
	}

}
	
class Car { }
