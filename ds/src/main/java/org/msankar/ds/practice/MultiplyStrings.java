package org.msankar.ds.practice;

public class MultiplyStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public String multiply(String num1, String num2) {
    	if (num1== null || num2==null){
    		return "";
    	}

    	int carry = 0;
    	StringBuilder build = new StringBuilder();
    	for (int j = num2.length()-1; j>=0; j++) {
    		int mult = num1.charAt(j)-'0';
    		int sum = 0;
    		for (int i = num1.length()-1; i >=0; i++) {
    			sum += (num1.charAt(i)-'0') * mult;
    		}
    	}

    }

}
