package com.amaze.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
/*
 * Given an input stream of n integers, find the kth largest element for each element in the stream.
 */
/*
 * Input:
2
4 6
1 2 3 4 5 6
1 2
3 4

Output:
-1 -1 -1 1 2 3
3 4 
 */
public class KthLargest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		 System.out.println(k + " " + n);
		 System.out.println(Arrays.toString(a));

		kthMax(k, n, a);
	}
/*
 * initialize pq and i =0
 * loop till i < k-1
 * 		add a[i] to pq
 * 		sysout -1
 * add a[i] to pq
 * sysout pq.peek
 * loop i from k to n
 * 		if a[i] > pq.peek()
 * 			poll from pq and add a[i] to pq
 * 		sysout pq.peek
 */
	private static void kthMax(int k, int n, int[] a) {
		PriorityQueue<Integer> min = new PriorityQueue<>();
		int i = 0;
		for (i = 0; i < k - 1; i++) {
			min.add(a[i]);
			System.out.print(-1 + " ");
		}
		min.add(a[i]);
		System.out.print(min.peek() + " ");
		for (i = k; i < n; i++) {
			if(a[i] > min.peek()) {
				min.poll();
				min.add(a[i]);
			}
			System.out.print(min.peek() + " ");
		}
	}

}
