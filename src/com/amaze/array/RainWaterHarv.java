package com.amaze.array;

public class RainWaterHarv {

	public static void main(String[] args) {
		/*
		 * Given an array arr[] of N non-negative integers representing height 
		 * of blocks at index i as Ai where the width of each block is 1. 
		 * Compute how much water can be trapped in between blocks after raining.
			Structure is like below:
			| |
			|_|
			We can trap 2 units of water in the middle gap.
		 */
		/*
		 * Input:
			2
			4
			7 4 0 9
			3
			6 9 9
			
		   Output:
			10
			0
		 */
		int a[] = { 7, 4, 0, 9 };
		/*
		 * initialize low as 0 high as n - 1 count as 0 left_max = 0 right_max = 0
		 * loop from low to high (<=)
		 * 		if a[low] < a[high]
		 * 			if a[low] > left_max set left_max as a[low]
		 * 			else increment count as (left_max - a[low])
		 * 		low++
		 * 		similar logic for else
		 */
		optRain(a, a.length);
	}

	private static void optRain(int a[], int n) {
		int low = 0;
		int high = n - 1;
		int count = 0;
		int lmax = 0;
		int rmax = 0;
		while (low <= high) {
			if (a[low] < a[high]) {
				if (a[low] > lmax)
					lmax = a[low];
				else
					count += (lmax - a[low]);
				low++;
			} else {
				if (a[high] > rmax)
					rmax = a[high];
				else
					count += (rmax - a[high]);
				high--;
			}
		}
		System.out.println(count);
	}

}
