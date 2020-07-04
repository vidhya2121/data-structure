package com.array.rearrange;

import java.util.Arrays;

public class ReaarangeOddEven {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 1, 4, 5, 6, 8, 8 };
		int[] temp = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}
		Arrays.sort(temp);
		System.out.println(Arrays.toString(temp));

		int evens = arr.length / 2;
		int odds = arr.length - evens;
		int j = odds - 1;
		for (int i = 0; i < arr.length; i += 2) {
			arr[i] = temp[j];
			j--;
		}
		j = odds;
		for (int i = 1; i < arr.length; i += 2) {
			arr[i] = temp[j];
			j++;
		}
		System.out.println(Arrays.toString(arr));
	}

}
