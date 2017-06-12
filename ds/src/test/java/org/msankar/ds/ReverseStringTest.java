package org.msankar.ds;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReverseStringTest {

	private final String str = "hello tester";
	private final String rev = "retset olleh";
	
	@Test
	public void test() {
		assertEquals(rev, ReverseString.reverseString(str));
		assertEquals(rev, ReverseString.reverseString2(str));
		
		assertEquals(rev, ReverseString.reverseString3(str));
	}
}
