package org.msankar.ds.practice;

public class ReverseLinkedList {

	public static void main(String[] args) {
		ListNode a = new ListNode(2);
		ListNode b = new ListNode(3);
		ListNode c = new ListNode(4);
		ListNode d = new ListNode(5);
		a.next = b;
		b.next = c;
		c.next = d;

		ListNode n = reverseList(a);
		while (n !=null ) {
			System.out.println(n.val);
			n = n.next;
		}

	}

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        ListNode node = head.next;
        prev.next = null;
        while (node != null) {
        	ListNode next = node.next;
        	node.next = prev;
        	prev = node;
        	node = next;
        }
        return prev;
    }

    public static class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) { val = x; }
    }

}
