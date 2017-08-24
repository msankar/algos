package org.msankar.ds.practice;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstringKDistinct {

	public static void main(String[] args) {
		String str = "aa";//"ababbdccccdde";
		int k = 2;
		System.out.println(lengthOfLongestSubstringKDistinct(str, k));
	}

	public static int lengthOfLongestSubstringKDistinct(String str, int k) {
		if (null == str) {
			return 0;
		}
		if (str.length() <= k) {
			return str.length();
		}

		int left = 0; int maxLen = 0;
		Map<Character, Integer> map = new HashMap<>(k+1);

		for (int right = 0; right < str.length(); right++) {
			char currChar = str.charAt(right);
			if (!map.containsKey(currChar)) {
				map.put(currChar, 0);
			}
			map.put(currChar, map.get(currChar)+1);

			while (map.size() > k) {
				char leftPtrChar = str.charAt(left++);
				map.put(leftPtrChar, map.get(leftPtrChar)-1);
				if (map.get(leftPtrChar) == 0) {
					map.remove(leftPtrChar);
				}
			}
			maxLen = Math.max(maxLen, right - left + 1);
		}
		return maxLen;
	}

}
