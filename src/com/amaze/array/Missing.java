package com.amaze.array;

import java.util.Arrays;

public class Missing {

	public static void main(String[] args) {

		int arr[] = { 2, 3, 4, 1, 6, 7 };
		Arrays.sort(arr);
		int mis = 0;
		int a = arr[0];
		if (a!=1) {
			System.out.println(1);
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != a) {
				mis = arr[i]-1;
				break;
			}
			a++;
		}
		System.out.println(mis==0?a:mis);
	}

}
