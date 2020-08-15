package com.amaze.array;

import java.util.Arrays;

public class Chocolates {

	public static void main(String[] args) {
		/*
		 * Given an array A of positive integers of size N, where each value
		 *  represents number of chocolates in a packet. Each packet can have variable number 
		 *  of chocolates. There are M students, the task is to distribute chocolate packets such that :
			1. Each student gets one packet.
			2. The difference between the number of chocolates given to the students
			 having packet with maximum chocolates and student having packet with minimum chocolates is minimum.
		 */
		/*
		 * Input:
			2
			8
			3 4 1 9 56 7 9 12
			5
			7
			7 3 2 4 9 12 56
			3
			
		   Output:
			6
			2
		 */
		int n = 9;
		int arr[] = { 17, 83, 59, 25, 38, 63, 25, 1, 37 };
		int m = 3;
		/*	m students n chocolates
		 *  Sort the given array
		 *  intialize min to MAX_VALUE
		 *  loop 0 to n
		 *  	if i + m <= n and a[i + m - 1] - a[i] < min
		 *  		UPDATE min as a[i+m-1]-a[i]
		 */
		choco(arr, n, m);
	}

	private static void choco(int[] a, int n, int m) {
		Arrays.sort(a);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (i + m <= n && (a[i + m - 1] - a[i] < min)) {
				min = a[i + m - 1] - a[i];
			}
		}
		System.out.println(min);
	}

}
