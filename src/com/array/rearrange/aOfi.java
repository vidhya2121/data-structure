package com.array.rearrange;

import java.util.Arrays;

public class aOfi {

	public static void main(String[] args) {
		int[] arr = { -1, -1, 6, 1, 9, 3, 2, -1, 4, -1 };

		for (int i = 0; i < arr.length;) {
			if (arr[i] != -1 && arr[i] != i) {
				int e = arr[arr[i]];
				arr[arr[i]] = arr[i];
				arr[i] = e;
			} else {
				i++;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
