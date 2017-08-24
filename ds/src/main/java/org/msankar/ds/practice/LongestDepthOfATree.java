package org.msankar.ds.practice;

import java.util.Stack;

public class LongestDepthOfATree {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(9);
		node.right = new TreeNode(20);
		node.left.left = null;
		node.left.right = null;
		node.right.left = new TreeNode(15);
		node.right.right = new TreeNode(7);
		int x = maxDepth(node);
		System.out.println(x);

		System.out.println(maxDepthRecur(node));
	}

	public static int maxDepthRecur(TreeNode node) {
		if (null == node) {
			return 0;
		}
		int leftDepth = maxDepthRecur(node.left);
		int rightDepth = maxDepthRecur(node.right);
		return 1 + Math.max(leftDepth, rightDepth);
	}

	public static int maxDepth(TreeNode node) {
        if (null == node) {
            return 0;
        }

        Stack<NodeWD> stack = new Stack<>();
        int depth = 1;
        int retDepth = depth;
        stack.push (new NodeWD(node, depth));
        while (!stack.isEmpty()) {
            NodeWD nwd = stack.pop();
            TreeNode nd = nwd.node;
            depth = nwd.depth;
            retDepth = Math.max(retDepth, depth);

            if (nd != null && nd.left != null) {
                stack.push (new NodeWD(nd.left, depth+1));
            }
            if (nd != null && nd.right != null) {
                stack.push(new NodeWD(nd.right, depth+1));
            }
        }
        return retDepth;
    }

    public static class NodeWD {
        TreeNode node;
        int depth;

        public NodeWD(TreeNode node, int depth){
            this.node = node;
            this.depth = depth;
        }

        @Override
		public String toString() {
        	return "Node = "+node.val+" - " + depth;
        }
    }

    public static class TreeNode {
    	int val;
    	TreeNode left;
   	    TreeNode right;
   	    TreeNode(int x) { val = x; }
   	    @Override
		public String toString( ){
   	    	return val + " - " + left.val + " - " + right.val;
   	    }
    }
}
