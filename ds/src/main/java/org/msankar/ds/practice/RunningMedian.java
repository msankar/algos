package org.msankar.ds.practice;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class RunningMedian {
	public static void main(String[] args) {
        @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        System.out.println(getMedian(a));
	}

	public static double getMedian(int[] arr) {
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException("Cannot find mean of an empty array");
		}
		if (arr.length == 1) {
			return arr[arr.length-1];
		}
	    Queue<Integer> minHeap = new PriorityQueue<>();
		Queue<Integer> maxHeap = new PriorityQueue<>(new DescComparator());
		for (int i = 0; i < arr.length; i++) {
			addElement(arr[i], minHeap, maxHeap);
			balance(minHeap, maxHeap);
		}
		return median(minHeap, maxHeap);
	}

	public static void addElement(int num, Queue<Integer> minHeap, Queue<Integer> maxHeap) {
		if (minHeap.isEmpty() || num < minHeap.peek()) {
			minHeap.add(num);
		} else {
			maxHeap.add(num);
		}
	}

	public static void balance(Queue<Integer> minHeap, Queue<Integer> maxHeap) {
		if(minHeap.isEmpty() && maxHeap.isEmpty()) {
			return;
		}
		while (Math.abs(minHeap.size() - maxHeap.size()) > 1) {
			if (minHeap.size()-maxHeap.size() > 1) {
				maxHeap.add(minHeap.poll());
			} else {
				minHeap.add(maxHeap.poll());
			}
		}
	}

	public static double median(Queue<Integer> minHeap, Queue<Integer> maxHeap) {
		if(minHeap.isEmpty() && maxHeap.isEmpty()) {
			throw new IllegalStateException("Cannot find median of empty array");
		}
		int size = minHeap.size()+maxHeap.size();
		if (size % 2 == 1) {
			if (minHeap.size() > maxHeap.size()) {
				return minHeap.peek();
			} else {
				return maxHeap.peek();
			}
		} else {
			return ((minHeap.peek()+maxHeap.peek())/2d);
		}
	}

	static class DescComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer x, Integer y) {
			return -1 * x.compareTo(y);
		}
	}

}
