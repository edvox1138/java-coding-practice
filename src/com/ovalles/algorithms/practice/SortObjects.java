package com.ovalles.algorithms.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Example of sorting a list objects with natural ordering,
 *   and ordering objects based on its application order requirements.
 *   Person objects are sorted by height thru the compareTo() method.
 * @author Edward
 *
 */
public class SortObjects {

	public static void main(String[] args) {
		SortObjects  test = new SortObjects();
		
		List<Integer> numbers = test.generateNumbers();
		System.out.println("[numbers] " + numbers);
		test.sortList(numbers);
		System.out.println("[sorted] " + numbers);
		
		List<Person> listOfHeights = test.generatePersons();
		System.out.println("[heights] " + listOfHeights);
		test.sortList(listOfHeights);
		System.out.println("[sorted by height] " + listOfHeights);

	}

	private List<Person> generatePersons() {
		List<Person> persons = new ArrayList<Person>();
		
		persons.add(new Person("Fred", Gender.MALE, 5.8, 170));
		persons.add(new Person("Bob", Gender.MALE, 6.0, 200));
		persons.add(new Person("Lucy", Gender.FEMALE, 5.0, 150));
		persons.add(new Person("Mars", Gender.FEMALE, 5.9, 180));
		persons.add(new Person("Tom", Gender.MALE, 5.5, 167));
		persons.add(new Person("Mary", Gender.FEMALE, 4.8, 140));
		persons.add(new Person("Ed", Gender.MALE, 5.6, 170));
		persons.add(new Person("Mike", Gender.MALE, 5.0, 180));
		persons.add(new Person("Earl", Gender.MALE,  5.9, 170));
		persons.add(new Person("Lisa", Gender.FEMALE, 5.2, 120));
		persons.add(new Person("Zach", Gender.MALE, 5.9, 187));
		persons.add(new Person("Connie", Gender.FEMALE, 4.5, 130));
		
		return persons;
	}

	/**
	 * Sort object that are comparable.
	 * List cannot contain null items.
	 * List item must implement the Comparable interface.
	 * @param numbers is a list of comparable items to sort
	 */
	public void sortList(List<?> numbers) {
		quicksort(numbers,0, numbers.size() - 1);	
	}

	private void quicksort(List<?> items, int start, int end) {
		if(start < end) {
		     int m = partition(items,start, end);
		     quicksort(items, start, m-1);
		     quicksort(items, m+1, end);
		}
	}

	private int partition(List<?> items, int start, int end) {
		Object pivot = items.get(end);
	    int i = start - 1;
	    for(int j = start; j < end; j++) {
	    	Comparable item = (Comparable) items.get(j);
	    	if(item.compareTo(pivot) <= 0) {
	    		i++;
	    		Collections.swap(items, i, j);
	    	}
	    }
	    
	    Collections.swap(items, i+1, end);
		return i+1;
	}

	private List<Integer> generateNumbers() {
		List<Integer> numbers = new ArrayList<Integer>();
		
		for(int i = 0; i < 10; i++) {
			numbers.add(new Integer(i));
		}
		Collections.shuffle(numbers);
		
		return numbers;
	}

	
}
