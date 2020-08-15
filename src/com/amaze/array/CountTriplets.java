package com.amaze.array;

import java.util.Arrays;

public class CountTriplets {

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6, 7 };
		
		/*
		 * Given an array of distinct integers. 
		 * The task is to count all the triplets such that sum of two elements equals the third element.
		 */
		
		/*
		 * Input:
			2
			4
			1 5 3 2
			3
			3 2 7
		   Output:
			2
			-1
		 */

		/*
		 * sort input array
		 * start from end of array i.e k=n-1
		 * loop till 0
		 * 		have 2 pointers i=0 and j=k-1 pointing at first and last but one
		 * 		loop while i<j
		 * 			if ith + jth = kth , increment count i++ j--
		 * 			else if      >        j--
		 * 			else                  i++
		 * 		k--
		 */
		int n = a.length;
		int count = 0;
		Arrays.sort(a);
		int k = n - 1;
		while (k >= 0) {
			int i = 0, j = k - 1;
			while (i < j) {
				if (a[i] + a[j] == a[k]) {
					count++;
					i++;
					j--;
				} else if (a[i] + a[j] > a[k]) {
					j--;
				} else {
					i++;
				}
				
			}
			k--;
		}
		System.out.println(count == 0 ? -1 : count);
	}

}
