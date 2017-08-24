package org.msankar.ds.practice;

import java.util.Arrays;

public class DivisionWithoutDivOrMod {

	public static void main(String[] args) {
		int [] nums = {0,1,0,3,12};
		//System.out.println(divide(15,3));
		moveZeroes(nums);
	}

    public static int divide(int dividend, int divisor) {
		if(dividend==Integer.MIN_VALUE && divisor==-1) {
            return Integer.MAX_VALUE;
        }
		boolean isNeg = false;
		if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
			isNeg = true;
		}

		int shift = 0,  quotient = 0;
		int remainder = dividend;

		while(remainder > 0) {
			remainder = dividend - (divisor << shift);
			shift++;
		}

		if (remainder < 0) {
			shift = shift -1;
		    quotient = (shift);
		    remainder = dividend - (divisor << shift);
			if (remainder >= divisor) {
				quotient ++;
			}
		}
		return isNeg ? -quotient : quotient;
    }

    public static void moveZeroes(int[] nums) {
        if (nums.length > 0) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i+1; j < nums.length; j++) {
                    if (nums[i] == 0 && nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

}
