package com.paytm.codechallenge.movingaverage;

/**
 * This is the test  class for MovingAverage class unit testing 
 * 
 * @author jx
 *
 * @version 0.0.1
 */

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import com.paytm.codechallenge.*;

public class MovingAverageTest {

	private MovingAverage<Double> movingAverage;
	private double torlerance = 0.00001;


	@Before
	public void init() {
		movingAverage = new MovingAverageImpl(3);
	}

	// Test to check the count of elements added and being retrieved are same
	@Test
	public void addElementOneTest() {
		movingAverage.addElement(1d);
		movingAverage.addElement(2d);
		assertEquals(2, movingAverage.getElements().size());
	}

	// Test to check the moving average is correct if the number of elements added is
	// same as value of 'N' (3)
	@Test
	public void calculateAverageListCountEqualsNTest() {
		movingAverage.addElement(1d);
		movingAverage.addElement(2d);	
		assertEquals(2.0, movingAverage.calculateMovingAverage(3d), torlerance);
	}

	// Test to check the moving average is correct if the number of elements added is
	// more than the value of 'N'(3)
	@Test
	public void calculateAverageListCountMoreThanNTest() {
		movingAverage.addElement(1d);
		movingAverage.addElement(2d);
		movingAverage.addElement(3d);
		movingAverage.addElement(4d);
		assertEquals(4.0, movingAverage.calculateMovingAverage(5d), torlerance);
	}

	// Test to check the moving average is correct if the number of elements added is
	// less than the value of 'N'
	@Test
	public void calculateAverageListCountLessThanNTest() {
		movingAverage.addElement(1d);
		assertEquals(null, movingAverage.addElement(2d));
	}


	// Test to check that the same elements that were added can be retrieved also
	@Test
	public void getElementValidIndexTest() {
		movingAverage.addElement(1d);
		movingAverage.addElement(2d);
		movingAverage.addElement(3d);
		assertEquals(1.0, movingAverage.getElement(0), torlerance);
		assertEquals(2.0, movingAverage.getElement(1), torlerance);
		assertEquals(3.0, movingAverage.getElement(2), torlerance);
	}

}
