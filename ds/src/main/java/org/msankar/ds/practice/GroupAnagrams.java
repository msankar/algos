package org.msankar.ds.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> retList = groupAnagrams(strs);
		for (List<String> strList : retList) {
			System.out.println(Arrays.toString(strList.toArray()));
			char[] charArr= {'a', 'b', 'c'};
			System.out.println(String.valueOf(charArr));
		}
		System.out.println("done");
	}

    public static List<List<String>> groupAnagrams(String[] strs) {
    	if (strs == null || strs.length == 0) {
    		return Collections.emptyList();
    	}
    	Map<String, List<String>> strToAnagrams = new HashMap<>();
    	List<List<String>> retList = new ArrayList<>();

    	for (int i = 0; i < strs.length; i++) {
    		char[] currChars = strs[i].toCharArray();
    		Arrays.sort(currChars);
    		String key = Arrays.toString(currChars);
    		if (!strToAnagrams.containsKey(key)) {
    			strToAnagrams.put(key, new ArrayList<String>());
    		}
    		strToAnagrams.get(key).add(strs[i]);
    	}

    	for (String str : strToAnagrams.keySet()) {
    		retList.add(strToAnagrams.get(str));
    	}
        return retList;
    }
}
