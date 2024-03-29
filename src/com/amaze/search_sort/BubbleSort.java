package com.amaze.search_sort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int a[] = { 5, 7, 3, 2, 6, 1, 8, 4 };
		bubbleSort(a, a.length);
	}
	/*
	 * ensures that at end of each iteration, largest number is placed last
	 */
/*
 * loop 0 to length - 1
 * 		loop 0 to length - 1 - i
 * 			if(a[j+1] < a[j])
 * 				swap(j+1,j)
 */
	private static void bubbleSort(int[] a, int length) {
		for (int i = 0; i < length - 1; i++) {
			for (int j = 0; j < length - 1 - i; j++) {
				if (a[j + 1] < a[j]) {
					int t = a[j];
					a[j] = a[j + 1];
					a[j + 1] = t;
				}
			}
		}
		System.out.println(Arrays.toString(a));
	}

}
