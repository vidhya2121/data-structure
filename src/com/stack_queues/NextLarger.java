package com.stack_queues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NextLarger {

	public static void main(String[] args) {

		long arr[] = { 1, 2, 3, 1 };
		nextLarger(arr, arr.length);
	}

	private static void nextLarger(long[] a, int n) {
		Stack<Long> stack = new Stack<>();
		long ans[] = new long[n];
		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && a[i] >= stack.peek()) {
				stack.pop();
			}
			ans[i] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(a[i]);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(ans[i] + " ");
		}
		System.out.println(sb);
	}

}
