package com.amaze.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestFromSrcDest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int mat[][] = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					mat[i][j] = sc.nextInt();
				}
			}
			int x = sc.nextInt();
			int y = sc.nextInt();
			System.out.println(shortPath(mat, n, m, x, y));
		}
	}

	private static int shortPath(int[][] mat, int n, int m, int x, int y) {
		if (mat[0][0] != 1 || mat[x][y] != 1) {
			return -1;
		}
		boolean visited[][] = new boolean[n][m];
		Queue<PNode> q = new LinkedList<>();
		q.add(new PNode(new Point(0, 0), 0));
		visited[0][0] = true;
		while (!q.isEmpty()) {
			PNode curr = q.poll();
			if (curr.p.x == x && curr.p.y == y) {
				return curr.dist;
			}
			int row[] = { -1, 0, 1, 0 };
			int col[] = { 0, 1, 0, -1 };
			for (int i = 0; i < 4; i++) {
				int c_row = curr.p.x + row[i];
				int c_col = curr.p.y + col[i];
				if (c_row >= 0 && c_row < n && c_col >= 0 && c_col < m && mat[c_row][c_col] == 1
						&& !visited[c_row][c_col]) {

					visited[c_row][c_col] = true;
					q.add(new PNode(new Point(c_row, c_col), curr.dist + 1));
				}
			}
		}
		return -1;
	}

}

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class PNode {
	Point p;
	int dist;

	PNode(Point p, int dist) {
		this.p = p;
		this.dist = dist;
	}
}
