package org.msankar.ds;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MultiplyStringsTest {

	@Test
	public void test() {
		String s1 = "99988787.89";
		String s2 = "78788899.56";
		String result = "7878006566191354.3284";

		assertEquals(result, MultiplyStrings.multiplyStrings(s1, s2));
	}
}
