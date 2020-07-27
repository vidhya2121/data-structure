package com.amaze.matrix;

public class BooleanMatrix {

	public static void main(String[] args) {
		int mat[][] = { { 0, 0, 0 }, { 0, 0, 1 } };

		System.out.println("Input Matrix :");
		printMatrix(mat);

		modifyMatrix(mat);

		System.out.println("Matrix After Modification :");
		printMatrix(mat);
	}

	private static void modifyMatrix(int[][] mat) {
		int r = mat.length;
		int c = mat[0].length;
		int row[] = new int[r];
		int col[] = new int[c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (mat[i][j] == 1) {
					row[i] = 1;
					col[j] = 1;
				}
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (row[i] == 1 || col[j] == 1) {
					mat[i][j] = 1;
				}
			}
		}

	}

	public static void printMatrix(int mat[][]) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j]);
			}
			System.out.println("");
		}
	}

}
