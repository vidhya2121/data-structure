package com.amaze.array;

import java.util.Arrays;

public class PythogoreanTriplet {

	public static void main(String[] args) {
		/*
		 * Given an array of integers, write a function that returns 
		 * true if there is a triplet (a, b, c) that satisfies a2 + b2 = c2.
		 */
		/*
			Input:
			1
			5
			3 2 4 6 5
			Output:
			Yes
		 */
		int arr[] = { 3, 2, 4, 6, 5 };
		/*
		 * have a new array and put squares of a and sort it
		 * loop i from n-1 to 0
		 * 		initialize j as 0 and k as i - 1
		 * 		loop while j < k
		 * 			if square of jth and square of kth == sqaure of ith
		 * 				return true
		 * 			if > k--
		 * 			else j++
		 * return false
		 */
		boolean res = pyth(arr, arr.length);
		System.out.println(res);
	}

	private static boolean pyth(int[] a, int n) {
		int sqA[] = new int[n];
		for (int i = 0; i < n; i++) {
			sqA[i] = a[i] * a[i];
		}
		Arrays.sort(sqA);
		for (int i = n - 1; i > 1; i--) {
			int j = 0;
			int k = i - 1;
			while (j < k) {
				if (sqA[j] + sqA[k] == sqA[i]) {
					return true;
				} else if (sqA[j] + sqA[k] > sqA[i]) {
					k--;
				} else {
					j++;
				}
			}
		}
		return false;
	}

}
