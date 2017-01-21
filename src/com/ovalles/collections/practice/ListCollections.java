package com.ovalles.collections.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListCollections {

	public static void main(String[] args) {
		ListCollections test = new ListCollections();

		List<Integer> numbers = new ArrayList<Integer>();
		test.testListUsage(numbers);

		List<Integer> linkedList = new LinkedList<Integer>();
		test.testListUsage(linkedList);

		// list are not thread safe, create a thread safe list
		List<Integer> syncList = Collections
				.synchronizedList(new ArrayList<Integer>());
		test.testListUsage(syncList);
		
		test.testSortingObjects();
	}

	public void testSortingObjects() {
		// Sorted objects?
		List<Book> books = new ArrayList<Book>();
		books.add(new Book("Stormy Night", "Jack Writer"));
		books.add(new Book("Gradle", "Groovy"));
		books.add(new Book("Peter Rabbit", "Werewolf"));
		books.add(new Book("Star Wars", "Darth Vader"));

		System.out.println("books: " + books);
		Collections.sort(books); // must implement Comparable

		System.out.println("sorted books:" + books);
	}

	public void testListUsage(List<Integer> numbers) {
		// emptyList is immutable, possible return value instead of null
		List<Integer> emptyList = Collections.EMPTY_LIST;

		if (numbers instanceof ArrayList)
			System.out.println("[list is] " + ArrayList.class.getName());
		if (numbers instanceof LinkedList)
			System.out.println("[list is] " + LinkedList.class.getName());

		for (int i = 0; i < 10; i++) {
			numbers.add(new Integer(i * 10));
		}
		numbers.add(50); // list allows duplicates
		numbers.add(null); // list allows null

		// list has toString() semantics , can print directly
		System.out.println("list preserves order:");
		System.out.println(numbers);
		System.out.println("size: " + numbers.size());

		// iterator
		// enumeration is obsolete
		System.out.print("[iterator] ");
		Iterator<Integer> it = numbers.iterator();
		int index = 0;
		while (it.hasNext()) {
			Integer item = it.next();
			System.out.print(item + ", ");
			// cannot modify list on same thread
		}
		System.out.println("");

		// for each
		System.out.print("[for each] ");
		for (Integer item : numbers) {
			System.out.print(item + ", ");
		}
		System.out.println("");

		Collections.shuffle(numbers);
		System.out.println("[shuffled] " + numbers);

		// works if no null element
		numbers.remove(null);
		Collections.sort(numbers);
		System.out.println("[sorted] " + numbers);

		int value = 50;
		int indexIfFound = Collections
				.binarySearch(numbers, new Integer(value));
		if (indexIfFound < 0) {
			System.out.println("[binarySearch] not found in list - " + value);
		} else {
			System.out.println("[binarySearch] found in list - " + value
					+ ", at index " + indexIfFound);
		}

		List<Integer> immutableList = Collections.unmodifiableList(numbers);
		System.out.println("[read-only] "
				+ Arrays.toString(immutableList.toArray()));

		// always return an immutable list , if list is private class field
		immutableList.size();

		// compare list
		numbers.remove(0); // changes immutableList
		System.out.println(numbers);
		System.out.println(immutableList);
		if (numbers.equals(immutableList)) {
			System.out.println("numbers list and immutableList are equal");
		} else {
			System.out.println("numbers list and immutableList are not equal");
		}

		// copy list, is problematic
		List<Integer> newList = new ArrayList<Integer>(numbers.size());
		System.out.println("[size of newList] " + newList.size());
		// copy method check the size of the destination, but it is empty
		// Collections.copy(newList, numbers);

		// make a copy by using the constructor parameter
		List<Integer> copyOfList = new ArrayList<Integer>(numbers);
		System.out.println("[copyOfList] " + copyOfList);

	}

}
