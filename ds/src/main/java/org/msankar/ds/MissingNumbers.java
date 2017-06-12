package org.msankar.ds;

/**
 * The Class MissingNumbers.
 * @author malathi.sankar
 */
public class MissingNumbers {

	/**
	 * Find missing number.
	 *
	 * @param arr the arr
	 * @return the int
	 */
	public int findMissingNum1(int[] arr) {
		for (int i=1; i <= 20; i++) {
			if (arr[i-1] != i) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Find missing number.
	 *
	 * @param inputArray the input array
	 * @param length the length
	 * @return the int
	 */
	public int findMissingNumberSum(int[] inputArray, int length) {
		int total = length * (length+1) / 2 ;
		for (int i = 0; i < inputArray.length; i++) {
			total = total - inputArray[i];
		}
		return total;		
	}
	
	/**
	 * Find missing number XOR.
	 *
	 * @param inputArray the input array
	 * @return the int
	 */
	public int findMissingNumberXOR(int[] inputArray) {
		int length = inputArray.length;
		 int xor1 = inputArray[0];
		 int xor2 = 1;
		 
		 for (int i = 1; i < length; i++) {
			 xor1 = xor1 ^ inputArray[i];
		 }
		 
		 for (int i = 2; i <= length+1; i++) {
			 xor2 = xor2 ^ i;
		 }		 
		 return xor1^xor2;
	}
	
	//TODO : Fix this...
	/**
	 * Find missing number equals.
	 *
	 * @param inputArray the input array
	 * @return the int
	 */
	public int findMissingNumberEquals(int[] inputArray) {
		int length = inputArray.length;
		int sIndex = 0;
		int eIndex = length - 1;
		int mIndex = (eIndex + sIndex) / 2;
		
		while (sIndex < eIndex) {
			if (inputArray[mIndex] - inputArray[sIndex] != mIndex-sIndex) {
				if (mIndex - sIndex == 1 && inputArray[mIndex] - inputArray[sIndex] > 1 ) {
					return mIndex -1;
				}
				eIndex = mIndex;
				mIndex = (sIndex + eIndex) / 2;
			} else if (inputArray[eIndex] - inputArray[mIndex] != eIndex - mIndex) {
				if (eIndex - mIndex == 1 && inputArray[eIndex] - inputArray[mIndex] > 1) {
					return mIndex + 1;
				}
				sIndex = mIndex;
				mIndex = (sIndex + eIndex) / 2;
			}
			
		}
		return 0;			
	}

}
