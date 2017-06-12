package org.msankar.ds;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class FibonacciSeries.
 * @author malathi.sankar
 */
public class FibonacciSeries {
	
	public static int fib(int num) {
		int[] result = new int[num+1];
		
		for (int i= 0; i <= num; i++) {
			if (i < 2) {
				result[i] = i;
			} else {
				result[i] = result[i-1] + result[i-2];
			}
		}
		
		return result[num];
	}
	
	public static int fibMap(int num) {
		Map<Integer, Integer> result = new HashMap<>();
		
		for (int i= 0; i <= num; i++) {
			if (i < 2) {
				result.put(i, i);
			} else {
				result.put(i, (result.get(i-1)+result.get(i-2)));
			}
		}
		
		return result.get(num);
	}

	/**
	 * Gets the fib series.
	 *
	 * @param len the len
	 * @return the fib series
	 */
	public static int[] getFibSeries(int len) {
		int[] result = new int[len];
		result[0] = 0;
		result[1] = 1;

		for (int i = 0; i < len; i++) {
			if (i == 0 || i == 1) {
				result[i] = i;
			} else {
				result[i] = result[i - 2] + result[i - 1];
			}
		}
		return result;
	}

	/**
	 * Gets the fib series recursive.
	 *
	 * @param len the len
	 * @return the fib series recursive
	 */
	public static int[] getFibSeriesRecursive(int len) {
		int[] result = new int[len];
		for (int i = 0; i < len; i++) {
			result[i] = fibonacci(i);
		}
		return result;
	}

	/**
	 * Fibonacci.
	 *
	 * @param number the number
	 * @return the int
	 */
	private static int fibonacci(int number) {
		if (number == 0 || number == 1) {
			return number;
		}
		
		return fibonacci(number - 1) + fibonacci(number - 2);
	}
}
