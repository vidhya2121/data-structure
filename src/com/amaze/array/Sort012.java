package com.amaze.array;

import java.util.Arrays;

public class Sort012 {

	public static void main(String[] args) {
		
		/*
		 * Given an array A of size N containing 0s, 1s, and 2s; you need to sort the array in ascending order.
		 */
		/*
		Input :
			2
			5
			0 2 1 2 0
			3
			0 1 0

		Output:
			0 0 1 2 2
			0 0 1
		*/
		int a[] = { 1, 0, 1, 2, 1, 1, 0, 0, 1, 2, 1, 2, 1, 2, 1, 0, 0, 1, 1, 2, 2, 0, 0, 2, 2, 2, 1, 1, 1, 2, 0, 0, 0,
				2, 0, 1, 1, 1, 1, 0, 0, 0, 2, 2, 1, 2, 2, 2, 0, 2, 1, 1, 2, 2, 0, 2, 2, 1, 1, 0, 0, 2, 0, 2, 2, 1, 0, 1,
				2, 0, 0, 0, 0, 2, 0, 2, 2, 0, 2, 1, 0, 0, 2, 2 };
		
		int b[] = sortSpecial(a);
		
		/*
		 * initialise low=0 mid=0 high=n-1
		 * loop for mid <= high
		 * 		if a[mid] is 0 swap mid and low and increment mid and low
		 * 		else if a[mid] is 2 swap mid and high and decrement high
		 * 		else increment mid
		 */
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<b.length;i++) {
			sb.append(b[i]+" ");
		}
		System.out.println(sb);
	}

	private static int[] sortSpecial(int[] a) {
		int n = a.length;
		int low = 0;
		int high = n - 1;
		int mid = 0;
		while (mid <= high) {
			if (a[mid] == 0) {
				int t = a[mid];
				a[mid] = a[low];
				a[low] = t;
				mid++;
				low++;
			} else if (a[mid] == 2) {
				int t = a[mid];
				a[mid] = a[high];
				a[high] = t;
				high--;
			} else {
				mid++;
			}

		}
		return a;
	}

}
