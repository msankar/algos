package org.msankar.ds.practice;

import java.util.Arrays;

public class MinHeap2 {
	private int capacity;
	private int size;
	private int[] arr;

	public MinHeap2(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.arr = new int[capacity];
	}

	public int peek() {
		if (arr == null || arr.length == 0) {
			throw new IllegalStateException("array is empty");
		}
		return arr[0];
	}

	public int poll() {
		if (arr == null || arr.length == 0) {
			throw new IllegalStateException("array is empty");
		}
		int retNum = arr[0];
		arr[0] = arr[size - 1];
		size = size-1;
		minHeapify();
		return retNum;
	}

	private void minHeapify() {
		int idx = 0;
		int smallerIdx = 0;

		while (idx < size) {
			if (hasLeft(idx) && getLeft(idx) < arr[idx]) {
				smallerIdx = getLeftIdx(idx);
			}
			if (hasRight(idx) && getRight(idx) < arr[smallerIdx]) {
				smallerIdx = getRightIdx(idx);
			}
			if (arr[idx] == arr[smallerIdx]) {
				break;
			}
			swap(idx, smallerIdx);
			idx = smallerIdx;
		}
	}

	public void add(int num) {
		ensureCapacity();
		arr[size] = num;
		size ++;
		heapifyUp();
	}

	private void heapifyUp() {
		int idx = size -1;
		while (hasParent(idx) && getParent(idx) > arr[idx]) {
			swap(getParentIdx(idx), idx);
			idx = getParentIdx(idx);
		}
	}

	private void ensureCapacity() {
		if (size < capacity) {
			return;
		}
		capacity = 2*capacity;
		arr = Arrays.copyOf(arr, capacity);
	}

	private void swap(int idx1, int idx2) {
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
	}

	private int getLeft(int idx) {
		return arr[getLeftIdx(idx)];
	}
	private int getRight(int idx) {
		return arr[getRightIdx(idx)];
	}
	private int getParent(int idx) {
		return arr[getParent(idx)];
	}
	private boolean hasLeft(int idx) {
		return getLeftIdx(idx) <= size-1;
	}
	private boolean hasRight(int idx) {
		return getRightIdx(idx) <= size-1;
	}
	private boolean hasParent(int idx) {
		return getParentIdx(idx) >= 0;
	}
	private int getLeftIdx(int idx) {
		return 2*idx + 1;
	}
	private int getRightIdx(int idx) {
		return 2*idx + 2;
	}
	private int getParentIdx(int idx) {
		return (idx-1)/2;
	}
}
