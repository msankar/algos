package org.msankar.ds;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LargestIntegerTest {
	private LargestInteger lt;
	int[] arr = new int[] {14, 7,9,8,23,6,3,2};
	
	@Test
	public void test() {
		lt = new LargestInteger();
		assertEquals(23,lt.getLargestInteger(arr));
	}
}
