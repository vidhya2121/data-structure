package com.amaze.strings;

public class LongestPalindrome {

	public static void main(String[] args) {
		String str = "raceecar";
		palindrome(str);
	}

	private static void palindrome(String str) {
		int start = 0;
		int end = 0;
		for (int i = 0; i < str.length(); i++) {
			int l1 = expandFromMiddle(str, i, i);
			int l2 = expandFromMiddle(str, i, i + 1);
			int l = Math.max(l1, l2);
			if (l > end - start + 1) {
				start = i - ((l - 1) / 2);
				end = i + (l / 2);
			}
		}
		System.out.println(str.substring(start, end + 1));
	}

	private static int expandFromMiddle(String str, int l, int r) {
		if (str == null && l > r)
			return 0;
		while (l >= 0 && r < str.length() && str.charAt(l) == str.charAt(r)) {
			l--;
			r++;
		}
		return r - l - 1;
	}

}
