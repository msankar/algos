package org.msankar.ds.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RecursiveStringCombos {

	public static void main(String[] args) {
		Set<String> perms = getPermutation("cat");
		//Set<String> perms = getPermutation("cat");

		for  (String perm : perms) {
			System.out.println(perm);
		}
	}

	public static Set<String> getPermutation(String inputStr) {
		// Base case
		if (inputStr.length() <= 1) {
			return new HashSet<String>(Arrays.asList(inputStr));
		}

		String strExceptLastChar = inputStr.substring(0, inputStr.length()-1);
		String lastCharacter = inputStr.substring(inputStr.length()-1);
		// Recursively call and get all possible permutations for all chars except last.
		Set<String> allPerms =  getPermutation(strExceptLastChar);

		Set<String> retSet = new HashSet<>();
		for (String perm : allPerms) {
			for (int i = 0; i <= strExceptLastChar.length(); i++) {
				String combo = perm.substring(0, i) +
						lastCharacter +
						perm.substring(i);
				retSet.add(combo);
			}
		}
		return retSet;
	}
}
