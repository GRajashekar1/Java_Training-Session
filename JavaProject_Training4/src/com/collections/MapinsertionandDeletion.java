package com.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapinsertionandDeletion {
	public static void main(String[] args) {

		Map<Integer, String> hashmap = new HashMap<>();
		Map<Integer, String> linkedhashmap = new LinkedHashMap<>();
		Map<Integer, String> treemap = new TreeMap<>();

		long startTime, endTime;

		// Time taken to add the HashMap elements
		startTime = System.nanoTime();

		for (int i = 0; i < 100000; i++) {
			hashmap.put(i, "value" + i);

		}

		endTime = System.nanoTime();

		System.out.println("HashMap insertion time taken : " + (endTime - startTime) + " ns");
		System.out.println("===================================================================");

		// Time taken to add the LinkedhashMap elements

		startTime = System.nanoTime();

		for (int i = 0; i < 100000; i++) {
			linkedhashmap.put(i, "value" + i);
		}

		endTime = System.nanoTime();

		System.out.println("LinkedHashMap insertion time : " + (endTime - startTime) + " ns");
		System.out.println("===================================================================");

		// Time taken to add the TreeMap elements

		startTime = System.nanoTime();

		for (int i = 0; i < 100000; i++) {
			treemap.put(i, "value" + i);
		}

		endTime = System.nanoTime();

		System.out.println("TreeMap insertion time : " + (endTime - startTime) + " ns");
		System.out.println("===================================================================");

		// Time taken to access the HashMap elements
		startTime = System.nanoTime();
		hashmap.get(10000);
		endTime = System.nanoTime();
		System.out.println("Time taken to access the HashMap elements : " + (endTime - startTime) + " ns");
		System.out.println("===================================================================");

		// Time taken to access the LinkedHashMap elements
		startTime = System.nanoTime();
		linkedhashmap.get(10000);
		endTime = System.nanoTime();
		System.out.println("Time taken to access the LinkedHashMap elements : " + (endTime - startTime) + " ns");
		System.out.println("=============================================================================");

		// Time taken to access the TreeSet elements
		startTime = System.nanoTime();
		treemap.get(10000);
		endTime = System.nanoTime();
		System.out.println("Time taken to access the TreeMap elements : " + (endTime - startTime) + " ns");
		System.out.println("=============================================================================");

		// Time taken to remove the HashMap elements
		startTime = System.nanoTime();
		hashmap.remove(10000);
		endTime = System.nanoTime();
		System.out.println("Time taken to remove the HashMap elements : " + (endTime - startTime) + " ns");
		System.out.println("=============================================================================");

		// Time taken to remove the LinkedHashMap elements
		startTime = System.nanoTime();
		linkedhashmap.remove(10000);
		endTime = System.nanoTime();
		System.out.println("Time taken to remove the LinkedHashMap elements : " + (endTime - startTime) + " ns");
		System.out.println("=============================================================================");

		// Time taken to remove the TreeSet elements
		startTime = System.nanoTime();
		treemap.remove(10000);
		endTime = System.nanoTime();
		System.out.println("Time taken to remove the TreeMap elements : " + (endTime - startTime) + " ns");
		System.out.println("=============================================================================");

	}

}
