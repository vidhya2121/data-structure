package com.amaze.strings;

import java.util.Arrays;

public class StringPermutation {
/*
 * Example:
Input:
2
ABC
ABSG

Output:
ABC ACB BAC BCA CAB CBA 
ABGS ABSG AGBS AGSB ASBG ASGB BAGS BASG BGAS BGSA BSAG BSGA GABS GASB GBAS GBSA GSAB GSBA SABG SAGB SBAG SBGA SGAB SGBA
 */
	/*
	 * convert str to char array and sort convert back to string
	 * call permute(str, "")
	 * permute(str,ans)
	 * 		if length is 0 return ans
	 * 		loop i from 0 to length
	 * 			ch = char at i
	 * 			rem = substring(0,i) + substring(i+1,length)
	 * 			permute(rem, ans+ch)
	 */
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
