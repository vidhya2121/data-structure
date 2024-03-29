package com.amaze.heap;

import java.util.Iterator;
import java.util.PriorityQueue;

public class SortK {
/*
 * sort almost sorted array
 */
	/*
	 * pq
	 * for i<0 to i<k+1
	 * 		add a[i] to pq
	 * j=0
	 * for i from k+1 to n
	 * 		a[j] = poll from pq
	 * 		j++
	 * 		add a[i] to pq
	 * add remaining from pq to array
	 */
	public static void main(String[] args) {
		int k = 3;
		int arr[] = { 2, 6, 3, 1, 56, 8 };
		int n = arr.length;
		kSort(arr, n, k);
		System.out.println("Following is sorted array");
		printArray(arr, n);

	}

	private static void printArray(int[] arr, int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

	private static void kSort(int[] arr, int n, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < k + 1; i++) {
			pq.add(arr[i]);
		}
		int j = 0;
		for (int i = k + 1; i < n; i++) {
			arr[j++] = pq.peek();
			pq.poll();
			pq.add(arr[i]);
		}
		Iterator<Integer> it = pq.iterator();
		while (it.hasNext()) {
			arr[j++] = pq.peek();
			pq.poll();
		}
		// PriorityQueue<Integer> pp = new PriorityQueue<>();
		// for (int i = 0; i < n; i++) {
		// pp.add(arr[i]);
		// }
		// int j = 0;
		// Iterator<Integer> it = pp.iterator();
		// while (it.hasNext()) {
		// arr[j++] = pp.peek();
		// pp.poll();
		// }
	}

}
