package com.array;

public class MinimunInSortedArray {

	public static void main(String[] args) {
		int arr[] = { 3, 4, 5, 6, 7, 1, 2 };
		// int pivot = 0;
		// for (int i=0;i<arr.length-1;i++) {
		// if(arr[i]>arr[i+1]) {
		// pivot = i+1;
		// }
		// }
		System.out.println(min(arr,arr.length,0,arr.length-1));
		// System.out.println(arr[pivot]);

	}

	public static int min(int arr[], int n, int low, int high) {
		if (low > high)
			return arr[0];
		if (low == high)
			return arr[low];

		int mid = (low + high) / 2;

		if (mid < high && arr[mid] > arr[mid + 1])
			return arr[mid + 1];
		if (mid > low && arr[mid - 1] > arr[mid])
			return arr[mid];

		if (arr[high] > arr[mid]) {
			return min(arr, n, low, mid - 1);
		}

		return min(arr, n, mid + 1, high);

	}

}
