package org.msankar.ds;

import java.util.PriorityQueue;

public class Graphs {	
	
	public static void main (String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(24);
		pq.add(13);
		pq.add(5);
		pq.add(9);
		
		pq.contains(24);
		pq.isEmpty();
		pq.offer(39);
		
		pq.peek();
		pq.poll();
		
		pq.remove();
		pq.remove(24);	
		
	}
}
