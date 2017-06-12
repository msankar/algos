package org.msankar.ds;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexHarness {

	public static void match(String regex, String str) {
		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(str);

		boolean found = false;
		while (matcher.find()) {
			System.out.format("I found the text" + " \"%s\" starting at "
					+ "index %d and ending at index %d.%n", matcher.group(),
					matcher.start(), matcher.end());
			found = true;
		}
		if (!found) {
			System.out.format("No match found.%n");
		}
	}
}
