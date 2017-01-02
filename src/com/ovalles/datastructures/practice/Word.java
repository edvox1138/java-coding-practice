package com.ovalles.datastructures.practice;

/**
 * Value object to queue up word based on its word count.
 * @author Edward
 *
 */
public class Word implements Comparable<Word>{
	private String word;
	private int count;
	
	Word(String word, int count) {
		this.word = word;
		this.count = count;
	}
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return (word + ":" + count);
	}

	@Override
	/**
	 * compareTo semantics is for priority queue scenario
	 * 
	 * returns -1 if other word has higher count
	 *          0 if word has same count
	 *          1 if other word has lower count
	 */
	public int compareTo(Word other) {
		if(this.count == other.getCount()) return 0;
		
		return (this.count > other.getCount() ? 1 : -1 );
	}
	
	@Override
	/**
	 * Ensure equals and compareTo semantics behaves the same.
	 * Sorting functions might have unexpected results.
	 * Effective Java: Item 8 Obey the general contract in override equals
	 */
	public boolean equals(Object object) {
		if(!(object instanceof Word )) return false;
		Word other = (Word) object;
		
		return (this.word.equals(other.getWord()) && this.count == other.getCount());
	}
	
	@Override
	/**
	 * Effective Java: Item 9 Always override hashcode when you override equals()
	 */
	public int hashCode() {
		int hashcode = 31 * count;
		return hashcode * this.word.hashCode();
	}

}
