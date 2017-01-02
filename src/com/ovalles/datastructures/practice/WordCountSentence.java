package com.ovalles.datastructures.practice;

import java.util.HashMap;
import java.util.Map;


/**
 * Solution splits the words using String.split() and uses HashMap data structure to save the word count.
 * 1) Ensure word is normalize to compare same words( clarify before coding) is The = the?
 * 2) Ensure code uses Map interface, is show you know the different between HashMap and Map
 * 3) Loop thru the Map interface correctly.
 * Follow up questions:
 *    HashMap vs HashTable- site at least four difference
 *    How many words can the map contain? Can it count a 1000 page book in a text file?
 * @author Edward
 *
 */
public class WordCountSentence {
	
	public static void main(String[] args) {
		String test = "The quick brown fox jumped, over the lazy dogs, twice."
		            + " The quick brown fox jumped, over the lazy dogs, twice."
		            + " The quick brown fox jumped, over the lazy dogs, twice.";
		Map<String, Integer> wordMap = WordCountSentence.countWords(test);
		WordCountSentence.printMap(wordMap);
		
		String emptyTest = "";
		Map<String, Integer> wordMapEmpty = WordCountSentence.countWords(emptyTest);
		WordCountSentence.printMap(wordMapEmpty);

	}
	
	/** Given a sentence count the unique words by
	 * displaying :
	 * word -> n
	 * the -> 3
	 * rabbit -> 1
	 * @param - an English sentence delimited by spaces and terminated with a period.
	 */
	public static Map<String,Integer>  countWords(String sentence)  {
		// null check
		if(sentence == null) throw new IllegalArgumentException("Parameter sentence cannot be null");
		
		Map<String, Integer> wordMap = new HashMap<String, Integer>();
		
		//String[] words = sentence.split(" ");   //1st iteration , split on spaces only
		String[] words = sentence.split("\\s+"); // splits on whitespaces - tabs
		
		for(String word : words) {
			int count = 1;
			// count case insensitive
			String lword = word.toLowerCase();
			// carefull with replaceAll, arguement is regex
			lword = lword.replace(".","");
			lword = lword.replace(",","");
			lword = lword.trim();
			
			if(wordMap.containsKey(lword)) {
				count = wordMap.get(lword) + 1;
			}
			// updates count for unique keys - word
			System.out.println("put " + lword + ": " + count);
			wordMap.put(lword,new Integer(count));
			
		}
		
		return wordMap;
	}
	
	public static void printMap(Map<String,Integer> map) {
		for(java.util.Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		} 
	}

}
