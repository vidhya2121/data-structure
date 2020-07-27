package com.amaze.matrix;

public class SearchSortedRowColumn {

	public static void main(String[] args) {
		int mat[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };

		search(mat, 4, 10);
	}

	private static void search(int[][] mat, int size, int key) {
		// TODO Auto-generated method stub
		int i = 0;
		int j = size - 1;
		while (i < size && j >= 0) {
			if(mat[i][j]==key) {
				System.out.println(i + " " + j);
				break;
			} else if (mat[i][j] < key) {
				i++;
			} else {
				j--;
			}
		}
	}

}
