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
		
		pq.peek(); // Retrieve don't remove. Return NULL if queue is empty
		pq.poll(); // REtrieve and remove. Return NULL if queue is empty
		
		pq.remove(); // Retrieve and remove. Throw an exception if queue is empty
		pq.remove(24); 
		
	}
}
