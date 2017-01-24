package com.ovalles.algorithms.practice;

/**
 * Sort by height, then by gender.
 * Example of multi category sorting.
 * 
 * @author Edward
 *
 */
public class Person implements Comparable {
	private String name;
	private Gender gender;
	private double height;
	private double weight;
	
	Person(String name, Gender gender, double height, double weight) {
		this.name = name;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
	}

	@Override
	/**
	 * Comparable method override.
	 * @return -1 if this object is less that other.
	 *          0 if objects are equal
	 *          1 if this object's order is greater than
	 *          
	 * Person's order is according to its
	 *    height property.         
	 */
	public int compareTo(Object o) {
		if( !(o instanceof Person)) {
		     throw new ClassCastException();	
		}
		Person other = (Person) o;
		
		int result = 0;
		if(this.height < other.height) {
			result = -1;
		} else {
		   if(this.height > other.height) {
			   result = 1;
		   }
		}
		
		return result;
	}
	
	@Override
	public boolean equals(Object o) {
		Person other = (Person) o;
		if(this == other) return true;
		
		return(this.height == other.height);
	}
	
	@Override
	public int hashCode() {
		int hashcode = (int) (31*height);
		return(this.name.hashCode()+hashcode);
	}
	
	@Override
	public String toString() {
		return ("["+this.name+":"+this.height+"] ");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
}
