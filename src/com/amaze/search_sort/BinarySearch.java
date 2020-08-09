package com.amaze.search_sort;

public class BinarySearch {

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int res = binarySearch(a, 0, a.length, 7);
		System.out.println(res);
	}

	private static int binarySearch(int[] a, int s, int e, int key) {
		int mid = (s + e) / 2;
		if (s >= e) {
			return -1;
		}
		if (a[mid] == key) {
			return mid;
		} else if (key > a[mid]) {
			return binarySearch(a, mid + 1, e, key);
		}
		return binarySearch(a, s, mid, key);
	}

}
