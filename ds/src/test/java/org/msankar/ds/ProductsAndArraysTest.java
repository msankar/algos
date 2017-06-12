package org.msankar.ds;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class ProductsAndArraysTest {

	@Test
	public void test() {
		int arr[][] = new int[][] { { 3, 2, 2 }, { 1, 4, 2 }, { 6, 2, 1 } };
		int arr2[] = new int[] {1,4,2};

		assertEquals("[[4, 6, 6], [8, 2, 4], [2, 6, 12]]",
				Arrays.deepToString(ProductsAndArrays.findProductArray(arr)));

		assertEquals("[[4, 6, 6], [8, 2, 4], [2, 6, 12]]",
				Arrays.deepToString(ProductsAndArrays.findProductArray2(arr)));
		
		assertEquals("[8, 2, 4]", Arrays.toString(ProductsAndArrays.findProd(arr2)));
	}
}
