package org.msankar.ds;

import org.msankar.ds.hashtable.Node;

/**
 * Smallest number from a circular list.
 * 
 * @author malathi.sankar
 */
public class MinNumInCircularList {

	public static int findMinimum(Node start) {
		int min = 0;
		if (start != null) {
			min = (int) start.getData();
			Node next = start.getNext();
			while (next != null && next != start) {
				if (next.getData() < min) {
					min = next.getData();
				}
				next = next.getNext();
			}
		}
		return min;
	}
	
	public static boolean cyclicalList1(Node root) {
		boolean isCyclical = false;
		Node next = root.getNext();
		Node nextNext = root.getNext().getNext();
		
		while (next != null && nextNext != null) {
			if (next == nextNext) {
				isCyclical = true;
				break;
			}
			next = next.getNext();
			nextNext = nextNext.getNext().getNext();
		}
		
		System.out.println(isCyclical);
		return isCyclical;
	}

	public static boolean cyclicalList(Node start) {
		boolean isCyclical = false;
		Node next;
		if (start != null) {
			next = start.getNext();
			while (next != null) {
				if (next == start) {
					isCyclical = true;
					break;
				}
				next = next.getNext();
			}
		}
		return isCyclical;
	}

}
