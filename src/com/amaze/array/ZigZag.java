package com.amaze.array;

import java.util.Arrays;

public class ZigZag {

	public static void main(String[] args) {
		/*
		 * Given an array A (distinct elements) of size N. Rearrange the elements of array in zig-zag fashion. 
		 * The converted array should be in form a < b > c < d > e < f.
		 *  The relative order of elements is same in the output i.e you have to iterate on the original array only.
		 */
		/*
		 * Input:
				2
				7
				4 3 7 8 6 2 1
				4
				1 4 3 2
			Output:
				3 7 4 8 2 6 1
				1 4 2 3
		 */
		int arr[] = {1, 4, 3, 2 ,7,9,8,5};
		int n = arr.length;
		/*
		 * loop from 0 to n-1
		 * 		if index is even
		 * 			it should be like current should be less than next(a<b>c<d), swap if now
		 * 		else
		 * 			rev
		 */
		zigZag(arr, n);
	}

	private static void zigZag(int[] a, int n) {
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < n - 1; i++) {
			if (i % 2 == 0) {
				if (a[i] > a[i + 1]) {
					int t = a[i];
					a[i] = a[i + 1];
					a[i + 1] = t;
				}
			} else {
				if (a[i] < a[i + 1]) {
					int t = a[i];
					a[i] = a[i + 1];
					a[i + 1] = t;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			str.append(a[i] + " ");
		}
		System.out.println(str);
	}

}
