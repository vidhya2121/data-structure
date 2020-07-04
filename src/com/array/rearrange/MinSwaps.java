package com.array.rearrange;

public class MinSwaps {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 1, 9, 4, 5, 6, 8, 8 };
		int k = 5;
		
		int count = 0;
		int bad = 0;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<=k) {
				count++;
			}
		}
		
		for(int i=0;i<count;i++) {
			if(arr[i]>k) {
				bad++;
			}
		}
		
		System.out.println(bad);
	}

}
