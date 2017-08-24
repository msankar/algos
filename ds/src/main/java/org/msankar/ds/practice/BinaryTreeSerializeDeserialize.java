package org.msankar.ds.practice;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeSerializeDeserialize {
	private static final String COMMA = ",";
	private static final String NULL = "null";

	public static void main(String[] args) {
		TreeNode TreeNode = constructTree();
		String data = "8,4,12,null,null,9,16,null,null,null,null";
		System.out.println(serialize(TreeNode));
		TreeNode nd = deserialize(data);
		System.out.println(serialize(nd));
	}

    // Encodes a tree to a single string.
    public static String serialize(TreeNode TreeNode) {
    	if (null == TreeNode) {
    		return "";
    	}
    	StringBuilder strBldr = new StringBuilder();
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(TreeNode);
    	while (!queue.isEmpty()) {
    		TreeNode = queue.poll();
    		if (TreeNode == null) {
    			strBldr.append(NULL).append(COMMA);
    			continue;
    		}
    		strBldr.append(TreeNode.val).append(COMMA);
    		queue.add(TreeNode.left);
    		queue.add(TreeNode.right);
    	}
    	return strBldr.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
    	if (data == null || data.isEmpty()) {
    		return null;
    	}
    	String[] vals = data.split(COMMA);
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	TreeNode n = new TreeNode(Integer.valueOf(vals[0]));
    	queue.add(n);
    	for (int i = 1; i < vals.length; i++) {
    		TreeNode TreeNode = queue.poll();
    		if (!vals[i].equals(NULL)) {
    			TreeNode left = new TreeNode(Integer.parseInt(vals[i]));
    			TreeNode.left = left;
    			queue.add(left);
    		}
    		if (!vals[++i].equals(NULL)) {
    			TreeNode right = new TreeNode(Integer.parseInt(vals[i]));
    			TreeNode.right = right;
    			queue.add(right);
    		}
    	}
    	return n;
    }

    static class TreeNode {
	  int val;
	  TreeNode left;
	  TreeNode right;
	  TreeNode(int x) { val = x; }
    }

    private static TreeNode constructTree() {
    	TreeNode TreeNode = new TreeNode(8);
    	TreeNode.left = new TreeNode(4);
    	TreeNode.right = new TreeNode(12);
    	TreeNode.right.left = new TreeNode(9);
    	TreeNode.right.right = new TreeNode(16);
    	return TreeNode;
    }
}
