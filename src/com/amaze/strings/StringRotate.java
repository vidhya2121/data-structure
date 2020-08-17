package com.amaze.strings;

import java.util.Scanner;

public class StringRotate {
	/*
	 * Input:
		2
		amazon
		azonam
		geeksforgeeks
		geeksgeeksfor
		
		Output:
		1
		0
	 */
	/**
	 * amazon onamaz azonam
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			String s1 = sc.next();
			String s2 = sc.next();
			System.out.println(isRBy2(s1, s2));
		}
	}
	/*
	 *  if s1 == s2.substring(length-2).concat(s2.substring(0,length-2)) return 1
	 *  if s1 == s2.substring(2,length).concat(s2.substring(0,2)) return 1
	 *  return 0
	 */
	private static int isRBy2(String s1, String s2) {
		if (s1.equals(s2.substring(s2.length() - 2).concat(s2.substring(0, s2.length() - 2)))) {
			return 1;
		} else if (s1.equals(s2.substring(2, s2.length()).concat(s2.substring(0, 2)))) {
			return 1;
		}
		return 0;
	}

}
