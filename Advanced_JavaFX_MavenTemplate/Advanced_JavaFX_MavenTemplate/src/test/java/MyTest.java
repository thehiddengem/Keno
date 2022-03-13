import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MyTest {

	@BeforeEach
	 void init() {
		GameplayDriver.init_GameplayDriver(100);
		
		//Players hits confirm button with input 4
		GameplayDriver.validNumSpots(4);        // Must be set to 1,4,8,10 or it will fail. 
		
		
		
	}
	
	// Test case written for Hannah to help understand intention of functions
	// Also tests incSelected(), decSelected(), validNumSpots(), readyToPlay()
	@Test
	void ReadyToPlayTest() {
		assertEquals(true,GameplayDriver.validNumSpots(10));    // Player has input that he wants to play with 10 spots in the text field. This is a valid input so pass
		
		assertEquals(false, GameplayDriver.readyToPlay());      // 0 / 10 spots selected, thus fail
		assertEquals(0, GameplayDriver.getnumSpotsSelected());
		assertEquals("You still have 10 spots remaining!",      
				      GameplayDriver.remainingPicks());        //  remainingPicks()Function creates error message you could use
		
		
		assertEquals(true,GameplayDriver.incSelected());        //  Player selects 1 spot out of 10
		assertEquals(false, GameplayDriver.readyToPlay());
		assertEquals(1, GameplayDriver.getnumSpotsSelected());
		assertEquals("You still have 9 spots remaining!",      
			      GameplayDriver.remainingPicks());
		
		
		GameplayDriver.setnumSpotsSelected(10);                //  Player Selects 10 out of 10 spots
		assertEquals(true, GameplayDriver.readyToPlay());      //  All spots filled, game is ready to progress
		assertEquals(10, GameplayDriver.getnumSpotsSelected());
		
		
		assertEquals(false,GameplayDriver.incSelected());      //  Player attempts to select 11 out of his 10 available spots. 
															   //  incSelected fails and does not increment
		
		
		assertEquals(true, GameplayDriver.readyToPlay());      //  Player still has 10 / 10 spots thus pass
		assertEquals(10, GameplayDriver.getnumSpotsSelected());
		
		
		assertEquals(true,GameplayDriver.decSelected());       //  Player De-Selects 2 Spots
		assertEquals(true,GameplayDriver.decSelected());
		
		

		
		assertEquals(false, GameplayDriver.readyToPlay());     //  8/10 spots selected, will fail
		assertEquals(8, GameplayDriver.getnumSpotsSelected());
		assertEquals("You still have 2 spots remaining!",      
			      GameplayDriver.remainingPicks());
		
		
		GameplayDriver.setnumSpotsSelected(0);                 //  Player has de-selected every spot
		assertEquals(false, GameplayDriver.decSelected());     //  This shouldn't be possible, but 
		 													   //  if a player did somehow manage to un-select more buttons than he selected, 
															   //  it will return false and do nothing
		
		
		
	}
	/*
	@Test
	void drawingsInitdTest() {
		assertEquals(1, GameplayDriver.drawings.get(0));
		assertEquals(2, GameplayDriver.drawings.get(1));
		assertEquals(80, GameplayDriver.drawings.get(79));
	}*/
	
	// This test verifies that every possible winning number 1-80, is actually still in the reshuffled list.
	@Test
	void shuffleDrawingsTest() {
		GameplayDriver.shuffleDrawings();
		for (int i = 1; i < 81; i++) {
			System.out.print(" " + GameplayDriver.drawings[i-1]);     //  Prints every value from 1 - 80 in index 0 to 79 in randomized order
		}
		System.out.println();
		
		GameplayDriver.shuffleDrawings();
		for (int i = 1; i < 81; i++) {
			System.out.print(" " + GameplayDriver.drawings[i-1]);     //  Prints every value from 1 - 80 in index 0 to 79 in randomized order
		}
		System.out.println();
		
		GameplayDriver.shuffleDrawings();
		for (int i = 1; i < 81; i++) {
			System.out.print(" " + GameplayDriver.drawings[i-1]);     //  Prints every value from 1 - 80 in index 0 to 79 in randomized order
		}
		System.out.println();

	}
	@Test
	void matchingTest() {
		GameplayDriver.setnumSpotsTotal(5);
		GameplayDriver.setnumSpotsSelected(0);
		GameplayDriver.addNumberToPlayerSelections(5);
		GameplayDriver.addNumberToPlayerSelections(7);
		GameplayDriver.addNumberToPlayerSelections(9);
		GameplayDriver.addNumberToPlayerSelections(11);
		GameplayDriver.addNumberToPlayerSelections(13);
		String s = GameplayDriver.findWinners();
		System.out.println("Winners" + s);
		
	}
	
	
	@ParameterizedTest
	@ValueSource(ints = {1,4,8,10})
	void CorrectNumberSpotsTest(int i) {
		assertEquals(GameplayDriver.validNumSpots(i), true);
		assertEquals(GameplayDriver.getnumSpotsTotal(), i);
		assertEquals(GameplayDriver.getnumSpotsSelected(), 0);
		assertEquals(GameplayDriver.getRepeat(), 0);
	}
	
	@ParameterizedTest
	@ValueSource(ints = {2,3,5,6,7,9,11,12})
	void BadNumberSpotsTest(int i) {
		GameplayDriver.setRepeat(2);                //Player has played same card twice
		GameplayDriver.setnumSpotsSelected(3);      //Player has selected 3 spots out of his total 4
		
		assertEquals(GameplayDriver.validNumSpots(i), false); // Because it fails, none of the 3 following data members should be changed
		assertEquals(GameplayDriver.getnumSpotsTotal(), 4);
		assertEquals(GameplayDriver.getnumSpotsSelected(), 3);
		assertEquals(GameplayDriver.getRepeat(), 2);
	}
	

}
