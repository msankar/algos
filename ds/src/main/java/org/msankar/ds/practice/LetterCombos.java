package org.msankar.ds.practice;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LetterCombos {
	public static void main(String[] args) {
		String input = "234";
		List<String> retList = letterCombinations(input);
		for (String s : retList) {
			System.out.println(s);
		}
	}

    public static List<String> letterCombinations(String input) { // 2 3
    	if (null == input || input.length() == 0) {
    		return Collections.emptyList();
    	}
    	String[] phoneStrings = {"","","abc","def","ghi","jkl","mno","pqrs","tuv", "wxyz"};
    	LinkedList<String> queue = new LinkedList<>();
    	queue.add("");

    	for(int i = 0; i < input.length(); i++) {
    		int num = input.charAt(i) - '0'; //2
    		while (queue.peek()!=null && queue.peek().length() ==i) {
    			String e = queue.remove();
	    		for(char s : phoneStrings[num].toCharArray()) {
	    			queue.add(e + s);
	    		}
    		} //while
    	}
		return queue;
	}

}
