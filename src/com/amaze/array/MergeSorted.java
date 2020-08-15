package com.amaze.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MergeSorted {

	public static void main(String[] args) throws Exception {
		
		/*
		 * Given two sorted arrays arr1[] and arr2[] in non-decreasing order with size n and m. 
		 * The task is to merge the two sorted arrays into one sorted array (in non-decreasing order).
		 */
		/*
		 * Input:
			2
			4 5
			1 3 5 7
			0 2 6 8 9
			2 3
			10 12
			5 18 20
			
		   Output:
			0 1 2 3 5 6 7 8 9
			5 10 12 18 20
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
		while (t-- > 0) {
			String inputLine[] = br.readLine().trim().split(" ");
			int n = Integer.parseInt(inputLine[0]);
			int m = Integer.parseInt(inputLine[1]);
			int a[] = new int[n];
			int b[] = new int[m];
			inputLine = br.readLine().trim().split(" ");
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(inputLine[i]);
			}
			inputLine = br.readLine().trim().split(" ");
			for (int i = 0; i < m; i++) {
				b[i] = Integer.parseInt(inputLine[i]);
			}
			
			/* initialise string builder
			 * loop from i : 0 to n and j : 0 to m
			 * 		if a[i] <= b[j] append a[i] and i++
			 * 		else append b[j] j++
			 * 
			 *  loop and add remaining elements
			 * 
			 */
			int i, j;
			StringBuffer sb = new StringBuffer();
			for (i = 0, j = 0; i < a.length && j < b.length;) {
				if (a[i] <= b[j]) {
					sb.append(a[i] + " ");
					i++;
				} else {
					sb.append(b[j] + " ");
					j++;
				}
			}
			while (i < a.length) {
				sb.append(a[i] + " ");
				i++;
			}
			while (j < b.length) {
				sb.append(b[j] + " ");
				j++;
			}
			System.out.println(sb);
		}
	}
}