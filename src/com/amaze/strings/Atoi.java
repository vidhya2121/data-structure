package com.amaze.strings;

import java.util.Scanner;
/*
 * Your task  is to implement the function atoi. 
 * The function takes a string(str) as argument and converts it to an integer and returns it.
 */
/*
 * Input:
		2
		123
		21a
		
	Output:
		123
		-1
 */
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
}
/*
 * initialize sign as 1 i as 0
 * if first char in str is - then update sign as -1 and i++
 * initialize ans as 0
 * loop for i < length
 * 		if char at i not a number return -1
 * 		if a number then ans = ans * 10 + (char at i - '0')
 * 		i++
 * return sign*ans
 */
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
