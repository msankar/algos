package org.msankar.ds.practice;

import java.util.Stack;

public class ValidBinarySearchTree {
	/*
	 * Is the Binary tree balanced?
	 */
	public static void main(String[] args) {
		TreeNode node = new TreeNode(Integer.MIN_VALUE);
		node.left = null;
		node.right = new TreeNode(Integer.MAX_VALUE);
		System.out.println(isValidBST(node));
		System.out.println(isValidBSTWithRecur(node));

	}

	public static boolean isValidBSTWithRecur(TreeNode node) {
    	if (node == null){
    		return true;
    	}
        if (node.left == null && node.right == null) {
            return true;
        }
        long minVal = Integer.MIN_VALUE;
        long maxVal = Integer.MAX_VALUE;
        return isValid(node, minVal-1, maxVal+1);
	}

	public boolean isValidBSTInOrderTraverse (TreeNode root){
		   Stack<TreeNode> stack = new Stack<TreeNode> ();
		   TreeNode cur = root ;
		   TreeNode pre = null ;
		   while (!stack.isEmpty() || cur != null) {
			   if (cur != null) {
				   stack.push(cur);
				   cur = cur.left ;
			   } else {
				   TreeNode p = stack.pop() ;
				   if (pre != null && p.val <= pre.val) {
					   return false ;
				   }
				   pre = p ;
				   cur = p.right ;
			   }
		   }
		   return true ;
	   }

	private static boolean isValid(TreeNode node, long min, long max) {
		if (node == null){
			return true;
		}
		if (node.val <= min || node.val > max) {
			return false;
		}
		return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
	}

	public static boolean isValidBST(TreeNode node) {
    	if (node == null){
    		return true;
    	}
        if (node.left == null && node.right == null) {
            return true;
        }
    	long min = Integer.MIN_VALUE;
    	long max = Integer.MAX_VALUE;
    	Stack<NodeWBounds> stack = new Stack<>();
    	stack.push(new NodeWBounds(node, min-1, max+1));

    	while (!stack.isEmpty()){
    		NodeWBounds nwb = stack.pop();
    		node = nwb.node;
    		min = nwb.min;
    		max = nwb.max;

    		if (node.val <= min || node.val >= max) {
    			return false; //not a valid BST.
    		}
    		if (node.left != null) {
    			stack.push(new NodeWBounds(node.left, min, node.val));
    		}
    		if (node.right != null) {
    			stack.push(new NodeWBounds(node.right, node.val, max) );
    		}
    	}

        return true;
    }

    public static class NodeWBounds {
        TreeNode node;
        long min;
        long max;
        public NodeWBounds(TreeNode node, long min, long max){
            this.node = node;
            this.min = min;
            this.max = max;
        }
        @Override
		public String toString() {
        	return "Node = "+node.val+", min=" + min + ", max=" + max;
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
