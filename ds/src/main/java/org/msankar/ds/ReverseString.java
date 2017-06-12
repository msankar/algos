package org.msankar.ds;


public class ReverseString {
	
	public static String reverseString3 (String s) {
		int len = s.length();
		char[] str = s.toCharArray();

		for (int i = 0; i < len/2; i++) {
			char temp = str[i];
			str[i] = str[len-1-i];
			str[len-1-i] = temp;
		}
		return new String(str);
	}

	public static String reverseString(String str) {
		int len = str.length();
		return len <= 1 ? str
				: (reverseString(str.substring(len / 2)) + reverseString(str
						.substring(0, len / 2)));
	}
	
	public static String reverseString2(String s){
	    if (s.length() == 0) 
	         return s;

	    return reverseString2(s.substring(1)) + s.charAt(0);
	}


}
