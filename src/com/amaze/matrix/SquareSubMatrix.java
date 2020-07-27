package com.amaze.matrix;

public class SquareSubMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m[][] = { { 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 }, { 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0 } };
		printMatrix(m);
		printMaxSubSquare(m);

	}

	public static void printMatrix(int mat[][]) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j]);
			}
			System.out.println("");
		}
	}

	private static void printMaxSubSquare(int[][] m) {
		// TODO Auto-generated method stub
		int r = m.length;
		int c = m[0].length;

		int s[][] = new int[r][c];

		for (int j = 0; j < c; j++) {
			s[0][j] = m[0][j];
		}
		for (int i = 0; i < r; i++) {
			s[i][0] = m[i][0];
		}
		for (int i = 1; i < r; i++) {
			for (int j = 1; j < c; j++) {
				if (m[i][j] == 1) {
					s[i][j] = Math.min(s[i][j - 1], Math.min(s[i - 1][j], s[i - 1][j - 1])) + 1;
				} else {
					s[i][j] = 0;
				}
			}
		}
		printMatrix(s);
		int maxLen = 0;
		int maxI = 0;
		int maxJ = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (maxLen < s[i][j]) {
					maxLen = s[i][j];
					maxI = i;
					maxJ = j;
				}
			}
		}
		System.out.println(maxLen);
		System.out.println(maxI + " " + maxJ);
		for(int i=maxI;i>maxI-maxLen;i--) {
			for(int j=maxJ;j>maxJ-maxLen;j--) {
				System.out.print(m[i][j]);
			}
			System.out.println();
		}
	}

}
