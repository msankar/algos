package org.msankar.ds.practice;

public class HappyNum {
	public static void main (String[] args) {
		System.out.println(isHapppy(18));
	}

	public static boolean isHappy(int n) {
		int count = 0;
		while (n > 1 && count < 1000) {
			count++;
			n = sumSquare(n);
			if (n == 1) {
				return true;
			}
		}
		return false;
    }

    public static int sumSquare (int n) {
        String s = String.valueOf(n);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
        	int digit = s.charAt(i) - '0';
        	sum += digit * digit;
        }
        return sum;
    }

    public static int digitSquareSum(int n) {
        int sum = 0, tmp;
        while (n > 0) {
            tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return sum;
    }

    public static boolean isHapppy(int n) {
        int slow, fast;
        slow = fast = n;
        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);
        } while(slow != fast);
        return (slow == 1);
    }
}


