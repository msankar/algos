package org.msankar.ds;

import org.junit.Test;

public class RegexHarnessTest {
	@Test
	public void quantifierTest() {
		// zero or one
		RegexHarness.match("a?", "");
		// zero or more
		RegexHarness.match("a*", "");
		// one or more
		RegexHarness.match("a+", "");

		RegexHarness.match("a?", "a");
		RegexHarness.match("a*", "a");
		RegexHarness.match("a+", "a");

		// Pattern should match exactly 3 times.
		RegexHarness.match("a{3}", "a");
		RegexHarness.match("a{3}", "aaa");
		RegexHarness.match("a{3}", "aaaa");

		// Pattern should match atleast 3 times.
		RegexHarness.match("a{3,}", "aaaaaaa");

		// Specify an upper limit on the number of occurances.
		RegexHarness.match("a{3,6}", "aaaaaaaaaaaa");

		// greedy quantifier
		RegexHarness.match(".*foo", "xfooxxxxxxfoo");

		// Reluctant quantifier
		RegexHarness.match(".?foo", "xfooxxxxxxfoo");

		// Possessive quantifier
		RegexHarness.match(".*+foo", "xfooxxxxxxfoo");
		
		RegexHarness.match("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b", "MSANKAR@MSANKAR.COM");
		RegexHarness.match("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b", "msankar980@msankar.org");
	}
	
	@Test
	public void matchEmailAddresses() {
		RegexHarness.match("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b", "MSANKAR@MSANKAR.COM");
		RegexHarness.match("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b", "msankar980@msankar.org");
	}

	@Test
	public void predefinedCharTest() {
		// Any character may or may not match line terminators.
		RegexHarness.match(".", "a");
		RegexHarness.match(".", "*");
		RegexHarness.match(".", "1");

		// Match digits
		RegexHarness.match("\\d", "9");
		RegexHarness.match("\\d", "a");

		// Match non-digits
		RegexHarness.match("\\D", "a");
		RegexHarness.match("\\D", "4");

		// Match whitespace character
		RegexHarness.match("\\s", " ");
		RegexHarness.match("\\s", "	");
		RegexHarness.match("\\s", "a");

		// Match non-whitespace character
		RegexHarness.match("\\S", "a");
		RegexHarness.match("\\S", "  ");

		// Match word character
		RegexHarness.match("\\w", "a");
		RegexHarness.match("\\w", "!!!");

		// Match non-word character
		RegexHarness.match("\\W", "*");
		RegexHarness.match("\\W", "ab");
	}

	@Test
	public void testCharacterClasses() {
		RegexHarness.match("[bcr]at", "bat");

		// Negation
		RegexHarness.match("[^bcr]at", "bat");
		RegexHarness.match("[^bcr]att", "hatter");

		// Ranges
		System.out.println("\nRanges.....");
		RegexHarness.match("[a-c]", "a");
		RegexHarness.match("[a-c]", "d");
		RegexHarness.match("foo[1-5]", "foo2");
		RegexHarness.match("foo[1-5]", "foo9");
		RegexHarness.match("foo[^1-5]", "foo2");

		// Unions;
		System.out.println("\nUnions.....");
		RegexHarness.match("[0-4[6-8]]", "7");
		RegexHarness.match("[0-4[6-8]]", "5");

		// Intersections
		System.out.println("\nIntersections.....");
		RegexHarness.match("[0-9&&[345]]", "3");
		RegexHarness.match("[0-9&&[345]]", "6");

		// Intersection of 2 ranges
		System.out.println("\nIntersection of two ranges.....");
		RegexHarness.match("[2-8&&[4-6]]", "6");
		RegexHarness.match("[2-8&&[4-6]]", "7");

		// Subtraction
		System.out.println("\nSubtraction.....");
		RegexHarness.match("[0-9&&[^345]]", "2");
		RegexHarness.match("[0-9&&[^345]]", "5");
		RegexHarness.match("[0-9&&[^345]]", "8");
	}
}
