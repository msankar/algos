package org.msankar.ds;

public class ProductsAndArrays {
	
	public static int[] findProd(int[] arr) {
		double prod = 0;
		
		for(int i = 0; i < arr.length; i++) {
			prod += Math.log(arr[i]);
		}
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int) Math.round(Math.exp(prod - Math.log(arr[i])));
		}
		return arr;		
	}
	
	public static int[][] findProductArray(int[][] arr) {
		int row = arr.length;
		int col = arr[0].length;
		int[][] result = new int[row][col];
		int[] prod = new int[row];
		
		for (int i = 0; i < row; i ++) {
			prod[i] = arr[i][0];
			for (int j = 1; j < col ; j++) {
				 prod[i] = arr[i][j] * prod[i];
			}
		}
		
		for (int i = 0; i < row; i ++) {
			for (int j = 0; j < col ; j++) {
				 result[i][j]= prod[i]/arr[i][j];
			}
		}
		return result;
	}
	
	public static int[][] findProductArray2(int[][] arr) {
		int row = arr.length;
		int col = arr[0].length;
		int[][] result = new int[row][col];
		double[] sum = new double[row];
		
		for (int i = 0; i < row; i ++) {
			sum[i] = Math.log(arr[i][0]);
			for (int j = 1; j < col ; j++) {
				 sum[i] += Math.log(arr[i][j]);
			}
		}
		
		for (int i = 0; i < row; i ++) {
			for (int j = 0; j < col ; j++) {
				 result[i][j]= (int) Math.round(Math.exp(sum[i] - Math.log(arr[i][j])));
			}
		}
		return result;
	}

}
