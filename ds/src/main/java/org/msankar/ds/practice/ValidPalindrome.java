package org.msankar.ds.practice;

public class ValidPalindrome {

	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		System.out.println(isPalindrome(s));
	}

    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        s = s.toLowerCase();

        int i = 0;
        int j = s.length()-1;
        char start = 'a'; char end ='a';
        while (i < j) {
        	if (!Character.isLetterOrDigit(s.charAt(i))) {
        		i++;
        		continue;
        	}
        	if (!Character.isLetterOrDigit(s.charAt(j))) {
        		j--;
        		continue;
        	}
        	start = s.charAt(i++);
        	end = s.charAt(j--);

        	if (start != end) {
        		return false;
        	}
        }
        return true;
    }

}
