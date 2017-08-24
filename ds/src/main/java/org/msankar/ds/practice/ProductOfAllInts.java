package org.msankar.ds.practice;

import java.util.Arrays;

public class ProductOfAllInts {
	public static void main (String[] args) {
		int[] array = new int[] {2, 3, 1, 10};
		int[] products = getProductsOfAllIntsExceptAtIndex(array);
		System.out.println(Arrays.toString(products));
	}
	
	/**
	 * Write a function getProductsOfAllIntsExceptAtIndex() that takes an 
	 * array of integers and returns an array of the products.
	 * Do not use division.
	 */
	public static int[] getProductsOfAllIntsExceptAtIndex (int[] array) {
		if (array.length < 2) {
			throw new IllegalArgumentException("Product of numbers at other indices needs "
					+ "an array of size greater than 1");
		}

		int[] multiplesBefore = new int[array.length];
		int multipleSoFar = 1;
		
		// Build an array of the multiples before the number at the index.
		for (int i = 0; i < array.length; i++) {
			multiplesBefore[i] = multipleSoFar;
			multipleSoFar *= array[i];
		}
			
		// Now find product of all ints after the current number.
		// Multiply after with before and that gives the final array of 
		// total product of all other integers.
		multipleSoFar = 1;
	    for (int i = array.length - 1; i >= 0; i--) {
	    	multiplesBefore[i] *= multipleSoFar;
	        multipleSoFar *= array[i];
	    }

	    return multiplesBefore;
	}
}
