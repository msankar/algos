package org.msankar.ds.practice;

/*
 * Convert a non-negative integer to its english words representation.
 * Given input is guaranteed to be less than 231 - 1.
 * For example
 * 123 -> "One Hundred Twenty Three"
 * 12345 -> "Twelve Thousand Three Hundred Forty Five"
 * 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 */
public class IntegerToEnglishWords {
	private static final int BILLION = 1_000_000_000;
	private static final int MILLION = 1_000_000;
	private static final int THOUSAND = 1_000;
	private static final String [] tensStr = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty",
			"Seventy", "Eighty", "Ninety"
	};
	private static final String[] ones = {"Zero", "One", "Two", "Three", "Four", "Five", "Six",
			"Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen",
			"Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
	};

	public static void main (String[] args) {
		int num1 = 1_050_000_000;
		System.out.println(numberToWords(num1));
	}

    public static String numberToWords(int num) {
        if (num == 0) {
        	return ones[0];
        }
        StringBuilder ret = new StringBuilder();

        if (num / BILLION > 0) {
        	ret.append(helper (num/BILLION)).append(" ").append("Billion");
        	num = num % BILLION;
        }
        if (num / MILLION > 0) {
        	ret.append(helper (num/MILLION)).append(" ").append("Million");
        	num = num % MILLION;
        }
        if (num/THOUSAND > 0) {
        	ret.append(helper (num/THOUSAND)).append(" ").append("Thousand");
        	num = num % THOUSAND;
        }
        ret.append(helper(num));


        return ret.toString().trim();
    }

    private static String helper(int num) {
    	StringBuilder ret = new StringBuilder();
		if (num/100 > 0) {
			ret.append(" ").append(ones[num/100]).append(" ").append("Hundred");
			num = num %100;
		}
		if (num/10 > 1) {
			ret.append(" ").append(tensStr[num/10]);
			num = num%10;
		}
		if (num > 0) {
			ret.append(" ").append(ones[num]);
		}
    	return ret.toString();
    }
}
