package com.amaze.stack_queues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NextLarger {

	public static void main(String[] args) {
		/*
		 * Given an array A of size N having distinct elements, the task is to find the next greater element 
		 * for each element of the array in order of their appearance in the array. If no such element exists, output -1 
		 */
		/*
		 * Input
				2
				4
				1 3 2 4
				4
				4 3 2 1
			Output
				3 4 4 -1
				-1 -1 -1 -1
		 */
		long arr[] = { 1, 2, 3, 1 };
		nextLarger(arr, arr.length);
	}
	/*
	 * initialize stack and array res
	 * loop from n-1 to 0
	 * 		loop stack not empty and ele >= stack.peek
	 * 			pop from stack
	 * 		res[i] = -1 if stack is empty else it is stack.peek
	 * 		add ele to stack
	 */
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
