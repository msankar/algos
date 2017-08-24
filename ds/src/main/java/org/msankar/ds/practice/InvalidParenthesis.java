package org.msankar.ds.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * Remove the minimum number of invalid parentheses in order to make the
 * input string valid. Return all possible results.
 * Note: The input string may contain letters other than the parentheses ( and ).
 * Examples:
 * "()())()" -> ["()()()", "(())()"]
 * "(a)())()" -> ["(a)()()", "(a())()"]
 * ")(" -> [""]
 */
public class InvalidParenthesis {
	public static void main(String[] args) {
		//String inputStr = "()())()
		String inputStr = "(a)())()";
		List<String> retList = removeInvalidParentheses(inputStr);
		for (String ss : retList) {
			System.out.println(ss);
		}
	}

    public static List<String> removeInvalidParentheses(String s) {
        if (s==null || s.length() == 0){
        	return Collections.emptyList();
        }
        List<String> retList = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        boolean found = false;

        queue.add(s);
        visited.add(s);

        while (!queue.isEmpty()) {
        	s = queue.poll();
        	if (isValidStr(s)) {
        		found = true;
        		retList.add(s);
        	}

        	if(found) {
        		continue;
        	}

        	for (int i = 0; i < s.length(); i++) {
        		if (s.charAt(i) != '(' && s.charAt(i) != ')') {
        			continue;
        		}

        		String sub = s.substring(0, i) + s.substring(i + 1);
        		if (!visited.contains(sub)) {
        			queue.add(sub);
        			visited.add(sub);
        		}
        	}
        }
        return retList;
    }

    private static boolean isValidStr(String s) {
    	int count = 0;
    	for (int i = 0; i < s.length(); i++) {
    		char currChar = s.charAt(i);
    		if (currChar == '(') {
    			count++;
    		} else if (currChar == ')') {
    			count --;
    			if (count < 0) {
    				return false;
    			}
    		}
    	}
    	return count == 0;
    }
}
