package com.ovalles.algorithms.practice;

import java.util.Arrays;

//  Sorting something that you will never search is a complete waste,
//     searching something you never sorted is merely inefficient. 
//   Algorithms to Live By  -  Christian & Griffiths

/**
 * Quicksort sorting algorithm applies the divide and conquer approach. Quicksort
 *    has an advantage that it sorts in place, and on average it performs (0 n log n).
 * <p>
 * The divide and conquer approach consists of these three high-level steps:
 * <p>
 *   Divide: Divide the incoming array into two sub-arrays. It is valid to have an 
 *      empty sub-array.  This process is called partitioning.
 *      The arrData[0.. n] is  partitioned into arrData[0 .. m-1] and arrData[ m+1.. n],
 *         such that : all elements of arrData[0..m-1] <=  arrData[n]
 *                     arrData[m] <= all elements in arrData[m+1..n]
 *                     m is the computed index of the partitioning process
 *      The value of arrData[m] is called the pivot, which is used to divide the incoming array.
 *      The pivot value may be randomized by swapping any array element with the last element,
 *      before sorting.  
 * <p>     
 *   Conquer:
 *      The two sub-array becomes input to the recursive calls to the quicksort function.
 * <p>      
 *   Combine:
 *       The resulting sub-arrays are already sorted and are just combined to get the final sorted array.  
 * <p>         
 *   Worst case performance is O(n2), but on average performance is 0(n log n). Duplicate values can
 *       impact performance.
 *       
 * Note: Implementation is not thread safe, synchronization is required on the
 *   array reference, to avoid undefined behavior on multi-threaded programs.
 *     
 * @author Edward Ovalles
 *
 */
public final class QuickSort {

	public static void main(String[] args) {
		QuickSort test = new QuickSort();
		
		int[] arr = {2,1,3,4};
		System.out.println("[arr] " + Arrays.toString(arr));
		test.sort(arr);
		System.out.println("[arr sorted] " + Arrays.toString(arr));
			
		arr = generateTestData();
		System.out.println("[arr] " + Arrays.toString(arr));
		test.sort(arr);
		System.out.println("[arr sorted] " + Arrays.toString(arr));
	}
	
	private static int[] generateTestData() {
		int[] arr = new int[10];
		for(int i=0; i < 10; i++)
		{
			arr[i] = i*3;
		}
		return arr;
	}
	
	/**
	 * Sort an array of integers
	 * @param arr
	 */
	public void sort(int[]arr){
		if((arr!= null) &&( arr.length > 1)) {
		    quicksort(arr, 0, arr.length-1);
		}
	}

	private void quicksort(int[] arr, int startIndex, int endIndex)  {	
	    if(startIndex < endIndex) {
	    	int m = partition(arr, startIndex, endIndex);
	    	quicksort(arr, startIndex, m-1);
	    	quicksort(arr, m+1, endIndex);
	    }
	}
	
	/**
	 * Partition - split the array into two arrays between the pivot value.
	 *    The pivot value is the value of last element of the array.
	 * @param arr is an array of integers
	 * @param startIndex - start index
	 * @param endIndex - end index 
	 * @return returns the index of the pivot element
	 */
	private int partition(int[] arr, int startIndex, int endIndex) {
		// select the pivot values as the last array element
		int pivot = arr[ endIndex];
		int i = startIndex-1;
		for(int j = startIndex; j <= (endIndex-1); j++) {
			if(arr[j]  <= pivot) {
				i++;
				swap(arr,i,j);
			}
		}
		
		swap(arr,i+1,endIndex);	
		return i+1;
	}
	
	private void swap(int[] arr, int i, int j) {
		if (i == j) return;
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
