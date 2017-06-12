package org.msankar.ds;

import java.util.Arrays;

public class Heap {
	
	public static void main (String[] args) {
		int[] arr = new int[] {8,6,2,5,3,9,1};
		System.out.println(Arrays.toString(arr));
		int[] s = build_max_heap(arr);
		System.out.println(Arrays.toString(s));
	}
	
	public static int[] build_max_heap(int[] a) {
		int n = a.length;
		
		for (int i=n/2; i>=0; i--) {
			max_heapify(a, i);
		}
		return a;
	}

	public static void max_heapify(int[] a, int i) {
		int left = getLeft(i, a.length); //2*i
		int right = getRight(i, a.length); //2*i + 1
		int largest = i;
		
		if (left <= a.length && a[left] > a[i]) {
			largest = left;
		}
		if (right <= a.length && a[right] > a[largest]) {
			largest = right;
		}
		if (largest != i) {
			int temp = a[i];
			a[i] = a[largest];
			a[largest] = temp;
			max_heapify(a, largest);
		}

	}
	
	private static int getLeft (int index, int size) {
		int left = index * 2;
		return left == size ? left-1 : left;
	}
	
	private static int getRight (int index, int size) {
		int right = (index*2) + 1;
		return right == size ? right-1 : right;
	}
}
