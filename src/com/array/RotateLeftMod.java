package com.array;

public class RotateLeftMod {

	public static void main(String[] args) {
		int arr[] = { 3, 4, 5, 6, 7, 8, 9 };

		int k = 3;
		int start = k % arr.length;
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[(start + i) % arr.length] + " ");
		}

		rightRotRev(arr, 0, arr.length - 1);
		rightRotRev(arr, 0, k - 1);
		rightRotRev(arr, k, arr.length - 1);
		System.out.println(arr.toString());
	}

	private static void rightRotRev(int[] arr, int i, int j) {
		while (i < j) {
			int t = arr[i];
			arr[i] = arr[j];
			arr[j] = t;
			i++;
			j--;
		}
	}

}
// 7,8,9,3,4,5,6
// 6,7,8,9,3,4,5

// 9876543
// 7896543
// 7893456