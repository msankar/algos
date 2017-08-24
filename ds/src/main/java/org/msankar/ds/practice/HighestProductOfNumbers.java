package org.msankar.ds.practice;

public class HighestProductOfNumbers {

	public static void main(String[] args) {
		HighestProductOfNumbers highestProductOfNumbers = new HighestProductOfNumbers();
		int[] array = new int[] {2, 3, 1, 10};
		int product = highestProductOfNumbers.getHighestProduct(array);
		System.out.println(String.format("Highest Product %d", product));
	}

	/**
	 * Given an array of integers, find the highest product you can get from three of the integers.
	 */
	public int getHighestProduct(int[] array) {
		if (array.length < 3) {
			throw new IllegalArgumentException("Need at least 3 numbers in the array");
		}

		int lowest = Math.min(array[0], array[1]);
		int highest = Math.max(array[0], array[1]);
		int highestProdOfTwo = array[0]*array[1];
		int lowestProdOfTwo = array[0]*array[1];
		int highestProdOfThree = array[0]*array[1]*array[2];

		for (int i = 2; i < array.length; i++) {
			int current = array[i];
			//System.out.println(
			//	String.format("Current=%d, Highest=%d, lowest=%d, highestProd2=%d, lowestProd2=%d, highestProd3=%d"
			//			,current, highest, lowest, highestProdOfTwo, lowestProdOfTwo, highestProdOfThree));
			highestProdOfThree = Math.max(
					Math.max(highestProdOfThree, current * highestProdOfTwo),
			            	current * lowestProdOfTwo);
			lowestProdOfTwo = Math.min(Math.min(lowestProdOfTwo, current*lowest), current*highest);
			highestProdOfTwo = Math.max(Math.max(highestProdOfTwo, current*lowest), current*highest);
			highest = Math.max(highest, current);
			lowest = Math.min(lowest, current);
		}
		return highestProdOfThree;
	}
}
