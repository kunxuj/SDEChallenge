package com.paytm.codechallenge.movingaverage;

/**
 * 
 * This interface has the following operations :
 * 1) Providing moving average of the last N elements in a list 
 * 2) Providing moving average of the last N elements when add a new element 
 * 3) Add a new element in the data structure 
 * 4) Initialize or Reset all elements in the data structure
 * 5) Accessing one element at the specific location
 * 6) Accessing all elements added
 * 
 * @author JX
 *
 * @version 0.0.1
 */

import java.util.List;

public interface MovingAverage<T> {

	/**
	 * Function to return the average of last N digits
	 * for all elements in a ArrayList
	 * 
	 * 
	 * @return the average of last n digits
	 */
	public List<T> calculateMovingAverage();
	
	/**
	 * Function to return the average of last N digits
	 * when add one new element
	 * 
	 * 
	 * @return the average of last n digits
	 */
	public T calculateMovingAverage(T element);	

	/**
	 * Function to add an element to the data structure
	 * 
	 */
	public T addElement(T element);

	/**
	 * Function to set elements in the data structure
	 * 
	 */	
	public void setElements(List<T> elements);


	/**
	 * Function to access an element in the data structure
	 * 
	 * 
	 * @return an element
	 */
	public T getElement(int i);
	
	/**
	 * Function to access elements present in the data structure
	 * 
	 * 
	 * @return List containing the elements
	 */	
	public List<T> getElements();

}
