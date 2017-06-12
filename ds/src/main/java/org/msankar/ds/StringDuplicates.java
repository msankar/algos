package org.msankar.ds;

public class StringDuplicates {

	public static void main(String[] args) {
		System.out.println(StringDuplicates.hasDuplicateCharacters("hello"));
		System.out.println(StringDuplicates.hasDuplicateCharacters("coder"));
	}
	
	public static boolean hasDuplicateCharacters (String str) {
		if (str == null || str.isEmpty()) {
			return false;
		}
		
		boolean[] byteArray = new boolean[256];
		
		for ( int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			
			if (byteArray[val]) {
				return true;
			} else {
				byteArray[val] = true;
			}
		}
		return false;
	}

}
