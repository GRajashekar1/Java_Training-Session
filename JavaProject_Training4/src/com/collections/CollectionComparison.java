package com.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CollectionComparison {

	private static long getMemoryUsage() {
		Runtime runtime = Runtime.getRuntime();
		return runtime.totalMemory() - runtime.freeMemory();

	}

	public static void main(String[] args) {
		List<Integer> arraylist = new ArrayList<>();
		List<Integer> linkedlist = new LinkedList<>();

		Set<Integer> hashset = new HashSet<>();
		Set<Integer> linkedhashset = new LinkedHashSet<>();

		Map<Integer, String> hashmap = new HashMap<>();
		Map<Integer, String> treemap = new TreeMap<>();

		long startTime, endTime;
		long memoryBefore, memoryAfter;

		// ArrayList and linkedList
		startTime = System.nanoTime();
		memoryBefore = getMemoryUsage();

		for (int i = 0; i < 100000; i++) {
			arraylist.add(i);

		}
		memoryAfter = getMemoryUsage();
		endTime = System.nanoTime();

		System.out.println("===================================================================");
		System.out.println("ArrayList insertion time: " + (endTime - startTime) + " ns");
		System.out.println("ArrayList memory usage: " + (memoryAfter - memoryBefore) + " bytes");
		System.out.println("===================================================================");
		startTime = System.nanoTime();
		memoryBefore = getMemoryUsage();

		for (int i = 0; i < 100000; i++) {
			linkedlist.add(i);
		}
		memoryAfter = getMemoryUsage();
		endTime = System.nanoTime();

		System.out.println("===================================================================");
		System.out.println("LinkedList insertion time: " + (endTime - startTime) + " ns");
		System.out.println("LinkedList memory usage: " + (memoryAfter - memoryBefore) + " bytes");
		System.out.println("===================================================================");

		// HashSet and TreeSet
		startTime = System.nanoTime();
		memoryBefore = getMemoryUsage();

		for (int i = 0; i < 100000; i++) {
			hashset.add(i);
		}
		memoryAfter = getMemoryUsage();
		endTime = System.nanoTime();

		System.out.println("===================================================================");
		System.out.println("Hashset insertion time: " + (endTime - startTime) + " ns");
		System.out.println("Hashset memory usage: " + (memoryAfter - memoryBefore) + " bytes");
		System.out.println("===================================================================");

		startTime = System.nanoTime();
		memoryBefore = getMemoryUsage();

		for (int i = 0; i < 100000; i++) {
			linkedhashset.add(i);
		}
		memoryAfter = getMemoryUsage();
		endTime = System.nanoTime();

		System.out.println("===================================================================");
		System.out.println("LinkedHashset insertion time: " + (endTime - startTime) + " ns");
		System.out.println("LinkedHashset memory usage: " + (memoryAfter - memoryBefore) + " bytes");
		System.out.println("===================================================================");
		
		//HashMap & TreeMap
		startTime = System.nanoTime();
		memoryBefore = getMemoryUsage();

		for (int i = 0; i < 100000; i++) {
			hashmap.put(i,"value"+ i);
		}
		memoryAfter = getMemoryUsage();
		endTime = System.nanoTime();

		System.out.println("===================================================================");
		System.out.println("Hashmap insertion time: " + (endTime - startTime) + " ns");
		System.out.println("Hashmap memory usage: " + (memoryAfter - memoryBefore) + " bytes");
		System.out.println("===================================================================");
		
		startTime = System.nanoTime();
		memoryBefore = getMemoryUsage();

		for (int i = 0; i < 100000; i++) {
			treemap.put(i,"value"+ i);
		}
		memoryAfter = getMemoryUsage();
		endTime = System.nanoTime();

		System.out.println("===================================================================");
		System.out.println("Treemap insertion time: " + (endTime - startTime) + " ns");
		System.out.println("Treemap memory usage: " + (memoryAfter - memoryBefore) + " bytes");
		System.out.println("===================================================================");
		
		
	}

}
