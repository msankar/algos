package org.msankar.ds;

import org.junit.Test;

public class MultiplicationTableTest {
	MultiplicationTable mt;
	
	@Test
	public void multiplyAndPrintTest() {
		mt = new MultiplicationTable();
		mt.multiplyAndPrint(1, 12);
	}
}
