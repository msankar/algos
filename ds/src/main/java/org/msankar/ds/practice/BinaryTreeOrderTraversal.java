package org.msankar.ds.practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class BinaryTreeOrderTraversal {

	/**
	 * Given a binary tree, return the level order traversal of its nodes' values.
	 * (ie, from left to right, level by level).
	 * For example:
	 * 		Given binary tree [3,9,20,null,null,15,7]
	*/
	public static void main(String[] args) {
		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(9);
		node.right = new TreeNode(20);
		node.right.left = new TreeNode(15);
		node.right.right = new TreeNode(7);
		levelOrderDFS(node);
	}

    public static Collection<List<Integer>> levelOrderDFS(TreeNode node) {
    	if (null == node) {
    		return Collections.emptyList();
    	}
    	Map<Integer, List<Integer>> depth2Vals = new HashMap<>();
    	Stack<NWD> stack = new Stack<>();
    	int depth = 0;
    	stack.push (new NWD(node, depth));

    	while(!stack.isEmpty()) {
    		NWD nwd = stack.pop();
    		node = nwd.node;
    		depth = nwd.depth;
    		if (!depth2Vals.containsKey(depth)) {
    			depth2Vals.put(depth, new ArrayList<Integer>());
    		}
    		depth2Vals.get(depth).add(node.val);

    		if (node.left != null) {
    			stack.push(new NWD(node.left, depth+1));
    		}
    		if (node.right != null) {
    			stack.push(new NWD(node.right, depth+1));
    		}

    	}
    	return  depth2Vals.values();
    }

    public static class NWD {
    	TreeNode node;
    	int depth;
    	NWD(TreeNode node, int depth) {
    		this.node = node;
    		this.depth = depth;
    	}
    }

	 public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
}
