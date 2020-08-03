package com.amaze.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SL {

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

	private static int snakeLadder(int[] mat, int n) {
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
