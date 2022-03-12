import java.util.ArrayList;

public class GameplayDriver {
	
	public static ArrayList<Integer> playerSelections = new ArrayList<Integer>();  
    public static ArrayList<Integer> matches = new ArrayList<Integer>();           
    public static Integer[] drawings = new Integer[80];                            //Size wont change, only order will change
    

    
    
	public static Integer totalWinnings;    // set by default constructor or setWinnings()
	public static Integer numSpotsSelected; // how many buttons player has chosen currently as winners
	public static Integer numSpotsTotal;    // how many total buttons a player may choose.
	public static Integer repeatCards;      // how many times the same card has been used. Max of 4 times usable
	

	static void init_GameplayDriver(Integer cash){
		setWinnings(cash);
		setRepeat(0);
		
	    for (int i = 0; i < 80; i++) {
	    	drawings[i] = i+1;
	    }
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
	
	
	
	
	// Setters and getters ------------------------------------->
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
	
	
}
