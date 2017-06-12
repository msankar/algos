package org.msankar.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class StringArrayDiff {
	public static void main(String[] args) {
		String[] mainStrArray = new String[] {"cat", "dog", "rat", "monkey", "tiger", "lion"};
		String[] subStrArray = new String[] {"lion", "cat", "dog"};
		
		StringArrayDiff sad = new StringArrayDiff();
		sad.diffArrays1(mainStrArray, subStrArray);
		sad.diffArrays2(mainStrArray, subStrArray);
		sad.diffArrays3(mainStrArray, subStrArray);
	}
	
	private void diffArrays1(String[] array1, String[] array2) {
		String[] returnArray = new String[10]; int len = 0;
		for ( int i = 0; i < array1.length; i++ ) {
			for (int j = 0; j < array2.length; j++ ) {
				if (array1[i] == array2[j]) {
					returnArray[len] = array1[i];
					len++;
				}
			}			
		}
		System.out.println(Arrays.toString(returnArray));
	}
	
	private void diffArrays2(String[] array1, String[] array2) {
		
		Collection<String> col1 = new ArrayList<String>(Arrays.asList(array1));
		
		for (int i = 0; i < array2.length; i++ ) {
			if(col1.contains(array2[i])) {
				col1.remove(array2[i]);
			}
		}
		System.out.println(col1);		
	}
	
	private void diffArrays3(String[] array1, String[] array2) {
		Collection<String> col1 = new ArrayList<String>(Arrays.asList(array1));
		
		col1.removeAll(Arrays.asList(array2));
		
		System.out.println(col1);	
	}
}
