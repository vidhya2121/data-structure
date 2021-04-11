package com.amaze.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestFromSrcDest {
/*
 * Given a boolean 2D matrix (0-based index), find whether there is path from (0,0) to (x,y) 
 * and if there is one path, print the minimum no of steps needed to reach it, else print -1 if the destination is not reachable.
 *  You may move in only four direction ie up, down, left and right. The path can only be created out of a cell if its value is 1.
 */
	/*
	 * Input:
		2
		3 4
		1 0 0 0 1 1 0 1 0 1 1 1
		2 3
		3 4
		1 1 1 1 0 0 0 1 0 0 0 1
		0 3
		Output:
		5
		3
	 */
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
/*
 * shortPath(mat,n,m,x,y)
 * if mat[0][0] or [x][y] not 1 then return -1
 * create a class PNode(Point p, dist) Point(x,y)
 * have a visited boolean array and also a Queue with PNode
 * add point 0 0 dist 0 to q
 * mark visited[0][0] as true
 * loop q not empty
 * 		curr = poll from q
 * 		if curr x,y == x,y
 * 			return curr.dist
 * 		have row array as -1 0 1 0 and col array as 0 1 0 -1
 * 		loop 4 times down, right, up, left
 * 			r = curr x + row[i]   c = curr y + col[i]
 * 			if r and c in bounds and not visited and mat[r][c] is 1
 * 				make visited as 1 and add r c curr.dist+1 to q
 * return -1 
 * 
 */
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
