package org.msankar.ds;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class DivFunctionTest {

	@Test
	public void test() {
		assertEquals("[3, 0]", Arrays.toString(DivFunction.divFunction(9, 3)));
		assertEquals("[4, 2]", Arrays.toString(DivFunction.divFunction(14, 3)));
		assertEquals("[0, 2]", Arrays.toString(DivFunction.divFunction(2, 3)));
	}
}
