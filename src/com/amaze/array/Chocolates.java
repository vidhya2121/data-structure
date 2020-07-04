package com.amaze.array;

import java.util.Arrays;

public class Chocolates {

	public static void main(String[] args) {

		int n = 9;
		int arr[] = { 17, 83, 59, 25, 38, 63, 25, 1, 37 };
		int m = 9;
		choco(arr, n, m);
	}

	private static void choco(int[] a, int n, int m) {
		Arrays.sort(a);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (i + m <= n && (a[i + m - 1] - a[i] < min)) {
				min = a[i + m - 1] - a[i];
			}
		}
		System.out.println(min);
	}

}
