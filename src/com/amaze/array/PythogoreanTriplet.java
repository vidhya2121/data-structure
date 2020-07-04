package com.amaze.array;

import java.util.Arrays;

public class PythogoreanTriplet {

	public static void main(String[] args) {

		int arr[] = { 3, 2, 4, 6, 5 };
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
				//System.out.println(sqA[j] + " " + sqA[k] + " "+ sqA[i]);
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
