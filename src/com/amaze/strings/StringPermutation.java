package com.amaze.strings;

import java.util.Arrays;

public class StringPermutation {

	public static void main(String[] args) {
		String str = "ABC";
		char[] chArr = str.toCharArray();
		Arrays.sort(chArr);
		permute(String.valueOf(chArr), "");
		System.out.println();
	}

	private static void permute(String str, String ans) {
		if (str.length() == 0) {
			System.out.print(ans + " ");
		}
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			String rem = str.substring(0, i) + str.substring(i + 1, str.length());
			permute(rem, ans + ch);
		}
	}

}
