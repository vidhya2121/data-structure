package com.array;

public class BinarySearchRotated {

	public static void main(String[] args) {
		int arr[] = { 3, 4, 5, 6, 7, 1, 2 };
		int key = 0;
		pivotedSearch(arr, key);

	}

	private static void pivotedSearch(int[] arr, int key) {
		int pivot = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[pivot] < arr[i]) {
				pivot = i;
			}
		}
		int x = pivot;
		if (arr[x] == key) {
			System.out.println(x);
			return;
		} else if (arr[0] > key) {
			System.out.println(search(arr, x + 1, arr.length - 1, key));
			return;
		}
		System.out.println(search(arr, 0, x - 1, key));
		return;
	}

	public static int search(int arr[], int left, int right, int key) {
		if (left > right)
			return -1;
		int mid = (left + right) / 2;
		if (key == arr[mid]) {
			return mid;
		}
		if (arr[mid] > key) {
			return search(arr, left, mid - 1, key);
		}
		return search(arr, mid + 1, right, key);
	}

}
