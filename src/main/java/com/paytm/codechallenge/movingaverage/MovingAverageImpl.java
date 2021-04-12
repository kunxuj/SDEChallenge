package com.paytm.codechallenge.movingaverage;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * This class use the sliding window algorithm to implement MovingAverage.
 * Assuming calculated elements are Double Type
 * 
 * 
 * @author JX
 *
 * @version 0.0.1
 */
public class MovingAverageImpl implements MovingAverage<Double> {
	
	// the list for storing added elements; 
	List<Double> list;
	// The size of the sliding window
	private int wsize;

	// Using a Queue to store elements in the sliding window
	private Queue<Double> wqueue;

	// the result for calculated moving average
	private Double wsum;

	public MovingAverageImpl(int n) {
		if (n <= 0)
			throw new IllegalArgumentException("The size for moving "
					+ "average calculation should be great than zero");
		this.wsize = n;
		this.wqueue = new LinkedList<Double>();
		this.wsum = 0d;
		this.list = new ArrayList<Double>();
	}
	
    public List<Double> calculateMovingAverage() {
    	List<Double> averageList = new ArrayList<>();
    	for(int i = 0; i <  list.size(); i++) {
    		Double sum = calculateMovingAverage(list.get(i));
    		if(sum != null) averageList.add(sum);
    	}  
    	return averageList;
    }
    
	public Double calculateMovingAverage(Double lastElement) {
	
		wsum += lastElement;
		wqueue.offer(lastElement);
		if (wqueue.size() > wsize)
        {
            wsum -= wqueue.poll();
        }
		if (wqueue.size() < 3) return null;
		
		return wsum/wsize;
	}

	public Double addElement(Double element) {
		list.add(element);
		return calculateMovingAverage(element);
	}
	
	public void setElements(List<Double> elements) {
		list = elements;
	}

	public Double getElement(int i) {
		return list.get(i);
	}	
	
	public List<Double> getElements() {
		return list;
	}

}
