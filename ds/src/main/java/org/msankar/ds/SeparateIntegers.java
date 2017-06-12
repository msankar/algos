package org.msankar.ds;

/**
 * The Class SeparateIntegers.
 */
public class SeparateIntegers {

	/**
	 * Separate odd integers.
	 *
	 * @param arr the arr
	 * @return the int[]
	 */
	public static int[] separateOddIntegers(int[] arr) {
		int[] ret = new int[arr.length];
		int len = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]%2 != 0) {
				ret[len++] = arr[i];
			}
		}
		return ret;
	}
	
	/**
	 * Separate even integers.
	 *
	 * @param arr the arr
	 * @return the int[]
	 */
	public static int[] separateEvenIntegers(int[] arr) {
		int[] ret = new int[arr.length];
		int len = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]%2 == 0) {
				ret[len++] = arr[i];
			}
		}
		return ret;
	}
	
	/**
	 * Separate odd and even integers.
	 *
	 * @param arr the arr
	 * @return the int[][]
	 */
	public static int[][] separateOddAndEvenIntegers(int[] arr) {
		int[][] ret = new int[2][arr.length];
				
		int elen = 0, olen =0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]%2 == 0) {
				ret[0][elen++] = arr[i];
			} else {
				ret[1][olen++] = arr[i];
			}
		}
		return ret;
	}	
}
