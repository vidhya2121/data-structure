package com.amaze.array;

import java.util.Arrays;

public class ReverseArrayGroups {

	public static void main(String[] args) {
		/*
		 * Given an array arr[] of positive integers of size N. Reverse every sub-array of K group elements.
		 */
		/*
		 * Input
				2
				5 3
				1 2 3 4 5
				6 2
				10 20 30 40 50 60
				
			Output
				3 2 1 5 4
				20 10 40 30 60 50
		 */
		int a[] = { 10, 20, 30, 40, 50, 60 };
		/*
		 *  loop from 0 to n increments by i+k
		 *  	left is i and right is min(i+k,n)-1
		 *  	while left < right
		 *  		swap left and right
		 *  		increment left and decrement right
		 */
		reverseGroup(a, a.length, 3);
		
	}

	private static void reverseGroup(int[] a, int n, int k) {

		for (int i = 0; i < n; i += k) {
			int l = i;
			int r = Math.min(i + k, n) - 1;
			while (l < r) {
				int t;
				t = a[l];
				a[l] = a[r];
				a[r] = t;
				l++;
				r--;
			}
		}
		System.out.println(Arrays.toString(a));
	}
}
