package org.msankar.ds;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NextHighestNumTest {
	@Test
	public void test() {
		assertEquals(3547, NextHighestNum.findNextHighestNumWithSameDigits(3475));
		assertEquals(3547, NextHighestNum.findNextHighestNumWithSameDigits(3457));
		assertEquals(93158, NextHighestNum.findNextHighestNumWithSameDigits(91853));
		assertEquals(9997518, NextHighestNum.findNextHighestNumWithSameDigits(9997158));
		assertEquals(997215689, NextHighestNum.findNextHighestNumWithSameDigits(997196258));
		//assertEquals(21345, NextHighestNum.findNextHighestNumWithSameDigits(15432));
	}
}
