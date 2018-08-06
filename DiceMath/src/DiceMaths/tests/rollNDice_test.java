package tests;


import static org.junit.jupiter.api.Assertions.*;
import DiceMaths.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class rollNDice_test {

	@Test
	void test() {
		
		ArrayList<Integer> list = DiceMethods.rollNDice(10,6);
		assertEquals(10, list.size());
	}

}
