package com.amaze.graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindPathFromStoD {
/*
 * going with naive approach
 * Given a N X N matrix (M) filled with 1, 0, 2, 3. The task is to find whether there is a path possible from source to destination, while traversing through blank cells only. You can traverse up, down, right and left.

A value of cell 1 means Source.
A value of cell 2 means Destination.
A value of cell 3 means Blank cell.
A value of cell 0 means Blank Wall.
Note: there is only single source and single destination.
 */
	/*
	 * Given a matrix like
	 * Testcase 1: The matrix for the above given input is:
		3 0 0 0
		0 3 3 0
		0 1 0 3
		0 2 3 3
		From the matrix we can see that there exists a path from to reach destination 2 from source 1.
	 */
	/*
	 *find starti startj endi endj
	 *call dfs(mat,starti,startj,endi,endj)
	 *dfs(a,i,j,endi,endj)
	 *		if i's and j's out of bounds or a[i][j] < 0 
	 *			return false 
	 *		mark a[i][j] as -1 (hinting that it is visited)
	 *		if i=endi and j=endj
	 *			return
	 *		top = dfs(a,i-1,j,endi,endj)
	 *		if top == true return true
	 *		do for right,bottom,left
	 *		return false
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int mat[][] = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					mat[i][j] = sc.nextInt();
				}
			}
			System.out.println(findPathExists(mat, n)); // 0.35
			System.out.println(naive(mat, n)); // 0.35
		}
	}

	private static boolean naive(int[][] a, int n) {
		int starti = 0, startj = 0, endi = 0, endj = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 1) {
					starti = i;
					startj = j;
				}
				if (a[i][j] == 2) {
					endi = i;
					endj = j;
				}
			}
		}
		return dfs(a, starti, startj, endi, endj);
	}

	private static boolean dfs(int[][] a, int i, int j, int endi, int endj) {
		int n = a.length;
		if (i < 0 || i >= n || j < 0 || j >= n || a[i][j] <= 0)
			return false;
		a[i][j] = -1;
		if (i == endi && j == endj)
			return true;
		boolean top = dfs(a, i - 1, j, endi, endj);
		if (top)
			return true;
		boolean right = dfs(a, i, j + 1, endi, endj);
		if (right)
			return true;
		boolean bottom = dfs(a, i + 1, j, endi, endj);
		if (bottom)
			return true;
		boolean left = dfs(a, i, j - 1, endi, endj);
		if (left)
			return true;
		return false;
	}

	private static boolean findPathExists(int[][] a, int n) {
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		int source = 0;
		int dest = 0;
		for (int i = 0; i <= n * n; i++) {
			graph.add(new ArrayList<>());
		}
		int k = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 1) {
					source = k;
				}
				if (a[i][j] == 2) {
					dest = k;
				}
				if (a[i][j] != 0) {
					// top -> will be N nodes up
					if (i > 0 && isSafe(i - 1, j, a)) {
						graph.get(k).add(k - n);
					}
					// left -> one node back
					if (isSafe(i, j - 1, a)) {
						graph.get(k).add(k - 1);
					}
					// bottom -> will be N nodes down
					if (i < n - 1 && isSafe(i + 1, j, a)) {
						graph.get(k).add(k + n);
					}
					// right -> one node front
					if (isSafe(i, j + 1, a)) {
						graph.get(k).add(k + 1);
					}
				}
				k++;
			}
		}
		return bfs(graph, source, dest);

	}

	private static boolean bfs(ArrayList<ArrayList<Integer>> graph, int source, int dest) {
		Queue<Integer> q = new LinkedList<>();
		boolean visited[] = new boolean[graph.size()];
		q.add(source);
		visited[source] = true;
		while (!q.isEmpty()) {
			int curr = q.poll();
			Iterator<Integer> it = graph.get(curr).iterator();
			while (it.hasNext()) {
				int next = it.next();
				if (next == dest)
					return true;
				if (visited[next] == false) {
					visited[next] = true;
					q.add(next);
				}
			}
		}
		return false;
	}

	static boolean isSafe(int i, int j, int[][] M) {
		int N = M.length;
		if ((i < 0 || i >= N) || (j < 0 || j >= N) || M[i][j] == 0)
			return false;
		return true;
	}

}
