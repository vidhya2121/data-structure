package com.amaze.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LargestNumber {

	public static void main(String[] args) {

		String[] num = {"54", "546","548", "60"};
		ArrayList<String> str = new ArrayList<>();
		
//		for(String s : num.split(" ")) {
//			str.add(s);
//		}
		
		Arrays.sort(num, new Comp());
		System.out.println(Arrays.toString(num));
	}
	
	public static class Comp implements Comparator<String> {

		public int compare(String s1, String s2) {
			return -Integer.compare(Integer.parseInt(s1+s2), Integer.parseInt(s2+s1));
		}
		
	}
}
