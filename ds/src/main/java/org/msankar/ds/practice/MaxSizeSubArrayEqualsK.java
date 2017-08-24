package org.msankar.ds.practice;

import java.util.HashMap;
import java.util.Map;

public class MaxSizeSubArrayEqualsK {

	public static void main(String[] args) {
		/*
		 *
Given an array nums and a target value k, find the maximum length of a subarray that sums to k.
If there isn't one, return 0 instead.
Note:
The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.
Example 1:
Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
Example 2:
Given nums = [-2, -1, 2, 1], k = 1,
return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
Follow Up:
Can you do it in O(n) time?
		 */
		int[] nums = {1,-1,5,-2,3};
		int k = 3;
		int x = maxSubArrayLen(nums, k);
		System.out.println(x);

	}

    public static  int maxSubArrayLen(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> sumToIdxMap = new HashMap<>(nums.length);
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int j = 1; j < nums.length; j++) {
        	sums[j] = sums[j-1]+nums[j];
        }
        int max = 0;
        sumToIdxMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
        	if (sumToIdxMap.containsKey(sums[i]-target)) {
        		max = Math.max(max, i-sumToIdxMap.get(sums[i]-target));
        	}
        	if (!sumToIdxMap.containsKey(sums[i])) {
        		sumToIdxMap.put(sums[i], i);
        	}
        }
        return max;
    }
}
