package com.array;

public class Rotate {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5 };
		int rot = 2;
		int[] temp = new int[arr.length];
		int c = 0;
		for (int i = rot; i < arr.length; i++) {
			temp[c] = arr[i];
			c++;
		}
		for (int i=0; i<rot; i++) {
			temp[c] = arr[i];
			c++;
		}
		System.out.println(temp);
	}
	
	/*
	 * Other Methods
	 * 1. temp the first index value, shift all by one place left
	 * 2. rev(0,d) rev(d,n) rev(0,n)
	 * 3. 
	 * 
	 * 
	 */
}
