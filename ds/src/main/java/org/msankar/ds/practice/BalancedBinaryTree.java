package org.msankar.ds.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BalancedBinaryTree {
	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.left = null;//new TreeNode(9);
		node.right = new TreeNode(2);
		node.right.left = null;//new TreeNode(15);
		node.right.right = new TreeNode(7);
		System.out.println(isBalanced(node));
	}

    public static boolean isBalanced(TreeNode node) {
    	if (node == null){
    		return true;
    	}

        int depth = 0;
    	Stack<NodeWDepth> stack = new Stack<>();
    	stack.push(new NodeWDepth(node, depth));
        List<Integer> depthSet = new ArrayList<>(3);

    	while (!stack.empty()){
    		NodeWDepth nwd = stack.pop();
    		node = nwd.node;
    		depth = nwd.depth;
            if (node.left == null && node.right == null) {
            	if (!depthSet.contains(depth)) {
	                depthSet.add(depth);

	                if (depthSet.size() > 2) {
	                    return false;
	                }
	                if (depthSet.size() == 2 && Math.abs(depthSet.get(0)-depthSet.get(1)) > 1) {
	                    return false;
	                }
            	}
            } else {
                if (node.left != null) {
                    stack.push(new NodeWDepth(node.left, depth+1));
                }
                if (node.right != null) {
                    stack.push(new NodeWDepth(node.right, depth+1) );
                }
            }
    	}

        return true;
    }

    public static class NodeWDepth {
    	TreeNode node;
    	int depth;
    	NodeWDepth(TreeNode node, int depth) {
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
