package com.amaze.matrix;

public class InplaceMXMTranspose {

	public static void main(String[] args) {
		int m[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		printMatrix(m);
		inPlace(m);
		printMatrix(m);
	}

	public static void printMatrix(int mat[][]) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println("");
		}
	}

	private static void inPlace(int[][] m) {
		int r = m.length;
		int c = m[0].length;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (i > j) {
					int t = m[i][j];
					m[i][j] = m[j][i];
					m[j][i] = t;
				}
			}
		}

	}

}
