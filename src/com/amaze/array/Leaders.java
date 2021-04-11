package com.amaze.array;

import java.util.ArrayList;
import java.util.List;

public class Leaders {

	public static void main(String[] args) {
		/*
		 * Given an array of positive integers. Your task is to find the leaders in the array.
			Note: An element of array is leader if it is greater than or equal to all 
			the elements to its right side. Also, the rightmost element is always a leader. 
		 */
		/*
		 * Input:
				3
				6
				16 17 4 3 5 2
				5
				1 2 3 4 0
				5
				7 4 5 7 3
			Output:
				17 5 2
				4 0
				7 7 3
		 */
		int arr[] = { 16, 17, 4, 3, 5, 2 };
		/*
		 *  initialize max to 0, initialize ArrayList and a StringBuidler
		 *  loop from n-1 to 0
		 *  	if current element > max change max to current and add to array list
		 *  use stringbuilder and print array in reverse order
		 */
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
			}
		}
		for (int i = res.size()-1; i >= 0; i--) {
			str.append(res.get(i)+ " ");
		}
		System.out.println(str);
	}

}
