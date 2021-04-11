package com.amaze.search_sort;

public class LinearSearch {
/*
 * loop 0 to length
 * 		if a[i] == key
 * 			return i
 */
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6 };
		linearSearch(a, a.length, 9);
	}

	private static void linearSearch(int[] a, int n, int key) {
		for (int i = 0; i < n; i++) {
			if (a[i] == key) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
	}

}
