     package org.msankar.ds;

public class ReplaceString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(ReplaceString.replace("hello tester how are you how is the weather"));
		System.out.println(ReplaceString.replaceWhiteSpace("hello tester how are you how is the weather"));
	}

	public static String replaceWhiteSpace(String s) {
		if (s == null || s.isEmpty()) {
			return s;
		}

		int spaces = 0, len = s.length();
		for (int i=0; i < len; i++) {
			if (s.charAt(i) == ' ') {
				spaces ++;
			}
		}

		int newLen = 0;
		char[] sarr = new char[len+(spaces*3)];

		for ( int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				sarr[newLen++] = '%';
				sarr[newLen++] = '2';
				sarr[newLen++] = '0';
			} else {
				sarr[newLen++] = s.charAt(i);
			}
		}
		return new String(sarr);
	}

	public static String replace (String s) {
		s = s.replaceAll("\\s", "%20");
		return s;
	}

}
