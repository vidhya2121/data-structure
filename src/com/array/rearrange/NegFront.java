package com.array.rearrange;

import java.util.Arrays;

public class NegFront {

	public static void main(String[] args) {

		int arr[] = { -12, 11, -13, -5, 6, -7, 5, -3, -6 };
		int n = arr.length;

		for (int i = 1; i < n; i++) {
			int key = arr[i];
			if (key > 0) continue;
			int j = i -1;
			while(arr[j] > 0 && j>=0) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
		System.out.println(Arrays.toString(arr));
	}

}
