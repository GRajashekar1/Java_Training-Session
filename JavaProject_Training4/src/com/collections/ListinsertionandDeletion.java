package com.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;	

public class ListinsertionandDeletion {

	public static void main(String[] args) {
		List<Integer> arraylist = new ArrayList<>();
		List<Integer> linkedlist = new LinkedList<>();

		long startTime, endTime;

		// Time taken to add the ArrayList elements
		startTime = System.nanoTime();

		for (int i = 0; i < 100000; i++) {
			arraylist.add(i);
			
		}

		endTime = System.nanoTime();

		System.out.println("ArrayList insertion time taken : " + (endTime - startTime) + " ns");
		System.out.println("===================================================================");
		// Time taken to add the LinkedList elements

		startTime = System.nanoTime();

		for (int i = 0; i < 100000; i++) {
			linkedlist.add(i);
		}

		endTime = System.nanoTime();

		System.out.println("LinkedList insertion time: " + (endTime - startTime) + " ns");
		System.out.println("===================================================================");

		// Time taken to access the ArrayList elements
		startTime = System.nanoTime();
		arraylist.get(10000);
		endTime = System.nanoTime();
		System.out.println("Time taken to access the ArrayList elements : " + (endTime - startTime) + " ns");
		System.out.println("=============================================================================");

		// Time taken to access the LinkedList elements
		startTime = System.nanoTime();
		linkedlist.get(10000);
		endTime = System.nanoTime();
		System.out.println("Time taken to access the LinkedList elements : " + (endTime - startTime) + " ns");
		System.out.println("=============================================================================");

		// Time taken to remove the ArrayList elements
		startTime = System.nanoTime();
		arraylist.remove(10000);
		endTime = System.nanoTime();
		System.out.println("Time taken to remove the ArrayList elements : " + (endTime - startTime) + " ns");
		System.out.println("=============================================================================");
		
		// Time taken to remove the LinkedList elements
		startTime = System.nanoTime();
		linkedlist.remove(10000);
		endTime = System.nanoTime();
		System.out.println("Time taken to remove the LinkedList elements : " + (endTime - startTime) + " ns");
		System.out.println("=============================================================================");

	}
}
