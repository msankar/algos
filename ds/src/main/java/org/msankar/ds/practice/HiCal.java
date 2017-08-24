package org.msankar.ds.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Your company built an in-house calendar tool called HiCal.
 * You want to add a feature to see the times in a day when everyone is available.
 * To do this, you’ll need to know when any team is having a meeting.
 * In HiCal, a meeting is stored as an object of a Meeting class with integer
 * variables startTime and endTime. These integers represent the number of 30-minute blocks
 * past 9:00am.
 */
public class HiCal {
	public static void main (String[] args){
		//[Meeting(0, 1), Meeting(3, 5), Meeting(4, 8), Meeting(10, 12), Meeting(9, 10)]
		// Return   [Meeting(0, 1), Meeting(3, 8), Meeting(9, 12)]
		List<Meeting> meetingList = Arrays.asList(new Meeting(0,1), new Meeting(3,5),
				new Meeting(4,8), new Meeting(10,12), new Meeting(9,10));
		List<Meeting> mergedMeetings = mergeRanges(meetingList);
		for (Meeting mtg : mergedMeetings) {
			System.out.println(String.format("Meeting: %d - %d ", mtg.getStartTime(), mtg.getEndTime()));
		}
	}

	public static List<Meeting> mergeRanges(List<Meeting> mtgList) {
		// Sort meetings by start time  O(nlgn)
		List<Meeting> sortedMtgs = sort(mtgList);

		// Start merging the meetings.  Worst case O(n) space cost.
		List<Meeting> mergedMtgs = new ArrayList<>(sortedMtgs.size());
		mergedMtgs.add(sortedMtgs.get(0));

		for (Meeting currentMtg : sortedMtgs) {
			Meeting previousMergedMtg = mergedMtgs.get(mergedMtgs.size()-1);
			if (currentMtg.getStartTime() <= previousMergedMtg.getEndTime()) {
				previousMergedMtg.setEndTime(Math.max(currentMtg.getEndTime(), previousMergedMtg.getEndTime()));
			} else {
				mergedMtgs.add(currentMtg);
			}
		}
		return mergedMtgs;

	}

	private static List<Meeting> sort(List<Meeting> mtgList) {
	    List<Meeting> sortedMtgs = new ArrayList<Meeting>(mtgList);
	    Collections.sort(sortedMtgs, new Comparator<Meeting>() {
	        @Override
	        public int compare(Meeting m1, Meeting m2)  {
	            return m1.getStartTime() - m2.getStartTime();
	        }
	    });
	    return sortedMtgs;
	}
}
