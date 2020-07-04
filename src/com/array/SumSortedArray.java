package com.array;

public class SumSortedArray {

	public static void main(String[] args) {

		int arr[] = { 11, 15, 6, 8, 9, 10 };
		int sum = 24;

		int pivot = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[pivot] < arr[i]) {
				pivot = i;
			}
		}

		int start = (pivot + 1) % arr.length;
		int end = pivot;

		System.out.println(findSum(arr, start, end, sum));
	}

	public static boolean findSum(int[] arr, int start, int end, int sum) {
		if (start == end)
			return false;
		if (arr[start] + arr[end] == sum)
			return true;
		if (arr[start] + arr[end] > sum) {
			return findSum(arr, start, (arr.length + end - 1) % arr.length, sum);
		}
		return findSum(arr, (start + 1) % arr.length, end, sum);
	}
}
