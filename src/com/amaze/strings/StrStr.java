package com.amaze.strings;

import java.util.Scanner;

public class StrStr {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while (t > 0) {
			String line = sc.nextLine();
			String a = line.split(" ")[0];
			String b = line.split(" ")[1];

			GfG2 g = new GfG2();
			System.out.println(g.strstr(a, b));

			t--;
		}
	}
}// } Driver Code Ends
/*
 * Your task is to implement the function strstr. The function takes two strings as arguments (s,x) 
 * and  locates the occurrence of the string x in the string s.
 *  The function returns and integer denoting the first occurrence of the string x in s (0 based indexing).
 */
/*
 * Input:
		s = GeeksForGeeks, x = For
	Output: 5
		Explanation: For is present as substring
		in GeeksForGeeks from index 5 (0 based
		indexing).
 */
/*
 * return str.indexOf(target)
 */
class GfG2 {
	int strstr(String str, String target) {
		// Your code here
		int i = str.indexOf(target);
		return i;
	}
}
