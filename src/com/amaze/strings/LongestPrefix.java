package com.amaze.strings;

import java.util.Scanner;

public class LongestPrefix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			sc.nextLine();
			String line = sc.nextLine();
			String[] str = line.split(" ");
			int ans = longPrefix(str);
			if (ans == -1) {
				System.out.println(-1);
			} else {
				System.out.println(str[0].substring(0, ans));
			}
			t--;
		}
	}
	/*
	 * Input:
			2
			4
			geeksforgeeks geeks geek geezer
			3
			apple ape april
			
	Output:
			gee
			ap
	 */
/*
 * longPrefix(String[] str)\
 * 		if str length i 1 then return str[0].length
 * 		first = str[0]
 * 		loop i = 1 to length
 * 			count = 0
 * 			loop j = 0 j< first.lngth and j < str[i].length
 * 				if str[i].charAt j == first.charAt j count++
 * 				else break
 * 		    count == 0 return -1
 * 			min = min(min,count)
 * return min
 * 
 */
	private static int longPrefix(String[] str) {
		if(str.length==1) {
			return str[0].length();
		}
		String first = str[0];
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < str.length; i++) {
			int count = 0;
			for (int j = 0; j < str[i].length() && j < first.length(); j++) {
				if (str[i].charAt(j) == first.charAt(j)) {
					count++;
				} else {
					break;
				}
			}
			if (count == 0) {
				return -1;
			}
			min = Integer.min(min, count);
		}
		return min == Integer.MAX_VALUE ? -1 : min;
	}

}
