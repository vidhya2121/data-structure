package com.stack_queues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class MaxSubArrays {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
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
			// maxSun(arr, arr.length, k);
			maxSunOpt(arr, arr.length, k);
		}

	}

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

	private static void maxSun(int[] a, int n, int k) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i <= n - k; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = i; j < i + k; j++) {
				if (a[j] > max) {
					max = a[j];
				}
			}
			sb.append(max + " ");
		}
		System.out.println(sb);
	}

}
