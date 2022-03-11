
public class GameplayDriver {
	static Integer pCash;
	static Integer numSpotsSelected; // how many buttons player has chosen currently as winners
	static Integer numSpotsTotal;    // how many total buttons a player may choose.
	static Integer repeatCards;
	
	GameplayDriver(Integer cash){
		setCash(cash);
		setRepeat(0);
	}
	
	public static void setCash(Integer cash) {
		pCash = cash;
	}
	
	public static Integer getCash() {
		return pCash;
	}
	
	public static void setnumSpotsTotal(Integer spots) {
		numSpotsTotal =spots;
	}
	
	public static Integer getSpots() {
		return numSpotsTotal;
	}
	
	public static void setRepeat(Integer repeat) {
		repeatCards = repeat;
	}
	
	public static Integer getRepeat() {
		return repeatCards;
	}
	//number of spots given is valid. if true updates numSpotsTotal
	public static Boolean validNumSpots(Integer n) {
		if (n == 1 || n == 4 || n == 8 || n == 10) {
			numSpotsSelected = 0;
			numSpotsTotal = n;
			repeatCards = 0;
			
			return true;
		}
		return false;
	}
	
	public static String remainingPicks() {
		Integer i = numSpotsTotal - numSpotsSelected;
		String result = "You still have " + i + " spots remaining!";
		return result;
	}
	
	public static Boolean readyToPlay(Integer numSpots) {
		return numSpotsTotal == numSpotsSelected;
	}
	
	
}
