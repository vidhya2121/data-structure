package com.amaze.strings;

import java.util.Scanner;

public class RemoveDuplicates {
/*
 * Example:
	Input:
	2
	geeksforgeeks
	geeks for geeks
	
	Output:
	geksfor
	geks for
 */
	/*
	 * res = ""
	 * loop 0 to length
	 * 		if res not contains substring of str(i,i+1) => that char not present in str
	 * 			add char at i to res
	 * return res
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		String buf = sc.nextLine();
		while (t-- > 0) {
			String s1 = sc.nextLine();
			String s = removeDuplicates(s1);
			System.out.println(s);
		}
	}

	private static String removeDuplicates(String s1) {
		String res = "";
		for (int i = 0; i < s1.length(); i++) {
			if (!res.contains(s1.substring(i, i+1))) {
				res += s1.charAt(i);
			}
		}
		return res;
	}

}
