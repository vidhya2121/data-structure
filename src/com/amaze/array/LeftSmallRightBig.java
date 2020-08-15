package com.amaze.array;

public class LeftSmallRightBig {

	public static void main(String[] args) {
		/*
		 * Given an unsorted array of size N. Find the first element in array such that all of its
		 *  left elements are smaller and all right elements to it are greater than it.
		 */
		/*
		 * Input:
				3
				4
				4 2 5 7
				3
				11 9 12
				6
				4 3 2 7 8 9
				
			Output:
				5
				-1
				7
		 */
		int n = 4;
		int arr[] = { 1, 4, 2, 5 };
		/*
		 * initialize leftMax array, with first element as min value
		 * loop from 1 to n
		 * 		leftMax[i] = max(leftMax[i-1], a[i-1]
		 * set rightMin as max value
		 * loop from n-1 to 0
		 * 		if left max < ele and rightmin > ele
		 * 			res = ele
		 * 		rightMin = main(rightMin, ele)
		 */
		leftRight(arr, n);
	}

	private static void leftRight(int[] a, int n) {
		int[] leftMax = new int[n]; 
        leftMax[0] = Integer.MIN_VALUE;
		for (int i = 1; i < n; i++) {
			leftMax[i] = Math.max(leftMax[i-1], a[i-1]);
		}
		int rightMin = Integer.MAX_VALUE; 
		int res = -1;
		for (int i = n-1; i >= 0 ; i--) {
			if(leftMax[i] < a[i] && rightMin > a[i]) {
				res = a[i];
			}
			rightMin = Math.min(rightMin, a[i]);
		}
		System.out.println(res);
	}

}
