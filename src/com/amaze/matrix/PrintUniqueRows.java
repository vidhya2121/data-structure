package com.amaze.matrix;

import java.util.Arrays;

public class PrintUniqueRows {

	public static void main(String[] args) {
		int m[][] = { { 0, 1, 0, 0, 1 }, { 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 1, 0, 0 } };

		findUniqueRows(m);

	}

	private static void findUniqueRows(int[][] m) {
		for (int i = 0; i < m.length; i++) {
			int f = 0;
			for (int j = 0; j < i; j++) {
				if (Arrays.toString(m[i]).equals(Arrays.toString(m[j]))) {
					f = 1;
				}
			}
			if (f == 0) {
				System.out.println(Arrays.toString(m[i]));
			}
		}
	}

}
