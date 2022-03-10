import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MyTest {

	@Test
	void Gameplay_Cash_Passed_Correctly() {
		Integer cash = 100;
		GameplayDriver G = new GameplayDriver(cash);
		cash = GameplayDriver.setCash(50);
		assertEquals(50, GameplayDriver.getCash());
		assertEquals(50, cash);
		
	}

}
