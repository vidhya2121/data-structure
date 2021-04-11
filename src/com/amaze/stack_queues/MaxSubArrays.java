package com.amaze.stack_queues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class MaxSubArrays {
/*
 * Given an array A and an integer K. Find the maximum for each and every contiguous subarray of size K.
 */
	/*
	 * Example:
		Input:
			2
			9 3
			1 2 3 1 4 5 2 3 6
			10 4
			8 5 10 7 9 4 15 12 90 13
			
		Output:
			3 3 4 5 5 5 6
			10 10 10 15 15 90 90
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
		while (t-- > 0) {
			String v[] = br.readLine().trim().split(" ");
			int n = Integer.parseInt(v[0]);
			int k = Integer.parseInt(v[1]);
			int arr[] = new int[n];
			String inputLine[] = br.readLine().trim().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(inputLine[i]);
			}
			maxSunOpt(arr, arr.length, k);
		}

	}
	/*
	 * have a deque(will add index to q) q and d are same in my explanation
	 * i = 0
	 * loop i from 0 to k
	 * 		while q not empty and a[i] > a[d.peekLast()]
	 * 			pollLast from q
	 * 		add i to q
	 * loop for i till i < n
	 * 		add a[d.peek()] to res
	 * 		while d not empty and i - k >= d.peekFirst()
	 * 			pollFirst from d (this ensures the current window)
	 * 		while d is not empty and a[i]>a[d.peekLast()]
	 * 			pollLast from q
	 * 		add i to q
	 * add a[d.peek()] to res
	 */
	private static void maxSunOpt(int[] a, int n, int k) {
		Deque<Integer> d = new LinkedList<>();
		StringBuffer sb = new StringBuffer();
		int i = 0;
		for (i = 0; i < k; i++) {
			while (!d.isEmpty() && a[i] > a[d.peekLast()]) {
				d.pollLast();
			}
			d.add(i);
		}
		for (; i < n; i++) {
			sb.append(a[d.peek()] + " ");
			while (!d.isEmpty() && i - k >= d.peekFirst()) {
				d.pollFirst();
			}
			while (!d.isEmpty() && a[i] > a[d.peekLast()]) {
				d.pollLast();
			}
			d.add(i);
		}
		sb.append(a[d.peek()]);
		System.out.println(sb);
	}

}
