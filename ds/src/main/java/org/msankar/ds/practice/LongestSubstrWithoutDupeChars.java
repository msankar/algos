package org.msankar.ds.practice;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstrWithoutDupeChars {

	public static void main(String[] args) {
		String input = "abcbhhhijkl";
		int len = lengthOfLongestSubstring(input);
		System.out.println(len);
	}

    public static int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }
}
