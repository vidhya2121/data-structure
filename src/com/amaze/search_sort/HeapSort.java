package com.amaze.search_sort;

import java.util.Arrays;

public class HeapSort {
/*
 * loop from n/2 - 1 to 0
 * 		call heapify(a, n, i)
 * loop from n-1 to 0
 * 		swap a[0] and a[i]
 * 		heapify(a, i, 0)
 * heapify(arr, n ,i)
 * 		largest = i
 * 		l = 2*i + 1
 * 		r = 2*1 + 2
 * 		if l<n and a[l] > a[i]
 * 			largest = a[l]
 * 		if r<n a[r] > a[largest]
 * 			largest = a[r]
 * 		if i != largest swapand heapify(a,i,largest)
 */
	public static void main(String args[]) {
		int arr[] = { 12, 11, 13, 5, 6, 7 };
		int n = arr.length;

		HeapSort ob = new HeapSort();
		ob.sort(arr);

		System.out.println("Sorted array is");
		printArray(arr);
	}

	private static void printArray(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	private void sort(int[] arr) {
		int n = arr.length;
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}
		for (int i = n - 1; i > 0; i--) {
			int t = arr[0];
			arr[0] = arr[i];
			arr[i] = t;
			heapify(arr, i, 0);
		}
	}

	private void heapify(int[] arr, int n, int i) {
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		if (l < n && arr[l] > arr[largest]) {
			largest = l;
		}
		if (r < n && arr[r] > arr[largest]) {
			largest = r;
		}
		if (largest != i) {
			int t = arr[largest];
			arr[largest] = arr[i];
			arr[i] = t;
			heapify(arr, n, largest);
		}
	}

}
