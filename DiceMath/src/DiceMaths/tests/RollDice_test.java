package tests;
import static org.junit.jupiter.api.Assertions.*;
import DiceMaths.*;

import org.junit.jupiter.api.Test;

class RollDice_test {

	@Test
	void test() {
		int i = DiceMethods.rollDice(6);
		assertTrue(i <= 6);
	}

}
