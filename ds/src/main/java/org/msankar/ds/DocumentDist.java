package org.msankar.ds;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DocumentDist {

	public static void main(String[] args) {
		DocumentDist d = new DocumentDist();
		
		Map<String, Integer> map1 = d.readFirstDocument("C:\\testwks\\ds\\resources\\docDist1.txt");
		Map<String, Integer> map2 = d.readFirstDocument("C:\\testwks\\ds\\resources\\docDist2.txt");
		
		// Compare the lengths of the two maps
		// Disregard the sequence of the words.
		int w1 = 0, w2 = 0 ;
		double numW = 0;
		double denomW1Squared = 0 , denomW2Squared = 0;
		
		for (String str : map1.keySet()) {
			if (map2.containsKey(str)) {
				w1 = map1.get(str);
				w2 = map2.get(str);
				
				numW += w1 * w2;
				denomW1Squared += w1*w1;
				denomW2Squared += w2*w2;
			}
		}
		
		double result = Math.acos( numW / (Math.sqrt(denomW1Squared) * Math.sqrt(denomW2Squared)));		
		
		if (result < 0.001) {
			System.out.println("These docs are identical " + result);			
		} else {
			System.out.println("These docs are NOT identical " + result);
		}
	}
	
	public Map<String, Integer> readFirstDocument(String filePath) {
		Map<String, Integer> retMap = new HashMap<> ();
		
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line = "";			
			while ((line = br.readLine()) != null) {
				String[] wordList = line.split(" ");
				String word;
				int occurs = 0;
				
				for (int i = 0; i < wordList.length; i++) {
					word = wordList[i].toLowerCase().trim().replaceAll("\\p{Punct}", "");
					occurs = retMap.get(word)==null?0:retMap.get(word);
					retMap.put(word, occurs + 1);
				}
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return retMap;
	}

}
