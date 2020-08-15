package com.amaze.array;

import java.util.Arrays;

public class Missing {

	public static void main(String[] args) {
		/*
		 * Given an array C of size N-1 and given that there are numbers from 
		 * 1 to N with one element missing, the missing number is to be found.
		 */
		
		/*
		 * Input:
			2
			5
			1 2 3 5
			10
			1 2 3 4 5 6 7 8 10
			
		   Output:
			4
			9
		 */
		int arr[] = { 2, 3, 4, 1, 6, 7 };
		/*
		 *  Sort the array
		 *  initialize a as arr[0]
		 *  if first element is not 1 then missing is 1
		 *  loop from 0 to n
		 *  	if arr[i] != a
		 *  		then arr[i]-1 is the missing
		 *  	a++
		 */
		Arrays.sort(arr);
		int mis = 0;
		int a = arr[0];
		if (a != 1) {
			System.out.println(1);
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != a) {
				mis = arr[i] - 1;
				break;
			}
			a++;
		}
		System.out.println(mis == 0 ? a : mis);
	}

}
