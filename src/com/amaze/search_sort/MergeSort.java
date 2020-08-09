package com.amaze.search_sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int a[] = { 5, 7, 3, 2, 6, 1, 8, 4 };
		MergeSort ob = new MergeSort();
		ob.mergeSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}

	private void mergeSort(int[] a, int l, int r) {
		if (l < r) {
			int mid = (l + r) / 2;
			mergeSort(a, l, mid);
			mergeSort(a, mid + 1, r);
			merge(a, l, mid, r);
		}
	}

	private void merge(int[] a, int l, int mid, int r) {
		int n1 = mid - l + 1;
		int n2 = r - mid;
		int temp1[] = new int[n1];
		int temp2[] = new int[n2];
		for (int i = 0; i < n1; i++) {
			temp1[i] = a[i + l];
		}
		for (int i = 0; i < n2; i++) {
			temp2[i] = a[i + mid + 1];
		}
		int i = 0;
		int j = 0;
		int k = l;
		while (i < n1 && j < n2) {
			if (temp1[i] < temp2[j]) {
				a[k] = temp1[i];
				i++;
			} else {
				a[k] = temp2[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			a[k] = temp1[i];
			i++;
			k++;
		}
		while (j < n2) {
			a[k] = temp2[j];
			j++;
			k++;
		}
	}

}
