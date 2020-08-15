package com.amaze.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LargestNumber {

	public static void main(String[] args) {
		/*
		 * Given a list of non negative integers, arrange them in such a manner that they form the largest number possible.
		 * The result is going to be very large, hence return the result in the form of a string.
		 */
		/*
		 * Input:
			2
			5
			3 30 34 5 9
			4
			54 546 548 60
			
			Output:
			9534330
			6054854654
		 */
		String[] num = {"54", "546","548", "60"};
		/*
		 * treat inputs as string write comparator by concat of s1+s2 and s2+s1
		 */
		Arrays.sort(num, new Comp());
		System.out.println(Arrays.toString(num));
	}
	
	public static class Comp implements Comparator<String> {

		public int compare(String s1, String s2) {
			return -Integer.compare(Integer.parseInt(s1+s2), Integer.parseInt(s2+s1));
		}
		
	}
}
