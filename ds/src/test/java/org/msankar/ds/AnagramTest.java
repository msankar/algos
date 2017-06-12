package org.msankar.ds;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AnagramTest {
	
	@Test
	public void test() {
		assertTrue(Anagram.isAnagram("ice man", "manice"));
		assertTrue(Anagram.isAnagram("parliament", "partial men"));
	}

}
