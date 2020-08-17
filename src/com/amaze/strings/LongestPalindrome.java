package com.amaze.strings;

public class LongestPalindrome {
/*
 * Input:
		1
		aaaabbaa
	Output:
		aabbaa
 */
	public static void main(String[] args) {
		String str = "raceecar";
		palindrome(str);
	}
/*
 * start and end is 0
 * loop 0 to length
 * 		l1 exFromMid(str, i, i)
 *      l2 exFromMid(str, i, i+1)
 *      l is max of l1 and  l2
 *      if l > end - start + 1
 *      	start = i - ((l - 1)/2)
 *      	end = i + (l/2)
 * sysout substring(start, end+1)
 * 
 * exFromMid(str, l, r)
 * 		if str is null and l > r return 0
 * 		loop l>=0 r<length and char at l == char at r
 * 			l-- r++
 * 		return r - l -1 (actually this is dist between l and r but with r - 1 - (l + 1) + 1
 * 
 */
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
