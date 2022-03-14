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
	void matchingTestSimple() {
		GameplayDriver.setnumSpotsTotal(5);
		GameplayDriver.setnumSpotsSelected(0);
		GameplayDriver.addNumberToPlayerSelections(5);
		GameplayDriver.addNumberToPlayerSelections(7);
		GameplayDriver.addNumberToPlayerSelections(9);
		GameplayDriver.addNumberToPlayerSelections(11);
		GameplayDriver.addNumberToPlayerSelections(13);
		GameplayDriver.drawings[0] = 1;
		
		GameplayDriver.drawings[1] = 10;
		
		GameplayDriver.drawings[2] = 2;
		GameplayDriver.drawings[3] = 3;
		GameplayDriver.drawings[4] = 4;
		GameplayDriver.drawings[5] = 5;
		GameplayDriver.drawings[6] = 6;
		GameplayDriver.drawings[7] = 7;
		GameplayDriver.drawings[8] = 8;
		GameplayDriver.drawings[9] = 9;
		GameplayDriver.drawings[10] = 11;
		GameplayDriver.drawings[11] = 12;
		GameplayDriver.drawings[12] = 13;
		GameplayDriver.drawings[13] = 14;
		GameplayDriver.drawings[14] = 15;
		GameplayDriver.drawings[15] = 16;
		GameplayDriver.drawings[16] = 17;
		GameplayDriver.drawings[17] = 18;
		GameplayDriver.drawings[18] = 19;
		GameplayDriver.drawings[19] = 20;
		String s = GameplayDriver.findWinnersTESTER();
		
		assertEquals(GameplayDriver.matches.size(), 5);
		assertEquals(s, "5 7 9 11 13 ");
		
	}
	
	void matchingTestDuplicates() {
		GameplayDriver.setnumSpotsTotal(5);
		GameplayDriver.setnumSpotsSelected(0);
		GameplayDriver.addNumberToPlayerSelections(5);
		GameplayDriver.addNumberToPlayerSelections(7);
		GameplayDriver.addNumberToPlayerSelections(9);
		GameplayDriver.addNumberToPlayerSelections(11);
		GameplayDriver.addNumberToPlayerSelections(13);
		GameplayDriver.drawings[0] = 1;
		
		GameplayDriver.drawings[1] = 1;
		
		GameplayDriver.drawings[2] = 1;
		GameplayDriver.drawings[3] = 1;
		GameplayDriver.drawings[4] = 1;
		GameplayDriver.drawings[5] = 2;
		GameplayDriver.drawings[6] = 2;
		GameplayDriver.drawings[7] = 2;
		GameplayDriver.drawings[8] = 5;
		GameplayDriver.drawings[9] = 5;
		GameplayDriver.drawings[10] = 5;
		GameplayDriver.drawings[11] = 5;
		GameplayDriver.drawings[12] = 5;
		GameplayDriver.drawings[13] = 5;
		GameplayDriver.drawings[14] = 7;
		GameplayDriver.drawings[15] = 7;
		GameplayDriver.drawings[16] = 7;
		GameplayDriver.drawings[17] = 7;
		GameplayDriver.drawings[18] = 7;
		GameplayDriver.drawings[19] = 7;
		String s = GameplayDriver.findWinnersTESTER();
		
		assertEquals(GameplayDriver.matches.size(), 5);
		assertEquals(s, "5 7 ");
		
	}
	
	void SelectionProofOfConceptTest() {
		Integer inputi = 2;  // player has selected 2 as their input
		assertEquals(false, GameplayDriver.validNumSpots(inputi));
		
		inputi = 4;         // player changes to 4 as 2 is rejected
		assertEquals(true, GameplayDriver.validNumSpots(inputi));
		
		assertEquals(4, GameplayDriver.getnumSpotsTotal());
		
		assertEquals(true, GameplayDriver.incSelected());  //player attempts to click on a button. Returns true
		GameplayDriver.addNumberToPlayerSelections(5);     //because it returned true, the event handler adds the number to the player picks
		assertEquals(1, GameplayDriver.getnumSpotsSelected());
		
		assertEquals(true, GameplayDriver.incSelected());  //the same follows...
		GameplayDriver.addNumberToPlayerSelections(7);
		assertEquals(2, GameplayDriver.getnumSpotsSelected());
		
		assertEquals(true, GameplayDriver.incSelected()); 
		GameplayDriver.addNumberToPlayerSelections(9);
		assertEquals(3, GameplayDriver.getnumSpotsSelected());
		
		assertEquals(true, GameplayDriver.incSelected()); 
		GameplayDriver.addNumberToPlayerSelections(11);
		assertEquals(4, GameplayDriver.getnumSpotsSelected());
		
		assertEquals(false, GameplayDriver.incSelected()); // Player attempts to click on a button. Returns false because he hit max picks.
		//GameplayDriver.addNumberToPlayerSelections(13);  // Therefore do not run this code, because event handler sees that they cannot add more picks
		assertEquals(4, GameplayDriver.getnumSpotsSelected());
		
		assertEquals(true, GameplayDriver.decSelected()); // Player deselects a button because he wants to change 7 to 13
		GameplayDriver.removeNumberPlayerSelections(7);
		assertEquals(3, GameplayDriver.getnumSpotsSelected());
		
		assertEquals(true, GameplayDriver.incSelected());      // Player wants to select button 13
		GameplayDriver.addNumberToPlayerSelections(13);        //  incSelected returns true, therefore run it
		assertEquals(4, GameplayDriver.getnumSpotsSelected());
		
		//Player picks are 5 9 11 13
		
		GameplayDriver.drawings[0] = 5;
		
		GameplayDriver.drawings[1] = 9;
		
		GameplayDriver.drawings[2] = 11;
		GameplayDriver.drawings[3] = 13;
		
		GameplayDriver.drawings[4] = 87;
		GameplayDriver.drawings[5] = 83;
		GameplayDriver.drawings[6] = 79;
		GameplayDriver.drawings[7] = 72;
		GameplayDriver.drawings[8] = 61;
		GameplayDriver.drawings[9] = 40;
		GameplayDriver.drawings[10] = 12;
		GameplayDriver.drawings[11] = 41;
		GameplayDriver.drawings[12] = 42;
		GameplayDriver.drawings[13] = 55;
		GameplayDriver.drawings[14] = 61;
		GameplayDriver.drawings[15] = 67;
		GameplayDriver.drawings[16] = 70;
		GameplayDriver.drawings[17] = 82;
		GameplayDriver.drawings[18] = 66;
		GameplayDriver.drawings[19] = 1;
		String s = GameplayDriver.findWinnersTESTER();
		
		assertEquals(GameplayDriver.matches.size(), 4);
		assertEquals(s, "5 9, 11, 13 ");
		
	}
	
	@Test
	void autoPicksTest() {
		GameplayDriver.reset();
		//Player is lazy, wants computer to generate picks for him
		GameplayDriver.autoPicks(2);
		assertEquals(0, GameplayDriver.getnumSpotsSelected());
		assertEquals(0, GameplayDriver.getnumSpotsTotal());
		assertEquals(0, GameplayDriver.playerSelections.size());
		
		GameplayDriver.autoPicks(4);
		assertEquals(4, GameplayDriver.getnumSpotsSelected());
		assertEquals(4, GameplayDriver.getnumSpotsTotal());
		assertEquals(4, GameplayDriver.playerSelections.size());
		assertEquals(true,GameplayDriver.readyToPlay());
		System.out.println(GameplayDriver.extractSelectionsString());
		
		GameplayDriver.autoPicks(8);
		assertEquals(8, GameplayDriver.getnumSpotsSelected());
		assertEquals(8, GameplayDriver.getnumSpotsTotal());
		assertEquals(8, GameplayDriver.playerSelections.size());
		assertEquals(true,GameplayDriver.readyToPlay());
		
		GameplayDriver.autoPicks(10);
		assertEquals(10, GameplayDriver.getnumSpotsSelected());
		assertEquals(10, GameplayDriver.getnumSpotsTotal());
		assertEquals(10, GameplayDriver.playerSelections.size());
		assertEquals(true,GameplayDriver.readyToPlay());
	}
	
	@Test
	void winnings1Spot(){
		GameplayDriver.reset();
		GameplayDriver.setWinnings(1);
		GameplayDriver.setnumSpotsTotal(1);
		
		GameplayDriver.matches.add(1);
		assertEquals(2, GameplayDriver.calculateWinnings(1));
		assertEquals(3, GameplayDriver.getWinnings());
		
		// Shouldn't be possible. Indicates cheating. Should return 0;
		GameplayDriver.matches.add(2);
		assertEquals(0, GameplayDriver.calculateWinnings(1));
		assertEquals(3, GameplayDriver.getWinnings());
		
		GameplayDriver.matches.remove(1);
		assertEquals(2, GameplayDriver.calculateWinnings(1));
		assertEquals(5, GameplayDriver.getWinnings());
		
		GameplayDriver.setWinnings(1);
		assertEquals(4, GameplayDriver.calculateWinnings(2));
		assertEquals(5, GameplayDriver.getWinnings());
		
		GameplayDriver.setWinnings(1);
		assertEquals(6, GameplayDriver.calculateWinnings(3));
		assertEquals(7, GameplayDriver.getWinnings());
	}
	
	@Test
	void winnings4Spot(){
		GameplayDriver.reset();
		GameplayDriver.setnumSpotsTotal(4);
		
		GameplayDriver.setWinnings(0);
		GameplayDriver.matches.add(1);
		assertEquals(0, GameplayDriver.calculateWinnings(1));
		assertEquals(0, GameplayDriver.getWinnings());
		
		GameplayDriver.setWinnings(0);
		GameplayDriver.matches.add(2);
		assertEquals(1, GameplayDriver.calculateWinnings(1));
		assertEquals(1, GameplayDriver.getWinnings());
		
		GameplayDriver.setWinnings(0);
		GameplayDriver.matches.add(3);
		assertEquals(5, GameplayDriver.calculateWinnings(1));
		assertEquals(5, GameplayDriver.getWinnings());
		
		GameplayDriver.setWinnings(0);
		GameplayDriver.matches.add(4);
		assertEquals(75, GameplayDriver.calculateWinnings(1));
		assertEquals(75, GameplayDriver.getWinnings());
		
		// Cheating
		GameplayDriver.setWinnings(0);
		GameplayDriver.matches.add(5);
		assertEquals(0, GameplayDriver.calculateWinnings(1));
		assertEquals(0, GameplayDriver.getWinnings());
		
		GameplayDriver.matches.remove(4);
		// Multiplier
		
		GameplayDriver.setWinnings(100);
		assertEquals(750, GameplayDriver.calculateWinnings(10));
		assertEquals(850, GameplayDriver.getWinnings());
	}
	
	@Test
	void winnings8Spot(){
		GameplayDriver.reset();
		GameplayDriver.setnumSpotsTotal(4);
		
		GameplayDriver.setWinnings(0);
		GameplayDriver.matches.add(1);
		assertEquals(0, GameplayDriver.calculateWinnings(1));
		assertEquals(0, GameplayDriver.getWinnings());
		
		GameplayDriver.setWinnings(0);
		GameplayDriver.matches.add(2);
		assertEquals(1, GameplayDriver.calculateWinnings(1));
		assertEquals(1, GameplayDriver.getWinnings());
		
		GameplayDriver.setWinnings(0);
		GameplayDriver.matches.add(3);
		assertEquals(5, GameplayDriver.calculateWinnings(1));
		assertEquals(5, GameplayDriver.getWinnings());
		
		GameplayDriver.setWinnings(0);
		GameplayDriver.matches.add(4);
		assertEquals(75, GameplayDriver.calculateWinnings(1));
		assertEquals(75, GameplayDriver.getWinnings());
		
		// Cheating
		GameplayDriver.setWinnings(0);
		GameplayDriver.matches.add(5);
		assertEquals(0, GameplayDriver.calculateWinnings(1));
		assertEquals(0, GameplayDriver.getWinnings());
		
		GameplayDriver.matches.remove(4);
		// Multiplier
		
		GameplayDriver.setWinnings(100);
		assertEquals(750, GameplayDriver.calculateWinnings(10));
		assertEquals(850, GameplayDriver.getWinnings());
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
