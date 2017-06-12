package org.msankar.ds;

public class CharsInStrings {
	public static void findCommonChars(String s1, String s2) {
		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		
		for (int i = 0; i < arr1.length; i++) {
			
		}
	}
	
	public static char[] removeDups(char[] arr) {
		char[] result = new char[arr.length];
		for ( int i = 0; i < arr.length; i++) {
			for(int j = i+1; j < arr.length; j++) {
				if(arr[i] == arr[j]) {
					arr[j] = 'a';
				}
			}
		}
		
		return result;
	}

}
