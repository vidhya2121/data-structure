package com.amaze.array;

public class RainWaterHarv {

	public static void main(String[] args) {

		int a[] = { 7, 4, 0, 9, 8, 5, 7 };
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

	private static void rain(int[] a, int n) {

		int count = 0;
		for (int i = 1; i < n - 1; i++) {
			int f = max(a, 0, i);
			int l = max(a, i, n);
			int limit = Math.min(f, l);
			if (a[i] < limit) {
				count = count + (limit - a[i]);
			}
		}
		System.out.println(count);
	}

	private static int max(int[] a, int s, int e) {
		int max = 0;
		for (int i = s; i < e; i++) {
			if (a[i] > max)
				max = a[i];
		}
		return max;
	}

}
