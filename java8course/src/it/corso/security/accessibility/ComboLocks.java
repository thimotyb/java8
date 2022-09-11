package it.corso.security.accessibility;

import java.util.Map;

/**
 * Demonstrates an accessibility attack
 * @author thimo
 *
 */
public class ComboLocks {
   private Map<String, String> combos;
 
   public boolean isComboValid(String animal, String combo) {
      String correctCombo = combos.get(animal);
      return combo.equals(correctCombo);
   }
}

class GrasshopperCage {
	   public static void openLock(ComboLocks comboLocks, String combo) {
	      if (comboLocks.isComboValid("grasshopper", combo))
	         System.out.println("Open!");
	   }
}

/**
 * Because ComboLocks is not final, an attacker can supply additional code
 * that extends it to access its information even if fields are private
 * @author thimo
 *
 */
class EvilComboLocks extends ComboLocks {
	   public boolean isComboValid(String animal, String combo) {
	      boolean valid = super.isComboValid(animal, combo);
	      if (valid) {
	         // email the password to Hacker
	      }
	      return valid;
	   }
	}

