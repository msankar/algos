package org.msankar.ds.practice;

public class AddBinary {

	public static void main(String[] args) {
		String a = "11010";
		String b = "1011";
		System.out.println(addBinary(a,b));

	}

    public static String addBinary(String a, String b) {
        if (null == a || a.length() == 0) { return "";}
        if (null == b || b.length() == 0) { return "";}
        StringBuilder retStrBuff = new StringBuilder();

        int sum = 0, carry = 0, x1 = 0, x2 = 0;
        for (int i = a.length()-1, j= b.length()-1; i>=0 || j>=0; i--, j--) {
        	if (i >= 0) {
        		x1 = Character.getNumericValue(a.charAt(i));
        	} else {
        		x1 = 0;
        	}
        	if (j >= 0) {
        		x2 = Character.getNumericValue(b.charAt(j));
        	} else {
        		x2 = 0;
        	}

        	sum = x1 + x2 + carry;
        	int reminder = sum % 2 ;
        	carry = sum/2;

        	retStrBuff.append(reminder);
        }
        if (carry > 0) {
        	retStrBuff.append(carry);
        }
        return retStrBuff.reverse().toString();
     }

}
