package com.ovalles.datastructures.practice;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ovalles.datastructures.practice.Point;

/**
 * Example Unit test for Point object.
 * Unit test Java file are physically separated, but compiled into the same package 
 *   as the class under test.
 * Each test is independent of other test. Test order can run in any order.
 * Each test assert standardized on Assert.assertTrue().
 * @author Edward Ovalles
 *
 */
public class PointTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Called only once per test run.");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Called for every test.");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPoint() {
		Point point = new Point(1.0,2.0);
		Assert.assertTrue("Can create Point object", point != null);
	}

	@Test
	public void testGetX() {
		double expected = 4.5;
		Point point = new Point(expected, -4.8);
		double result = point.getX();
		Assert.assertTrue("getter test", result == expected);
	}

	@Test
	public void testSetX() {
		double expected = 4.5;
		Point point = new Point(9.0, expected);
		point.setX(expected);
		double result = point.getX();
		Assert.assertTrue("getter test x", result == expected);
	}

	@Test
	public void testGetY() {
		double expected = 4.5;
		Point point = new Point(100.0,expected);
		double result = point.getY();
		Assert.assertTrue("getter test y", result == expected);
	}

	@Test
	public void testSetY() {
		double expected = 4.57;
		Point point = new Point(9.0, expected);
		point.setY(expected);
		double result = point.getY();
		Assert.assertTrue("setter test y", result == expected);
	}

	@Test
	public void testDistanceFromOrigin() {
		double expected = 12.3;
		Point point = new Point(0, expected);
		double result = point.distanceFromOrigin();
		Assert.assertTrue("y value only", result == expected);
	}

	@Test
	public void testDistanceFromOtherPoint() {
		double expected = 12.00;
		Point point = new Point(0.00, expected);
		double result = point.distanceFromOtherPoint(new Point(0.0,0.0));
		Assert.assertTrue("test distance formula", result == expected);
	}

	@Test
	public void testToString() {
		Point point = new Point(0.0,0.0);
		String text = point.toString();
		Assert.assertTrue("toString ", text.equals("(0.0,0.0)"));
	}


	@Test
	public void testCompareToEqual() {
		Point point = new Point(12.3, 4.5);
		Point farther = new Point(12.3,4.5);
		int result = point.compareTo(farther);
		Assert.assertTrue("test farther ", result == 0);
	}
	
	@Test
	public void testCompareToFarther() {
		Point point = new Point(12.3, 4.5);
		Point farther = new Point(12.3,5.0);
		int result = point.compareTo(farther);
		Assert.assertTrue("test farther ", result == -1);
	}
	
	@Test
	public void testCompareToNearer() {
		Point point = new Point(12.3, 5.1);
		Point farther = new Point(12.3,5.0);
		int result = point.compareTo(farther);
		Assert.assertTrue("test farther ", result == 1);
	}

}
