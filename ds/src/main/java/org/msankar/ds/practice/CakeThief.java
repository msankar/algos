package org.msankar.ds.practice;

public class CakeThief {
	public static void main (String[] args) {
		CakeType[] cakeTypes = new CakeType[] {
				    new CakeType(7, 160),
				    new CakeType(3, 90),
				    new CakeType(2, 15),
		};

		int capacity = 20;

		maxDuffelBagValue(cakeTypes, capacity);
	}

	private static long maxDuffelBagValue(CakeType[] cakeTypes, int bagCapacity) {
		long[] maxVal = new long[bagCapacity+1];
		long maxValueAtCurrCapacity = 0L;

		for (int currCap = 0; currCap < bagCapacity; currCap++) {
			maxValueAtCurrCapacity = 0l;
			for (CakeType cake : cakeTypes) {
				if  (cake.weight <= currCap) {
					 long currValue = cake.value + maxVal[currCap-cake.weight];
					 maxValueAtCurrCapacity = Math.max(currValue, maxValueAtCurrCapacity);
				}
			}
			maxVal[currCap] = maxValueAtCurrCapacity;
		}

		return maxVal[bagCapacity];
	}

	public static long maxDuffelBagValueWithCapacity1(CakeType[] cakeTypes, int cap) {
		long maxValueAtCapacity1 = 0L;
	    for (CakeType cakeType : cakeTypes) {
	        if (cakeType.weight <= cap) {
	            maxValueAtCapacity1 = Math.max(maxValueAtCapacity1, cakeType.value);
	        }
	    }
	    return maxValueAtCapacity1;
	}

	static class CakeType {
		int weight;
		int value;
		public CakeType(int weight, int value) {
		    this.weight = weight;
		    this.value  = value;
		}
	}
}
