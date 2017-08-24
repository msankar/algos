package org.msankar.ds.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PermutationsOfAStringRecursive {

	public static void main(String[] args) {
		Set<String> retSet = getPermutations("cats");
		for (String s : retSet) {
			System.out.println(s);
		}
	}

	public static Set<String> getPermutations(String inputStr) {
		//Base case
		if (inputStr.length() <= 1) {
			return new HashSet<String>(Arrays.asList(inputStr));
		}

		//Get last character and rest of the string
		String lastCharacter = inputStr.substring(inputStr.length()-1);
		String restOfStr = inputStr.substring(0, inputStr.length()-1);

		//Recursively get permutations.
		Set<String> permutations = getPermutations(restOfStr);

		Set<String> retSet = new HashSet<>();
		for (String perm : permutations) {
			for (int i = 0; i < restOfStr.length()+1; i++) {
				String s = perm.substring(0, i) + lastCharacter + perm.substring(i,perm.length());
				retSet.add(s);
			}
		}
		return retSet;
	}

}
