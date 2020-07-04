package com.amaze.array;

public class Kadane {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, -2,-1,3,4,-78,1,2,3,4 };

		int sum = arr[0], prev_sum = arr[0];
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			if (arr[i] > 0 && sum < 0)
				sum = 0;
			sum += arr[i];
			if (sum > prev_sum) {
				prev_sum = sum;
			}
			if (sum < 0)
				sum = 0;
		}
		System.out.println(prev_sum);
	}

}
