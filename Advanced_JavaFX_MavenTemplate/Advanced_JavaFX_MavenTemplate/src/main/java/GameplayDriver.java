
public class GameplayDriver {
	static Integer pCash;
	static Integer numPicks;
	static Integer repeatCards;
	
	GameplayDriver(Integer cash){
		setCash(cash);
		setRepeat(0);
	}
	
	public static Integer setCash(Integer cash) {
		pCash = cash;
		return pCash;
	}
	
	public static Integer getCash() {
		return pCash;
	}
	
	public static void setPicks(Integer picks) {
		numPicks = picks;
	}
	
	public static Integer getPicks() {
		return numPicks;
	}
	
	public static void setRepeat(Integer repeat) {
		repeatCards = repeat;
	}
	
	public static Integer getRepeat() {
		return repeatCards;
	}
	
	
}
