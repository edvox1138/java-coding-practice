package com.ovalles.datastructures.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Note:
 * PriorityQueue is not thread safe, use PriorityBlockingQueue.
 * Farthest point value can be any priority value based on metrics to track and display.
 * 1) Number of least used words.
 * 2) Most visit sequence of web pages.
 * 3) Most ordered product by customers.
 * 4) Most busiest time range for orders.
 * PriorityQueue is implemented internally with PriorityHeap.
 * 
 * @author Edward Ovalles
 * 
 * "The truncated top of an immense sorted list is in many ways the ultimate
 *    universal user interface." - Algorithms to Live By, B. Christians and T. Griffiths.
 *
 */
public class PointsFromOrigin {

	public static void main(String[] args) {
		List<Point> points = PointsFromOrigin.generateTestData();
		
		int numToFind = 3;
		List<Point> farthest = PointsFromOrigin.findFarthestPoints(points, numToFind);
		
		// k-th elements of any items - possible dashboard metrics 
		System.out.println("Farthest " + numToFind + " points.");
		for(Point point : farthest) {
			System.out.println(point +  " : " + String.format("%.2f",point.distanceFromOrigin()));
		}
	}

	/**
	 * Find the k-th farthest point from a list of points.
	 * @param points
	 * @param numToFind
	 * @return
	 */
	public static List<Point> findFarthestPoints(List<Point> points, int numToFind) {
	    PriorityQueue<Point> queue = new PriorityQueue<Point>();
	    
	    for(Point point : points) {
	    	if(queue.size() < numToFind) {
	    		queue.add(point);
	    	}
	    	else {
	    		// replace a least farthest point if new point is farther
	    		if(point.compareTo(queue.peek()) > 0) {
	    			queue.poll();
	    			queue.add(point);
	    		}
	    		else {
	    			queue.add(point);
	    		}
	    	}
	    }
	    
	    List<Point> farthest = new ArrayList<Point>();
	    while(!queue.isEmpty()) {
	    	farthest.add(queue.poll());
	    }
		return farthest;
	}
	
	private static List<Point> generateTestData() {
		List<Point> points = new ArrayList<Point>();
		
		for(int i = 0; i < 100; i++){
			double y = 5.0;
			y = y + i;
			points.add( new Point((double)i, y));
		}
		return points;
	}

}
