package org.msankar.ds;

import java.util.Arrays;

public class SortAlgorithms {

	public static void sortByLen(String[] inputArray) {
		System.out.println(Arrays.toString(bubbleSort(inputArray)));
	}

	// O(n^2)
	private static String[] bubbleSort(String[] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			for (int j = i + 1; j < inputArray.length; j++) {
				if (inputArray[i].length() > inputArray[j].length()) {
					String temp = inputArray[i];
					inputArray[i] = inputArray[j];
					inputArray[j] = temp;
				}
			}
		}
		return inputArray;
	}
	
	//O(n^2)
	public static int[] insertSort(int[] inArray) {
		for (int i = 1; i < inArray.length; i++) {
			int key = inArray[i];
			for (int j = i-1; j >= 0; j--) {
				if (key < inArray[j]) {
					inArray[j+1] = inArray[j];
					inArray[j] = key;
				} else {
					break;
				}
			}
		}
		return inArray;
	}
	
	//Rearrange in ascending order using the natural order.
	public static int[] mergeSort(int[] a) {
		mergeSort(a, 0, a.length-1);
		return a;
	}
	
	private static void mergeSort(int[] array, int lo, int hi) {
		if (lo < hi) {
			int mid = lo + (hi-lo)/2;
			mergeSort(array, lo, mid);
			mergeSort(array, mid+1, hi);
			merge(array, lo, mid, hi);
		}
	}
	
	private static void merge(int[] array, int lo, int mid, int hi) {
		int[] temp = new int[hi-lo+1];
		int left = lo, right = mid+1, k=0;
		
		while ( left <= mid && right <= hi){
			if(array[left] < array[right]) {
				temp[k++] = array[left++];
			} else {
				temp[k++] = array[right++];
			}
		}
		
		//Supposing left side is bigger than right side copy over remaining elements.
		if (left <= mid) {
			while (left <= mid) {
				temp[k++] = array[left++];
			}
		} else {
			while (right <= hi) {
				temp[k++] = array[right++];
			}
		}
		
		for (int m = 0; m < temp.length; m++) {
			array[lo+m] = temp[m];
		}
	}

	// O(n log n)
	public static int[] quickSort(int[] arr, int left, int right) {
		int index = partition(arr, left, right);

		if (left < index - 1) {
			quickSort(arr, left, index - 1);
		}
		if (index < right) {
			quickSort(arr, index, right);
		}
		return arr;
	}

	private static int partition(int[] arr, int left, int right) {
		int pivot = arr[(left + right) / 2];

		while (left <= right) {
			while (arr[left] < pivot)
				left++;

			while (arr[right] > pivot)
				right--;

			if (left <= right) {
				int tmp = arr[left];
				arr[left] = arr[right];
				arr[right] = tmp;
				left++;
				right--;
			}
		}
		return left;
	}
	
	public static void countingSort(int[] inArr) {
		
		int[] output = new int[inArr.length];
		
		for ( int i = 0; i < inArr.length; i++) {
			output[inArr[i]] ++;
		}
		
		for (int j = 0; j < output.length; j++) {
			for (int k=0; k<output[j]; k++) {
				System.out.print(j + "  ");
			}
		}
	}
}
