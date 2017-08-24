package org.msankar.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortNameSolution {

	public static void main(String[] args) {
		List<String> input = Arrays.asList("Pen10","Apple1", "Apple10", "Apple2", "Fox1");
		List<String> ret = sortName(input);
		for (String s : ret) {
			System.out.println(s);
		}
	}

	public static List<String> sortName(List<String> input) {
		Map<String, Queue<Integer>> nameToIdList = new HashMap<>();
		List<String> retList = new ArrayList<>();
		for (String inputStr : input) {
			for (int i = 0; i < inputStr.length(); i++) {
				if (Character.isDigit( inputStr.charAt(i))) {
					String name = inputStr.substring(0, i);
					String id = inputStr.substring(i);
					if (!nameToIdList.containsKey(name)) {
						nameToIdList.put(name, new PriorityQueue<Integer>());
					}
					nameToIdList.get(name).add(Integer.parseInt(id));
					break;
				}
			}
		}

		List<String> names = new ArrayList<>(nameToIdList.keySet());
		Collections.sort(names);

		for (String name : names) {
			Queue<Integer> listOfId = nameToIdList.get(name);
			while (!listOfId.isEmpty()) {
				Integer id = listOfId.remove();
				retList.add(name+id);
			}
		}
		return retList;
	}



}
