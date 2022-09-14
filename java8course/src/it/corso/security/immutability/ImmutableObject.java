package it.corso.security.immutability;

/**
 * An example of creating an Immutable object with defensive copying strategies
 * @author thimo
 */


// This object is not immutable (why?)
/*import java.util.*;

  public final class Animal {
     private final ArrayList<String> favoriteFoods;

     public Animal() {
        this.favoriteFoods = new ArrayList<String>();
        this.favoriteFoods.add("Apples");
     }
    public List<String> getFavoriteFoods() { 
       return favoriteFoods;
    }
 }
 */



// This one is Immutable
  import java.util.*;

  public final class ImmutableObject implements Cloneable {
     private final ArrayList<String> favoriteFoods;

 /**
  * This needs to use the copy constructor partner to avoid that attacker
  * holds a reference to the object when created
  * @param favoriteFoods
  */
	public ImmutableObject(List<String> favoriteFoods) {
		// Security validation before using the object
		if (favoriteFoods == null)
			throw new RuntimeException("favoriteFoods is required");
		this.favoriteFoods = new ArrayList<String>(favoriteFoods);
	}
     
    public int getFavoriteFoodsCount() { 
       return favoriteFoods.size();
    }
    public String getFavoriteFoodsElement(int index) { 
       return favoriteFoods.get(index);
    }
    
    // You can use defensive copy or cloning instead of the getCount/getElement pattern above
    // In this way you never provide externally the reference to the internal object used by the class
    public ArrayList<String> getFavoriteFoods() { 
           return new ArrayList<String>(this.favoriteFoods);
    }
    
    /**
     * Override clone to make a deep copy instead of shallow, so cloning will not give away internal reference
     */
    @Override
    public ImmutableObject clone() {
    	   ArrayList<String> listClone = (ArrayList) favoriteFoods.clone();
    	   return new ImmutableObject(listClone);
    }
    
  }
  
//This is how you can attack previous implementation if you do not use the copy constructor pattern
/*
* void modifyNotSoImmutableObject() {
     var favorites = new ArrayList<String>();
     favorites.add("Apples");
     var animal = new ImmutableObject(favorites);
     System.out.print(animal.getFavoriteFoodsCount());
     favorites.clear();
     System.out.print(animal.getFavoriteFoodsCount());
}
*/
