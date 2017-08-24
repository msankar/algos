package org.msankar.ds.practice;

import java.util.Arrays;

public class MergeSortedArrays {
	public static void main(String[] args) {
		  int[] arr1 = new int[]{3, 4, 6, 10, 11, 15, 49, 50, 52, 53};
		  int[] arr2 = new int[]{1, 5, 8, 12, 14, 19, 24, 28};
		  int[] arr3 = merge(arr1, arr2);
		  System.out.println(Arrays.toString(arr3));

	}

	public static int[] merge (int[] arr1, int[] arr2) {
		int[] result = new int[arr1.length+ arr2.length];
		if (arr1.length == 0 && arr2.length == 0) {
			return null;
		}

		int i = 0; int j = 0; int k = 0;
		while (i < arr1.length && j < arr2.length) {
			if(arr1[i] < arr2[j]) {
				result[k++] = arr1[i++];
			} else {
				result[k++] = arr2[j++];
			}
		}

		while (i < arr1.length) {
			result[k++] = arr1[i++];
		}
		while (j < arr2.length) {
			result[k++] = arr2[j++];
		}
		return result;
	}

}
