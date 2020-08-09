package com.amaze.search_sort;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int a[] = { 1,2,3,4,5,6,7,6,5,4,3,2,1};
		quickSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}

	private static void quickSort(int[] a, int l, int r) {
		int index = partition(a, l, r);
		if (l < index - 1) {
			quickSort(a, l, index - 1);
		} 
		if (r > index) {
			quickSort(a, index, r);
		}
	}

	private static int partition(int[] a, int l, int r) {
		// TODO Auto-generated method stub
		int pivot = a[(l + r) / 2];
		while (l <= r) {
			while (a[l] < pivot)
				l++;
			while (a[r] > pivot)
				r--;
			if (l <= r) {
				int t = a[l];
				a[l] = a[r];
				a[r] = t;
				l++;
				r--;
			}
		}

		return l;
	}

}
