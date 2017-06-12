package org.msankar.ds;

/**
 * Prints out a multiplication table.
 * 
 * @author malathi.sankar
 */
public class MultiplicationTable {
	
	/**
	 * Multiply and print a multiplication table.
	 *
	 * @param startNum the start number
	 * @param endNum the end number
	 */
	public void multiplyAndPrint(int startNum, int endNum) {
		for (int i = startNum; i <= endNum; i++) {
			for (int j = startNum; j <= endNum; j++) {
				System.out.format("%5d", i*j);
			}
			System.out.println();
		}
	}
}
