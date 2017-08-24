package org.msankar.ds;

public class PeakFinder {
	public static void main(String[] args) {
		PeakFinder pf = new PeakFinder();
		int[] arr = new int[] {4,2,1,5,7,9,2,6,3};
		System.out.println(pf.findPeak(arr));
	}

	public int findPeak(int[] arr) {
		if (arr == null || arr.length < 1) {
			return 0;
		}
		
		int lo = 0;
		int hi = arr.length - 1;
		
		return peakfinder (arr, lo, hi);		
	}

	// Binary Search O(log n)
	// Two dimensional O(nlogm)
    public int peakfinder (int[] arr, int lo, int hi) {
    	int mid = lo + ((hi-lo)/2);
    	
    	if (arr.length == 1) {
			return arr[0];
		}
    	
    	if (arr[mid] >= arr[mid-1] && arr[mid] >= arr[mid+1]) {
			return arr[mid];
		}  
    	if (arr[mid] < arr[mid-1]) {
			//go left
			return peakfinder(arr, lo, mid-1);
		} else {
			//go right
			return peakfinder(arr, mid+1, hi);
		}
    }

}
