package com.amaze.matrix;

public class AllSumKXK {

	public static void main(String arg[]) {
		int mat[][] = { { 1, 1, 1, 1, 1 }, { 2, 2, 2, 2, 2 }, { 3, 3, 3, 3, 3 }, { 4, 4, 4, 4, 4 }, { 5, 5, 5, 5, 5 } };
		int k = 3;
		printMatrix(mat);
		printSumSimple(mat, k);
	}

	public static void printMatrix(int mat[][]) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j]);
			}
			System.out.println("");
		}
	}

	// for square matrix only
	private static void printSumSimple(int[][] mat, int k) {
		int r = mat.length;
		int c = mat[0].length;
		if (k > r)
			return;
		for (int i = 0; i <= r - k; i++) {
			for (int j = 0; j <= r - k; j++) {
				int sum = 0;
				for (int m = i; m < i + k; m++) {
					for (int n = j; n < j + k; n++) {
						sum += mat[m][n];
					}
				}
				System.out.print(sum + " ");
			}
			System.out.println();
		}
	}

}
