package com.amaze.matrix;

import javax.management.relation.RoleStatus;

public class SpiralTraversal {

	public static void main(String[] args) {
		int R = 3;
		int C = 6;
		int a[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 } };
		spiralPrint(R, C, a);
	}

	private static void spiralPrint(int r, int c, int[][] a) {

		int rowStart = 0;
		int colStart = 0;
		int rowEnd = r - 1;
		int colEnd = c - 1;

		while (rowStart <= rowEnd && colStart <= colEnd) {
			for (int i = colStart; i <= colEnd; i++) {
				System.out.print(a[rowStart][i] + " ");
			}
			rowStart++;
			for (int i = rowStart; i <= rowEnd; i++) {
				System.out.print(a[i][colEnd] + " ");
			}
			colEnd--;
			if (rowStart <= rowEnd) {
				for (int k = colEnd; k >= colStart; k--) {
					System.out.print(a[rowEnd][k] + " ");
				}
				rowEnd--;
			}
			if (colStart <= colEnd) {
				for (int m = rowEnd; m >= rowStart; m--) {
					System.out.print(a[m][colStart] + " ");
				}
				colStart++;
			}
		}
	}

}
