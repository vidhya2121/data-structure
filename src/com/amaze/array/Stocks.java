package com.amaze.array;

import java.util.ArrayList;
import java.util.Arrays;

public class Stocks {

	public static void main(String[] args) {
		int n = 2;
		int arr[] = { 272, 5};

		buySell(arr, n);
	}

	private static void buySell(int[] a, int n) {

		ArrayList<Integer> res = new ArrayList<>();
		StringBuffer str = new StringBuffer();
		int i = 0;
		while (i < n - 1) {
			while (i < n - 1 && (a[i] > a[i + 1])) {
				i++;
			}
			if (i == n - 1)
				break;
			res.add(i);
			while (i < n - 1 && (a[i] < a[i + 1])) {
				i++;
			}
			res.add(i);
		}
		System.out.println(res.toString());
		if (res.size() == 0) {
			str.append("No Profit");
			System.out.println(str);
			return;
		}
		for (int j = 0; j < res.size() - 1; j += 2) {
			str.append("(" + res.get(j) + " " + res.get(j + 1) + ") ");
		}
		System.out.println(str);
	}

}
