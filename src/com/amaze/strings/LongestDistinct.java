package com.amaze.strings;

import java.util.Scanner;

public class LongestDistinct {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		String buf = sc.nextLine();
		while (t-- > 0) {
			String s1 = sc.nextLine();
			int s = longDist(s1);
			System.out.println(s);
		}
	}

	private static int longDist(String s1) {
		int count = 1;
		int max = count;
		String ss = "" + s1.charAt(0);
		for (int i = 1; i < s1.length(); i++) {
			if (ss.indexOf(s1.charAt(i)) != -1) {
				count = 0;
				ss = ss.substring(ss.indexOf(s1.charAt(i)) + 1, ss.length());
				ss += s1.charAt(i);
				count = ss.length();
			} else {
				count++;
				ss += s1.charAt(i);
			}
			max = Math.max(count, max);
		}
		return max;
	}

}
