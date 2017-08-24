package org.msankar.ds.practice;

public class CoinProblem {
	//Use dynamic programming
	public static void main(String[] args) {
		CoinProblem cp = new CoinProblem();
		int amount = 10;
		int[] coins = {2,5,3,6};
		long x = cp.numberOfWaysToMakeAmount(amount, coins);
		System.out.println(x);
	}

	public long numberOfWaysToMakeAmount(int amount, int[] coins) {
		long[] numWays = new long[amount+1];
		numWays[0] = 1L;

		for (int coin: coins) {
			for (int amt = coin; amt <= amount; amt++) {
				numWays[amt] = numWays[amt] + numWays[amt-coin];
			}

		}
		return numWays[amount];
	}

}
