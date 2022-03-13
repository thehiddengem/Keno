import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class GameplayDriver {
	
	public static ArrayList<Integer> playerSelections = new ArrayList<Integer>();  
    public static ArrayList<Integer> matches = new ArrayList<Integer>();           
    public static Integer[] drawings = new Integer[80];                         //Size wont change, only order will change
    

    
    
	public static Integer totalWinnings;    // set by default constructor or setWinnings()
	public static Integer numSpotsSelected; // how many buttons player has chosen currently as winners
	public static Integer numSpotsTotal;    // how many total buttons a player may choose.
	public static Integer repeatCards;      // how many times the same card has been used. Max of 4 times usable
	

	public static void init_GameplayDriver(Integer cash){
		setWinnings(cash);
		setRepeat(0);
		init_Drawings(); // sets drawings[0] to 1 .... drawings[79] to 80;
	}
	
	//
	//  public static Boolean validNumSpots(Integer n):
	//
	//  number of spots given is valid. 
	//  if true updates numSpotsTotal, numSpotsSelected, and repeatCards
    //
	public static Boolean validNumSpots(Integer n) {
		if (n == 1 || n == 4 || n == 8 || n == 10) {
			numSpotsSelected = 0; // init for next Scene where player picks his numbers
			numSpotsTotal = n;    
			repeatCards = 0;      // if the player is validating number of spots, he is using a new card. Thus 0
			
			return true;
		}
		// same as above but returns false so 0 cannot accidentally be used in actual gameplay. Can be used to "reset" the game state. 
		else if (n == 0) {
			numSpotsSelected = 0; // init for next Scene where player picks his numbers
			numSpotsTotal = n;    
			repeatCards = 0;      // if the player is validating number of spots, he is using a new card. Thus 0
			
			return false;
			
		}
		return false;
	}
	
	
	//  public static String remainingPicks():
	//  
	//  Returns a string stating how many picks must be made before the player can continue to next scene
	//  
	public static String remainingPicks() {
		Integer i = numSpotsTotal - numSpotsSelected;
		String result = "You still have " + i + " spots remaining!";
		return result;
	}
	
	public static Boolean readyToPlay() {
		return numSpotsTotal == numSpotsSelected;
	}
	
	//  This shuffles index's 0 to 80, "randomizing" the contents
	//  The first 20 index's will be used as winners ( 0- 19 )
	static void shuffleDrawings() {

		Random shuffleDraw = new Random();
		 Set<Integer> set = new LinkedHashSet<Integer>();
		 while(set.size() < 80) {
			 set.add(shuffleDraw.nextInt(80) + 1);
		 }
		 int counter = 0;
		 
		 for(Integer entry : set) {
			drawings[counter] = entry;
			counter++;
		 }
		
		}
	
	//  This creates a random generated selection for the player to use
	//  Will check that the number provided is a valid playable spot number
	static void autoPicks(int autoPicks) {
		
		if (!validNumSpots(autoPicks)) {
			return;
		}

		Random shuffleDraw = new Random();
		 Set<Integer> set = new LinkedHashSet<Integer>();
		 playerSelections.clear();
		 while(set.size() < autoPicks) {
			 set.add(shuffleDraw.nextInt(80) + 1);
		 }
 
		 for(Integer entry : set) {
			incSelected();
			addNumberToPlayerSelections(entry);

		 }
		
		}
	
	// This function finds all of the matches by comparing matches arraylist to 1-19 of drawings
	// You can access matches by using the string, or just iterate through the matches ArrayList
	public static String findWinners() {
		String result = "";
		matches.clear();
		shuffleDrawings();
		for (int i = 0; i < 20; i++) {
			if (playerSelections.contains(drawings[i])) {
				matches.add(drawings[i]);
				result += drawings[i] + " "; // can we pass an Int to string like this?
			}
		}
		return result;
		
	
	}
	
	// Extracts drawings[0] - drawings[19] and returns it as a string. Can be used for testing, but leaving it up here in case you decide to use it
	public static String extractDrawingsString() {
		String result = "";
		for (int i = 0; i < 20; i++) {
			result += drawings[i] + " ";
		}
		return result;
	}
	//  // Extracts playerSelections and returns it as a string. Can be used for testing, but leaving it up here in case you decide to use it
	public static String extractSelectionsString() {
		String result = "";
		for (int i = 0; i < playerSelections.size(); i++) {
			result += playerSelections.get(i) + " ";
		}
		return result;
	}
	
	//  clears matches and playerSelections array lists
	//  numSpotsSelected = 0;
	//  numSpotsTotal = 0;    
	//  repeatCards = 0;
	public static void reset() {
		playerSelections.clear();
		if (matches.size() > 0) {
			matches.clear();
		}
		validNumSpots(0);
		
	}
	
	
	
	// Setters and getters ------------------------------------->
	
	// Add a number to player selected array. Should be used with with Boolean incSelected() to avoid adding too many numbers
	public static void addNumberToPlayerSelections(Integer i) {
		playerSelections.add(i);
	}
	
	
	// remove a number to player selected array. Should be used with with Boolean decSelected() to avoid adding too many numbers
	public static void removeNumberToPlayerSelections(Integer i) {
		playerSelections.remove(i);
	}

	
	public static void setWinnings(Integer cash) {
		totalWinnings = cash;
	}
	
	public static Integer getWinnings() {
		return totalWinnings;
	}
	
	public static void setnumSpotsSelected(Integer spots) {
		numSpotsSelected =spots;
	}
	
	public static Integer getnumSpotsSelected() {
		return numSpotsSelected;
	}
	
	// Made for Hanna
	// If player hits button and is able to select more spots return true
	// increment numSpotsSelected by 1.
	// else return false
	public static Boolean incSelected() {
		
		 if (numSpotsTotal > numSpotsSelected) {
			numSpotsSelected++;
			return true;
		}
		return false;
	}
	
	public static Boolean decSelected() {
		if (numSpotsSelected > 0) {
			numSpotsSelected--;
			return true;
		}
		// Should never return false. This means the user is attempting to unselect a button when all buttons are unselected...
		return false;
	}
	
	public static void setnumSpotsTotal(Integer spots) {
		numSpotsTotal = spots;
	}
	
	public static Integer getnumSpotsTotal() {
		return numSpotsTotal;
	}
	
	// Made for Hanna
		// If player "plays again"
		// increment repeatCards by 1.
		// else return repeatCards
	public static Integer incRepeat() {
		repeatCards++;
		return repeatCards;
	}
	public static void setRepeat(Integer repeat) {
		repeatCards = repeat;
	}
	
	public static Integer getRepeat() {
		return repeatCards;
	}
	
	// Testing Functions: These are for me. Use them if you need to, but be careful--------------------------------------------------------------
	
	//  used to initialize drawings[]
	//  Also if for some reason drawings does not contain the original numbers 1-80, can be used as a reset
	//  will be used for testing pre-determined drawings
	public static void init_Drawings() {
		 for (int i = 0; i < 80; i++) {
		    	drawings[i] = i;
		    }
	}
	
	public static void setdrawingsIndex(int i, Integer value) {
		drawings[i] = value;
	}
	
	//  This is exactly the same as findWinners, but it removes the code that shuffles drawings.
	//  This allows testing of the finding winners while allowing the tester to manually enter drawings array
	public static String findWinnersTESTER() {
		String result = "";
		matches.clear();
		for (int i = 0; i < 20; i++) {
			if (playerSelections.contains(drawings[i])) {
				matches.add(drawings[i]);
				result += drawings[i] + " "; // can we pass an Int to string like this?
			}
		}
		return result;

	}
	
}
