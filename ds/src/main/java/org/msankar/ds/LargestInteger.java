package org.msankar.ds;

/**
 * The Class LargestInteger.
 * @author malathi.sankar
 */
public class LargestInteger {
	
	/**
	 * Gets the largest integer.
	 *
	 * @param arr the arr
	 * @return the largest integer
	 */
	public int getLargestInteger(int[] arr) {
		int ret = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > ret) {
				ret = arr[i];
			}
		}
		return ret;
	}
}
