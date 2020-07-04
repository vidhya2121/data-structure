package com.amaze.array;

import java.util.Arrays;

public class ReverseArrayGroups {

	public static void main(String[] args) {

		int a[] = { 10, 20, 30, 40, 50, 60 };

		reverseGroup(a, a.length, 3);
		// reverse(a, a.length, 0, a.length);
		// System.out.println(Arrays.toString(a));
	}

	private static void reverseGroup(int[] a, int n, int k) {

		for (int i = 0; i < n; i += k) {
			int l = i;
			int r = Math.min(i + k, n) - 1;
			while (l < r) {
				int t;
				t = a[l];
				a[l] = a[r];
				a[r] = t;
				l++;
				r--;
			}
		}
		System.out.println(Arrays.toString(a));
	}
}
