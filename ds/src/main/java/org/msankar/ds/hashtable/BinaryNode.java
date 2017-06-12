package org.msankar.ds.hashtable;

public class BinaryNode {

	private int data;
	private BinaryNode left;
	private BinaryNode right;
	private BinaryNode parent;
	
	public BinaryNode(int d, BinaryNode left, BinaryNode right, BinaryNode parent) {
		this.data = d;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BinaryNode getLeft() {
		return left;
	}

	public void setLeft(BinaryNode left) {
		this.left = left;
	}

	public BinaryNode getRight() {
		return right;
	}

	public void setRight(BinaryNode right) {
		this.right = right;
	}

	public BinaryNode getParent() {
		return parent;
	}

	public void setParent(BinaryNode parent) {
		this.parent = parent;
	}	
}
