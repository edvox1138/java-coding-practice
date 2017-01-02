package com.ovalles.datastructures.practice;

/*
 * Point represents the x,y coordinates in a Cartesian plane.
 */
public class Point implements Comparable<Point>  {
	private double x;
	private double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	/**
	 * Distance of this point from the origin point(0,0)
	 * @return double
	 */
	public double distanceFromOrigin() {
		return Math.sqrt((Math.pow(x, 2) + Math.pow(y,2)));
	}
	
	public double distanceFromOtherPoint(Point p) {
		double a = x - p.getX();
		double b = y - p.getY();
		return Math.sqrt((Math.pow(a, 2) + Math.pow(b, 2)));
	}

	@Override
	public String toString() {
		return("(" + x + "," + y + ")");
				
	}
	
	/**
	 * Application sensitive semantics,defines this
	 *  method in association with the use of PriorityQueue.
	 * @param object
	 * @return
	 */
	@Override
	public int compareTo(Point other) {
		double diff = (distanceFromOrigin() - other.distanceFromOrigin());
		if(diff == 0.0) return 0;
		return(diff > 0.0 ? 1 : -1);
	}

}
