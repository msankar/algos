package org.msankar.ds.practice;

public class StockPrice {
	public static void main (String[] args) {
		int[] stockPriceArray = new int[] {12, 10, 4, 25, 8, 1};
		int profit = getMaxProfit(stockPriceArray);
		System.out.println(String.format("We made a profit of %d dollars", profit));
	}
	
	public static int getMaxProfit (int[] stockPriceArray) {
		if (stockPriceArray.length < 2) {
		    throw new IllegalArgumentException("Getting a profit requires at least 2 prices");
		}
		int maxProfit = stockPriceArray[1] - stockPriceArray[0];		
		int minPrice = stockPriceArray[0];
		
		for (int i = 1; i < stockPriceArray.length; i++) {	
			int currentPrice = stockPriceArray[i];
			maxProfit = Math.max(maxProfit, currentPrice-minPrice);
			minPrice = Math.min(currentPrice, minPrice);
		}
		
		return maxProfit;
	}

}
