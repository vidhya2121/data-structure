package com.array.rearrange;

public class MaxSumSubarray {

	public static void main(String[] args) {

		int a[] = {-2,5,-1};
		int n = a.length;

		int sum = a[0];
		int prev_sum = a[0];

		for (int i = 1; i < n; i++) {
			sum += a[i];
			if (sum > prev_sum)
				prev_sum = sum;
			if (sum < 0 ) sum = 0;
			
		}
		System.out.println(prev_sum);
	}

}
