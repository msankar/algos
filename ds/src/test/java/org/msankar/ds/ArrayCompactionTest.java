package org.msankar.ds;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class ArrayCompactionTest {
	
	@Test
	public void test() {
		int[] array1 = new int[] { 9, 8, 8, 4, 10, 5, 6, 3, 7, 2, 8, 6, 1, 9, 4 };

		assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0, 0, 0]",
				Arrays.toString(ArrayCompaction.compactArray(array1)));
	}
}
