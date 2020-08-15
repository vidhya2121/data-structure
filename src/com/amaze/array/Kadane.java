package com.amaze.array;

public class Kadane {

	public static void main(String[] args) {
		/*
		 * Given an array arr of N integers. Find the contiguous sub-array with maximum
		 * sum.
		 */
		/*
		 * Input
			2
			5
			1 2 3 -2 5
			4
			-1 -2 -3 -4
		   Output
			9
			-1
		 */
		int arr[] = { 1, 2, 3, -2, -1, 3, 4, -78, 1, 2, 3, 4 };
		/*
		 * Intialize sum and prev_sum to a[0]
		 * loop from 1 to n
		 * 		if element > 0 and sum < 0 , make sum as 0
		 * 		add element to the sum
		 * 		if sum > prev_sum make prev_sum as the sum
		 * 		if sum < 0 make sum as 0		 * 
		 */
		int sum = arr[0], prev_sum = arr[0];
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			if (arr[i] > 0 && sum < 0)
				sum = 0;
			sum += arr[i];
			if (sum > prev_sum) {
				prev_sum = sum;
			}
			if (sum < 0)
				sum = 0;
		}
		System.out.println(prev_sum);
	}

}
