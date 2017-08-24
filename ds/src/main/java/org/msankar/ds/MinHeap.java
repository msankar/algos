package org.msankar.ds;

import java.util.Arrays;

public class MinHeap {
	private int[] array;
	private int capacity;
	private int size;

	public MinHeap(int cap) {
		this.capacity = cap;
		this.array = new int[capacity];
		this.size = 0;
	}

	public int peek() {
		if (array == null || array.length == 0) {
			throw new IllegalStateException();
		}
		return array[0];
	}

	public int poll() {
		if (array == null || array.length == 0) {
			throw new IllegalStateException();
		}
		int retNum = array[0];
		array[0] = array[array.length-1];
		size--;
		minHeapify();
		return retNum;
	}

	private void minHeapify() {
		int idx = 0;
		int smallerIdx = idx;

		while (idx < size) {
			if (hasLeftChild(idx) && array[idx] > getLeftChild(idx)) {
				smallerIdx = getLeftChildIdx(idx);
			}

			if (hasRightChild(idx) && array[smallerIdx] > getRightChild(idx)) {
				smallerIdx = getRightChildIdx(idx);
			}
			if (array[idx] < array[smallerIdx]) {
				break;
			}
			swap(smallerIdx, idx);
			idx = smallerIdx;
		}

	}

	public void add(int num) {
		ensureCapacity();
		array[size] = num;
		int idx = size;
		size++;
		while (hasParent(idx) && getParent(idx) > array[idx]) {
			swap(getParentIdx(idx), idx);
			idx = getParentIdx(idx);
		}
	}

	private void swap(int idx1, int idx2) {
		int temp = array[idx1];
		array[idx1] = array[idx2];
		array[idx2] = temp;
	}

	private void ensureCapacity() {
		if (size < capacity) {
			return ;
		}
		array = Arrays.copyOf(array, 2*capacity);
		capacity *= 2;
	}

	private boolean hasLeftChild(int idx) {
		return getLeftChildIdx(idx) < array.length;
	}

	private boolean hasRightChild(int idx) {
		return getRightChildIdx(idx) < array.length;
	}

	private boolean hasParent(int idx) {
		return getParentIdx(idx) >=0;
	}

	private int getLeftChild(int idx) {
		return array[getLeftChildIdx(idx)];
	}

	private int getRightChild(int idx) {
		return array[getRightChildIdx(idx)];
	}

	private int getParent(int idx) {
		return array[getParentIdx(idx)];
	}

	private int getParentIdx(int idx) {
		return (idx - 1)/2;
	}

	private int getLeftChildIdx(int idx) {
		return 2*idx + 1;
	}

	private int getRightChildIdx(int idx) {
		return 2*idx + 2;
	}
}
