package org.msankar.ds.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
	List<Integer> numList;
	Map<Integer, Integer> valToIndexMap;
	Random random;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        numList = new ArrayList<>();
        valToIndexMap = new HashMap<>();
        random = new Random();
    }

    /** Inserts a value to the set.
     * Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
    	if (valToIndexMap.containsKey(val)) {
    		return false;
    	}
    	valToIndexMap.put(val, numList.size());
       	numList.add(val);
       	return true;
    }

    /** Removes a value from the set.
     * Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
    	if (!valToIndexMap.containsKey(val)) {
    		return false;
    	}
    	int idx = valToIndexMap.get(val);
    	numList.remove(idx);
    	valToIndexMap.remove(val);
    	return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
    	return numList.get(random.nextInt(numList.size()));
    }

}
