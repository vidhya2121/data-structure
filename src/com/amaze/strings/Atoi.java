package com.amaze.strings;

import java.util.Scanner;

public class Atoi {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while (t > 0) {
			String str = sc.nextLine();

			GfG g = new GfG();
			System.out.println(g.atoi(str));
			t--;
		}
	}
}// } Driver Code Ends

/* You are required to complete this method */
class GfG {
	int atoi(String str) {
		// int ans = 0;
		// try {
		// ans = Integer.parseInt(str);
		// } catch (Exception e) {
		// return -1;
		// }
		// return ans;
		int sign = 1;
		int i = 0;
		if (str.charAt(0) == '-') {
			sign = -1;
			i++;
		}
		int ans = 0;
		while (i < str.length()) {
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				ans = ans * 10 + (str.charAt(i) - '0');
			} else {
				return -1;
			}
			i++;
		}
		return sign * ans;
	}
}
