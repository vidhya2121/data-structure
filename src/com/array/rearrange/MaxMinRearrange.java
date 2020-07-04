package com.array.rearrange;

import java.util.Arrays;

public class MaxMinRearrange {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		// int res[] = new int[arr.length];
		// int j = 0;
		// for (int i = 1; i < arr.length; i += 2) {
		// res[i] = arr[j];
		// j++;
		// }
		// j = arr.length-1;
		// for (int i = 0; i <arr.length; i+=2) {
		// res[i] = arr[j];
		// j--;
		// }
		//
		// System.out.println(Arrays.toString(res));
		int min = 0;
		int max = arr.length - 1;
		int maxEl = arr[arr.length - 1] + 1;
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				arr[i] += (arr[max] % maxEl) * maxEl;
				max--;
			} else {
				arr[i] += (arr[min] % maxEl) * maxEl;
				min++;
			}
		}
		for (int i = 0; i < arr.length; i++)
			arr[i] = arr[i] / maxEl;
		System.out.println(Arrays.toString(arr));
	}

}
