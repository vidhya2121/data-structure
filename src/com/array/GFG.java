package com.array;

import java.io.*;
import java.util.*;

class GFG {

	public static int nextGap(int gap) {
		if (gap <= 1)
			return 0;
		return (gap / 2);
	}

	public static void merge(int arr1[], int arr2[], int n, int m) {
		int i, j, gap = n + m, tmp;
		System.out.println(Arrays.toString(arr1) + " line 1 " + Arrays.toString(arr2));
		for (gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {
			for (i = 0; i + gap < n; i++) {
				if (arr1[i] > arr1[i + gap]) {
					tmp = arr1[i];
					arr1[i] = arr1[i + gap];
					arr1[i + gap] = tmp;
				}
			}
			System.out.println(Arrays.toString(arr1) + " line 2 " + Arrays.toString(arr2));
			for (j = gap > n ? gap - n : 0; i < n && j < m; i++, j++) {
				if (arr1[i] > arr2[j]) {
					tmp = arr1[i];
					arr1[i] = arr2[j];
					arr2[j] = tmp;
				}
			}
			System.out.println(Arrays.toString(arr1) + " line 3 " + Arrays.toString(arr2));
			if (j < m) {
				for (j = 0; j + gap < m; j++) {
					if (arr2[j] > arr2[j + gap]) {
						tmp = arr2[j];
						arr2[j] = arr2[j + gap];
						arr2[j + gap] = tmp;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		int arr1[] = { 1,3,5,7,9};
		int arr2[] = { 2,4,6,8 };
		int n = arr1.length;
		int m = arr2.length;
		merge(arr1, arr2, n, m);

		StringBuffer str = new StringBuffer();
		for (int i = 0; i < n; i++) {
			str.append(arr1[i] + " ");
		}
		for (int i = 0; i < m; i++) {
			str.append(arr2[i] + " ");
		}
		System.out.println(str);
	}
}
