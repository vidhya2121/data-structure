package com.amaze.array;

import java.util.ArrayList;
import java.util.Arrays;

public class Stocks {
	/*
	 * The cost of stock on each day is given in an array A[] of size N.
	 *  Find all the days on which you buy and sell the stock so that in between those days your profit is maximum.
	 */
	public static void main(String[] args) {
		/*
		 * Input:
				3
				7
				100 180 260 310 40 535 695 //We can buy stock on day 0, and sell it on 3rd day, which will give us maximum profit.
				4
				100 50 30 20
				10
				23 13 25 29 33 19 34 45 65 67
				
			Output:
				(0 3) (4 6)
				No Profit
				(1 4) (5 9)
		 */
		int n = 8;
		int arr[] = { 100, 180, 260, 310, 100, 40, 535, 695};
		
		buySell(arr, n);
	}

	private static void buySell(int[] a, int n) {
		/*
		 *  initialize array list set i = 0
		 *  loop i < n - 1
		 *  	loop i < n - 1 and a[i] > a[i+1]
		 *  		i++
		 *  	if i == n - 1 break
		 *  	add i to array list
		 *  	loop i < n - 1 and a[i] < a[i+1]
		 *  		i++
		 *  	add i to array list
		 */
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
