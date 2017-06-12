package org.msankar.ds;

import java.math.BigDecimal;

/**
 * Write a function that takes as input two numbers represented as strings, and
 * returns the product of the numbers of a string. The numbers can be
 * arbitrarily large.
 */
public class MultiplyStrings {

	/**
	 * Takes as input two numbers represented as strings, and returns the
	 * product of the numbers of a string. The numbers can be arbitrarily large.
	 * 
	 * @param s1
	 *            the s1
	 * @param s2
	 *            the s2
	 * @return the string
	 */
	public static String multiplyStrings(String s1, String s2) {
		BigDecimal bd1 = new BigDecimal(s1);
		BigDecimal bd2 = new BigDecimal(s2);
		return bd1.multiply(bd2).toString();
	}
}
