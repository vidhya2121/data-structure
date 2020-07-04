package com.amaze.array;

public class LeftSmallRightBig {

	public static void main(String[] args) {
		int n = 4;
		int arr[] = { 4, 2, 5, 7 };

		leftRight(arr, n);
	}

	private static void leftRight(int[] a, int n) {
		boolean isMin = false;
		boolean isMax = false;
		for (int i = 1; i < n-1; i++) {
			isMin = isMini(a, 0, i);
			isMax = isMaxi(a, i + 1, n);
			if(isMax&&isMin) {
				System.out.println(a[i]);
				return;
			}
		}
		System.out.println(-1);
	}

	private static boolean isMaxi(int[] a, int i, int n) {
		int e = a[i - 1];
		for (int k = i; k < n; k++) {
			if (a[k] < e)
				return false;
		}
		return true;
	}

	private static boolean isMini(int[] a, int i, int j) {
		int e = a[j];
		for (int k = i; k < j; k++) {
			if (a[k] > e)
				return false;
		}
		return true;
	}

}
