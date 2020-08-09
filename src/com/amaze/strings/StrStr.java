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
 * the function returns the position where the target string matches the string
 * str
 * 
 * Your are required to complete this method
 */

class GfG2 {
	int strstr(String str, String target) {
		// Your code here
		int i = str.indexOf(target);
		return i;
	}
}
