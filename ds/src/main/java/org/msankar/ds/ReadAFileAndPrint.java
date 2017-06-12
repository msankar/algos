package org.msankar.ds;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAFileAndPrint {

	public static void main(String[] args) {
		ReadAFileAndPrint read = new ReadAFileAndPrint();
		read.readAndPrint("C:\\testwks\\ds\\resources\\EmailServer.log");
		read.sumIntegersInAFile("C:\\testwks\\ds\\resources\\SumNumbers.txt");
	}

	private void readAndPrint(String fileName) {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line = "";
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void sumIntegersInAFile(String filename) {
		try ( BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line = ""; 
			double sum = 0.0;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				sum += Double.valueOf(line);
			}
			System.out.println("The sum of all numbers in SumNumbers.txt is = " + sum);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
