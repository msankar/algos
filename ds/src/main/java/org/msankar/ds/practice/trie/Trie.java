package org.msankar.ds.practice.trie;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	TrieNode root;
	private static final char EOW = '\0';
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
    	TrieNode currNode = root;
        for (char c : word.toCharArray()) {
        	if (!currNode.hasChildNode(c)) {
        		currNode.addChildNode(c);
        	}
        	currNode = currNode.getChildNode(c);
        }
        if (currNode.hasChildNode(EOW)) {
        	currNode.addChildNode(EOW);
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	TrieNode currNode = root;
        for (char c : word.toCharArray()) {
        	if (!currNode.hasChildNode(c)) {
        		return false;
        	}
        	currNode = currNode.getChildNode(c);
        }
        return (currNode.hasChildNode(EOW));
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	TrieNode currNode = root;
    	for (char c : prefix.toCharArray()) {
    		if (!currNode.hasChildNode(c)) {
        		return false;
        	}
        	currNode = currNode.getChildNode(c);
    	}
    	return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

class TrieNode {
	private Map<Character, TrieNode> children;
	public TrieNode() {
		this.children = new HashMap<>();
	}
	public boolean hasChildNode(char c) {
		return children.containsKey(c);
	}
	public void addChildNode(char c) {
		children.put(c, new TrieNode());
	}
	public TrieNode getChildNode(char c) {
		return children.get(c);
	}
}
