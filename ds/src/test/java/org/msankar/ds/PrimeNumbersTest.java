package org.msankar.ds;

import org.junit.Test;

public class PrimeNumbersTest {

	@Test
	public void findPrimes() {
		PrimeNumbers primeNum = new PrimeNumbers();
		primeNum.findPrimeNumbersInRange(1, 100);
	}
}
