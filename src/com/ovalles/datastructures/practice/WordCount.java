package com.ovalles.datastructures.practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCount {
	// How many words can this map take? Current use English words 171,476 words.
	private Map<String, Integer> wordMap = new HashMap<String, Integer>();

	public static void main(String[] args) {

		WordCount test = new WordCount();
		try {
			long total = test.readWords("EULAMS-ANSI.txt");
			System.out.println("total words = " + total);
			System.out.println(" unique words = " + test.uniqueCount(
					));
			
		} catch (IOException e) {
			System.out.println("File related error, check file path");
			System.out.println("Running in " + System.getProperty("user.dir"));
			
			e.printStackTrace();
		}
	}
	
	public long uniqueCount() {
		return wordMap.size();
	}

	public long readWords(String fileName) throws IOException {

		File textFile = new File(fileName);
		FileReader reader;
		BufferedReader breader = null;
		long total = 0;
		
		try {
			reader = new FileReader(textFile);
			breader = new BufferedReader(reader);
			
			String line;
			while ((line = breader.readLine()) != null) {
				total += countWords(line);
			}

		} finally {
			// ensure file I/O resources are closed
			if(breader != null)
			    breader.close();
		}
		
		return total;
	}
	
	
	/**
	 * Count unique words, case insensitive.
	 * 1) Split text in whitespaces.
	 * 2) Normalize word as lowercase without comma, periods.
	 * 3) What is the max words before the in memory map blows up?
	 * @param line
	 * @return
	 */
	private int countWords(String line) {
		String[] words = line.split("\\s+");
		for(String word : words) {
			int count = 1;
			String lword = word.trim().toLowerCase();
			if(wordMap.containsKey(lword)) {
				count = wordMap.get(lword) + 1;
			}
			wordMap.put(lword, count);
		}
		
		return words.length;
	}

}
