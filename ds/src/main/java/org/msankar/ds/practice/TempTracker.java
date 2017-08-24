package org.msankar.ds.practice;

/**
 * Write a class TempTracker with these methods:
 * insert()—records a new temperature
 * getMax()—returns the highest temp we've seen so far
 * getMin()—returns the lowest temp we've seen so far
 * getMean()—returns the mean of all temps we've seen so far
 * getMode()—returns a mode of all temps we've seen so far
 * @author malathi.sankar
 *
 */
public class TempTracker {
	private int max = Integer.MAX_VALUE;
	private int min = Integer.MIN_VALUE;
	private int[] occurrences = new int[120];

	private int totalNumTemp = 0;
	private int sumOfAllTemp = 0;

	private int maxOccurence = 0;
	private int mode;

	public void insert(int temp) {
		max = Math.max(max, temp);
		min = Math.min(min, temp);

		totalNumTemp++;
		sumOfAllTemp += temp;

		occurrences[temp] ++;
		if (maxOccurence < occurrences[temp]) {
			maxOccurence = occurrences[temp];
			mode = temp;
		}
	}

	public double getMean() {
		if (sumOfAllTemp <= 0) {
			return 0d;
		}
		return totalNumTemp*1d/sumOfAllTemp;
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}

	public int getMode() {
		return mode;
	}
}
