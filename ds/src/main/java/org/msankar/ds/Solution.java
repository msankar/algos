package org.msankar.ds;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
	    public static void main(String args[] ) throws Exception {
	        Solution s = new Solution();
	        String line;
	        String[] arr = null;
	        try(BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
	            while (br.readLine() != null) {
	            	line = br.readLine();
	            	
	            	arr = line.split(" ");
	            }
	            
	        
			System.out.println(  s.findMissingNumber(arr));
	        } catch (IOException e) {
	        	System.out.println(e.getStackTrace());
	        }
	            
	    }
	    
	    public int findMissingNumber (String[] arr) {
	    	int[] intarr = new int[arr.length];
	    	for (int i = 0; i < arr.length; i++) {
	    		intarr[i] = Integer.parseInt(arr[i]);
	    	}
	    	return findMissingNumber(intarr);
	    }
	    
	    public int findMissingNumber(int[] arr) {
	        int diff = arr[1] - arr[0];
	        int next;
	        for (int i = 0; i < arr.length; i++) {
	            next = arr[i] + diff;
	            if (arr[i+1] - arr[i] != next) {
	                return next;
	            }
	        }
	        return -1;
	    }
	        
	}
