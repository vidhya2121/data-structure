package com.amaze.matrix;

public class RectangleXO {

	public static void main(String[] args) {
		int R = 6;
		int C = 7;
		xO(R, C);
	}

	private static void xO(int r, int c) {
		String a[][] = new String[r][c];
		int rowStart = 0;
		int colStart = 0;
		int rowEnd = r - 1;
		int colEnd = c - 1;
		int count = 0;
		while (rowStart <= rowEnd && colStart <= colEnd) {
			for (int i = colStart; i <= colEnd; i++) {
				a[rowStart][i] = count % 2 == 0 ? "X" : "O";
			}
			rowStart++;
			for (int i = rowStart; i <= rowEnd; i++) {
				a[i][colEnd] = count % 2 == 0 ? "X" : "O";
			}
			colEnd--;
			if (rowStart <= rowEnd) {
				for (int k = colEnd; k >= colStart; k--) {
					a[rowEnd][k] = count % 2 == 0 ? "X" : "O";
				}
				rowEnd--;
			}
			if (colStart <= colEnd) {
				for (int m = rowEnd; m >= rowStart; m--) {
					a[m][colStart] = count % 2 == 0 ? "X" : "O";
				}
				colStart++;
			}
			count++;
		}
		printMatrix(a);
	}

	public static void printMatrix(String[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println("");
		}
	}

}
