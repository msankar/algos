package org.msankar.ds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ReverseListTest {
	private ListNode l1, l2, l3;

	@Before
	public void setup() {
		l3 = new ListNode(3, null);
		l2 = new ListNode(2, l3);
		l1 = new ListNode(1, l2);
	}

	@Test
	public void test() {
		assertNotNull(l1.getNext());
		assertNull(l3.getNext());
		assertTrue(l1.getNext().equals(l2));
		assertTrue(l2.getNext().equals(l3));
		assertEquals(
				"ListNode [data=1, next=ListNode [data=2, next=ListNode [data=3, next=null]]]",
				l1.toString());

		ListNode revList = ListNode.reverse(l1);
		assertNull(l1.getNext());
		assertNotNull(l3.getNext());
		assertTrue(l3.getNext().equals(l2));
		assertTrue(l2.getNext().equals(l1));
		assertEquals(
				"ListNode [data=3, next=ListNode [data=2, next=ListNode [data=1, next=null]]]",
				revList.toString());
	}
}