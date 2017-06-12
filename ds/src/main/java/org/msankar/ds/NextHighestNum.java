package org.msankar.ds;

import java.util.Arrays;

public class NextHighestNum {
	
	public static int findNextHighestNumWithSameDigits(int num) {
		char[] numArr = (String.valueOf(num)).toCharArray();
		int splitIndex = 0; 

		//Find where I want to split the string
		if (splitIndex == 0) {
		for (int i = 0; i < numArr.length; i++) {	
			if (i != 0 && ((i+1) <= numArr.length)) {
			if (numArr[i] < numArr[i+1]) {
				splitIndex = i+1;
				break;
			}
			}
		}
		}

		//Now split the string
		char[] s1 = Arrays.copyOfRange(numArr, 0, splitIndex);
		char[] s2 = Arrays.copyOfRange(numArr, splitIndex, numArr.length);
		Arrays.sort(s2);
		
		//Now swap the numbers
		char temp = s1[s1.length -1];
		s1[s1.length - 1] = s2[0];
		s2[0] = temp;

		String s3 = new String (s1).concat(new String (s2));
		int ret = Integer.valueOf(s3);
		System.out.println(ret);
		return ret;
	}


}
