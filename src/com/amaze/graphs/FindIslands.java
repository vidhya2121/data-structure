package com.amaze.graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class FindIslands {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			ArrayList<ArrayList<Integer>> list = new ArrayList<>(N);

			// creating arraylist of arraylist
			for (int i = 0; i < N; i++) {
				ArrayList<Integer> temp = new ArrayList<>(M);
				list.add(i, temp);
			}

			// adding elements to the arraylist of arraylist
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int val = sc.nextInt();
					list.get(i).add(j, val);
				}
			}

			System.out.println(new Islands().findIslands(list, N, M));
		}
	}
}

class Islands {

	// Function to find the number of island in the given list A
	// N, M: size of list row and column respectively
	static int findIslands(ArrayList<ArrayList<Integer>> A, int N, int M) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (A.get(i).get(j) == 1) {
					count++;
					island(A, i, j, N, M);
				}
			}
		}
		return count;
	}

	private static void island(ArrayList<ArrayList<Integer>> a, int i, int j, int n, int m) {
		if (i < 0 || i >= n || j < 0 || j >= m) {
			return;
		}
		if (a.get(i).get(j) != 1) {
			return;
		}
		a.get(i).set(j, 2);
		island(a, i - 1, j - 1, n, m);
		island(a, i - 1, j, n, m);
		island(a, i + 1, j + 1, n, m);
		island(a, i, j - 1, n, m);
		island(a, i + 1, j, n, m);
		island(a, i + 1, j - 1, n, m);
		island(a, i, j + 1, n, m);
		island(a, i - 1, j + 1, n, m);
	}
}
