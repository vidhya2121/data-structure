package com.amaze.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SL {
/*
 * Given a snake and ladder board of order 5x6, find the minimum number of dice throws required 
 * to reach the destination or last cell (30th cell) from source (1st cell) . 
 */
	/*
	 * Input:
			2
			6
			11 26 3 22 5 8 20 29 27 1 21 9
			1
			2 30
			
		Output:
			3
			1

Explanation:
Testcase 1:
For 1st throw get a 2, which contains ladder to reach 22
For 2nd throw get a 6, which will lead to 28
Finally get a 2, to reach at the end 30. Thus 3 dice throws required to reach 30.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int mat[] = new int[30+1];
			for (int i = 1; i <= 30; i++) {
				mat[i] = -1;
			}
			for (int i = 0; i < n; i++) {
				int src = sc.nextInt();
				mat[src] = sc.nextInt();
			}
			System.out.println(snakeLadder(mat, 30));
		}
	}
/*
 * visited boolean array Queue of SNode(vertex,dist)
 * add 1,0 to q
 * loop till q is empty
 * 		curr = poll from q
 * 		if current vertex in n break
 * 		v = curr vertex
 * 		loop j = v + 1  j < v+6 and j<=n
 * 			if j not visited
 * 				create a new SNode and set its dist as curr.dist+1
 * 				if mat[j] != -1 then set new node's vertex to mat[j] 
 * 				else set to j only
 * 				add node to q
 * return curr.dist
 */
	private static int snakeLadder(int[] mat, int n) {
//		mat [0, -1, -1, 22, -1, 8, -1, -1, -1, -1, -1, 26, -1, -1, -1, -1, -1, -1, -1, -1, 29, 9, -1, -1, -1, -1, -1, 1, -1, -1, -1]
		boolean visited[] = new boolean[n+1];
		Queue<SNode> q = new LinkedList<>();
		q.add(new SNode(1, 0));
		visited[0] = true;
		SNode curr = null;
		while (!q.isEmpty()) {
			curr = q.poll();
			if (curr.vertex == n) {
				break;
			}
			int v = curr.vertex;
			for (int j = v + 1; j <= v + 6 && j <= n; j++) {
				if (!visited[j]) {
					SNode s = new SNode();
					s.dist = curr.dist + 1;
					if (mat[j] != -1) {
						s.vertex = mat[j];
					} else {
						s.vertex = j;
					}
					q.add(s);
				}
			}
		}
		return curr.dist;
	}

}

class SNode {
	int vertex;
	int dist;

	SNode(int vertex, int dist) {
		this.vertex = vertex;
		this.dist = dist;
	}

	public SNode() {
	}
}
