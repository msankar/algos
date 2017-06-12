package org.msankar.ds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.msankar.ds.hashtable.Node;

public class MinNumInCircularListTest {
	Node n0;
	
	@Before
	public void init() {
		Node n3 = new Node(15, null);
		Node n2 = new Node(2, n3);
		Node n1 = new Node(-4, n2);
		n0 = new Node(4, n1);
		n3.setNext(n0);
	}
	
	@Test
	public void test() {
		assertEquals(-4, MinNumInCircularList.findMinimum(n0));		
		assertTrue(MinNumInCircularList.cyclicalList(n0));
		assertTrue(MinNumInCircularList.cyclicalList1(n0));
	}
}
