package org.msankar.ds.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {
		//Given a collection of intervals, merge all overlapping intervals.
		//Given [1,3],[2,6],[8,10],[15,18],
		//return [1,6],[8,10],[15,18].
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1,4));
		intervals.add(new Interval(0,2));
		intervals.add(new Interval(8,10));
		intervals.add(new Interval(15,18));
		List<Interval> mergedList = merge(intervals);
		//assertTrue(mergedList != null);
		for (Interval interval : mergedList) {
			System.out.println(interval);
		}

	}
	public static List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return Collections.emptyList();
        }

        Collections.sort(intervals, new IntervalComparator());

		List<Interval> mergedList = new ArrayList<>();
		mergedList.add(intervals.get(0));
		for (Interval currInterval : intervals) {
			Interval mergedInterval = mergedList.get(mergedList.size()-1);
			if (mergedInterval != null) {
				if (mergedInterval.end >= currInterval.start && mergedInterval.start <= currInterval.start) {
					mergedInterval.end = Math.max(currInterval.end, mergedInterval.end);
					mergedInterval.start = Math.min(mergedInterval.start, currInterval.start);
				} else {
					mergedList.add(currInterval);
				}
			}
		}
		return mergedList;
	}

	static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return start + " - " + end;
		}
	}

	public static class IntervalComparator implements Comparator<Interval> {

	    @Override
	    public int compare(Interval o1, Interval o2) {
	        Integer result = 0;
	        if(o1 == null) {
	            if(o2 == null) {
	                result = 0;
	            } else {
	                result = 1;
	            }
	        } else {
	            if(o2 == null) {
	                result = -1;
	            } else {
	            	if (o1.start < o2.start) {
	            		result = -1;
	            	} else if (o1.start > o2.start) {
	            		result = 1;
	            	}
	            }
	        }
	        return result;
	    }

	}

}
