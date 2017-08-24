package org.msankar.ds.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Implement a data structure supporting the following operations:

Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1.
Key is guaranteed to be a non-empty string.
Dec(Key) - If Key's value is 1, remove it from the data structure.
Otherwise decrements an existing key by 1. If the key does not exist, this function does nothing.
Key is guaranteed to be a non-empty string.
GetMaxKey() - Returns one of the keys with maximal value.
If no element exists, return an empty string "".
GetMinKey() - Returns one of the keys with minimal value.
If no element exists, return an empty string "".
Challenge: Perform all these in O(1) time complexity.
 */
public class AllOne {
	private Map<String, Integer> keyValMap;
	private Map<Integer, Set<String>> valToKeyMap;
	private int maxVal;
	private int minVal;


    /** Initialize your data structure here. */
    public AllOne() {
    	keyValMap = new HashMap<>();
    	valToKeyMap = new HashMap<>();
    	maxVal = Integer.MIN_VALUE;
    	minVal = 0;
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
    	int val = 1;
    	if (keyValMap.containsKey(key)) {
    		val = keyValMap.get(key)+1;
    	}
    	if (valToKeyMap.get(val) == null) {
    		valToKeyMap.put(val, new HashSet<String>());
    	}
    	if (val > maxVal) {
    		maxVal = val;
    	}
    	if (minVal == 0 || minVal > val) {
    		minVal = val;
    	}
    	valToKeyMap.get(val).add(key);
    	keyValMap.put(key, val);
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
    	if (keyValMap.containsKey(key)) {
    		int val = keyValMap.get(key)-1;
    		if (val == 0) {
    			keyValMap.remove(key);
    			valToKeyMap.get(val).remove(key);
    		} else {
    			keyValMap.put(key, val);
    			valToKeyMap.get(val+1).remove(key);
    			valToKeyMap.get(val).add(key);
    		}
        	if (val > maxVal) {
        		maxVal = val;
        	}
        	if (minVal == 0 || minVal > val) {
        		minVal = val;
        	}
    	}
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
    	if (keyValMap.isEmpty()) {
    		return "";
    	}
    	return maxKey;
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
    	if (keyValMap.isEmpty()) {
    		return "";
    	}
    	return minKey;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
