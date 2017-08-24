package org.msankar.ds.hashtable;

public class HashTable2 {
	int capacity;
	HashEntry[] table;

	public HashTable2() {
		this(128);
	}
	// Open addressing.
	public HashTable2(int cap) {
		this.capacity = cap;
		table = new HashEntry[capacity];
	}

	public int get(int key) {
		int hash = getHash(key);
		if (table[hash] == null) {
			return -1;
		}
		return table[hash].getValue();
	}

	public void put (int key, int val) {
		int hash = getHash(key);
		table[hash] = new HashEntry(key, val);
	}

	private int getHash(int key) {
		int hash = key % capacity;
		while (table[hash] != null && table[hash].getKey() != key) {
			hash = (hash+1) % capacity;
		}
		return hash;
	}

	class HashEntry {
		private int key;
		private int val;
		public HashEntry(int key, int val) {
			this.key = key;
			this.val = val;
		}
		public int getKey() {
			return key;
		}
		public int getValue() {
			return val;
		}
	}
}
