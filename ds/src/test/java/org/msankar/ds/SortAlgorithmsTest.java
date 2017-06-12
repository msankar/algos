package org.msankar.ds;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class SortAlgorithmsTest {
	private final String[] strArray = new String[] {"elephant",
			"mouse", "cat", "giraffe", "zebra", "leopard"};
	
	private final int[] intArray = new int[] {1,5,4,26,6,8,3,7,2};
	
	@Test
	public void stringArraySortTest() {
		SortAlgorithms.sortByLen(strArray);
	}
	
	@Test
	public void quickSortTest() {		
		int[] arr = SortAlgorithms.quickSort(intArray, 0, 8);
		System.out.println(Arrays.toString(arr));
		assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 26]", Arrays.toString(arr));
	}
	
	@Test
	public void insertSorTest() {		
		int[] arr = SortAlgorithms.insertSort(intArray);
		System.out.println(Arrays.toString(arr));
		assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 26]", Arrays.toString(arr));
	}
	
	@Test
	public void mergeSort() {
		int[] arr = SortAlgorithms.mergeSort(intArray);
		System.out.println(Arrays.toString(arr));
		assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 26]", Arrays.toString(arr));
	}
	
	@Test
	public void countingSort() {
		int[] arr = new int[] {1,5,4,3,3,5,1,1,6,8,3,7,2};
		SortAlgorithms.countingSort(arr);
	}
}