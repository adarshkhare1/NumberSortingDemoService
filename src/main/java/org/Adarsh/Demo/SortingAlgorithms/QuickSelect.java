import java.util.Arrays;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.Adarsh.Demo.SortingAlgorithms;

public class QuickSelect {
	
	public static int selectIterative(int[] array, int n) {
		return iterative(array, 0, array.length - 1, n);
	}
	
  	private static int iterative(int[] array, int left, int right, int n) {
  		if(left == right) {
  			return array[left];
  		}
  		
  		for(;;) {
  			int pivotIndex = randomPivot(left, right);
  			pivotIndex = partition(array, left, right, pivotIndex);
  			
  			if(n == pivotIndex) {
  				return array[n];
  			} else if(n < pivotIndex) {
  				right = pivotIndex - 1;
  			} else {
  				left = pivotIndex + 1;
  			}
  		}
	}
	
	
	public static int selectRecursive(int[] array, int n) {
		return recursive(array, 0, array.length - 1, n);
	}
	
	// Returns the n-th smallest element of list within left..right inclusive
  	// (i.e. left <= n <= right).
  	// The size of the list is not changing with each recursion.
  	// Thus, n does not need to be updated with each round.
	private static int recursive(int[] array, int left, int right, int n) {
		if (left == right) { // If the list contains only one element,
			return array[left]; // return that element
		}
		
		// select a pivotIndex between left and right
		int pivotIndex = randomPivot(left, right); 
		pivotIndex = partition(array, left, right, pivotIndex);
		// The pivot is in its final sorted position
		if (n == pivotIndex) {
			return array[n];
		} else if (n < pivotIndex) {
			return recursive(array, left, pivotIndex - 1, n);
		} else {
			return recursive(array, pivotIndex + 1, right, n);
		}
	}
	
	private static int partition(int[] array, int left, int right, int pivotIndex) {
		int pivotValue = array[pivotIndex];
		swap(array, pivotIndex, right); // move pivot to end
		int storeIndex = left;
		for(int i = left; i < right; i++) {
			if(array[i] < pivotValue) {
				swap(array, storeIndex, i);
				storeIndex++;
			}
		}
		swap(array, right, storeIndex); // Move pivot to its final place
		return storeIndex;
	}
	
	private static void swap(int[] array, int a, int b) {
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}

	private static int randomPivot(int left, int right) {
		return left + (int) Math.floor(Math.random() * (right - left + 1));
	}	
  	
  	public static void main(String[] args) {
  		int[] array = {9, 8, 7, 6, 5, 0, 1, 2, 3, 4};
  		
  		for(int i = 0; i < array.length; i++) {
  			System.out.println(selectIterative(array, i));
  		}
  		
  		for(int i = 0; i < array.length; i++) {
  			System.out.println(selectRecursive(array, i));
  		}
  	}
}
