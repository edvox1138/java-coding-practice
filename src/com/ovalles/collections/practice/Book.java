package com.ovalles.collections.practice;

/**
 * Book class, sorted by title
 * Objects without nutural ordering requires
 *   to implement Comparable to be sorted
 *   by Collections.sort()
 * @author Edward
 *
 */
public class Book implements Comparable {
	private String title;
	private String author;
	private String subject;
	private String ISBN;
	
	Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append(title);
		buf.append(" by " + author);
		return buf.toString();
	}

	@Override
	public int compareTo(Object other) {
		Book book = (Book) other;
		return this.title.compareTo(book.getTitle());
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
