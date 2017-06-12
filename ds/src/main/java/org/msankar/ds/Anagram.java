package org.msankar.ds;

import java.util.Arrays;

public class Anagram {
	
	public static boolean isAnagram(String s1, String s2) {
		if (s1 != null && !s1.isEmpty() && s2 != null )
		s1 = sort(sanitize(s1));
		s2 = sort(sanitize(s2));
		return s1.equalsIgnoreCase(s2);
	}
	
	private static String sanitize(String str) {
		char[] charArray = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < charArray.length; i++) {
			if (Character.isLetter(charArray[i])) {
				sb.append(charArray[i]);
			}
		}
		return sb.toString();
	}

	private static String sort(String str) {
		char[] charArray = str.toCharArray();		
		Arrays.sort(charArray);
		//return new String(charArray);
		return Arrays.toString(charArray);
	}

}
