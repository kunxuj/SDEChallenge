package com.paytm.codechallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.paytm.codechallenge.movingaverage.*;

/**
 * This is the main entry class for using Moving Average Calculation classes
 * 
 * @author JX
 *
 * @version 0.0.1
 */

public class MovingAverageApp {

	public static void main(String[] args) {
		
		int window_size = 3; 
	    List<Double> list = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0);    
		MovingAverage<Double> movingAverage_list = new MovingAverageImpl(window_size);
		movingAverage_list.setElements(list);
		List<Double> averageList = movingAverage_list.calculateMovingAverage();
		
		System.out.println("---moving average for a list--"); 
  	             
		averageList.stream()
		           .forEach(x -> System.out.println("moving average for last " 
	   	                         + window_size + " elements: " + x));

	   	System.out.println(movingAverage_list.getElements());
	   	
		System.out.println("---moving average for a sequence of numbers--"); 
	   	MovingAverage<Double> movingAverage_sequence = new MovingAverageImpl(window_size);
	   	System.out.println(movingAverage_sequence.addElement(1d));
	   	System.out.println(movingAverage_sequence.addElement(2d));
	   	System.out.println(movingAverage_sequence.addElement(3d));
	   	System.out.println(movingAverage_sequence.addElement(4d));
	   	System.out.println(movingAverage_sequence.addElement(5d));
	   	System.out.println(movingAverage_sequence.addElement(6d));
	   	System.out.println(movingAverage_sequence.addElement(7d));
	   	System.out.println(movingAverage_sequence.addElement(8d));

		System.out.println("---moving average for a stream of numbers--"); 
	   	MovingAverage<Double> movingAverage_stream = new MovingAverageImpl(window_size);
	   	list.stream()   	     
	   	     .map(a -> movingAverage_stream.calculateMovingAverage(a))
	   	     .filter(b -> b != null)
	   	     .forEach(c -> System.out.println(c));
	}
}
