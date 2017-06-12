package org.msankar.ds;

public class ArrayCompaction {
	
	public static int[] compactArray(int[] array) {
		sortArray(array);

		int length = array.length;
		int len = 1;
		int[] resultArray = new int[length];
		
		resultArray[0] = array[0];
		
		for (int i = 1; i < length; i++) {
			if (resultArray[len-1] != array[i]) {
				resultArray[len] = array[i];
				len++;
			}			
		}

		return resultArray;
	}
	
	private static void sortArray(int[] array) {
		int len = array.length; int temp = 0;
		for (int i = 0; i < len; i++) {
			for (int j = i+1; j < len; j++) {
				if(array[i] > array[j]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}			
		}		
	}

}
