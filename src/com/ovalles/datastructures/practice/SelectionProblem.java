package com.ovalles.datastructures.practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * Find the kth - smallest (largest) elements, typically from a large data set
 * (file based) or on going events. WordCount and WordCountSentence are warm up.
 * Now given a data set of words find the k-th words with smallest count. Test
 * file is End User License Agreement - has 1329 unique words. How do you find
 * the 10 least used words?
 * Notes:
 *   1) There will be more that 10 words with 1 occurence.
 *   2) Priortiy queue object (Word) compareTo() determines semantics of queued items
 *     largest/smallest Word count
 *     , farthest/nearest Point , most occurences/least occurence WebPage
 *  3) Specific to word being counted, how is a word defined  - quotes, double quotes, case 
 *  4) Solution is not thread safe. Use PriorityBlockingQueue and   ConcurrentHashMap
 *  
 * @author Edward Ovalles
 * 
 *
 */
public class SelectionProblem {
	Map<String, Integer> map = new HashMap<String, Integer>();
	PriorityQueue<Word> queue = new PriorityQueue<Word>();

	public static void main(String[] args) {
		SelectionProblem test = new SelectionProblem();
		try {
			long total = test.readWords("EULAMS-ANSI.txt");
			System.out.println("total words = " + total);

		} catch (IOException e) {
			System.out.println("File related error, check file path");
			System.out.println("Running in " + System.getProperty("user.dir"));

			e.printStackTrace();
		}

	}

	public long readWords(String fileName) throws IOException {

		File textFile = new File(fileName);
		FileReader reader = new FileReader(textFile);
		BufferedReader breader = new BufferedReader(reader);

		long total = 0;
		String line;
		while ((line = breader.readLine()) != null) {
			countWords(line);
		}

		// need a list of Word objects
		List<Word> words = new ArrayList<Word>();
		for (Entry<String, Integer> entry : map.entrySet()) {
			//System.out.println("add to list " + entry.getKey() + ":" + entry.getValue());
			words.add(new Word(entry.getKey(), entry.getValue()));
		}

		findKthLeastUsedWords(words, 10);

		System.out.println("Result least used kth words.");
		while (!queue.isEmpty()) {
			Word word = queue.poll();
			System.out.println(word);
		}

		breader.close();
		return total;
	}

	private int countWords(String line) {
		String[] words = line.split("\\s+");
		for (String word : words) {
			int count = 1;
			String lword = word.trim().toLowerCase();
			if (map.containsKey(lword)) {
				count = map.get(lword) + 1;
			}
			//System.out.println(lword + ":" + count);
			map.put(lword, count);
		}

		return words.length;
	}

	/**
	 * Unique words with the lowest count accumulates in the priority queue.
	 * 
	 * @param words
	 * @param numToFind
	 */
	private void findKthLeastUsedWords(List<Word> words, int numToFind) {
		for (Word word : words) {
			// queue only up to numToFind words
			if (queue.size() < numToFind) {
				System.out.println("Adding to queue " + word);
				queue.add(word);
			} else {
				if (word.compareTo(queue.peek()) > 0) {
					// replace if incoming word has lower count than the lowest word queued
					
					Word other = queue.poll();
					System.out.println("Replacing " +  other + " with " + word);
					
					queue.add(word);
				}
			}
		}

	}

}
