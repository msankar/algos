package org.msankar.ds;

public class PrimeNumbers {

	public void findPrimeNumbersInRange(int startRange, int endRange) {
		
		System.out.println("\nFinding primes 2 ...");
		for (int i = startRange; i <= endRange; i++ ) {
			if (isPrime (i) ) {
				System.out.print(i + "  ");
			}			
		}
		
		System.out.println("\n\nFinding Primes 3 ...");
		for (int i = startRange; i <= endRange; i++ ) {
			if (isPrimes (i) ) {
				System.out.print(i + "  ");
			}			
		}	
		System.out.println();
	}
	
	private boolean isPrime(int n) {
		if (n == 1 || n == 2) {
			return true;
		}
		
		for (int j = 2; j <= n/2; j++) {
			if (n%j == 0) {
				return false;
			}
		}		
		return true;
	}
	
	private boolean isPrimes (int n) {
		if (n == 1 || n == 2) {
			return true;
		}
		
		for (int j = 2; j <= Math.sqrt(n); j++) {
			if (n%j == 0) {
				return false;
			}
		}		
		return true;
	}
}
