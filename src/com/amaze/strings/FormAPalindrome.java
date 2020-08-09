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
