package com.amaze.array;

import java.util.Arrays;

public class CountTriplets {

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6, 7 };

		// int sumTwo = 0;
		// int count = 0;
		// int n = a.length;
		// for (int i = 0; i < n - 1; i++) {
		// for (int k = i + 1; k < n; k++) {
		// sumTwo = a[i] + a[k];
		// for (int j = 0; j < n; j++) {
		// if (a[j] == sumTwo) {
		// count++;
		// break;
		// }
		// }
		// }
		//
		// }
		// System.out.println(count == 0 ? -1 : count);

		int n = a.length;
		int count = 0;
		Arrays.sort(a);
		int k = n - 1;
		while (k >= 0) {
			int i = 0, j = k - 1;
			while (i < j) {
				if (a[i] + a[j] == a[k]) {
					count++;
					i++;
					j--;
				} else if (a[i] + a[j] > a[k]) {
					j--;
				} else {
					i++;
				}
				
			}
			k--;
		}
		System.out.println(count == 0 ? -1 : count);
	}

}
