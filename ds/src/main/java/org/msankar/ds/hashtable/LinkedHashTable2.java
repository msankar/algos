package org.msankar.ds.hashtable;

public class LinkedHashTable2 {
	int capacity;
	LinkedHashEntry[] table;
	public LinkedHashTable2(int cap) {
		this.capacity = cap;
		table = new LinkedHashEntry[capacity];
	}

	public int get(int key) {
		int hash = getHash(key);
		if (table[hash] == null) {
			return -1;
		}
		LinkedHashEntry entry = table[hash];
		while (entry.getKey() != key) {
			if (entry.getNext() == null) {
				break;
			}
			entry = entry.getNext();
		}
		if (entry.getKey() == key) {
			return entry.getVal();
		}
		return -1;
	}

	public void put (int key, int val) {
		int hash = getHash(key);
		if (table[hash] == null) {
			table[hash] = new LinkedHashEntry(key, val);
			return;
		}
		LinkedHashEntry entry = table[hash];
		while(entry.getKey() != key) {
			if (entry.getNext() == null) {
				break;
			}
			entry = entry.getNext();
		}
		if (entry.getKey() == key) {
			entry.val = val;
		} else {
			entry.setNext(new LinkedHashEntry(key, val));
		}
	}

	public int getHash(int key) {
		int hash = key % capacity;
		return hash;
	}


	class LinkedHashEntry {
		int key;
		int val;
		LinkedHashEntry next;

		public LinkedHashEntry(int k , int v) {
			this.key = k;
			this.val = v;
			this.next = null;
		}

		public int getKey() {
			return key;
		}
		public int getVal() {
			return val;
		}
		public LinkedHashEntry getNext() {
			return next;
		}
		public void setNext(LinkedHashEntry next) {
			this.next = next;
		}
	}
}
