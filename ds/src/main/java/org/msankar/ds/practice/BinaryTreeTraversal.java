package org.msankar.ds.practice;

import java.util.Stack;

public class BinaryTreeTraversal {

	public static void main(String[] args) {
		Node node = new Node(8);
		node.left = new Node(4);
		node.right = new Node(12);
		node.left.left = new Node(2);
		node.left.right = new Node(6);
		node.right.left = new Node(10);
		node.right.right = new Node(14);
		System.out.println("IN ORDER RECUR");
		inOrderTraversalRecur(node);
		System.out.println("\nIN ORDER DFS");
		inOrderTraversalDFS(node);
		System.out.println("\n\nPRE ORDER RECUR");
		preOrderTraversalRecur(node);
		System.out.println("\nPRE ORDER DFS");
		preOrderTraversalDFS(node);
		System.out.println("\n\nPOST ORDER RECUR");
		postOrderTraversalRecur(node);
		System.out.println("\nPOST ORDER DFS");
		postOrderTraversalDFS(node);
	}

	static void inOrderTraversalRecur(Node node) {
		if (node == null) {
			return;
		}
		inOrderTraversalRecur(node.left);
		System.out.print(" " + node.val + " ");
		inOrderTraversalRecur(node.right);
	}

	static void inOrderTraversalDFS(Node node) {
		if (null == node) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		while (!stack.isEmpty() || node != null) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			node = stack.pop();
			System.out.print(" " + node.val + " ");
			node = node.right;
		}
	}

	static void preOrderTraversalRecur(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(" " + node.val + " ");
		preOrderTraversalRecur(node.left);
		preOrderTraversalRecur(node.right);
	}

	static void preOrderTraversalDFS(Node node) {
		if (node == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		stack.push(node);
		while(!stack.isEmpty()) {
			node = stack.pop();
			System.out.print(" " + node.val + " ");
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
	}

	static void postOrderTraversalRecur(Node node) {
		if (node == null) {
			return;
		}
		postOrderTraversalRecur(node.left);
		postOrderTraversalRecur(node.right);
		System.out.print(" " + node.val + " ");
	}

	static void postOrderTraversalDFS(Node node) {
		if (node == null) {
			return;
		}
		Stack<Node> stack = new Stack<>();
		while(!stack.isEmpty() || node != null) {
			while (node != null) {
				stack.push(node);
				node = node.right;
			}
			if (node.left != null) {
				stack.push(node.left);
			}
			System.out.print(" " + node.val + " ");
		}
	}

	static class Node {
		int val;
		Node right;
		Node left;

		Node(int val) {
			this(val, null, null);
		}

		Node(int val, Node left, Node right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

}
