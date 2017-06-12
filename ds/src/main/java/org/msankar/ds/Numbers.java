package org.msankar.ds;

public class Numbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Numbers.median(new int[]{0,3,5,8,9,13});
		Numbers.median(new int[]{0,3,5,7,8,9,13});

	}
	
	public static double median(int[] arr) {
		double ret = 0;
		
		if (arr == null || arr.length == 0) {
			return 0;
		}
		
		boolean odd = (arr.length%2 > 0);
		
		if (odd) {
			ret = arr[(0+arr.length)/2];
		} else {
			int lo = arr.length/2;
			int hi = arr.length/2 - 1;
			ret = (arr[lo] + arr[hi])/2.0;
		}
		
		System.out.println("median = " + ret);
		return ret;
	}

}
