package org.msankar.ds.practice;

public class TotalHammingDist {

	public static void main(String[] args) {
		int[] nums = {4, 14, 2};
		int dist = totalHammingDist(nums);
		System.out.println(dist);

	}

	public static int totalHammingDist(int[] nums) {
		int total = 0;
		int bitCount = 0;
		for (int j= 0; j < 32; j++) {
			bitCount = 0;
			for (int num : nums) {
				bitCount += (num >> j) & 1;
			}
			total = total + (bitCount * (nums.length-bitCount));
		}
		return total;
	}

}
