package com.amaze.array;

import java.util.Arrays;

public class KthSmallest {

	public static void main(String[] args) {
		int k = 3;
		int a[] = {5,4,3,2,1,0,7,8};
		
		Arrays.sort(a);
		System.out.println(a[k-1]);
	}

}
