package org.msankar.ds;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class MissingNumbersTest {
	MissingNumbers mn ;
	private final int[] inputArray = new int[] {1,2,3,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
	int missing = 4;
	
	@Test
	public void testMissingNumbers() {
		mn = new MissingNumbers();		
		System.out.println("Input Array " + Arrays.toString(inputArray));
		
		assertEquals(mn.findMissingNum1(inputArray), missing);

		assertEquals(mn.findMissingNumberSum(inputArray, 20), missing);
		
		assertEquals(mn.findMissingNumberXOR(inputArray), missing);
		
		//assertEquals(mn.findMissingNumberEquals(inputArray), missing);
	}
}
