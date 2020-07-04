package com.amaze.array;

import java.util.Arrays;

public class ZigZag {

	public static void main(String[] args) {

		int arr[] = {1, 4, 3, 2 ,7,9,8,5};
		int n = arr.length;
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
