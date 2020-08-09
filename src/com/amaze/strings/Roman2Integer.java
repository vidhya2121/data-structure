package com.amaze.strings;

import java.util.Scanner;

public class Roman2Integer {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			String s1 = sc.next();
			System.out.println(rom2int(s1));
		}

	}

	private static int rom2int(String s1) {
		char ch[] = s1.toCharArray();
		int tot = 0;
		for (int i = 0; i < ch.length; i++) {
			int val = value(ch[i]);
			if (i + 1 < ch.length) {
				int nextVal = value(ch[i + 1]);
				if (val >= nextVal) {
					tot += val;
				} else {
					tot += -val + nextVal;
					i++;
				}
			} else {
				tot += val;
			}
		}
		return tot;
	}

	private static int value(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		}

		return 0;
	}

}
