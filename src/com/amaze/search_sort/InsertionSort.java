package com.amaze.search_sort;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int a[] = { 7,5, 3, 2, 6, 1, 8, 4 };
		insertionSort(a, a.length);
	}
	/*
	 * after each iteration place it in right place
	 * loop from 1 to n
	 * 		k = a[i]
	 * 		j = i - 1
	 * 		while j>=0 and a[j]>k
	 * 			a[j+1] = a[j]
	 * 			j--
	 * 		a[j+1] = k
	 */

	private static void insertionSort(int[] a, int n) {
		for (int i = 1; i < n; i++) {
			int k = a[i];
			int j = i - 1;
			while (j >= 0 && a[j] > k) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = k;
		}
		System.out.println(Arrays.toString(a));
	}

}
