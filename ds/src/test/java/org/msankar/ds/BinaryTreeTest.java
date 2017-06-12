package org.msankar.ds;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.msankar.ds.hashtable.BinaryNode;

public class BinaryTreeTest {
	
	BinaryNode bn1 = null;
	BinaryNode bn2 = null;
	BinaryNode bn3 = null;
	BinaryNode bn4 = null;
	BinaryNode bn5 = null;
	BinaryNode bn6 = null;
	BinaryNode bn7 = null;

	@Before
	public void init() {		
		bn7 = new BinaryNode(17, null, null, bn3);
		bn6 = new BinaryNode(11, null, null, bn3);		
		bn5 = new BinaryNode(9, bn6, bn7, bn2);
		bn4 = new BinaryNode(4, bn6, bn7, bn2);
		bn3 = new BinaryNode(13, bn6, bn7, bn1);
		bn2 = new BinaryNode(7, bn4, bn5, bn1);		
		bn1 = new BinaryNode(10, bn2, bn3, null);
	}

	@Test
	public void testFindingMax() {
		int max = bn1.getData();
		BinaryNode root = bn1;
		
		while (root != null && root.getRight() != null) {
			root = root.getRight();
			if (root.getData() > max) {
				max = root.getData();				
			}
		}
		
		System.out.println(max);
		assertEquals (17, max);
	}

}
