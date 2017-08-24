package org.msankar.ds.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinaryTreePaths {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(4);
		node.left = new TreeNode(8);
		node.right = new TreeNode(9);
		node.left.left = new TreeNode(1);
		node.left.right = new TreeNode(2);
		node.right.left = new TreeNode(6);
		node.left.right = new TreeNode(7);
		//List<String> paths = binaryTreePaths(node);
		List<String> paths = binaryTreePathsDFS(node);
	}

	public static List<String> binaryTreePathsDFS(TreeNode root) {
	    List<String> list=new ArrayList<String>();
	    Stack<TreeNode> sNode=new Stack<TreeNode>();
	    Stack<String> sStr=new Stack<String>();

	    if(root==null) return list;
	    sNode.push(root);
	    sStr.push("");
	    while(!sNode.isEmpty()) {
	        TreeNode curNode=sNode.pop();
	        String curStr=sStr.pop();

	        if(curNode.left==null && curNode.right==null) list.add(curStr+curNode.val);
	        if(curNode.left!=null) {
	            sNode.push(curNode.left);
	            sStr.push(curStr+curNode.val+"->");
	        }
	        if(curNode.right!=null) {
	            sNode.push(curNode.right);
	            sStr.push(curStr+curNode.val+"->");
	        }
	    }
	    return list;
	}

    public static List<String> binaryTreePaths(TreeNode node) {
    	if (null == node) {
    		return Collections.emptyList();
    	}
    	List<String> retList = new ArrayList<>();
		search(node, "", retList);
		return retList;
    }

    private static void search(TreeNode node, String path, List<String> retList) {
    	if (node.left==null && node.right == null) {
    		retList.add(path + node.val);
    	}
    	if (node.left != null) {
    		search(node.left, path+node.val+"-->", retList);
    	}
    	if (node.right != null) {
    		search(node.right, path+node.val+"-->", retList);
    	}
    }

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { this.val = x; }
		@Override
		public String toString() {
			return val+"";
		}
	}

}
