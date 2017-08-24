package org.msankar.ds.practice;

import java.util.Arrays;

public class ProductExceptSelf {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		int[] prods = productExceptSelf(nums);
		System.out.println(Arrays.toString(prods));

	}

    public static int[] productExceptSelf(int[] nums) {
    	int[] retArr = new int[nums.length];
    	int[] prodBefore = new int[nums.length];
    	int[] prodAfter = new int[nums.length];
    	prodBefore[0] = 1;
    	prodAfter[nums.length-1] = 1;

    	for (int i = 1; i < nums.length; i++) {
    		prodBefore[i] = nums[i-1] * prodBefore[i-1];
    	}

    	for (int i = nums.length-1; i >= 0; i--) {
    		if (i == nums.length-1) {
    			prodAfter[i] = 1;
    		} else {
    			prodAfter[i] = prodAfter[i+1] * nums[i+1];
    		}
    		retArr[i] = prodAfter[i] * prodBefore[i];
    	}
    	return retArr;
    }

}
