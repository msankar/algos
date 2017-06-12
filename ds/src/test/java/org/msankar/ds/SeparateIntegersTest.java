package org.msankar.ds;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class SeparateIntegersTest {
	private final int[] arr = new int[] {2,3,7,9,8,13, 19,22, 44};
	
	@Test
	public void test() {
		assertEquals("[3, 7, 9, 13, 19, 0, 0, 0, 0]", Arrays.toString(SeparateIntegers.separateOddIntegers(arr)));
		assertEquals("[2, 8, 22, 44, 0, 0, 0, 0, 0]", Arrays.toString(SeparateIntegers.separateEvenIntegers(arr)));
		
		assertEquals("[[2, 8, 22, 44, 0, 0, 0, 0, 0], [3, 7, 9, 13, 19, 0, 0, 0, 0]]",
				Arrays.deepToString(SeparateIntegers.separateOddAndEvenIntegers(arr)));
	}
}
