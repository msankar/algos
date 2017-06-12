package org.msankar.ds;

public class DivFunction {

	public static int[] divFunction(int number, int divisor) {
		int[] ret = new int[2];
		int remainder = number - divisor;
		int quotient = 0;

		if (remainder >= 0) {
			quotient = 1;

			while (remainder >= divisor) {
				quotient++;
				remainder = remainder - divisor;
			}
		} else {
			remainder = number;
		}
		ret[0] = quotient;
		ret[1] = remainder;
		return ret;
	}

}
