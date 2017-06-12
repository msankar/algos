package org.msankar.ds;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class FibonacciSeriesTest {
	int len = 11;
	int[] arr = new int[] { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34,55 };

	@Test
	public void fibTest() {
		
		System.out.println(Arrays.toString(FibonacciSeries.getFibSeries(len)));
		assertEquals(Arrays.toString(arr),
				Arrays.toString(FibonacciSeries.getFibSeries(len)));

		System.out.println(Arrays.toString(FibonacciSeries
				.getFibSeriesRecursive(len)));
		assertEquals(Arrays.toString(arr),
				Arrays.toString(FibonacciSeries.getFibSeriesRecursive(len)));
		
		assertEquals(13, FibonacciSeries.fib(7));
		
		assertEquals(13, FibonacciSeries.fibMap(7));
	}
}
