package com.amaze.search_sort;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int a[] = { 5, 7, 3, 2, 6, 1, 8, 4 };
		selectionSort(a, a.length);
	}
/*
 * for each iteration finds and place min at first
 */
	/*
	 * loop 0 to length-1
	 * 		min = a[i]  minIndex = i
	 * 		loop from i+1 to length
	 * 			if a[j]<min
	 * 				update min and minIndex with j's
	 * 		swap(i,minIndex)
	 * 		
	 */
	private static void selectionSort(int[] a, int length) {
		for (int i = 0; i < length - 1; i++) {
			int min = a[i];
			int minIndex = i;
			for (int j = i + 1; j < length; j++) {
				if (a[j] < min) {
					min = a[j];
					minIndex = j;
				}
			}
			int t = a[i];
			a[i] = a[minIndex];
			a[minIndex] = t;
		}
		System.out.println(Arrays.toString(a));
	}

}
