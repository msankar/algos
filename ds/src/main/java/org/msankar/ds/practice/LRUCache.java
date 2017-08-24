package org.msankar.ds.practice;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	int maxCapacity;
	int currentSize;
	Map<Integer, Node> keyToNodeMap;
	Node lruNode;
	Node mruNode;

    public LRUCache(int capacity) {
    	this.maxCapacity = capacity;
    	this.currentSize = 0;
    	keyToNodeMap = new HashMap<>();
    	lruNode = new Node(0, 0, null, null);
    	mruNode = lruNode;
    }

    public int get(int key) {
		if (!keyToNodeMap.containsKey(key)) {
			return -1;
		}

		Node node = keyToNodeMap.get(key);
		// Now this is the MRU. If it is already MRU node, nothing to do.
		if (node == mruNode) {
			return node.value;
		}
		if (node == lruNode) {
			// It is no longer LRU node.
			lruNode = lruNode.next;
			lruNode.previous = null;
		} else {
			// It is stuck somewhere in the middle.
			Node prevNode = node.previous;
			Node nextNode = node.next;

			// Previous node will now point to node's next.
			prevNode.next = nextNode;
			nextNode.previous = prevNode;
		}
		// It is now MRU node.
		mruNode.next = node;
		node.previous = mruNode;
		mruNode = node;
		return node.value;
    }

    // LRU -> LRU+1 -> ...MRU-1 ->MRU
    public void put(int key, int value) {
    	// 1. Nothing to do if map has key already.
    	if (keyToNodeMap.containsKey(key)) {
    		return;
    	}
    	// 2. Create a new node and this is the most recently used.
    	Node node = new Node(key, value, mruNode, null);
    	mruNode.next = node;
    	mruNode = node;
    	keyToNodeMap.put(key, node);

    	if (currentSize < maxCapacity) {
    		if (currentSize == 0) {
    			lruNode = node;
    		}
    		currentSize ++;
    	} else if (currentSize >= maxCapacity) {
    		int lruKey = lruNode.key;
    		keyToNodeMap.remove(lruKey);
    		lruNode = lruNode.next;
    		lruNode.previous = null;
    	}
    }

    class Node {
    	int key;
    	int value;
    	Node previous;
    	Node next;

    	public Node(int key, int value) {
    		this.key = key;
    		this.value = value;
    	}

    	public Node(int key, int value, Node prev, Node next) {
    		this.key = key;
    		this.value = value;
    		this.previous = prev;
    		this.next = next;
    	}
    }
}
