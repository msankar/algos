package org.msankar.ds.practice;

public class DupesToBeRemoved {
	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,2,2,3,3,3,4,4,5};
		System.out.println(removeDuplicates(nums, 2));
	}

    public static int removeDuplicates(int[] nums, int k) {
    	if (null == nums || nums.length == 0) {
    		return 0;
    	}
    	int i = 0;
    	for (int num : nums) {
    		if (i < 2 || (num > nums[i-k])) {
    			nums[i++] = num;
    		}
    	}
    	return i;
    }
}