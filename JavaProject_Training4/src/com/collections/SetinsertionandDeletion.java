package com.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetinsertionandDeletion {

	public static void main(String[] args) {
		Set<Integer> hashset = new HashSet<>();
		Set<Integer> linkedhashset = new LinkedHashSet<>();
		Set<Integer> treeset = new TreeSet<>();

		long startTime, endTime;

		// Time taken to add the Hashset elements
		startTime = System.nanoTime();

		for (int i = 0; i < 100000; i++) {
			hashset.add(i);

		}

		endTime = System.nanoTime();

		System.out.println("HashSet insertion time taken : " + (endTime - startTime) + " ns");
		System.out.println("===================================================================");

		// time taken to add the Linkedhashset elements

		startTime = System.nanoTime();

		for (int i = 0; i < 100000; i++) {
			linkedhashset.add(i);
		}

		endTime = System.nanoTime();

		System.out.println("LinkedHashSet insertion time : " + (endTime - startTime) + " ns");
		System.out.println("===================================================================");

		// Time taken to add the TreeSet elements

		startTime = System.nanoTime();

		for (int i = 0; i < 100000; i++) {
			treeset.add(i);
		}

		endTime = System.nanoTime();

		System.out.println("TreeSet insertion time : " + (endTime - startTime) + " ns");
		System.out.println("===================================================================");

		// Time taken to remove the HashSet elements
		startTime = System.nanoTime();
		hashset.remove(10000);
		endTime = System.nanoTime();
		System.out.println("Time taken to remove the HashSet elements : " + (endTime - startTime) + " ns");
		System.out.println("=============================================================================");

		// Time taken to remove the LinkedHashSet elements
		startTime = System.nanoTime();
		linkedhashset.remove(10000);
		endTime = System.nanoTime();
		System.out.println("Time taken to remove the LinkedHashSet elements : " + (endTime - startTime) + " ns");
		System.out.println("=============================================================================");

		// Time taken to remove the TreeSet elements
		startTime = System.nanoTime();
		treeset.remove(10000);
		endTime = System.nanoTime();
		System.out.println("Time taken to remove the TreeSet elements : " + (endTime - startTime) + " ns");
		System.out.println("=============================================================================");

	}

}
