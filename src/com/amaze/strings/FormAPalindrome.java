package com.amaze.strings;

import java.util.Scanner;

public class FormAPalindrome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		String buf = sc.nextLine();
		while (t-- > 0) {
			String s1 = sc.nextLine();
			int s = formPalindrome(s1.toCharArray(), 0, s1.length() - 1);
			System.out.println(s);
		}
	}
/*
 * Given a string, find the minimum number of characters to be inserted to convert it to palindrome.
For Example:
ab: Number of insertions required is 1. bab or aba
aa: Number of insertions required is 0. aa
abcd: Number of insertions required is 3. dcbabcd
 */
	/*
	 * input as charArray l = 0 and r=s1.length()-1
	 * if l > r
	 * 		return MAX
	 * if l == r return 0
	 * if l == r - 1
	 * 		if both l and r element equal return 0 else return 1
	 *if both l and r element equal
	 *		return fun(cs, l+1, r+1)
	 *else
	 *		return min(fun(cs,l,r-1),fun(cs,l+1.r)) + 1
	 */
	private static int formPalindrome(char[] cs, int l, int r) {
		if (l > r)
			return Integer.MAX_VALUE;
		if (l == r)
			return 0;
		if (l == r - 1)
			return (cs[l] == cs[r]) ? 0 : 1;
		return (cs[l] == cs[r]) ? formPalindrome(cs, l + 1, r - 1)
				: (Integer.min(formPalindrome(cs, l, r - 1),formPalindrome(cs, l + 1, r)) + 1);
	}

}
