package org.msankar.ds;

public class SubString {
	
	public void findSubString(String fullString, String subStr) {
		char[] full = fullString.toCharArray();
		char[] sub = subStr.toCharArray();
		for (int i = 0; i < sub.length; i ++) {
			for (int j=0; j < full.length; j++) {
				if(sub[i] == full[j]) {
					
				}
			}
		}		
	}
}
