package com.amaze.array;

import java.util.ArrayList;
import java.util.List;

public class Leaders {

	public static void main(String[] args) {

		int arr[] = { 16, 17, 4, 3, 5, 2 };
		optLeaders(arr);
	}

	private static void optLeaders(int[] arr) {
		int max = 0; 
		List<Integer> res = new ArrayList<>();
		StringBuffer str = new StringBuffer();
		for (int i = arr.length-1; i >= 0; i--) {
			if (arr[i] >= max) {
				max = arr[i];
				res.add(arr[i]);
//				System.out.print(arr[i] + " ");
			}
		}
		for (int i = res.size()-1; i >= 0; i--) {
			str.append(res.get(i)+ " ");
		}
		System.out.println(str);
	}

	public static int max(int arr[], int start, int end) {
		int max = 0;
		for (int i = start; i < end; i++) {
			if (arr[i] > max)
				max = arr[i];
		}
		return max;
	}

	public static void leaders(int a[]) {
		for (int i = 0; i < a.length; i++) {
			int max = max(a, i + 1, a.length);
			if (a[i] >= max)
				System.out.print(a[i] + " ");
		}
		System.out.println();
	}

}
